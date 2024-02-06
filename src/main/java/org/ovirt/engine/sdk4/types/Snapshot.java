/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.Date;
import java.util.List;

/**
 * Represents a snapshot object.
 * 
 * Example XML representation:
 * 
 * [source,xml]
 * ----
 * <snapshot id="456" href="/ovirt-engine/api/vms/123/snapshots/456">
 *   <actions>
 *     <link rel="restore" href="/ovirt-engine/api/vms/123/snapshots/456/restore"/>
 *   </actions>
 *   <vm id="123" href="/ovirt-engine/api/vms/123"/>
 *   <description>Virtual Machine 1 - Snapshot A</description>
 *   <type>active</type>
 *   <date>2010-08-16T14:24:29</date>
 *   <persist_memorystate>false</persist_memorystate>
 * </snapshot>
 * ----
 */
public interface Snapshot extends Vm {
    Date date();
    
    boolean datePresent();
    
    boolean persistMemorystate();
    
    boolean persistMemorystatePresent();
    
    SnapshotStatus snapshotStatus();
    
    boolean snapshotStatusPresent();
    
    SnapshotType snapshotType();
    
    boolean snapshotTypePresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
