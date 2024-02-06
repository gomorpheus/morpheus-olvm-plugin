/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface GlusterBrickAdvancedDetails extends Device {
    String device();
    
    boolean devicePresent();
    
    String fsName();
    
    boolean fsNamePresent();
    
    List<GlusterClient> glusterClients();
    
    boolean glusterClientsPresent();
    
    List<GlusterMemoryPool> memoryPools();
    
    boolean memoryPoolsPresent();
    
    String mntOptions();
    
    boolean mntOptionsPresent();
    
    BigInteger pid();
    Byte pidAsByte();
    Short pidAsShort();
    Integer pidAsInteger();
    Long pidAsLong();
    
    boolean pidPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
}
