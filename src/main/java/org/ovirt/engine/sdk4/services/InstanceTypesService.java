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
import org.ovirt.engine.sdk4.builders.InstanceTypeBuilder;
import org.ovirt.engine.sdk4.types.InstanceType;

public interface InstanceTypesService extends Service {
    /**
     * Creates a new instance type.
     * 
     * This requires only a name attribute and can include all hardware configurations of the
     * virtual machine.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/instancetypes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     * </template>
     * ----
     * 
     * Creating an instance type with all hardware configurations with a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     *   <console>
     *     <enabled>true</enabled>
     *   </console>
     *   <cpu>
     *     <topology>
     *       <cores>2</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     *   <custom_cpu_model>AMD Opteron_G2</custom_cpu_model>
     *   <custom_emulated_machine>q35</custom_emulated_machine>
     *   <display>
     *     <monitors>1</monitors>
     *     <single_qxl_pci>true</single_qxl_pci>
     *     <smartcard_enabled>true</smartcard_enabled>
     *     <type>spice</type>
     *   </display>
     *   <high_availability>
     *     <enabled>true</enabled>
     *     <priority>1</priority>
     *   </high_availability>
     *   <io>
     *     <threads>2</threads>
     *   </io>
     *   <memory>4294967296</memory>
     *   <memory_policy>
     *     <ballooning>true</ballooning>
     *     <guaranteed>268435456</guaranteed>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <compressed>inherit</compressed>
     *     <policy id="00000000-0000-0000-0000-000000000000"/>
     *   </migration>
     *   <migration_downtime>2</migration_downtime>
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>hd</device>
     *       </devices>
     *     </boot>
     *   </os>
     *   <rng_device>
     *     <rate>
     *       <bytes>200</bytes>
     *       <period>2</period>
     *     </rate>
     *     <source>urandom</source>
     *   </rng_device>
     *   <soundcard_enabled>true</soundcard_enabled>
     *   <usb>
     *     <enabled>true</enabled>
     *     <type>native</type>
     *   </usb>
     *   <virtio_scsi>
     *     <enabled>true</enabled>
     *   </virtio_scsi>
     * </instance_type>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest instanceType(InstanceType instanceType);
        AddRequest instanceType(InstanceTypeBuilder instanceType);
    }
    
    /**
     * Creates a new instance type.
     * 
     * This requires only a name attribute and can include all hardware configurations of the
     * virtual machine.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/instancetypes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     * </template>
     * ----
     * 
     * Creating an instance type with all hardware configurations with a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     *   <console>
     *     <enabled>true</enabled>
     *   </console>
     *   <cpu>
     *     <topology>
     *       <cores>2</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     *   <custom_cpu_model>AMD Opteron_G2</custom_cpu_model>
     *   <custom_emulated_machine>q35</custom_emulated_machine>
     *   <display>
     *     <monitors>1</monitors>
     *     <single_qxl_pci>true</single_qxl_pci>
     *     <smartcard_enabled>true</smartcard_enabled>
     *     <type>spice</type>
     *   </display>
     *   <high_availability>
     *     <enabled>true</enabled>
     *     <priority>1</priority>
     *   </high_availability>
     *   <io>
     *     <threads>2</threads>
     *   </io>
     *   <memory>4294967296</memory>
     *   <memory_policy>
     *     <ballooning>true</ballooning>
     *     <guaranteed>268435456</guaranteed>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <compressed>inherit</compressed>
     *     <policy id="00000000-0000-0000-0000-000000000000"/>
     *   </migration>
     *   <migration_downtime>2</migration_downtime>
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>hd</device>
     *       </devices>
     *     </boot>
     *   </os>
     *   <rng_device>
     *     <rate>
     *       <bytes>200</bytes>
     *       <period>2</period>
     *     </rate>
     *     <source>urandom</source>
     *   </rng_device>
     *   <soundcard_enabled>true</soundcard_enabled>
     *   <usb>
     *     <enabled>true</enabled>
     *     <type>native</type>
     *   </usb>
     *   <virtio_scsi>
     *     <enabled>true</enabled>
     *   </virtio_scsi>
     * </instance_type>
     * ----
     */
    public interface AddResponse extends Response {
        InstanceType instanceType();
    }
    
    /**
     * Creates a new instance type.
     * 
     * This requires only a name attribute and can include all hardware configurations of the
     * virtual machine.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/instancetypes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     * </template>
     * ----
     * 
     * Creating an instance type with all hardware configurations with a request body like this:
     * 
     * [source,xml]
     * ----
     * <instance_type>
     *   <name>myinstancetype</name>
     *   <console>
     *     <enabled>true</enabled>
     *   </console>
     *   <cpu>
     *     <topology>
     *       <cores>2</cores>
     *       <sockets>2</sockets>
     *       <threads>1</threads>
     *     </topology>
     *   </cpu>
     *   <custom_cpu_model>AMD Opteron_G2</custom_cpu_model>
     *   <custom_emulated_machine>q35</custom_emulated_machine>
     *   <display>
     *     <monitors>1</monitors>
     *     <single_qxl_pci>true</single_qxl_pci>
     *     <smartcard_enabled>true</smartcard_enabled>
     *     <type>spice</type>
     *   </display>
     *   <high_availability>
     *     <enabled>true</enabled>
     *     <priority>1</priority>
     *   </high_availability>
     *   <io>
     *     <threads>2</threads>
     *   </io>
     *   <memory>4294967296</memory>
     *   <memory_policy>
     *     <ballooning>true</ballooning>
     *     <guaranteed>268435456</guaranteed>
     *   </memory_policy>
     *   <migration>
     *     <auto_converge>inherit</auto_converge>
     *     <compressed>inherit</compressed>
     *     <policy id="00000000-0000-0000-0000-000000000000"/>
     *   </migration>
     *   <migration_downtime>2</migration_downtime>
     *   <os>
     *     <boot>
     *       <devices>
     *         <device>hd</device>
     *       </devices>
     *     </boot>
     *   </os>
     *   <rng_device>
     *     <rate>
     *       <bytes>200</bytes>
     *       <period>2</period>
     *     </rate>
     *     <source>urandom</source>
     *   </rng_device>
     *   <soundcard_enabled>true</soundcard_enabled>
     *   <usb>
     *     <enabled>true</enabled>
     *     <type>native</type>
     *   </usb>
     *   <virtio_scsi>
     *     <enabled>true</enabled>
     *   </virtio_scsi>
     * </instance_type>
     * ----
     */
    AddRequest add();
    
    /**
     * Lists all existing instance types in the system.
     * 
     * The order of the returned list of instance types isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed
         * taking case into account. The default value is `true`, which means that case is taken
         * into account. If you want to search ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of instance types to return. If not specified all the instance
         * types are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of instance types to return. If not specified all the instance
         * types are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of instance types to return. If not specified all the instance
         * types are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned templates.
         */
        ListRequest search(String search);
    }
    
    /**
     * Lists all existing instance types in the system.
     * 
     * The order of the returned list of instance types isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<InstanceType> instanceType();
    }
    
    /**
     * Lists all existing instance types in the system.
     * 
     * The order of the returned list of instance types isn't guaranteed.
     */
    ListRequest list();
    
    InstanceTypeService instanceTypeService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

