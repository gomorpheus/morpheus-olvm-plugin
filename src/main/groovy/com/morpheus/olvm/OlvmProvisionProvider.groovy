package com.morpheus.olvm

import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.AbstractProvisionProvider
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import com.morpheusdata.core.data.DataFilter
import com.morpheusdata.core.data.DataQuery
import com.morpheusdata.core.providers.CloudProvider
import com.morpheusdata.core.providers.WorkloadProvisionProvider
import com.morpheusdata.core.util.ComputeUtility
import com.morpheusdata.core.util.MorpheusUtils
import com.morpheusdata.model.Account
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServer
import com.morpheusdata.model.Icon
import com.morpheusdata.model.OptionType
import com.morpheusdata.model.ServicePlan
import com.morpheusdata.model.StorageVolume
import com.morpheusdata.model.StorageVolumeType
import com.morpheusdata.model.VirtualImage
import com.morpheusdata.model.VirtualImageLocation
import com.morpheusdata.model.Workload
import com.morpheusdata.model.provisioning.NetworkConfiguration
import com.morpheusdata.model.provisioning.WorkloadRequest
import com.morpheusdata.response.PrepareWorkloadResponse
import com.morpheusdata.response.ProvisionResponse
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.TemplateContainer

@Slf4j
class OlvmProvisionProvider extends AbstractProvisionProvider implements WorkloadProvisionProvider {
	public static final String PROVISION_PROVIDER_CODE = 'cloud.olvm.provision'

	protected MorpheusContext context
	protected Plugin plugin

	public OlvmProvisionProvider(Plugin plugin, MorpheusContext ctx) {
		super()
		this.@context = ctx
		this.@plugin = plugin
	}

	/**
	 * This method is called before runWorkload and provides an opportunity to perform action or obtain configuration
	 * that will be needed in runWorkload. At the end of this method, if deploying a ComputeServer with a VirtualImage,
	 * the sourceImage on ComputeServer should be determined and saved.
	 * @param workload the Workload object we intend to provision along with some of the associated data needed to determine
	 *                 how best to provision the workload
	 * @param workloadRequest the RunWorkloadRequest object containing the various configurations that may be needed
	 *                        in running the Workload. This will be passed along into runWorkload
	 * @param opts additional configuration options that may have been passed during provisioning
	 * @return Response from API
	 */
	@Override
	ServiceResponse<PrepareWorkloadResponse> prepareWorkload(Workload workload, WorkloadRequest workloadRequest, Map opts) {
		ServiceResponse<PrepareWorkloadResponse> resp = new ServiceResponse<>()
		resp.data = new PrepareWorkloadResponse(workload: workload, options: [sendIp: false])
		ComputeServer server = workload.server

		if(server.platform == "linux") {
			resp.data.disableCloudInit = false
			resp.data.disableAutoUpdates = false
		}

		//lets figure out what image we are deploying
		Connection connection
		try {
			connection = OlvmComputeUtility.getConnection(server.cloud)
			def imageType = workload.getConfigMap().imageType ?: 'default'
			//amazon generic instance type has a radio button for this
			def virtualImage = getWorkloadImage(workload, opts)
			def config = workload.configMap
			if (virtualImage) {
				//this ensures the image is set correctly for provisioning as it enters runWorkload
				workload.server.sourceImage = virtualImage
				VirtualImageLocation location = ensureVirtualImageLocation(connection, virtualImage, server.cloud)
				resp.data.setVirtualImageLocation(location)

				if (virtualImage.osType?.name?.contains('ubuntu') && MorpheusUtils.compareVersions(virtualImage.osType?.osVersion, '16.04') >= 0) {
					resp.data.disableAutoUpdates = true
				}
				resp.success = true
			}
			else {
				resp.success = false
				resp.msg = "Virtual Image not found"
			}
		}
		finally {
			connection?.close()
		}

		return resp
	}

