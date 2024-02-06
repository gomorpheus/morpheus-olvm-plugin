/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


public interface UnmanagedNetwork extends Identified {
    Host host();
    
    boolean hostPresent();
    
    HostNic hostNic();
    
    boolean hostNicPresent();
    
}
