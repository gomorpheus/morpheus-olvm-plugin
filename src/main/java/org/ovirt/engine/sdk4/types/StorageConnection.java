/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Represents a storage server connection.
 * 
 * Example XML representation:
 * 
 * [source,xml]
 * ----
 * <storage_connection id="123">
 *   <address>mynfs.example.com</address>
 *   <type>nfs</type>
 *   <path>/exports/mydata</path>
 * </storage_connection>
 * ----
 */
public interface StorageConnection extends Identified {
    String address();
    
    boolean addressPresent();
    
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
    
    GlusterVolume glusterVolume();
    
    boolean glusterVolumePresent();
    
    Host host();
    
    boolean hostPresent();
    
}