	/**
	 * Some older clouds have a provision type code that is the exact same as the cloud code. This allows one to set it
	 * to match and in doing so the provider will be fetched via the cloud providers {@link CloudProvider#getDefaultProvisionTypeCode()} method.
	 * @return code for overriding the ProvisionType record code property
	 */
	@Override
	String getProvisionTypeCode() {
		return PROVISION_PROVIDER_CODE
	}

	/**
	 * Provide an icon to be displayed for ServicePlans, VM detail page, etc.
	 * where a circular icon is displayed
	 * @since 0.13.6
	 * @return Icon
	 */
	@Override
	Icon getCircularIcon() {
		// TODO: change icon paths to correct filenames once added to your project
		return new Icon(path:'provision-circular.svg', darkPath:'provision-circular-dark.svg')
	}

	/**
	 * Provides a Collection of OptionType inputs that need to be made available to various provisioning Wizards
	 * @return Collection of OptionTypes
	 */
	@Override
	Collection<OptionType> getOptionTypes() {
		Collection<OptionType> options = []
		options << new OptionType([
			name:'datacenter',
			code:'olvm.plugin.provision.datacenter',
			category:'provisionType.olvm',
			fieldName:'datacenterId',
			fieldContext:'config',
			fieldLabel:'Datacenter',
			required:true,
			noBlank:true,
			inputType:OptionType.InputType.SELECT,
			displayOrder:100,
			optionSource:'olvmDatacenters'
		])
		options << new OptionType([
			name:'cluster',
			code:'olvm.plugin.provision.cluster',
			category:'provisionType.olvm',
			fieldName:'clusterId',
			fieldContext:'config',
			fieldLabel:'Cluster',
			required:true,
			noBlank:true,
			inputType:OptionType.InputType.SELECT,
			displayOrder:110,
			optionSource:'olvmClusters'
		])
		return options
	}

	/**
	 * Provides a Collection of OptionType inputs for configuring node types
	 * @since 0.9.0
	 * @return Collection of OptionTypes
	 */
	@Override
	Collection<OptionType> getNodeOptionTypes() {
		Collection<OptionType> nodeOptions = []
		return nodeOptions
	}

	/**
	 * Provides a Collection of StorageVolumeTypes that are available for root StorageVolumes
	 * @return Collection of StorageVolumeTypes
	 */
	@Override
	Collection<StorageVolumeType> getRootVolumeStorageTypes() {
		return getStorageVolumeTypes()
	}

	/**
	 * Provides a Collection of StorageVolumeTypes that are available for data StorageVolumes
	 * @return Collection of StorageVolumeTypes
	 */
	@Override
	Collection<StorageVolumeType> getDataVolumeStorageTypes() {
		return getStorageVolumeTypes()
	}

	private getStorageVolumeTypes() {
		Collection<StorageVolumeType> volumeTypes = []

		volumeTypes << new StorageVolumeType([
			code        : 'olvm-standard', displayName: 'standard', name: 'standard',
			description : 'OLVM standard volume', volumeType: 'volume', enabled: true,
			customLabel : true, customSize: true, defaultType: true, autoDelete: true,
			minStorage  : (ComputeUtility.ONE_GIGABYTE), maxStorage: (16L * ComputeUtility.ONE_TERABYTE),
			hasDatastore: true, allowSearch: true, volumeCategory: 'volume',
			displayOrder: 0
		])
	}

