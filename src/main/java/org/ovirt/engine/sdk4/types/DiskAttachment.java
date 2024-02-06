/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Describes how a disk is attached to a virtual machine.
 */
public interface DiskAttachment extends Identified {
    boolean active();
    
    boolean activePresent();
    
    boolean bootable();
    
    boolean bootablePresent();
    
    DiskInterface interface_();
    
    boolean interface_Present();
    
    String logicalName();
    
    boolean logicalNamePresent();
    
    boolean passDiscard();
    
    boolean passDiscardPresent();
    
    boolean readOnly();
    
    boolean readOnlyPresent();
    
    boolean usesScsiReservation();
    
    boolean usesScsiReservationPresent();
    
    Disk disk();
    
    boolean diskPresent();
    
    Template template();
    
    boolean templatePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
