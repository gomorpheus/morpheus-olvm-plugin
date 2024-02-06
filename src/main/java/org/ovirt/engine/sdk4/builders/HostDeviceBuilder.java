/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.HostDeviceContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostDevice;
import org.ovirt.engine.sdk4.types.MDevType;
import org.ovirt.engine.sdk4.types.Product;
import org.ovirt.engine.sdk4.types.Vendor;
import org.ovirt.engine.sdk4.types.Vm;

public class HostDeviceBuilder {
    private String capability;
    private String comment;
    private String description;
    private String driver;
    private Host host;
    private String href;
    private String id;
    private BigInteger iommuGroup;
    private List<MDevType> mDevTypes;
    private String name;
    private HostDevice parentDevice;
    private HostDevice physicalFunction;
    private Boolean placeholder;
    private Product product;
    private Vendor vendor;
    private BigInteger virtualFunctions;
    private Vm vm;
    
    public HostDeviceBuilder capability(String newCapability) {
        capability = newCapability;
        return this;
    }
    
    
    public HostDeviceBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public HostDeviceBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public HostDeviceBuilder driver(String newDriver) {
        driver = newDriver;
        return this;
    }
    
    
    public HostDeviceBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public HostDeviceBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public HostDeviceBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public HostDeviceBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public HostDeviceBuilder iommuGroup(int newIommuGroup) {
        iommuGroup = BigInteger.valueOf((long) newIommuGroup);
        return this;
    }
    
    public HostDeviceBuilder iommuGroup(Integer newIommuGroup) {
        if (newIommuGroup == null) {
            iommuGroup = null;
        }
        else {
            iommuGroup = BigInteger.valueOf(newIommuGroup.longValue());
        }
        return this;
    }
    
    public HostDeviceBuilder iommuGroup(long newIommuGroup) {
        iommuGroup = BigInteger.valueOf(newIommuGroup);
        return this;
    }
    
    public HostDeviceBuilder iommuGroup(Long newIommuGroup) {
        if (newIommuGroup == null) {
            iommuGroup = null;
        }
        else {
            iommuGroup = BigInteger.valueOf(newIommuGroup.longValue());
        }
        return this;
    }
    
    public HostDeviceBuilder iommuGroup(BigInteger newIommuGroup) {
        iommuGroup = newIommuGroup;
        return this;
    }
    
    
    public HostDeviceBuilder mDevTypes(List<MDevType> newMDevTypes) {
        if (newMDevTypes != null) {
            if (mDevTypes == null) {
                mDevTypes = new ArrayList<>(newMDevTypes);
            }
            else {
                mDevTypes.addAll(newMDevTypes);
            }
        }
        return this;
    }
    
    public HostDeviceBuilder mDevTypes(MDevType... newMDevTypes) {
        if (newMDevTypes != null) {
            if (mDevTypes == null) {
                mDevTypes = new ArrayList<>(newMDevTypes.length);
            }
            Collections.addAll(mDevTypes, newMDevTypes);
        }
        return this;
    }
    
    public HostDeviceBuilder mDevTypes(MDevTypeBuilder... newMDevTypes) {
        if (newMDevTypes != null) {
            if (mDevTypes == null) {
                mDevTypes = new ArrayList<>(newMDevTypes.length);
            }
            for (MDevTypeBuilder builder : newMDevTypes) {
                mDevTypes.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostDeviceBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public HostDeviceBuilder parentDevice(HostDevice newParentDevice) {
        parentDevice = newParentDevice;
        return this;
    }
    
    public HostDeviceBuilder parentDevice(HostDeviceBuilder newParentDevice) {
        if (newParentDevice == null) {
            parentDevice = null;
        }
        else {
            parentDevice = newParentDevice.build();
        }
        return this;
    }
    
    
    public HostDeviceBuilder physicalFunction(HostDevice newPhysicalFunction) {
        physicalFunction = newPhysicalFunction;
        return this;
    }
    
    public HostDeviceBuilder physicalFunction(HostDeviceBuilder newPhysicalFunction) {
        if (newPhysicalFunction == null) {
            physicalFunction = null;
        }
        else {
            physicalFunction = newPhysicalFunction.build();
        }
        return this;
    }
    
    
    public HostDeviceBuilder placeholder(boolean newPlaceholder) {
        placeholder = Boolean.valueOf(newPlaceholder);
        return this;
    }
    
    public HostDeviceBuilder placeholder(Boolean newPlaceholder) {
        placeholder = newPlaceholder;
        return this;
    }
    
    
    public HostDeviceBuilder product(Product newProduct) {
        product = newProduct;
        return this;
    }
    
    public HostDeviceBuilder product(ProductBuilder newProduct) {
        if (newProduct == null) {
            product = null;
        }
        else {
            product = newProduct.build();
        }
        return this;
    }
    
    
    public HostDeviceBuilder vendor(Vendor newVendor) {
        vendor = newVendor;
        return this;
    }
    
    public HostDeviceBuilder vendor(VendorBuilder newVendor) {
        if (newVendor == null) {
            vendor = null;
        }
        else {
            vendor = newVendor.build();
        }
        return this;
    }
    
    
    public HostDeviceBuilder virtualFunctions(int newVirtualFunctions) {
        virtualFunctions = BigInteger.valueOf((long) newVirtualFunctions);
        return this;
    }
    
    public HostDeviceBuilder virtualFunctions(Integer newVirtualFunctions) {
        if (newVirtualFunctions == null) {
            virtualFunctions = null;
        }
        else {
            virtualFunctions = BigInteger.valueOf(newVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostDeviceBuilder virtualFunctions(long newVirtualFunctions) {
        virtualFunctions = BigInteger.valueOf(newVirtualFunctions);
        return this;
    }
    
    public HostDeviceBuilder virtualFunctions(Long newVirtualFunctions) {
        if (newVirtualFunctions == null) {
            virtualFunctions = null;
        }
        else {
            virtualFunctions = BigInteger.valueOf(newVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostDeviceBuilder virtualFunctions(BigInteger newVirtualFunctions) {
        virtualFunctions = newVirtualFunctions;
        return this;
    }
    
    
    public HostDeviceBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public HostDeviceBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public HostDevice build() {
        HostDeviceContainer container = new HostDeviceContainer();
        container.capability(capability);
        container.comment(comment);
        container.description(description);
        container.driver(driver);
        container.host(host);
        container.href(href);
        container.id(id);
        container.iommuGroup(iommuGroup);
        container.mDevTypes(mDevTypes);
        container.name(name);
        container.parentDevice(parentDevice);
        container.physicalFunction(physicalFunction);
        container.placeholder(placeholder);
        container.product(product);
        container.vendor(vendor);
        container.virtualFunctions(virtualFunctions);
        container.vm(vm);
        return container;
    }
}