	/**
	 * Provides a Collection of ${@link ServicePlan} related to this ProvisionProvider that can be seeded in.
	 * Some clouds do not use this as they may be synced in from the public cloud. This is more of a factor for
	 * On-Prem clouds that may wish to have some precanned plans provided for it.
	 * @return Collection of ServicePlan sizes that can be seeded in at plugin startup.
	 */
	@Override
	Collection<ServicePlan> getServicePlans() {
		Collection<ServicePlan> plans = []
		plans << new ServicePlan(
			code:'olvm.plugin.512',
			editable:true,
			name:'1 CPU, 512MB Memory',
			description:'1 CPU, 512MB Memory',
			sortOrder:0,
			maxStorage:10l * 1024l * 1024l * 1024l,
			maxMemory:1l * 512l * 1024l * 1024l, maxCpu:0,
			maxCores:1,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.1024',
			editable:true,
			name:'1 CPU, 1GB Memory',
			description:'1 CPU, 1GB Memory',
			sortOrder:1,
			maxStorage:10l * 1024l * 1024l * 1024l,
			maxMemory:1l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:1,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.2048',
			editable:true,
			name:'1 CPU, 2GB Memory',
			description:'1 CPU, 2GB Memory',
			sortOrder:2,
			maxStorage:20l * 1024l * 1024l * 1024l,
			maxMemory:2l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:1,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.4096',
			editable:true,
			name:'1 CPU, 4GB Memory',
			description:'1 CPU, 4GB Memory',
			sortOrder:3,
			maxStorage:40l * 1024l * 1024l * 1024l,
			maxMemory:4l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:1,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.8192',
			editable:true,
			name:'2 CPU, 8GB Memory',
			description:'2 CPU, 8GB Memory',
			sortOrder:4,
			maxStorage:80l * 1024l * 1024l * 1024l,
			maxMemory:8l * 1024l * 1024l * 1024l,
			maxCpu:0, maxCores:2,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.16384',
			editable:true,
			name:'2 CPU, 16GB Memory',
			description:'2 CPU, 16GB Memory',
			sortOrder:5,
			maxStorage:160l * 1024l * 1024l * 1024l,
			maxMemory:16l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:2,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.24576',
			editable:true,
			name:'4 CPU, 24GB Memory',
			description:'4 CPU, 24GB Memory',
			sortOrder:6,
			maxStorage:240l * 1024l * 1024l * 1024l,
			maxMemory:24l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:4,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.32768',
			editable:true,
			name:'4 CPU, 32GB Memory',
			description:'4 CPU, 32GB Memory',
			sortOrder:7,
			maxStorage:320l * 1024l * 1024l * 1024l,
			maxMemory:32l * 1024l * 1024l * 1024l,
			maxCpu:0,
			maxCores:4,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			coresPerSocket:1
		)
		plans << new ServicePlan(
			code:'olvm.plugin.custom',
			editable:true,
			name:'Custom OLVM',
			description:'Custom OLVM',
			sortOrder:20,
			customMaxStorage:true,
			customMaxDataStorage:true,
			addVolumes:true,
			customCpu:true,
			customCores:true,
			customMaxMemory:true,
			deletable:false,
			provisionable:true,
			maxStorage:0l,
			maxMemory:0l,
			maxCpu:0,
			maxCores:1,
			coresPerSocket:0
		)
		return plans
	}

	@Override
	Boolean lvmSupported() {
		return true
	}

	@Override
	Boolean multiTenant() {
		return false
	}

	@Override
	Boolean aclEnabled() {
		return false
	}

	@Override
	String getHostDiskMode() {
		return "lvm"
	}

	@Override
	Boolean hasSecurityGroups() {
		return false
	}

	@Override
	Boolean supportsAutoDatastore() {
		return false
	}

	/**
	 * Determines if this provision type has datastores that can be selected or not.
	 * @return Boolean representation of whether or not this provision type has datastores
	 */
	@Override
	Boolean hasDatastores() {
		return true
	}

	/**
	 * Determines if this provision type has networks that can be selected or not.
	 * @return Boolean representation of whether or not this provision type has networks
	 */
	@Override
	Boolean hasNetworks() {
		return true
	}

	/**
	 * Determines if this provision type supports service plans that expose the tag match property.
	 * @return Boolean representation of whether or not service plans expose the tag match property.
	 */
	@Override
	Boolean hasPlanTagMatch() {
		return false
	}

	/**
	 * Returns the maximum number of network interfaces that can be chosen when provisioning with this type
	 * @return maximum number of networks or 0,null if unlimited.
	 */
	@Override
	Integer getMaxNetworks() {
		return 0
	}

