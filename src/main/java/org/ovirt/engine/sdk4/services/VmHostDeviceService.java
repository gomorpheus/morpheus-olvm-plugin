/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.HostDevice;

/**
 * A service to manage individual host device attached to a virtual machine.
 */
public interface VmHostDeviceService extends Service {
    /**
     * Retrieve information about particular host device attached to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *   <name>pci_0000_04_00_0</name>
     *   <capability>pci</capability>
     *   <iommu_group>30</iommu_group>
     *   <placeholder>true</placeholder>
     *   <product id="0x13ba">
     *     <name>GM107GL [Quadro K2200]</name>
     *   </product>
     *   <vendor id="0x10de">
     *     <name>NVIDIA Corporation</name>
     *   </vendor>
     *   <host href="/ovirt-engine/api/hosts/543" id="543"/>
     *   <parent_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *     <name>pci_0000_00_03_0</name>
     *   </parent_device>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </host_device>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieve information about particular host device attached to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *   <name>pci_0000_04_00_0</name>
     *   <capability>pci</capability>
     *   <iommu_group>30</iommu_group>
     *   <placeholder>true</placeholder>
     *   <product id="0x13ba">
     *     <name>GM107GL [Quadro K2200]</name>
     *   </product>
     *   <vendor id="0x10de">
     *     <name>NVIDIA Corporation</name>
     *   </vendor>
     *   <host href="/ovirt-engine/api/hosts/543" id="543"/>
     *   <parent_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *     <name>pci_0000_00_03_0</name>
     *   </parent_device>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </host_device>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieved information about the host device attached to given virtual machine.
         */
        HostDevice device();
    }
    
    /**
     * Retrieve information about particular host device attached to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     * 
     * [source,xml]
     * ----
     * <host_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *   <name>pci_0000_04_00_0</name>
     *   <capability>pci</capability>
     *   <iommu_group>30</iommu_group>
     *   <placeholder>true</placeholder>
     *   <product id="0x13ba">
     *     <name>GM107GL [Quadro K2200]</name>
     *   </product>
     *   <vendor id="0x10de">
     *     <name>NVIDIA Corporation</name>
     *   </vendor>
     *   <host href="/ovirt-engine/api/hosts/543" id="543"/>
     *   <parent_device href="/ovirt-engine/api/hosts/543/devices/456" id="456">
     *     <name>pci_0000_00_03_0</name>
     *   </parent_device>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </host_device>
     * ----
     */
    GetRequest get();
    
    /**
     * Remove the attachment of this host device from given virtual machine.
     * 
     * NOTE: In case this device serves as an IOMMU placeholder, it cannot be removed (remove will result only
     * in setting its `placeholder` flag to `true`). Note that all IOMMU placeholder devices will be removed
     * automatically as soon as there will be no more non-placeholder devices (all devices from given IOMMU
     * group are detached).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the attachment of this host device from given virtual machine.
     * 
     * NOTE: In case this device serves as an IOMMU placeholder, it cannot be removed (remove will result only
     * in setting its `placeholder` flag to `true`). Note that all IOMMU placeholder devices will be removed
     * automatically as soon as there will be no more non-placeholder devices (all devices from given IOMMU
     * group are detached).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the attachment of this host device from given virtual machine.
     * 
     * NOTE: In case this device serves as an IOMMU placeholder, it cannot be removed (remove will result only
     * in setting its `placeholder` flag to `true`). Note that all IOMMU placeholder devices will be removed
     * automatically as soon as there will be no more non-placeholder devices (all devices from given IOMMU
     * group are detached).
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/hostdevices/456
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

