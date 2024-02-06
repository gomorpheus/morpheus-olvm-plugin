/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface ReportedDevice extends Identified {
    List<Ip> ips();
    
    boolean ipsPresent();
    
    Mac mac();
    
    boolean macPresent();
    
    ReportedDeviceType type();
    
    boolean typePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