	/**
	 * Determines if this provision type has resources pools that can be selected or not.
	 * @return Boolean representation of whether or not this provision type has resource pools
	 */
	@Override
	Boolean hasComputeZonePools() {
		false
	}

	/**
	 * Indicates if Network selection should be scoped to the ComputeZonePool selected during provisioning
	 * @return Boolean
	 */
	Boolean networksScopedToPools() {
		return false
	}

	/**
	 * Indicates if a ComputeZonePool is required during provisioning
	 * @return Boolean
	 */
	@Override
	Boolean computeZonePoolRequired() {
		return false
	}

	/**
	 * Determines if this provision type allows the rot volume to be renamed.
	 * @return Boolean representation of whether or not this provision type allows the rot volume to be renamed
	 */
	@Override
	Boolean canCustomizeRootVolume() {
		return true
	}

	/**
	 * Determines if this provision type allows the root volume to be resized.
	 * @return Boolean representation of whether or not this provision type allows the root volume to be resized
	 */
	@Override
	Boolean canResizeRootVolume() {
		return true
	}

	/**
	 * Indicates if volumes may be added during provisioning
	 * @return Boolean
	 */
	@Override
	Boolean canAddVolumes() {
		return true
	}

	/**
	 * Determines if this provision type allows the user to add data volumes.
	 * @return Boolean representation of whether or not this provision type allows the user to add data volumes
	 */
	@Override
	Boolean canCustomizeDataVolumes() {
		return true
	}

	@Override
	Boolean customSupported() {
		return true
	}

	@Override
	Boolean createDefaultInstanceType() {
		return true
	}

	@Override
	ArrayList<OptionType> getDefaultInstanceTypeOptions() {
		Collection<OptionType> options = []
		options << new OptionType([
			name:'template',
			code:'olvm.plugin.provision.template',
			category:'provisionType.olvm',
			fieldName:'templateId',
			fieldContext:'config',
			fieldLabel:'Template',
			required:true,
			noBlank:true,
			inputType:OptionType.InputType.SELECT,
			displayOrder:110,
			optionSource:'olvmTemplates'
		])
	}

	/**
	 * Custom service plans can be created for this provider
	 * @return Boolean
	 */
	Boolean supportsCustomServicePlans() {
		return true;
	}

	/**
	 * Validates the provided provisioning options of a workload. A return of success = false will halt the
	 * creation and display errors
	 * @param opts options
	 * @return Response from API. Errors should be returned in the errors Map with the key being the field name and the error
	 * message as the value.
	 */
	@Override
	ServiceResponse validateWorkload(Map opts) {
		log.debug("validateWorkload: ${opts}")
		ServiceResponse rtn = new ServiceResponse(true, null, [:], null)
		try {
			def cloud = morpheus.async.cloud.getCloudById(opts.cloud?.id ?: opts.zoneId).blockingGet()
			def validateTemplate = opts.template != null
			def validationResults = OlvmComputeUtility.validateServerConfig(morpheus, [cloud:cloud, validateTemplate:validateTemplate] + opts)
			if(!validationResults.success) {
				validationResults.errors?.each { it ->
					rtn.addError(it.field, it.msg)
				}
			}
		} catch(e) {
			log.error("validateWorkload error: ${e}", e)
		}
		return rtn
	}

