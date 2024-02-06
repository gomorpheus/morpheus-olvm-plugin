package com.morpheus.olvm.sync

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataOrFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.util.SyncTask
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ImageType
import com.morpheusdata.model.OsType
import com.morpheusdata.model.VirtualImage
import com.morpheusdata.model.VirtualImageLocation
import com.morpheusdata.model.projection.VirtualImageIdentityProjection
import com.morpheusdata.model.projection.VirtualImageLocationIdentityProjection
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.core.Observable
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.TemplateContainer
import org.ovirt.engine.sdk4.types.TemplateStatus

@Slf4j
class TemplateSync {
    private Cloud cloud
    private MorpheusContext morpheusContext
    private OlvmCloudPlugin plugin
    private Connection connection

    public TemplateSync(OlvmCloudPlugin plugin, Cloud cloud, Connection connection = null) {
        super()
        this.@cloud = cloud
        this.@plugin = plugin
        this.@connection = connection
    }

    def execute() {
        log.info("Starting OLVM template sync for cloud ${cloud.name})")
        try {
            if (!connection)
                connection = OlvmComputeUtility.getConnection(cloud)

            def olvmTemplates = connection.systemService().templatesService().list().send().templates()
            Observable<VirtualImageLocationIdentityProjection> domainRecords = morpheusContext.async.virtualImage.location.listIdentityProjections(
                new DataQuery().withFilters(
                    new DataFilter<String>("virtualImage.imageType", ImageType.ova.toString()),
                    new DataFilter<String>("refType", "ComputeZone"),
                    new DataFilter<String>("refId", cloud.id)
                )
            )
            SyncTask<VirtualImageLocationIdentityProjection, TemplateContainer, VirtualImageLocation> syncTask = new SyncTask<>(domainRecords, olvmTemplates)
            syncTask.addMatchFunction { VirtualImageLocationIdentityProjection existingItem, TemplateContainer cloudItem ->
                existingItem.externalId == cloudItem.id()
            }.onDelete { removeItems ->
                removeMissingVirtualImages(removeItems)
            }.onUpdate { List<SyncTask.UpdateItem<VirtualImageLocation, TemplateContainer>> updateItems ->
                updateMatchedVirtualImageLocations(updateItems)
            }.onAdd { itemsToAdd ->
                addMissingVirtualImageLocations(itemsToAdd)
            }.withLoadObjectDetailsFromFinder { List<SyncTask.UpdateItemDto<VirtualImageLocationIdentityProjection, VirtualImageLocation>> updateItems ->
                morpheusContext.async.virtualImage.location.listById(updateItems.collect { it.existingItem.id } as List<Long>)
            }.observe()

            log.info("Finished OLVM template sync for cloud ${cloud.name}")
        }
        catch (Throwable t) {
            log.error("Failed to sync OLVM templates: ${t.message}", t)
        }
    }

    protected removeMissingVirtualImages(Collection<VirtualImageLocationIdentityProjection> removeList) {
        morpheusContext.async.virtualImage.location.remove(removeList).blockingGet()
    }

    protected addMissingVirtualImageLocations(Collection<TemplateContainer> addItems) {
        List<String> names = addItems.collect { it.name }
        Observable<VirtualImageIdentityProjection> existingRecords = morpheusContext.async.virtualImage.listIdentityProjections(
            new DataQuery().withFilters(
                new DataFilter<String>("imageType", ImageType.ova.toString()),
                new DataFilter<Collection<String>>("name", "in", names),
                new DataOrFilter(
                    new DataFilter<Boolean>("systemImage", true),
                    new DataOrFilter(
                        new DataFilter("owner", null),
                        new DataFilter<Long>("owner.id", cloud.owner.id)
                    )
                )
            )
        )

        SyncTask<VirtualImageIdentityProjection, TemplateContainer, VirtualImage> syncTask = new SyncTask<>(existingRecords, addItems)
        syncTask.addMatchFunction { VirtualImageIdentityProjection existingItem, TemplateContainer cloudItem ->
            existingItem.name == cloudItem.name
        }.onDelete { removeItems ->
            // noop
        }.onUpdate { List<SyncTask.UpdateItem<VirtualImage, TemplateContainer>> updateItems ->
            updateMatchedVirtualImages(updateItems)
        }.onAdd { itemsToAdd ->
            addMissingVirtualImages(itemsToAdd)
        }.withLoadObjectDetailsFromFinder { List<SyncTask.UpdateItemDto<VirtualImageIdentityProjection, VirtualImage>> updateItems ->
            morpheusContext.async.virtualImage.listById(updateItems.collect { it.existingItem.id } as List<Long>)
        }.observe()
    }

