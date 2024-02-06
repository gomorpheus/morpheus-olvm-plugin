/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * The type describes the configuration of a virtual network interface.
 */
public interface NicConfiguration {
    BootProtocol bootProtocol();
    
    boolean bootProtocolPresent();
    
    Ip ip();
    
    boolean ipPresent();
    
    Ip ipv6();
    
    boolean ipv6Present();
    
    BootProtocol ipv6BootProtocol();
    
    boolean ipv6BootProtocolPresent();
    
    String name();
    
    boolean namePresent();
    
    boolean onBoot();
    
    boolean onBootPresent();
    
}