	/**
	 * This method is a key entry point in provisioning a workload. This could be a vm, a container, or something else.
	 * Information associated with the passed Workload object is used to kick off the workload provision request
	 * @param workload the Workload object we intend to provision along with some of the associated data needed to determine
	 *                 how best to provision the workload
	 * @param workloadRequest the RunWorkloadRequest object containing the various configurations that may be needed
	 *                        in running the Workload
	 * @param opts additional configuration options that may have been passed during provisioning
	 * @return Response from API
	 */
	@Override
	ServiceResponse<ProvisionResponse> runWorkload(Workload workload, WorkloadRequest workloadRequest, Map opts) {
		log.debug "runWorkload: ${workload} ${workloadRequest} ${opts}"
		Connection connection = opts.connection
		def closeConnection = false
		ProvisionResponse provisionResponse = new ProvisionResponse(success: true)
		ComputeServer server = workload.server
		try {
			Cloud cloud = server.cloud
			if (!connection) {
				connection = OlvmComputeUtility.getConnection(cloud)
				closeConnection = true
			}
			VirtualImage virtualImage = server.sourceImage
			def runConfig = buildWorkloadRunConfig(workload, workloadRequest, virtualImage, connection, opts)
			runVirtualMachine(runConfig, provisionResponse, opts + [connection:connection])
			log.info("Checking Server Interfaces....")
			workload.server.interfaces?.each { netInt ->
				log.info("Net Interface: ${netInt.id} -> Network: ${netInt.network?.id}")
			}
			provisionResponse.noAgent = opts.noAgent ?: false
			return new ServiceResponse<ProvisionResponse>(success: true, data: provisionResponse)
		}
		catch (Throwable t) {
			log.error("runWorkload error: ${t.message}", t)
			provisionResponse.setError(t.message)
			return new ServiceResponse(success: false, msg:t.message, error:e.message, data: provisionResponse)
		}
		finally {
			if (closeConnection)
				connection?.close()
		}
	}

	/**
	 * This method is called after successful completion of runWorkload and provides an opportunity to perform some final
	 * actions during the provisioning process. For example, ejected CDs, cleanup actions, etc
	 * @param workload the Workload object that has been provisioned
	 * @return Response from the API
	 */
	@Override
	ServiceResponse finalizeWorkload(Workload workload) {
		return ServiceResponse.success()
	}

	/**
	 * Issues the remote calls necessary top stop a workload element from running.
	 * @param workload the Workload we want to shut down
	 * @return Response from API
	 */
	@Override
	ServiceResponse stopWorkload(Workload workload) {
		return ServiceResponse.success()
	}

	/**
	 * Issues the remote calls necessary to start a workload element for running.
	 * @param workload the Workload we want to start up.
	 * @return Response from API
	 */
	@Override
	ServiceResponse startWorkload(Workload workload) {
		return ServiceResponse.success()
	}

	/**
	 * Issues the remote calls to restart a workload element. In some cases this is just a simple alias call to do a stop/start,
	 * however, in some cases cloud providers provide a direct restart call which may be preferred for speed.
	 * @param workload the Workload we want to restart.
	 * @return Response from API
	 */
	@Override
	ServiceResponse restartWorkload(Workload workload) {
		// Generally a call to stopWorkLoad() and then startWorkload()
		return ServiceResponse.success()
	}

	/**
	 * This is the key method called to destroy / remove a workload. This should make the remote calls necessary to remove any assets
	 * associated with the workload.
	 * @param workload to remove
	 * @param opts map of options
	 * @return Response from API
	 */
	@Override
	ServiceResponse removeWorkload(Workload workload, Map opts) {
		return ServiceResponse.success()
	}

	/**
	 * Method called after a successful call to runWorkload to obtain the details of the ComputeServer. Implementations
	 * should not return until the server is successfully created in the underlying cloud or the server fails to
	 * create.
	 * @param server to check status
	 * @return Response from API. The publicIp and privateIp set on the WorkloadResponse will be utilized to update the ComputeServer
	 */
	@Override
	ServiceResponse<ProvisionResponse> getServerDetails(ComputeServer server) {
		return new ServiceResponse<ProvisionResponse>(true, null, null, new ProvisionResponse(success:true))
	}

	/**
	 * Method called before runWorkload to allow implementers to create resources required before runWorkload is called
	 * @param workload that will be provisioned
	 * @param opts additional options
	 * @return Response from API
	 */
	@Override
	ServiceResponse createWorkloadResources(Workload workload, Map opts) {
		return ServiceResponse.success()
	}

