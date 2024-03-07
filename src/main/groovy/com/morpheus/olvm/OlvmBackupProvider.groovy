package com.morpheus.olvm

import com.morpheus.olvm.backup.OlvmSnapshotBackupProvider
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import com.morpheusdata.core.backup.MorpheusBackupProvider

class OlvmBackupProvider extends MorpheusBackupProvider {
    OlvmBackupProvider(Plugin plugin, MorpheusContext context) {
        super(plugin, context)

        OlvmSnapshotBackupProvider awsSnapshotBackupProvider = new OlvmSnapshotBackupProvider(plugin, morpheus)
        plugin.registerProvider(awsSnapshotBackupProvider)
        addScopedProvider(awsSnapshotBackupProvider, OlvmProvisionProvider.PROVISION_PROVIDER_CODE, null)
    }
}
