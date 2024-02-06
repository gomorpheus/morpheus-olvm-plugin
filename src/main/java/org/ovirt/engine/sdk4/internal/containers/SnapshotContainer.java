/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.SnapshotStatus;
import org.ovirt.engine.sdk4.types.SnapshotType;
import org.ovirt.engine.sdk4.types.Vm;

public class SnapshotContainer extends VmContainer implements Snapshot {
    private Date date;
    private Boolean persistMemorystate;
    private SnapshotStatus snapshotStatus;
    private SnapshotType snapshotType;
    private List<Disk> disks;
    private Vm vm;
    
    public Date date() {
        if (date == null) {
            return null;
        }
        else {
            return new Date(date.getTime());
        }
    }
    
    public void date(Date newDate) {
        if (newDate == null) {
            date = null;
        }
        else {
            date = new Date(newDate.getTime());
        }
    }
    
    public boolean datePresent() {
        return date != null;
    }
    
    public boolean persistMemorystate() {
        return persistMemorystate;
    }
    
    public void persistMemorystate(boolean newPersistMemorystate) {
        persistMemorystate = Boolean.valueOf(newPersistMemorystate);
    }
    
    public void persistMemorystate(Boolean newPersistMemorystate) {
        persistMemorystate = newPersistMemorystate;
    }
    
    public boolean persistMemorystatePresent() {
        return persistMemorystate != null;
    }
    
    public SnapshotStatus snapshotStatus() {
        return snapshotStatus;
    }
    
    public void snapshotStatus(SnapshotStatus newSnapshotStatus) {
        snapshotStatus = newSnapshotStatus;
    }
    
    public boolean snapshotStatusPresent() {
        return snapshotStatus != null;
    }
    
    public SnapshotType snapshotType() {
        return snapshotType;
    }
    
    public void snapshotType(SnapshotType newSnapshotType) {
        snapshotType = newSnapshotType;
    }
    
    public boolean snapshotTypePresent() {
        return snapshotType != null;
    }
    
    public List<Disk> disks() {
        return makeUnmodifiableList(disks);
    }
    
    public void disks(List<Disk> newDisks) {
        disks = makeArrayList(newDisks);
    }
    
    public boolean disksPresent() {
        return disks != null && !disks.isEmpty();
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