	/**
	 * Stop the server
	 * @param computeServer to stop
	 * @return Response from API
	 */
	@Override
	ServiceResponse stopServer(ComputeServer computeServer) {
		return ServiceResponse.success()
	}

	/**
	 * Start the server
	 * @param computeServer to start
	 * @return Response from API
	 */
	@Override
	ServiceResponse startServer(ComputeServer computeServer) {
		return ServiceResponse.success()
	}

	/**
	 * Returns the Morpheus Context for interacting with data stored in the Main Morpheus Application
	 *
	 * @return an implementation of the MorpheusContext for running Future based rxJava queries
	 */
	@Override
	MorpheusContext getMorpheus() {
		return this.@context
	}

	/**
	 * Returns the instance of the Plugin class that this provider is loaded from
	 * @return Plugin class contains references to other providers
	 */
	@Override
	Plugin getPlugin() {
		return this.@plugin
	}

	/**
	 * A unique shortcode used for referencing the provided provider. Make sure this is going to be unique as any data
	 * that is seeded or generated related to this provider will reference it by this code.
	 * @return short code string that should be unique across all other plugin implementations.
	 */
	@Override
	String getCode() {
		return PROVISION_PROVIDER_CODE
	}

	/**
	 * Provides the provider name for reference when adding to the Morpheus Orchestrator
	 * NOTE: This may be useful to set as an i18n key for UI reference and localization support.
	 *
	 * @return either an English name of a Provider or an i18n based key that can be scanned for in a properties file.
	 */
	@Override
	String getName() {
		return 'OLVM Cloud Plugin Provisioning'
	}

	protected getWorkloadImage(Workload workload, Map opts = [:]) {
		VirtualImage rtn
		def containerConfig = workload.getConfigMap()
		def imageType = containerConfig.imageType ?: 'default'
		if(imageType == 'private' && containerConfig.imageId) {
			rtn = morpheus.async.virtualImage.get(containerConfig.imageId as Long).blockingGet()
		}
		else if(imageType == 'local' && (containerConfig.localImageId || containerConfig.template)) {
			Long localImageId = getImageId(containerConfig.localImageId) ?: getImageId(containerConfig.template)
			if(localImageId) {
				rtn = morpheus.async.virtualImage.get(localImageId).blockingGet()
			}
		}
		else if(workload.workloadType.virtualImage) {
			rtn = workload.workloadType.virtualImage
		}
		else if (containerConfig.templateId) {
			rtn = morpheus.async.virtualImage.find(
				new DataQuery().withFilters(new DataFilter<String>('externalId', containerConfig.templateId))
			).blockingGet()
		}
		return rtn
	}

	protected VirtualImageLocation ensureVirtualImageLocation(Connection connection, VirtualImage virtualImage, Cloud cloud) {
		def rtn = virtualImage.imageLocations?.find{it.refType == 'ComputeZone' && it.refId == cloud.id}
		if(!rtn) {
			rtn = virtualImage.imageLocations?.find{it.refType == 'ComputeZone' && it.refId == cloud.id}
		}
		if(!rtn) {
			def templateResults
			if(!virtualImage.externalId) {
				//load image by name
				templateResults = OlvmComputeUtility.loadImage([connection: connection, imageName: virtualImage.name, isPublic: true])
			}
			else {
				templateResults = OlvmComputeUtility.loadImage([connection: connection, imageId: virtualImage.externalId])
			}
			if (templateResults.success && templateResults.data.template) {
				TemplateContainer template = templateResults.data.template
				def newLocation = new VirtualImageLocation(
					virtualImage: virtualImage, imageName: virtualImage.name, externalId: template.id(),
					code: "olvm.plugin.template.${cloud.id}.${template.id()}",
					refType:'ComputeZone', refId:cloud.id
				)
				newLocation = morpheus.async.virtualImage.location.create(newLocation, cloud).blockingGet()
				rtn = newLocation
			}
		}
		return rtn
	}

