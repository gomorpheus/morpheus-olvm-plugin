/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskSnapshot;

public class DiskSnapshotContainer extends DiskContainer implements DiskSnapshot {
    private Disk disk;
    private DiskSnapshot parent;
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public DiskSnapshot parent() {
        return parent;
    }
    
    public void parent(DiskSnapshot newParent) {
        parent = newParent;
    }
    
    public boolean parentPresent() {
        return parent != null;
    }
    
}
