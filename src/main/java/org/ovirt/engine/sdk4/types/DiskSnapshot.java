/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


public interface DiskSnapshot extends Disk {
    Disk disk();
    
    boolean diskPresent();
    
    DiskSnapshot parent();
    
    boolean parentPresent();
    
}