	protected buildWorkloadRunConfig(Workload workload, WorkloadRequest workloadRequest, VirtualImage virtualImage, Connection connection, Map opts) {
		log.debug("buildRunConfig: {}, {}, {}, {}", workload, workloadRequest, virtualImage, opts)
		Map workloadConfig = workload.getConfigMap()
		ComputeServer server = workload.server
		Cloud cloud = server.cloud
		StorageVolume rootVolume = server.volumes?.find{it.rootVolume == true}

		def maxMemory = server.maxMemory
		def maxStorage = rootVolume.getMaxStorage()

		def runConfig = [:] + opts + buildRunConfig(server, virtualImage, workloadRequest.networkConfiguration, connection, workloadConfig, opts)

		runConfig += [
			name              : server.name,
			instanceId		  : workload.instance.id,
			containerId       : workload.id,
			account 		  : server.account,
			osDiskSize		  : maxStorage.div(ComputeUtility.ONE_GIGABYTE),
			maxStorage        : maxStorage,
			maxMemory		  : maxMemory,
			applianceServerUrl: workloadRequest.cloudConfigOpts?.applianceUrl,
			workloadConfig    : workload.getConfigMap(),
			timezone          : (server.getConfigProperty('timezone') ?: cloud.timezone),
			proxySettings     : workloadRequest.proxyConfiguration,
			noAgent           : (opts.config?.containsKey("noAgent") == true && opts.config.noAgent == true),
			installAgent      : (opts.config?.containsKey("noAgent") == false || (opts.config?.containsKey("noAgent") && opts.config.noAgent != true)),
			userConfig        : workloadRequest.usersConfiguration,
			cloudConfig	      : workloadRequest.cloudConfigUser,
			networkConfig	  : workloadRequest.networkConfiguration
		]

		return runConfig
	}

	protected buildRunConfig(ComputeServer server, VirtualImage virtualImage, NetworkConfiguration networkConfiguration, Connection connection, config, Map opts) {
		log.debug("buildRunConfig: {}, {}, {}, {}, {}", server, virtualImage, networkConfiguration, config, opts)
		Cloud cloud = server.cloud
		def network = networkConfiguration.primaryInterface?.network
		if(!network && server.interfaces) {
			network = server.interfaces.find {it.primaryInterface}?.network
		}
		def rootVolume = server.volumes?.find{it.rootVolume == true}
		def dataDisks = server?.volumes?.findAll{it.rootVolume == false}?.sort{it.id}
		def maxStorage
		if(rootVolume) {
			maxStorage = rootVolume.maxStorage
		} else {
			maxStorage = config.maxStorage ?: server.plan.maxStorage
		}

		// get data center and cluster information
		def zonePoolService = morpheus.async.cloud.pool
		def datacenter = zonePoolService.get(config.datacenterId).blockingGet()
		def cluster = zonePoolService.get(config.clusterId).blockingGet()

		def runConfig = [
			serverId:server.id,
			connection:connection,
			name:server.name,
			securityRef:config.securityId,
			networkRef:network?.externalId,
			datacenterRef:datacenter.externalId,
			datacenterName:datacenter.name,
			clusterRef:cluster.externalId,
			clusterName:cluster.name,
			server:server,
			imageType:virtualImage.imageType,
			serverOs:server.serverOs ?: virtualImage.osType,
			osType:(virtualImage.osType?.platform == 'windows' ? 'windows' : 'linux') ?: virtualImage.platform,
			platform:(virtualImage.osType?.platform == 'windows' ? 'windows' : 'linux') ?: virtualImage.platform,
			osDiskSize:maxStorage.div(ComputeUtility.ONE_GIGABYTE),
			maxStorage:maxStorage,
			osDiskName:'/dev/sda1',
			dataDisks:dataDisks,
			rootVolume:rootVolume,
			virtualImage:virtualImage,
			hostname:server.getExternalHostname(),
			hosts:server.getExternalHostname(),
			diskList:[],
			domainName:server.getExternalDomain(),
			serverInterfaces:server.interfaces,
			fqdn:server.getExternalHostname() + '.' + server.getExternalDomain()
		]

		runConfig.virtualImageLocation = ensureVirtualImageLocation(connection, virtualImage, server.cloud)

		log.debug("Setting snapshot image refs opts.snapshotImageRef: ${opts.snapshotImageRef},  ${opts.rootSnapshotId}")
		// use selected provision image
		runConfig.imageRef = runConfig.virtualImageLocation.externalId

		return runConfig
	}

