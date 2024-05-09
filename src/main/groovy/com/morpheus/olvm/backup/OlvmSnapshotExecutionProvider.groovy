package com.morpheus.olvm.backup

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.backup.BackupExecutionProvider
import com.morpheusdata.core.backup.response.BackupExecutionResponse
import com.morpheusdata.core.backup.util.BackupStatusUtility
import com.morpheusdata.core.util.ComputeUtility
import com.morpheusdata.core.util.DateUtility
import com.morpheusdata.model.Backup
import com.morpheusdata.model.BackupResult
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServer
import com.morpheusdata.model.projection.BackupResultIdentityProjection
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import io.reactivex.rxjava3.schedulers.Schedulers
import org.ovirt.engine.sdk4.Connection
import org.ovirt.engine.sdk4.internal.containers.SnapshotContainer
import org.ovirt.engine.sdk4.types.SnapshotStatus

@Slf4j
class OlvmSnapshotExecutionProvider implements BackupExecutionProvider {
    OlvmCloudPlugin plugin
    MorpheusContext morpheus

    public OlvmSnapshotExecutionProvider(OlvmCloudPlugin plugin, MorpheusContext ctx) {
        super()
        this.@plugin = plugin
        this.morpheus = ctx
    }

    @Override
    ServiceResponse configureBackup(Backup backup, Map config, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse validateBackup(Backup backup, Map config, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse createBackup(Backup backup, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse deleteBackup(Backup backup, Map opts) {
        def rtn = ServiceResponse.success()
        try {
            morpheus.async.backup.backupResult.listIdentityProjections(backup)
                .subscribeOn(Schedulers.io())
                .buffer(50)
                .concatMap {List<BackupResultIdentityProjection> backupResults ->
                    morpheus.async.backup.backupResult.listById(backupResults.collect { it.id})
                }
                .doOnNext { BackupResult backupResult ->
                    deleteBackupResult(backupResult, opts)
                }.blockingSubscribe()
        } catch (Exception ex) {
            log.error("deleteBackup error: {}", ex, ex)
            rtn.success = false
        }

        return rtn
    }

    @Override
    ServiceResponse deleteBackupResult(BackupResult backupResult, Map opts) {
        def rtn = ServiceResponse.success()
        try {
            def cloudId = backupResult.zoneId ?: backupResult.backup.zoneId
            def snapshotIds = backupResult?.configMap?.snapshots?.collect{ it.snapshotId }.unique()

            def cloud
            def backupConfig = backupResult.configMap
            if(cloudId) {
                cloud = morpheus.async.cloud.get(cloudId.toLong()).blockingGet()
            } else {
                def container = morpheus.async.workload.get(backupResult.containerId).blockingGet()
                def server = container?.server
                cloud = server?.cloud
            }

            if(cloud) {
                snapshotIds.each{ snapshotId ->
                    def result = deleteSnapshot(backupConfig.vmId, snapshotId, cloud)
                    if(!result.success) {
                        rtn.success = false
                    }
                }
            }
        }
        catch(Exception ex) {
            log.error("deleteBackupResult error: {}", ex, ex)
        }

        return rtn
    }

    @Override
    ServiceResponse prepareExecuteBackup(Backup backupModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse prepareBackupResult(BackupResult backupResultModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse cancelBackup(BackupResult backupResultModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse extractBackup(BackupResult backupResultModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse<BackupExecutionResponse> executeBackup(Backup backup, BackupResult backupResult, Map executionConfig, Cloud cloud, ComputeServer computeServer, Map opts) {
        ServiceResponse<BackupExecutionResponse> rtn = ServiceResponse.prepare(new BackupExecutionResponse(backupResult))

        try {
            log.debug("backupConfig container: {}", rtn)

            def container
            def vmId = computeServer.externalId

            //execute snapshot
            def result = createSnapshotsForVm(vmId, cloud)
            if(result.success) {
                def totalSize = result.snapshot.totalSize.toLong()
                def targetArchive = []
                def snapshotDisks = []
                result.snapshot?.disks.each { disk ->
                    def volumeSize = disk.provisionedSize.toLong()
                    targetArchive << result.snapshot.snapshotId
                    snapshotDisks << [
                        volumeId:disk.id, snapshotId:result.snapshot.snapshotId, volumeSize:volumeSize, sizeInMb:(volumeSize / ComputeUtility.ONE_MEGABYTE),
                        deviceName:disk.name
                    ]
                }
                rtn.data.backupResult.zoneId
                rtn.data.backupResult.status = BackupStatusUtility.IN_PROGRESS
                rtn.data.backupResult.resultArchive = targetArchive.join(",")
                rtn.data.backupResult.sizeInMb = totalSize / ComputeUtility.ONE_MEGABYTE
                rtn.data.backupResult.setConfigProperty("snapshots", snapshotDisks)
                rtn.data.backupResult.setConfigProperty("vmId", vmId)
                rtn.data.updates = true
            } else {
                rtn.data.backupResult.sizeInMb = 0
                rtn.data.backupResult.status = BackupStatusUtility.FAILED
                rtn.data.updates = true
            }
            rtn.success = true
        } catch(e) {
            log.error("executeBackup: ${e}", e)
            rtn.msg = e.getMessage()
            rtn.data.backupResult.errorOutput = "Failed to execute backup".encodeAsBase64()
            rtn.data.backupResult.sizeInMb = 0
            rtn.data.backupResult.status = BackupStatusUtility.FAILED
            rtn.data.updates = true
        }
        return rtn
    }

    @Override
    ServiceResponse<BackupExecutionResponse> refreshBackupResult(BackupResult backupResult) {
        ServiceResponse<BackupExecutionResponse> rtn = ServiceResponse.prepare(new BackupExecutionResponse(backupResult))
        log.debug("syncBackupResult {}", backupResult)

        try {
            def amazonClient
            ComputeServer server = morpheus.async.computeServer.get(backupResult.serverId).blockingGet()
            Cloud cloud = server?.cloud

            def snapshotIds = backupResult?.configMap?.snapshots?.collect { it.snapshotId }?.unique()

            // if cannot find snapshotIds, just skip
            if (!snapshotIds) {
                rtn.data.updates = false
                rtn.success = true
                return rtn
            }

            def completeCount = 0
            Boolean error = false
            snapshotIds?.each{ snapshotId ->
                def opts = [vmId:server.externalId, snapshotId:snapshotId, cloud:cloud]
                def snapshotResults = OlvmComputeUtility.getSnapshot(opts, morpheus)
                if(snapshotResults.success == true) {
                    SnapshotContainer snapshot = snapshotResults.data
                    if(snapshot.snapshotStatus() == SnapshotStatus.OK) {
                        completeCount++
                    }
                }
                else {
                    error = true
                }
            }

            if(!error && completeCount == snapshotIds?.size()) { //all complete, update status
                rtn.data.updates = true
                rtn.data.backupResult.status = BackupStatusUtility.SUCCEEDED
                if(!backupResult.endDate) {
                    rtn.data.backupResult.endDate = new Date()
                    def startDate = backupResult.startDate
                    if(startDate) {
                        def start = DateUtility.parseDate(startDate)
                        def end = rtn.data.backupResult.endDate
                        rtn.data.backupResult.durationMillis = end.time - start.time
                    }
                }
                rtn.success = true
            }
            else if(error) {
                rtn.data.updates = true
                rtn.data.backupResult.status = BackupStatusUtility.FAILED
                if(!backupResult.endDate) {
                    rtn.data.backupResult.endDate = new Date()
                    def startDate = backupResult.startDate
                    if(startDate) {
                        def start = DateUtility.parseDate(startDate)
                        def end = rtn.data.backupResult.endDate
                        rtn.data.backupResult.durationMillis = end.time - start.time
                    }
                }
            } else {
                rtn.data.updates = false
                rtn.success = true
            }
        } catch (Exception e) {
            log.error("refreshBackupResult error: {}", e, e)
        }

        return rtn
    }

    protected createSnapshotsForVm(vmId, Cloud cloud){
        log.debug("createSnapshotsForVm: ${vmId}")
        def rtn = [success:true]
        rtn.snapshot = createSnapshot(vmId, cloud)
        return rtn
    }

    protected getVolumesForVm(vmId, Cloud cloud, Connection connection = null){
        def disks = []
        def closeConnection = false
        try {
            if (!connection) {
                connection = OlvmComputeUtility.getConnection(cloud)
                closeConnection = true
            }
            def vmService = connection.systemService().vmsService().vmService(vmId)
            for (diskAttachment in vmService.diskAttachmentsService().list().send().attachments()) {
                def disk = connection.followLink(diskAttachment.disk())
                disks << [
                    name           : disk.name(),
                    id             : disk.id(),
                    status         : disk.status().toString(),
                    size           : disk.provisionedSize(),
                    bootable       : diskAttachment.bootable(),
                    storageDomainId: disk.storageDomain()?.id()
                ]
            }
        }
        finally {
            if (closeConnection)
                connection.close()
        }
        return disks
    }

    protected createSnapshot(vmId, Cloud cloud, Connection connection = null) {
        def rtn = [:]
        def closeConnection = false
        try {
            if (!connection) {
                connection = OlvmComputeUtility.getConnection(cloud, morpheus)
                closeConnection = true
            }
            log.debug("createSnapshot: ${vmId}")
            def snapShotResult = OlvmComputeUtility.snapshotVm([
                connection:connection, vmId:vmId, description:"Vm (${vmId}) snapshot on ${new Date()}"
            ])
            def snapshot = snapShotResult.data
            rtn.snapshotId = snapshot.id
            rtn.status = snapshot.status
            rtn.totalSize = 0l
            rtn.disks = []

            // grab all the disk info for the VM snapshot
            def snapshotService = connection.systemService().vmsService().vmService(vmId).snapshotsService().snapshotService(rtn.snapshotId)

            for (disk in snapshotService.disksService().list().send().disks()) {
                rtn.disks << [
                    id:disk.id(),
                    name:disk.name(),
                    provisionedSize:disk.provisionedSize()
                ]
                rtn.totalSize += disk.provisionedSize()
            }

            rtn.success = true
        }
        finally {
            if (closeConnection)
                connection?.close()
        }

        return rtn
    }

    protected deleteSnapshot(String vmId, String snapshotId, Cloud cloud, Connection connection = null) {
        def rtn = ServiceResponse.success()
        def closeConnection = false
        try {
            if (!connection) {
                connection = OlvmComputeUtility.getConnection(cloud, morpheus)
                closeConnection = true
            }

            def snapshotService = connection.systemService().vmsService().vmService(vmId).snapshotsService().snapshotService(snapshotId)
            snapshotService.remove().send()
            log.debug("deleted snapshot ${snapshotId}")
        }
        catch (Exception ex) {
            rtn.success = false
            log.error("Failed to delete snapshot ${snapshotId}", ex)
        }
        finally {
            if (closeConnection)
                connection?.close()
        }
        return rtn
    }
}
