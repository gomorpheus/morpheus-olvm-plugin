/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Describes a user session to a virtual machine.
 */
public interface Session extends Identified {
    boolean consoleUser();
    
    boolean consoleUserPresent();
    
    Ip ip();
    
    boolean ipPresent();
    
    String protocol();
    
    boolean protocolPresent();
    
    User user();
    
    boolean userPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
