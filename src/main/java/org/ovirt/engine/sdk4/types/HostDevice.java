/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface HostDevice extends Identified {
    String capability();
    
    boolean capabilityPresent();
    
    String driver();
    
    boolean driverPresent();
    
    BigInteger iommuGroup();
    Byte iommuGroupAsByte();
    Short iommuGroupAsShort();
    Integer iommuGroupAsInteger();
    Long iommuGroupAsLong();
    
    boolean iommuGroupPresent();
    
    List<MDevType> mDevTypes();
    
    boolean mDevTypesPresent();
    
    HostDevice physicalFunction();
    
    boolean physicalFunctionPresent();
    
    boolean placeholder();
    
    boolean placeholderPresent();
    
    Product product();
    
    boolean productPresent();
    
    Vendor vendor();
    
    boolean vendorPresent();
    
    BigInteger virtualFunctions();
    Byte virtualFunctionsAsByte();
    Short virtualFunctionsAsShort();
    Integer virtualFunctionsAsInteger();
    Long virtualFunctionsAsLong();
    
    boolean virtualFunctionsPresent();
    
    Host host();
    
    boolean hostPresent();
    
    HostDevice parentDevice();
    
    boolean parentDevicePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
