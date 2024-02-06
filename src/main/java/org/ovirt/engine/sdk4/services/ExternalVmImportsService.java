/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ExternalVmImportBuilder;
import org.ovirt.engine.sdk4.types.ExternalVmImport;

/**
 * Provides capability to import external virtual machines.
 */
public interface ExternalVmImportsService extends Service {
    /**
     * This operation is used to import a virtual machine from external hypervisor, such as KVM, XEN or VMware.
     * 
     * For example import of a virtual machine from VMware can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externalvmimports
     * ----
     * 
     * With request body of type <<types/external_vm_import,ExternalVmImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_vm_import>
     *   <vm>
     *     <name>my_vm</name>
     *   </vm>
     *   <cluster id="360014051136c20574f743bdbd28177fd" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <name>vm_name_as_is_in_vmware</name>
     *   <sparse>true</sparse>
     *   <username>vmware_user</username>
     *   <password>123456</password>
     *   <provider>VMWARE</provider>
     *   <url>vpx://wmware_user@vcenter-host/DataCenter/Cluster/esxi-host?no_verify=1</url>
     *   <drivers_iso id="virtio-win-1.6.7.iso" />
     * </external_vm_import>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest import_(ExternalVmImport import_);
        AddRequest import_(ExternalVmImportBuilder import_);
    }
    
    /**
     * This operation is used to import a virtual machine from external hypervisor, such as KVM, XEN or VMware.
     * 
     * For example import of a virtual machine from VMware can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externalvmimports
     * ----
     * 
     * With request body of type <<types/external_vm_import,ExternalVmImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_vm_import>
     *   <vm>
     *     <name>my_vm</name>
     *   </vm>
     *   <cluster id="360014051136c20574f743bdbd28177fd" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <name>vm_name_as_is_in_vmware</name>
     *   <sparse>true</sparse>
     *   <username>vmware_user</username>
     *   <password>123456</password>
     *   <provider>VMWARE</provider>
     *   <url>vpx://wmware_user@vcenter-host/DataCenter/Cluster/esxi-host?no_verify=1</url>
     *   <drivers_iso id="virtio-win-1.6.7.iso" />
     * </external_vm_import>
     * ----
     */
    public interface AddResponse extends Response {
        ExternalVmImport import_();
    }
    
    /**
     * This operation is used to import a virtual machine from external hypervisor, such as KVM, XEN or VMware.
     * 
     * For example import of a virtual machine from VMware can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externalvmimports
     * ----
     * 
     * With request body of type <<types/external_vm_import,ExternalVmImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_vm_import>
     *   <vm>
     *     <name>my_vm</name>
     *   </vm>
     *   <cluster id="360014051136c20574f743bdbd28177fd" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <name>vm_name_as_is_in_vmware</name>
     *   <sparse>true</sparse>
     *   <username>vmware_user</username>
     *   <password>123456</password>
     *   <provider>VMWARE</provider>
     *   <url>vpx://wmware_user@vcenter-host/DataCenter/Cluster/esxi-host?no_verify=1</url>
     *   <drivers_iso id="virtio-win-1.6.7.iso" />
     * </external_vm_import>
     * ----
     */
    AddRequest add();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

