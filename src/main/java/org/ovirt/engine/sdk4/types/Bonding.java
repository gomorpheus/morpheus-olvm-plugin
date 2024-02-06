/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents a network interfaces bond.
 */
public interface Bonding {
    Mac adPartnerMac();
    
    boolean adPartnerMacPresent();
    
    List<Option> options();
    
    boolean optionsPresent();
    
    List<HostNic> slaves();
    
    boolean slavesPresent();
    
    HostNic activeSlave();
    
    boolean activeSlavePresent();
    
}
