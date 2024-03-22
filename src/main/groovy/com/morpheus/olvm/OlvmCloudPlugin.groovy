/*
* Copyright 2022 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.morpheus.olvm

import com.morpheusdata.core.Plugin
import com.morpheusdata.core.backup.BackupProvider
import com.morpheusdata.core.providers.CloudProvider

class OlvmCloudPlugin extends Plugin {
    String backupProviderCode

    @Override
    String getCode() {
        return 'cloud.olvm'
    }

    @Override
    void initialize() {
        this.setName("OLVM Cloud")
        this.registerProvider(new OlvmCloudProvider(this,this.morpheus))
        this.registerProvider(new OlvmProvisionProvider(this,this.morpheus))
        this.registerProvider(new OlvmOptionSourceProvider(this, this.morpheus))
        def backupProvider = new OlvmBackupProvider(this, this.morpheus)
        backupProviderCode = backupProvider.code
        this.registerProvider(backupProvider)
    }

    /**
     * Called when a plugin is being removed from the plugin manager (aka Uninstalled)
     */
    @Override
    void onDestroy() {
        //nothing to do for now
    }

    CloudProvider getCloudProvider() {
        return this.getProviderByCode(OlvmCloudProvider.CLOUD_PROVIDER_CODE)
    }

    BackupProvider getBackupProvider() {
        return this.getProviderByCode(backupProviderCode)
    }
}