	protected void runVirtualMachine(Map runConfig, ProvisionResponse provisionResponse, Map opts) {
		try {
			// don't think this used
			// runConfig.template = runConfig.imageId
			def runResults = insertVm(runConfig, provisionResponse, opts)
			if(provisionResponse.success) {
				finalizeVm(runConfig, provisionResponse, runResults)
			}
		} catch(e) {
			log.error("runVirtualMachine error:${e}", e)
			provisionResponse.setError('failed to upload image file')
		}
	}

	protected insertVm(Map runConfig, ProvisionResponse provisionResponse, Map opts) {
		log.debug("insertVm runConfig: {}", runConfig)
		def taskResults = [success:false]
		ComputeServer server = runConfig.server
		Account account = server.account
		opts.createUserList = runConfig.userConfig.createUsers

		//save server
		runConfig.server = saveAndGet(server)

		//set install agent
		runConfig.installAgent = runConfig.noAgent && server.cloud.agentMode != 'cloudInit'

		//data volumes
		if(runConfig.dataDisks)
			runConfig.diskList = buildDataDiskList(runConfig.dataDisks)
		def createResults = OlvmComputeUtility.createServer(runConfig)
		log.debug("create server: ${createResults}")
		if(createResults.success == true && createResults.data.vmId) {
			server.externalId = createResults.data.vmId
			server.powerState = 'on'
			provisionResponse.externalId = server.externalId
			server = saveAndGet(server)
			runConfig.server = server

			OlvmComputeUtility.waitForServerExists([connection:runConfig.connection, server:server])
			// TODO: add data disks

			// start vm for the first time
			OlvmComputeUtility.startVm([connection:runConfig.connection, server:server])

			//wait for ready
			def statusResults = OlvmComputeUtility.checkServerReady(runConfig)
			if(statusResults.success == true) {
				//good to go
				def serverDetails = statusResults.data
				log.debug("server details: {}", serverDetails)
				//update network info
				def privateIp = serverDetails.ipV4?.first()
				def publicIp = privateIp

				taskResults.server = createResults.server
				taskResults.success = true
			}
			else {
				taskResults.message = 'Failed to get server status'
			}
		}
		else {
			taskResults.message = createResults.msg
		}
		return taskResults
	}

	def buildDataDiskList(dataDisks) {
		def rtn = []
		if(dataDisks) {
			dataDisks?.eachWithIndex { dataVolume, index ->
				def deviceName = OlvmComputeUtility.getDeviceName(index+1)
				rtn << [diskType:dataVolume?.type?.name ?: 'standard', diskSize: dataVolume.maxStorage.div(ComputeUtility.ONE_GIGABYTE),
						deviceName:deviceName]
				dataVolume.deviceName = deviceName
			}
		}
		return rtn
	}

	protected Long getImageId(imageId) {
		Long rtn
		try {
			rtn = imageId?.toLong()
		} catch(e) {
			//nothing
		}
		return rtn
	}

	protected ComputeServer saveAndGet(ComputeServer server) {
		def saveSuccessful = morpheus.async.computeServer.save([server]).blockingGet()
		if(!saveSuccessful) {
			log.warn("Error saving server: ${server?.id}" )
		}
		return morpheus.async.computeServer.get(server.id).blockingGet()
	}
}
