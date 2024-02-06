/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface HostedEngine {
    boolean active();
    
    boolean activePresent();
    
    boolean configured();
    
    boolean configuredPresent();
    
    boolean globalMaintenance();
    
    boolean globalMaintenancePresent();
    
    boolean localMaintenance();
    
    boolean localMaintenancePresent();
    
    BigInteger score();
    Byte scoreAsByte();
    Short scoreAsShort();
    Integer scoreAsInteger();
    Long scoreAsLong();
    
    boolean scorePresent();
    
}
