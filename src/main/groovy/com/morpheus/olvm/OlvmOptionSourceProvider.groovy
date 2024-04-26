package com.morpheus.olvm

import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.AbstractOptionSourceProvider
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import com.morpheusdata.core.data.DataAndFilter
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataOrFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.data.DataQueryResult
import com.morpheusdata.model.AccountCredential
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ImageType
import com.morpheusdata.model.VirtualImage
import com.morpheusdata.model.VirtualImageType
import groovy.util.logging.Slf4j

@Slf4j
class OlvmOptionSourceProvider extends AbstractOptionSourceProvider {
    OlvmCloudPlugin plugin
    MorpheusContext morpheusContext

    public OlvmOptionSourceProvider(OlvmCloudPlugin plugin, MorpheusContext context) {
        super()
        this.@plugin = plugin
        this.@morpheusContext = context
    }

    @Override
    MorpheusContext getMorpheus() {
        return this.@morpheusContext
    }

    @Override
    Plugin getPlugin() {
        return this.@plugin
    }

    @Override
    String getCode() {
        return 'olvm-option-source'
    }

    @Override
    String getName() {
        return 'OLVM Option Source'
    }

    @Override
    List<String> getMethodNames() {
        return new ArrayList<String>(['olvmDatacenters', 'olvmCloudDatacenters', 'olvmClusters', 'olvmTemplates', 'olvmCloudConfiguredDatacenter', 'olvmQcowImages'])
    }

    def olvmQcowImages(args) {
        def rtn = []
        args = args instanceof Object[] ? args.getAt(0) : args
        def images = morpheusContext.async.virtualImage.listIdentityProjections(args?.accountId?.toLong(), ImageType.qcow2).toList().blockingGet()
        if(images) {
            if(args.phrase) {
                rtn = images.findAll{it.name.toLowerCase().contains(args.phrase.toLowerCase())}.collect { img -> [name: img.name, value: img.id] }.sort { it.name }
            } else {
                rtn = images.collect { img -> [name: img.name, value: img.id] }.sort { it.name }
            }
        }
        return rtn
    }

    def olvmTemplates(args) {
        args = args instanceof Object[] ? args.getAt(0) : args
        Cloud cloud = loadCloud(args)
        def rtn = []

        // first grab all images that have been sync'd in by this cloud
        def templates = morpheusContext.async.virtualImage.location.listIdentityProjections(
            new DataQuery().withFilters(
                new DataFilter<String>('refType', 'ComputeZone'),
                new DataFilter<String>('refId', cloud.id)
            )
        ).blockingSubscribe { imageLocation ->
            rtn << [name:imageLocation.virtualImage.name, value:imageLocation.virtualImage.id]
        }

        // then grab all qcow2 images from morpheus that have been user uploaded. These SHOULD also run in olvm
        def images = morpheusContext.async.virtualImage.search(
            new DataQuery().withFilters(
                new DataFilter<VirtualImageType>('imageType', ImageType.qcow2.toString()),
                new DataFilter<Boolean>('userUploaded', true)
            )
        ).blockingGet()

        for (image in images.items) {
            rtn << [name:image.name, value:image.id]
        }

        if(args.phrase) {
            rtn = rtn.findAll{ it.name.toLowerCase().contains(args.phrase.toLowerCase()) }.unique { it.name }.sort { it.name }
        } else {
            rtn = rtn.unique{ it.name }.sort { it.name }
        }

        return rtn
    }

    def olvmCloudConfiguredDatacenter(args) {
        Cloud cloud = loadCloud(args)
        return cloud.configMap.datacenter
    }

    def olvmCloudDatacenters(args) {
        Cloud cloud = loadCloud(args)
        def rtn
        if(cloud?.accountCredentialData?.username && cloud?.accountCredentialData?.password) {
            def connection
            try {
                connection = OlvmComputeUtility.getConnection(cloud)
                def dcResult = OlvmComputeUtility.listDatacenters([connection: connection])
                if (dcResult.success && dcResult.data.datacenters) {
                    rtn = [[name: morpheusContext.services.localization.get('gomorpheus.label.all'), value: 'all']]
                    for (dc in dcResult.data.datacenters) {
                        rtn << [name: "${dc.name()}", value: dc.id()]
                    }
                }
            }
            finally {
                connection?.close()
            }
        }
        return rtn ?: [[name:'No datacenters found: verify credentials above.', value: '-1', isDefault: true]]
    }

    def olvmDatacenters(args) {
        def cloud = loadCloud(args)
        if (cloud.configMap.datacenter != 'all')
            return [[name:'From Cloud Config', value:'good', isDefault:true]]
        else
            return getCloudPools(args, 'datacenter')
    }
    def olvmClusters(args) {
        return getCloudPools(args, 'cluster')
    }

    protected getCloudPools(args, type, cloud = null) {
        cloud = cloud ?: loadCloud(args)
        def rtn = []
        def pools = morpheusContext.async.cloud.pool.search(
            new DataQuery().withFilters(
                new DataFilter<String>('type', type),
                new DataFilter<String>('refType', 'ComputeZone'),
                new DataFilter<String>('refId', cloud.id)
            )
        ).blockingGet()
        for (cloudPool in pools.items) {
            rtn << [name:cloudPool.name, value:cloudPool.id]
        }
        return rtn
    }

    protected Cloud loadCloud(args) {
        args = args instanceof Object[] ? args.getAt(0) : args
        Long cloudId = getCloudId(args)
        Cloud rtn = cloudId ? morpheusContext.async.cloud.getCloudById(cloudId).blockingGet() : null
        def cloud = rtn
        if(!rtn) {
            rtn = new Cloud()
            cloud = args.zone ?: args.domain
        }

        if(args.credential == null && !cloud.serviceUsername) {
            // check for passed in credentials
            if(!rtn.accountCredentialLoaded || !rtn.accountCredentialData) {
                AccountCredential credentials = morpheusContext.services.accountCredential.loadCredentials(rtn)
                rtn.accountCredentialData = credentials?.data
            }
        } else {
            def config = [
                username: cloud.serviceUsername ?: args.zone.serviceUsername,
                password: cloud.servicePassword ?: args.zone.servicePassword
            ]
            rtn.setConfigMap(rtn.getConfigMap() + config)
            rtn.accountCredentialData = morpheusContext.services.accountCredential.loadCredentialConfig(args.credential, config).data
            rtn.serviceUrl = cloud.serviceUrl
        }
        rtn.accountCredentialLoaded = true

        def proxy = args.apiProxy ? morpheusContext.async.network.networkProxy.getById(args.long('apiProxy')).blockingGet() : null
        rtn.apiProxy = proxy

        return rtn
    }

    private static getCloudId(args) {
        args = args instanceof Object[] ? args[0] : args
        def cloudId = args.cloudId ?: args.zoneId // ?: args.domain?.id
        cloudId ? cloudId.toLong() : null
    }
}
