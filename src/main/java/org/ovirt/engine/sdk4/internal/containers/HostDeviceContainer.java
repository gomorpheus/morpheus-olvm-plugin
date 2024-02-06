/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostDevice;
import org.ovirt.engine.sdk4.types.MDevType;
import org.ovirt.engine.sdk4.types.Product;
import org.ovirt.engine.sdk4.types.Vendor;
import org.ovirt.engine.sdk4.types.Vm;

public class HostDeviceContainer extends IdentifiedContainer implements HostDevice {
    private String capability;
    private String driver;
    private BigInteger iommuGroup;
    private List<MDevType> mDevTypes;
    private HostDevice physicalFunction;
    private Boolean placeholder;
    private Product product;
    private Vendor vendor;
    private BigInteger virtualFunctions;
    private Host host;
    private HostDevice parentDevice;
    private Vm vm;
    
    public String capability() {
        return capability;
    }
    
    public void capability(String newCapability) {
        capability = newCapability;
    }
    
    public boolean capabilityPresent() {
        return capability != null;
    }
    
    public String driver() {
        return driver;
    }
    
    public void driver(String newDriver) {
        driver = newDriver;
    }
    
    public boolean driverPresent() {
        return driver != null;
    }
    
    public BigInteger iommuGroup() {
        return iommuGroup;
    }
    
    public Byte iommuGroupAsByte() {
        return asByte("HostDevice", "iommuGroup", iommuGroup);
    }
    
    public Short iommuGroupAsShort() {
        return asShort("HostDevice", "iommuGroup", iommuGroup);
    }
    
    public Integer iommuGroupAsInteger() {
        return asInteger("HostDevice", "iommuGroup", iommuGroup);
    }
    
    public Long iommuGroupAsLong() {
        return asLong("HostDevice", "iommuGroup", iommuGroup);
    }
    
    public void iommuGroup(BigInteger newIommuGroup) {
        iommuGroup = newIommuGroup;
    }
    
    public boolean iommuGroupPresent() {
        return iommuGroup != null;
    }
    
    public List<MDevType> mDevTypes() {
        return makeUnmodifiableList(mDevTypes);
    }
    
    public void mDevTypes(List<MDevType> newMDevTypes) {
        mDevTypes = makeArrayList(newMDevTypes);
    }
    
    public boolean mDevTypesPresent() {
        return mDevTypes != null && !mDevTypes.isEmpty();
    }
    
    public HostDevice physicalFunction() {
        return physicalFunction;
    }
    
    public void physicalFunction(HostDevice newPhysicalFunction) {
        physicalFunction = newPhysicalFunction;
    }
    
    public boolean physicalFunctionPresent() {
        return physicalFunction != null;
    }
    
    public boolean placeholder() {
        return placeholder;
    }
    
    public void placeholder(boolean newPlaceholder) {
        placeholder = Boolean.valueOf(newPlaceholder);
    }
    
    public void placeholder(Boolean newPlaceholder) {
        placeholder = newPlaceholder;
    }
    
    public boolean placeholderPresent() {
        return placeholder != null;
    }
    
    public Product product() {
        return product;
    }
    
    public void product(Product newProduct) {
        product = newProduct;
    }
    
    public boolean productPresent() {
        return product != null;
    }
    
    public Vendor vendor() {
        return vendor;
    }
    
    public void vendor(Vendor newVendor) {
        vendor = newVendor;
    }
    
    public boolean vendorPresent() {
        return vendor != null;
    }
    
    public BigInteger virtualFunctions() {
        return virtualFunctions;
    }
    
    public Byte virtualFunctionsAsByte() {
        return asByte("HostDevice", "virtualFunctions", virtualFunctions);
    }
    
    public Short virtualFunctionsAsShort() {
        return asShort("HostDevice", "virtualFunctions", virtualFunctions);
    }
    
    public Integer virtualFunctionsAsInteger() {
        return asInteger("HostDevice", "virtualFunctions", virtualFunctions);
    }
    
    public Long virtualFunctionsAsLong() {
        return asLong("HostDevice", "virtualFunctions", virtualFunctions);
    }
    
    public void virtualFunctions(BigInteger newVirtualFunctions) {
        virtualFunctions = newVirtualFunctions;
    }
    
    public boolean virtualFunctionsPresent() {
        return virtualFunctions != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public HostDevice parentDevice() {
        return parentDevice;
    }
    
    public void parentDevice(HostDevice newParentDevice) {
        parentDevice = newParentDevice;
    }
    
    public boolean parentDevicePresent() {
        return parentDevice != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
