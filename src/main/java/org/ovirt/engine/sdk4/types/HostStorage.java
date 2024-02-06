/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface HostStorage extends Identified {
    String address();
    
    boolean addressPresent();
    
    List<Property> driverOptions();
    
    boolean driverOptionsPresent();
    
    List<Property> driverSensitiveOptions();
    
    boolean driverSensitiveOptionsPresent();
    
    List<LogicalUnit> logicalUnits();
    
    boolean logicalUnitsPresent();
    
    String mountOptions();
    
    boolean mountOptionsPresent();
    
    BigInteger nfsRetrans();
    Byte nfsRetransAsByte();
    Short nfsRetransAsShort();
    Integer nfsRetransAsInteger();
    Long nfsRetransAsLong();
    
    boolean nfsRetransPresent();
    
    BigInteger nfsTimeo();
    Byte nfsTimeoAsByte();
    Short nfsTimeoAsShort();
    Integer nfsTimeoAsInteger();
    Long nfsTimeoAsLong();
    
    boolean nfsTimeoPresent();
    
    NfsVersion nfsVersion();
    
    boolean nfsVersionPresent();
    
    boolean overrideLuns();
    
    boolean overrideLunsPresent();
    
    String password();
    
    boolean passwordPresent();
    
    String path();
    
    boolean pathPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String portal();
    
    boolean portalPresent();
    
    String target();
    
    boolean targetPresent();
    
    StorageType type();
    
    boolean typePresent();
    
    String username();
    
    boolean usernamePresent();
    
    String vfsType();
    
    boolean vfsTypePresent();
    
    VolumeGroup volumeGroup();
    
    boolean volumeGroupPresent();
    
    Host host();
    
    boolean hostPresent();
    
}
