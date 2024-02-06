/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents the IP configuration of a network interface.
 */
public interface Ip {
    String address();
    
    boolean addressPresent();
    
    String gateway();
    
    boolean gatewayPresent();
    
    String netmask();
    
    boolean netmaskPresent();
    
    IpVersion version();
    
    boolean versionPresent();
    
}
