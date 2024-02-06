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
import org.ovirt.engine.sdk4.builders.HostDeviceBuilder;
import org.ovirt.engine.sdk4.types.HostDevice;

/**
 * A service to manage host devices attached to a virtual machine.
 */
public interface VmHostDevicesService extends Service {
    /**
     * Attach target device to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/hostdevices
     * ----
     * 
     * With request body of type <<types/host_device,HostDevice>>, for example
     * 
     * [source,xml]
     * ----
     * <host_device id="123" />
     * ----
     * 
     * NOTE: A necessary precondition for a successful host device attachment is that the virtual machine must be pinned
     * to *exactly* one host. The device ID is then taken relative to this host.
     * 
     * NOTE: Attachment of a PCI device that is part of a bigger IOMMU group will result in attachment of the remaining
     * devices from that IOMMU group as "placeholders". These devices are then identified using the `placeholder`
     * attribute of the <<types/host_device,HostDevice>> type set to `true`.
     * 
     * In case you want attach a device that already serves as an IOMMU placeholder, simply issue an explicit Add operation
     * for it, and its `placeholder` flag will be cleared, and the device will be accessible to the virtual machine.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest device(HostDevice device);
        /**
         * The host device to be attached to given virtual machine.
         */
        AddRequest device(HostDeviceBuilder device);
    }
    
    /**
     * Attach target device to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/hostdevices
     * ----
     * 
     * With request body of type <<types/host_device,HostDevice>>, for example
     * 
     * [source,xml]
     * ----
     * <host_device id="123" />
     * ----
     * 
     * NOTE: A necessary precondition for a successful host device attachment is that the virtual machine must be pinned
     * to *exactly* one host. The device ID is then taken relative to this host.
     * 
     * NOTE: Attachment of a PCI device that is part of a bigger IOMMU group will result in attachment of the remaining
     * devices from that IOMMU group as "placeholders". These devices are then identified using the `placeholder`
     * attribute of the <<types/host_device,HostDevice>> type set to `true`.
     * 
     * In case you want attach a device that already serves as an IOMMU placeholder, simply issue an explicit Add operation
     * for it, and its `placeholder` flag will be cleared, and the device will be accessible to the virtual machine.
     */
    public interface AddResponse extends Response {
        /**
         * The host device to be attached to given virtual machine.
         */
        HostDevice device();
    }
    
    /**
     * Attach target device to given virtual machine.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/hostdevices
     * ----
     * 
     * With request body of type <<types/host_device,HostDevice>>, for example
     * 
     * [source,xml]
     * ----
     * <host_device id="123" />
     * ----
     * 
     * NOTE: A necessary precondition for a successful host device attachment is that the virtual machine must be pinned
     * to *exactly* one host. The device ID is then taken relative to this host.
     * 
     * NOTE: Attachment of a PCI device that is part of a bigger IOMMU group will result in attachment of the remaining
     * devices from that IOMMU group as "placeholders". These devices are then identified using the `placeholder`
     * attribute of the <<types/host_device,HostDevice>> type set to `true`.
     * 
     * In case you want attach a device that already serves as an IOMMU placeholder, simply issue an explicit Add operation
     * for it, and its `placeholder` flag will be cleared, and the device will be accessible to the virtual machine.
     */
    AddRequest add();
    
    /**
     * List the host devices assigned to given virtual machine.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of devices to return. If not specified all the devices are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List the host devices assigned to given virtual machine.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieved list of host devices attached to given virtual machine.
         */
        List<HostDevice> device();
    }
    
    /**
     * List the host devices assigned to given virtual machine.
     * 
     * The order of the returned list of devices isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific host device attached to given virtual machine.
     */
    VmHostDeviceService deviceService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

