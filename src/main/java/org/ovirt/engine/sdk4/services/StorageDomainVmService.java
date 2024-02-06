/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.RegistrationConfigurationBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.builders.VnicProfileMappingBuilder;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public interface StorageDomainVmService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Vm vm();
    }
    
    GetRequest get();
    
    /**
     * Imports a virtual machine from an export storage domain.
     * 
     * For example, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/vms/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * To import a virtual machine as a new entity add the `clone` parameter:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <clone>true</clone>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     * </action>
     * ----
     * 
     * Include an optional `disks` parameter to choose which disks to import. For example, to import the disks
     * of the template that have the identifiers `123` and `456` send the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     *   <disks>
     *     <disk id="123"/>
     *     <disk id="456"/>
     *   </disks>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    public interface ImportRequest extends Request<ImportRequest, ImportResponse> {
        /**
         * Indicates if the import should be performed asynchronously.
         */
        ImportRequest async(Boolean async);
        /**
         * Indicates if the identifiers of the imported virtual machine
         * should be regenerated.
         * 
         * By default when a virtual machine is imported the identifiers
         * are preserved. This means that the same virtual machine can't
         * be imported multiple times, as that identifiers needs to be
         * unique. To allow importing the same machine multiple times set
         * this parameter to `true`, as the default is `false`.
         */
        ImportRequest clone_(Boolean clone_);
        ImportRequest cluster(Cluster cluster);
        ImportRequest cluster(ClusterBuilder cluster);
        /**
         * Indicates of the snapshots of the virtual machine that is imported
         * should be collapsed, so that the result will be a virtual machine
         * without snapshots.
         * 
         * This parameter is optional, and if it isn't explicitly specified the
         * default value is `false`.
         */
        ImportRequest collapseSnapshots(Boolean collapseSnapshots);
        ImportRequest exclusive(Boolean exclusive);
        ImportRequest storageDomain(StorageDomain storageDomain);
        ImportRequest storageDomain(StorageDomainBuilder storageDomain);
        ImportRequest vm(Vm vm);
        ImportRequest vm(VmBuilder vm);
    }
    
    /**
     * Imports a virtual machine from an export storage domain.
     * 
     * For example, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/vms/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * To import a virtual machine as a new entity add the `clone` parameter:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <clone>true</clone>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     * </action>
     * ----
     * 
     * Include an optional `disks` parameter to choose which disks to import. For example, to import the disks
     * of the template that have the identifiers `123` and `456` send the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     *   <disks>
     *     <disk id="123"/>
     *     <disk id="456"/>
     *   </disks>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    public interface ImportResponse extends Response {
    }
    
    /**
     * Imports a virtual machine from an export storage domain.
     * 
     * For example, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/vms/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * To import a virtual machine as a new entity add the `clone` parameter:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>mydata</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <clone>true</clone>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     * </action>
     * ----
     * 
     * Include an optional `disks` parameter to choose which disks to import. For example, to import the disks
     * of the template that have the identifiers `123` and `456` send the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     *   <vm>
     *     <name>myvm</name>
     *   </vm>
     *   <disks>
     *     <disk id="123"/>
     *     <disk id="456"/>
     *   </disks>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    ImportRequest import_();
    
    public interface RegisterRequest extends Request<RegisterRequest, RegisterResponse> {
        /**
         * Indicates whether a virtual machine is allowed to be registered with only some of its disks.
         * 
         * If this flag is `true`, the engine will not fail in the validation process if an image is not found, but
         * instead it will allow the virtual machine to be registered without the missing disks. This is mainly used
         * during registration of a virtual machine when some of the storage domains are not available. The default
         * value is `false`.
         */
        RegisterRequest allowPartialImport(Boolean allowPartialImport);
        /**
         * Indicates if the registration should be performed asynchronously.
         */
        RegisterRequest async(Boolean async);
        RegisterRequest clone_(Boolean clone_);
        RegisterRequest cluster(Cluster cluster);
        RegisterRequest cluster(ClusterBuilder cluster);
        /**
         * Indicates if the problematic MAC addresses should be re-assigned during the import process by the engine.
         * 
         * A MAC address would be considered as a problematic one if one of the following is true:
         * 
         * - It conflicts with a MAC address that is already allocated to a virtual machine in the target environment.
         * - It's out of the range of the target MAC address pool.
         */
        RegisterRequest reassignBadMacs(Boolean reassignBadMacs);
        RegisterRequest registrationConfiguration(RegistrationConfiguration registrationConfiguration);
        /**
         * This parameter describes how the virtual machine should be
         * registered.
         * 
         * This parameter is optional. If the parameter is not specified, the virtual
         * machine will be registered with the same configuration that
         * it had in the original environment where it was created.
         */
        RegisterRequest registrationConfiguration(RegistrationConfigurationBuilder registrationConfiguration);
        RegisterRequest vm(Vm vm);
        RegisterRequest vm(VmBuilder vm);
        RegisterRequest vnicProfileMappings(List<VnicProfileMapping> vnicProfileMappings);
        /**
         * Deprecated attribute describing mapping rules for virtual NIC profiles that will be applied during the import\register process.
         * 
         * WARNING: Please note that this attribute has been deprecated since version 4.2.1 of the engine, and preserved only for backward
         * compatibility. It will be removed in the future. To specify `vnic_profile_mappings` use the `vnic_profile_mappings`
         * attribute inside the <<types/registration_configuration, RegistrationConfiguration>> type.
         */
        RegisterRequest vnicProfileMappings(VnicProfileMapping... vnicProfileMappings);
        /**
         * Deprecated attribute describing mapping rules for virtual NIC profiles that will be applied during the import\register process.
         * 
         * WARNING: Please note that this attribute has been deprecated since version 4.2.1 of the engine, and preserved only for backward
         * compatibility. It will be removed in the future. To specify `vnic_profile_mappings` use the `vnic_profile_mappings`
         * attribute inside the <<types/registration_configuration, RegistrationConfiguration>> type.
         */
        RegisterRequest vnicProfileMappings(VnicProfileMappingBuilder... vnicProfileMappings);
    }
    
    public interface RegisterResponse extends Response {
    }
    
    RegisterRequest register();
    
    /**
     * Deletes a virtual machine from an export storage domain.
     * 
     * For example, to delete the virtual machine `456` from the storage domain `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/storagedomains/123/vms/456
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Deletes a virtual machine from an export storage domain.
     * 
     * For example, to delete the virtual machine `456` from the storage domain `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/storagedomains/123/vms/456
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Deletes a virtual machine from an export storage domain.
     * 
     * For example, to delete the virtual machine `456` from the storage domain `123`, send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/storagedomains/123/vms/456
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Returns a reference to the service that manages the disk attachments of the virtual machine.
     */
    StorageDomainVmDiskAttachmentsService diskAttachmentsService();
    StorageDomainContentDisksService disksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

