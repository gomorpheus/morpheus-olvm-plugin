package com.morpheus.olvm.backup

import com.morpheus.olvm.OlvmCloudPlugin
import com.morpheus.olvm.util.OlvmComputeUtility
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.backup.BackupRestoreProvider
import com.morpheusdata.core.backup.response.BackupRestoreResponse
import com.morpheusdata.model.Backup
import com.morpheusdata.model.BackupRestore
import com.morpheusdata.model.BackupResult
import com.morpheusdata.model.Cloud
import com.morpheusdata.model.ComputeServer
import com.morpheusdata.model.Instance
import com.morpheusdata.model.Workload
import com.morpheusdata.response.ServiceResponse
import groovy.util.logging.Slf4j
import org.ovirt.engine.sdk4.Connection

@Slf4j
class OlvmSnapshotRestoreProvider implements BackupRestoreProvider{
    OlvmCloudPlugin plugin
    MorpheusContext morpheus

    public OlvmSnapshotRestoreProvider(OlvmCloudPlugin plugin, MorpheusContext ctx) {
        super()
        this.@plugin = plugin
        this.@morpheus = ctx
    }

    @Override
    ServiceResponse configureRestoreBackup(BackupResult backupResultModel, Map config, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse getBackupRestoreInstanceConfig(BackupResult backupResultModel, Instance instanceModel, Map restoreConfig, Map opts) {
        return ServiceResponse.success(restoreConfig)
    }

    @Override
    ServiceResponse validateRestoreBackup(BackupResult backupResultModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse getRestoreOptions(Backup backupModel, Map opts) {
        return ServiceResponse.success()
    }

    @Override
    ServiceResponse<BackupRestoreResponse> restoreBackup(BackupRestore backupRestore, BackupResult backupResult, Backup backup, Map opts) {
        ServiceResponse<BackupRestoreResponse> rtn = ServiceResponse.prepare(new BackupRestoreResponse(backupRestore))
        log.debug("restoreBackup {}, opts {}", backupResult, opts)
        Connection connection = null
        try {
            Workload workload = morpheus.async.workload.get(opts.containerId).blockingGet()
            ComputeServer server = workload.server
            Cloud cloud = server.cloud
            def vmId = server?.externalId
            def backupResultConfig = backupResult.getConfigMap()
            def snapshotId = backupResultConfig.snapshots?.collect{ it.snapshotId }.first()
            def restoreResult = OlvmComputeUtility.restoreSnapshot([vmId:vmId, snapshotId:snapshotId, connection:connection])

            if (restoreResult.success) {
                // start vm
                OlvmComputeUtility.startVm([connection:connection, vmId:vmId])
                updateInstanceIp(server.id, vmId, cloud)
                rtn.data.updates = true
                rtn.success = true
                rtn.data.backupRestore.status = BackupStatusUtility.SUCCEEDED
            }
        } catch(e) {
            log.error("restoreBackup: ${e}", e)
            rtn.success = false
            rtn.msg = e.getMessage()
            rtn.data.updates = true
            rtn.data.backupRestore.errorMessage = e.getMessage()
            rtn.data.backupRestore.status = BackupStatusUtility.FAILED
        }
        finally {
            connection?.close()
        }

        return rtn
    }

    @Override
    ServiceResponse refreshBackupRestoreResult(BackupRestore backupRestore, BackupResult backupResult) {
        ServiceResponse<BackupRestoreResponse> rtn = ServiceResponse.prepare(new BackupRestoreResponse(backupRestore))
        rtn.success = true

        return rtn
    }

    def updateInstanceIp(Long morphServerId, String ec2InstanceId, Connection connection = null) {
        log.debug("updateInstanceIp: {}, {}", morphServerId, ec2InstanceId)
        try {
            def morphServer = morpheus.async.computeServer.get(morphServerId).blockingGet()
            def serverDetails = OlvmComputeUtility.getServerDetail([connection:connection, serverId:morphServer.externalId])
            if(serverDetails.success) {
                String publicIp = serverDetails.data.ipV4?.first()
                log.debug("publicIp is {}", publicIp)
                if(publicIp) {
                    def networkInterface = morphServer.interfaces?.find {
                        it.addresses.find { it.address == morphServer.internalIp } || it.publicIpAddress == morphServer.externalIp
                    }
                    if(networkInterface) {
                        log.debug("refreshing instance public ip from: {} to: {}", networkInterface.publicIpAddress, publicIp)
                        if(morphServer.sshHost == networkInterface.publicIpAddress || morphServer.sshHost == morphServer.externalIp) {
                            morphServer.sshHost = publicIp
                        }
                        networkInterface.publicIpAddress = publicIp
                        morphServer.setExternalIp(publicIp)
                        morpheus.async.computeServer.save(morphServer).blockingGet()
                    }
                }
            }
        } catch(e)  {
            log.error "Error in updatingInstanceIp: ${e}", e
        }
    }
}