    protected addMissingVirtualImages(Collection<TemplateContainer> addList, String regionCode) {
        def adds = []
        for(cloudItem in addList) {
            String name = cloudItem.name() ?: cloudItem.id()

            // TODO: do block devices show on templates???
            /*
            def blockDeviceMap = cloudItem.diskAttachments()
            def blockDeviceConfig = []
            blockDeviceMap.each { blockDevice ->
                blockDeviceConfig << [
                    deviceName:blockDevice. , ebs: blockDevice.getEbs(), noDevice: blockDevice.getNoDevice(),
                    virtualName: blockDevice.getVirtualName()
                ]
            }
            */

            def imageConfig = [
                category   : "olvm.plugin.template.${cloud.id}", name: cloudItem.name() ?: cloudItem.id(),
                code       : "olvm.plugin.template.${cloud.id}.${cloudItem.id()}", imageType:ImageType.ova.toString(), externalType:cloudItem.type()?.name() ?: null,
                description: cloudItem.description(), remotePath:cloudItem.href(),
                platform   : (cloudItem.os()?.type().contains('windows') ? 'windows' : 'linux'), externalId: cloudItem.id(),
                isCloudInit: (cloudItem.os()?.type().contains('windows') ? false : true),
                status     : cloudItem.status() == TemplateStatus.OK ? 'Active' : cloudItem.status(),
                refType    : 'ComputeZone', refId: "${cloud.id}",
                owner      : cloud.owner, account: cloud.owner
            ]

            if (imageConfig.platform == 'windows') {
                imageConfig.osType = new OsType(code: 'windows')
            } else {
                imageConfig.osType = new OsType(code: 'linux')
            }
            def add = new VirtualImage(imageConfig)

            def locationConfig = [code:"olvm.plugin.template.${cloud.id}.${cloudItem.id()}", externalId:cloudItem.id(),
                                  refType:'ComputeZone', refId:cloud.id, imageName:cloudItem.name()]
            def addLocation = new VirtualImageLocation(locationConfig)
            add.imageLocations = [addLocation]
            adds << add
        }
        // Create em all!
        if(adds) {
            morpheusContext.async.virtualImage.bulkCreate(adds).blockingGet()
        }
    }

    protected updateMatchedVirtualImageLocations(List<SyncTask.UpdateItem<VirtualImageLocation, TemplateContainer>> updateList) {
        def saveLocationList = []
        def saveImageList = []
        def virtualImagesById = morpheusContext.async.virtualImage.listById(updateList.collect { it.existingItem.virtualImage.id }).toMap {it.id}.blockingGet()

        for(def updateItem in updateList) {
            def existingItem = updateItem.existingItem
            def virtualImage = virtualImagesById[existingItem.virtualImage.id]
            def cloudItem = updateItem.masterItem
            def save = false
            def saveImage = false
            def state = cloudItem.status() == TemplateStatus.OK ? 'Active' : cloudItem.status()

            def imageName = cloudItem.name() ?: cloudItem.id()
            if(existingItem.imageName != imageName) {
                existingItem.imageName = imageName

                if(virtualImage.imageLocations?.size() < 2) {
                    virtualImage.name = imageName
                    saveImage = true
                }
                save = true
            }
            if(existingItem.externalId != cloudItem.id()) {
                existingItem.externalId = cloudItem.id()
                save = true
            }
            if(virtualImage.status != state) {
                virtualImage.status = state
                saveImageList << virtualImage
            }
            if(save) {
                saveLocationList << existingItem
            }

            if(saveImage) {
                saveImageList << virtualImage
            }
        }

        if(saveLocationList) {
            morpheusContext.async.virtualImage.location.save(saveLocationList, cloud).blockingGet()
        }
        if(saveImageList) {
            morpheusContext.async.virtualImage.save(saveImageList.unique(), cloud).blockingGet()
        }
    }

    protected updateMatchedVirtualImages(List<SyncTask.UpdateItem<VirtualImage, TemplateContainer>> updateList) {
        def adds = []
        def removes = []
        for(def updateItem in updateList) {
            if(!updateItem.existingItem.imageLocations.find { it.externalId == updateItem.masterItem.id() }) {
                adds << new VirtualImageLocation(
                    virtualImage: updateItem.existingItem,
                    code:"olvm.plugin.template.${cloud.id}.${updateItem.masterItem.id()}",
                    externalId:updateItem.masterItem.id(),
                    refType:'ComputeZone', refId:cloud.id,
                    imageName:updateItem.masterItem.name()
                )
            }

            //prune duplicates
            def locations = [:]
            for(def location : updateItem.existingItem.imageLocations.sort { it.id }) {
                def locationKey = location.refId + ':' + location.refType + ':' + location.externalId
                if(locations[locationKey]) {
                    if(!location.systemImage) {
                        removes << location
                    }
                } else {
                    locations[locationKey] = true
                }
            }
        }
        if(adds) {
            morpheusContext.async.virtualImage.location.bulkCreate(adds).blockingGet()
        }
        if(removes) {
            morpheusContext.async.virtualImage.location.bulkRemove(removes).blockingGet()
        }
    }
}
