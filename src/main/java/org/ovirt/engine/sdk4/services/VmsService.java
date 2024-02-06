/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.types.Vm;

public interface VmsService extends Service {
    /**
     * Creates a new virtual machine.
     * 
     * The virtual machine can be created in different ways:
     * 
     * - From a template. In this case the identifier or name of the template must be provided. For example, using a
     *   plain shell script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <template>
     *     <name>Blank</name>
     *   </template>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * - From a snapshot. In this case the identifier of the snapshot has to be provided. For example, using a plain
     *   shel script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <snapshots>
     *     <snapshot id="266742a5-6a65-483c-816d-d2ce49746680"/>
     *   </snapshots>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * When creating a virtual machine from a template or from a snapshot it is usually useful to explicitly indicate
     * in what storage domain to create the disks for the virtual machine. If the virtual machine is created from
     * a template then this is achieved passing a set of `disk_attachment` elements that indicate the mapping:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="8d4bd566-6c86-4592-a4a7-912dbf93c298">
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * When the virtual machine is created from a snapshot this set of disks is slightly different, it uses the
     * `image_id` attribute instead of `id`.
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk>
     *         <image_id>8d4bd566-6c86-4592-a4a7-912dbf93c298</image_id>
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * It is possible to specify additional virtual machine parameters in the XML description, e.g. a virtual machine
     * of `desktop` type, with 2 GiB of RAM and additional description can be added sending a request body like the
     * following:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   <name>myvm</name>
     *   <description>My Desktop Virtual Machine</description>
     *   <type>desktop</type>
     *   <memory>2147483648</memory>
     *   ...
     * </vm>
     * ----
     * 
     * A bootable CDROM device can be set like this:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot dev="cdrom"/>
     *   </os>
     * </vm>
     * ----
     * 
     * In order to boot from CDROM, you first need to insert a disk, as described in the
     * <<services/vm_cdrom, CDROM service>>. Then booting from that CDROM can be specified using the `os.boot.devices`
     * attribute:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>cdrom</device>
     *       </devices>
     *     </boot>
     *   </os>
     * </vm>
     * ----
     * 
     * In all cases the name or identifier of the cluster where the virtual machine will be created is mandatory.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        /**
         * Specifies if the virtual machine should be independent of the template.
         * 
         * When a virtual machine is created from a template by default the disks of the virtual machine depend on
         * the disks of the template, they are using the https://en.wikipedia.org/wiki/Copy-on-write[_copy on write_]
         * mechanism so that only the differences from the template take up real storage space. If this parameter is
         * specified and the value is `true` then the disks of the created virtual machine will be _cloned_, and
         * independent of the template. For example, to create an independent virtual machine, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/vms?clone=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         * 
         * NOTE: When this parameter is `true` the permissions of the template will also be copied, as when using
         * `clone_permissions=true`.
         */
        AddRequest clone_(Boolean clone_);
        /**
         * Specifies if the permissions of the template should be copied to the virtual machine.
         * 
         * If this optional parameter is provided, and its values is `true` then the permissions of the template (only
         * the direct ones, not the inherited ones) will be copied to the created virtual machine. For example, to
         * create a virtual machine from the `mytemplate` template copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         */
        AddRequest clonePermissions(Boolean clonePermissions);
        /**
         * Relevant for admin users only. Indicates whether to assign UserVmManager role
         * on the created Virtual Machine for this user. This will enable the user to later access
         * the Virtual Machine as though he were a non-admin user, foregoing his admin permissions
         * (by providing filter=true).
         * 
         * NOTE: admin-as-user (meaning providing filter=true) POST requests on an existing Virtual
         * Machine will fail unless the Virtual Machine has been previously created by the admin as
         * a user (meaning with filter=true).
         */
        AddRequest filter(Boolean filter);
        AddRequest vm(Vm vm);
        AddRequest vm(VmBuilder vm);
    }
    
    /**
     * Creates a new virtual machine.
     * 
     * The virtual machine can be created in different ways:
     * 
     * - From a template. In this case the identifier or name of the template must be provided. For example, using a
     *   plain shell script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <template>
     *     <name>Blank</name>
     *   </template>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * - From a snapshot. In this case the identifier of the snapshot has to be provided. For example, using a plain
     *   shel script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <snapshots>
     *     <snapshot id="266742a5-6a65-483c-816d-d2ce49746680"/>
     *   </snapshots>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * When creating a virtual machine from a template or from a snapshot it is usually useful to explicitly indicate
     * in what storage domain to create the disks for the virtual machine. If the virtual machine is created from
     * a template then this is achieved passing a set of `disk_attachment` elements that indicate the mapping:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="8d4bd566-6c86-4592-a4a7-912dbf93c298">
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * When the virtual machine is created from a snapshot this set of disks is slightly different, it uses the
     * `image_id` attribute instead of `id`.
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk>
     *         <image_id>8d4bd566-6c86-4592-a4a7-912dbf93c298</image_id>
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * It is possible to specify additional virtual machine parameters in the XML description, e.g. a virtual machine
     * of `desktop` type, with 2 GiB of RAM and additional description can be added sending a request body like the
     * following:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   <name>myvm</name>
     *   <description>My Desktop Virtual Machine</description>
     *   <type>desktop</type>
     *   <memory>2147483648</memory>
     *   ...
     * </vm>
     * ----
     * 
     * A bootable CDROM device can be set like this:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot dev="cdrom"/>
     *   </os>
     * </vm>
     * ----
     * 
     * In order to boot from CDROM, you first need to insert a disk, as described in the
     * <<services/vm_cdrom, CDROM service>>. Then booting from that CDROM can be specified using the `os.boot.devices`
     * attribute:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>cdrom</device>
     *       </devices>
     *     </boot>
     *   </os>
     * </vm>
     * ----
     * 
     * In all cases the name or identifier of the cluster where the virtual machine will be created is mandatory.
     */
    public interface AddResponse extends Response {
        Vm vm();
    }
    
    /**
     * Creates a new virtual machine.
     * 
     * The virtual machine can be created in different ways:
     * 
     * - From a template. In this case the identifier or name of the template must be provided. For example, using a
     *   plain shell script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <template>
     *     <name>Blank</name>
     *   </template>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * - From a snapshot. In this case the identifier of the snapshot has to be provided. For example, using a plain
     *   shel script and XML:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <vm>
     *   <name>myvm</name>
     *   <snapshots>
     *     <snapshot id="266742a5-6a65-483c-816d-d2ce49746680"/>
     *   </snapshots>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </vm>
     * ' \
     * "${url}/vms"
     * ----
     * 
     * When creating a virtual machine from a template or from a snapshot it is usually useful to explicitly indicate
     * in what storage domain to create the disks for the virtual machine. If the virtual machine is created from
     * a template then this is achieved passing a set of `disk_attachment` elements that indicate the mapping:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk id="8d4bd566-6c86-4592-a4a7-912dbf93c298">
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * When the virtual machine is created from a snapshot this set of disks is slightly different, it uses the
     * `image_id` attribute instead of `id`.
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <disk_attachments>
     *     <disk_attachment>
     *       <disk>
     *         <image_id>8d4bd566-6c86-4592-a4a7-912dbf93c298</image_id>
     *         <storage_domains>
     *           <storage_domain id="9cb6cb0a-cf1d-41c2-92ca-5a6d665649c9"/>
     *         </storage_domains>
     *       </disk>
     *     <disk_attachment>
     *   </disk_attachments>
     * </vm>
     * ----
     * 
     * It is possible to specify additional virtual machine parameters in the XML description, e.g. a virtual machine
     * of `desktop` type, with 2 GiB of RAM and additional description can be added sending a request body like the
     * following:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   <name>myvm</name>
     *   <description>My Desktop Virtual Machine</description>
     *   <type>desktop</type>
     *   <memory>2147483648</memory>
     *   ...
     * </vm>
     * ----
     * 
     * A bootable CDROM device can be set like this:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot dev="cdrom"/>
     *   </os>
     * </vm>
     * ----
     * 
     * In order to boot from CDROM, you first need to insert a disk, as described in the
     * <<services/vm_cdrom, CDROM service>>. Then booting from that CDROM can be specified using the `os.boot.devices`
     * attribute:
     * 
     * [source,xml]
     * ----
     * <vm>
     *   ...
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>cdrom</device>
     *       </devices>
     *     </boot>
     *   </os>
     * </vm>
     * ----
     * 
     * In all cases the name or identifier of the cluster where the virtual machine will be created is mandatory.
     */
    AddRequest add();
    
    /**
     * add a virtual machine to the system from a configuration - requires the configuration type and the configuration data
     */
    public interface AddFromConfigurationRequest extends Request<AddFromConfigurationRequest, AddFromConfigurationResponse> {
        /**
         * Specifies if the virtual machine should be independent of the template.
         * 
         * When a virtual machine is created from a template by default the disks of the virtual machine depend on
         * the disks of the template, they are using the https://en.wikipedia.org/wiki/Copy-on-write[_copy on write_]
         * mechanism so that only the differences from the template take up real storage space. If this parameter is
         * specified and the value is `true` then the disks of the created virtual machine will be _cloned_, and
         * independent of the template. For example, to create an independent virtual machine, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/vms?clone=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         * 
         * NOTE: When this parameter is `true` the permissions of the template will also be copied, as when using
         * `clone_permissions=true`.
         */
        AddFromConfigurationRequest clone_(Boolean clone_);
        /**
         * Specifies if the permissions of the template should be copied to the virtual machine.
         * 
         * If this optional parameter is provided, and its values is `true` then the permissions of the template (only
         * the direct ones, not the inherited ones) will be copied to the created virtual machine. For example, to
         * create a virtual machine from the `mytemplate` template copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         */
        AddFromConfigurationRequest clonePermissions(Boolean clonePermissions);
        /**
         * Relevant for admin users only. Indicates whether to assign UserVmManager role
         * on the created Virtual Machine for this user. This will enable the user to later access
         * the Virtual Machine as though he were a non-admin user, foregoing his admin permissions
         * (by providing filter=true).
         * 
         * NOTE: admin-as-user (meaning providing filter=true) POST requests on an existing Virtual
         * Machine will fail unless the Virtual Machine has been previously created by the admin as
         * a user (meaning with filter=true).
         */
        AddFromConfigurationRequest filter(Boolean filter);
        AddFromConfigurationRequest vm(Vm vm);
        AddFromConfigurationRequest vm(VmBuilder vm);
    }
    
    /**
     * add a virtual machine to the system from a configuration - requires the configuration type and the configuration data
     */
    public interface AddFromConfigurationResponse extends Response {
        Vm vm();
    }
    
    /**
     * add a virtual machine to the system from a configuration - requires the configuration type and the configuration data
     */
    AddFromConfigurationRequest addFromConfiguration();
    
    /**
     * add a virtual machine to the system from scratch
     */
    public interface AddFromScratchRequest extends Request<AddFromScratchRequest, AddFromScratchResponse> {
        /**
         * Specifies if the virtual machine should be independent of the template.
         * 
         * When a virtual machine is created from a template by default the disks of the virtual machine depend on
         * the disks of the template, they are using the https://en.wikipedia.org/wiki/Copy-on-write[_copy on write_]
         * mechanism so that only the differences from the template take up real storage space. If this parameter is
         * specified and the value is `true` then the disks of the created virtual machine will be _cloned_, and
         * independent of the template. For example, to create an independent virtual machine, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/vms?clone=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         * 
         * NOTE: When this parameter is `true` the permissions of the template will also be copied, as when using
         * `clone_permissions=true`.
         */
        AddFromScratchRequest clone_(Boolean clone_);
        /**
         * Specifies if the permissions of the template should be copied to the virtual machine.
         * 
         * If this optional parameter is provided, and its values is `true` then the permissions of the template (only
         * the direct ones, not the inherited ones) will be copied to the created virtual machine. For example, to
         * create a virtual machine from the `mytemplate` template copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         */
        AddFromScratchRequest clonePermissions(Boolean clonePermissions);
        /**
         * Relevant for admin users only. Indicates whether to assign UserVmManager role
         * on the created Virtual Machine for this user. This will enable the user to later access
         * the Virtual Machine as though he were a non-admin user, foregoing his admin permissions
         * (by providing filter=true).
         * 
         * NOTE: admin-as-user (meaning providing filter=true) POST requests on an existing Virtual
         * Machine will fail unless the Virtual Machine has been previously created by the admin as
         * a user (meaning with filter=true).
         */
        AddFromScratchRequest filter(Boolean filter);
        AddFromScratchRequest vm(Vm vm);
        AddFromScratchRequest vm(VmBuilder vm);
    }
    
    /**
     * add a virtual machine to the system from scratch
     */
    public interface AddFromScratchResponse extends Response {
        Vm vm();
    }
    
    /**
     * add a virtual machine to the system from scratch
     */
    AddFromScratchRequest addFromScratch();
    
    /**
     * add a virtual machine to the system by cloning from a snapshot
     */
    public interface AddFromSnapshotRequest extends Request<AddFromSnapshotRequest, AddFromSnapshotResponse> {
        /**
         * Specifies if the virtual machine should be independent of the template.
         * 
         * When a virtual machine is created from a template by default the disks of the virtual machine depend on
         * the disks of the template, they are using the https://en.wikipedia.org/wiki/Copy-on-write[_copy on write_]
         * mechanism so that only the differences from the template take up real storage space. If this parameter is
         * specified and the value is `true` then the disks of the created virtual machine will be _cloned_, and
         * independent of the template. For example, to create an independent virtual machine, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/vms?clone=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         * 
         * NOTE: When this parameter is `true` the permissions of the template will also be copied, as when using
         * `clone_permissions=true`.
         */
        AddFromSnapshotRequest clone_(Boolean clone_);
        /**
         * Specifies if the permissions of the template should be copied to the virtual machine.
         * 
         * If this optional parameter is provided, and its values is `true` then the permissions of the template (only
         * the direct ones, not the inherited ones) will be copied to the created virtual machine. For example, to
         * create a virtual machine from the `mytemplate` template copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <vm>
         *   <name>myvm<name>
         *   <template>
         *     <name>mytemplate<name>
         *   </template>
         *   <cluster>
         *     <name>mycluster<name>
         *   </cluster>
         * </vm>
         * ----
         */
        AddFromSnapshotRequest clonePermissions(Boolean clonePermissions);
        /**
         * Relevant for admin users only. Indicates whether to assign UserVmManager role
         * on the created Virtual Machine for this user. This will enable the user to later access
         * the Virtual Machine as though he were a non-admin user, foregoing his admin permissions
         * (by providing filter=true).
         * 
         * NOTE: admin-as-user (meaning providing filter=true) POST requests on an existing Virtual
         * Machine will fail unless the Virtual Machine has been previously created by the admin as
         * a user (meaning with filter=true).
         */
        AddFromSnapshotRequest filter(Boolean filter);
        AddFromSnapshotRequest vm(Vm vm);
        AddFromSnapshotRequest vm(VmBuilder vm);
    }
    
    /**
     * add a virtual machine to the system by cloning from a snapshot
     */
    public interface AddFromSnapshotResponse extends Response {
        Vm vm();
    }
    
    /**
     * add a virtual machine to the system by cloning from a snapshot
     */
    AddFromSnapshotRequest addFromSnapshot();
    
    /**
     * Returns the list of virtual machines of the system.
     * 
     * The order of the returned list of virtual machines is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if all the attributes of the virtual machines should be included in the response.
         * 
         * By default the following attributes are excluded:
         * 
         * - `console`
         * - `initialization.configuration.data` - The OVF document describing the virtual machine.
         * - `rng_source`
         * - `soundcard`
         * - `virtio_scsi`
         * 
         * For example, to retrieve the complete representation of the virtual machines send a request like this:
         * 
         * ....
         * GET /ovirt-engine/api/vms?all_content=true
         * ....
         * 
         * NOTE: The reason for not including these attributes is performance: they are seldom used and they require
         * additional queries to the database. So try to use the this parameter only when it is really needed.
         */
        ListRequest allContent(Boolean allContent);
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * The maximum number of results to return.
         */
        ListRequest max(Integer max);
        /**
         * The maximum number of results to return.
         */
        ListRequest max(Long max);
        /**
         * The maximum number of results to return.
         */
        ListRequest max(BigInteger max);
        /**
         * Indicates if the results should expose the OVF as it appears in OVA files of that VM. The OVF document
         * describing the virtual machine. This parameter will work only when all_content=True is set.
         * The OVF will be presented in `initialization.configuration.data`.
         * 
         * For example:
         * [source]
         * ----
         * GET /vms?all_content=true&ovf_as_ova=true
         * ----
         */
        ListRequest ovfAsOva(Boolean ovfAsOva);
        /**
         * A query string used to restrict the returned virtual machines.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of virtual machines of the system.
     * 
     * The order of the returned list of virtual machines is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    public interface ListResponse extends Response {
        List<Vm> vms();
    }
    
    /**
     * Returns the list of virtual machines of the system.
     * 
     * The order of the returned list of virtual machines is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    ListRequest list();
    
    VmService vmService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

