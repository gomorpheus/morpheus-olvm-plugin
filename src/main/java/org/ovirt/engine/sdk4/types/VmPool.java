/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.List;

/**
 * Type represeting a virtual machines pool.
 */
public interface VmPool extends Identified {
    boolean autoStorageSelect();
    
    boolean autoStorageSelectPresent();
    
    Display display();
    
    boolean displayPresent();
    
    BigInteger maxUserVms();
    Byte maxUserVmsAsByte();
    Short maxUserVmsAsShort();
    Integer maxUserVmsAsInteger();
    Long maxUserVmsAsLong();
    
    boolean maxUserVmsPresent();
    
    BigInteger prestartedVms();
    Byte prestartedVmsAsByte();
    Short prestartedVmsAsShort();
    Integer prestartedVmsAsInteger();
    Long prestartedVmsAsLong();
    
    boolean prestartedVmsPresent();
    
    RngDevice rngDevice();
    
    boolean rngDevicePresent();
    
    BigInteger size();
    Byte sizeAsByte();
    Short sizeAsShort();
    Integer sizeAsInteger();
    Long sizeAsLong();
    
    boolean sizePresent();
    
    boolean soundcardEnabled();
    
    boolean soundcardEnabledPresent();
    
    boolean stateful();
    
    boolean statefulPresent();
    
    boolean tpmEnabled();
    
    boolean tpmEnabledPresent();
    
    VmPoolType type();
    
    boolean typePresent();
    
    boolean useLatestTemplateVersion();
    
    boolean useLatestTemplateVersionPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    InstanceType instanceType();
    
    boolean instanceTypePresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    Template template();
    
    boolean templatePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
