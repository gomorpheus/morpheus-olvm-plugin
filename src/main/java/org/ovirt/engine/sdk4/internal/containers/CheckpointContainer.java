/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.Checkpoint;
import org.ovirt.engine.sdk4.types.CheckpointState;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Vm;

public class CheckpointContainer extends IdentifiedContainer implements Checkpoint {
    private Date creationDate;
    private String parentId;
    private CheckpointState state;
    private List<Disk> disks;
    private Vm vm;
    
    public Date creationDate() {
        if (creationDate == null) {
            return null;
        }
        else {
            return new Date(creationDate.getTime());
        }
    }
    
    public void creationDate(Date newCreationDate) {
        if (newCreationDate == null) {
            creationDate = null;
        }
        else {
            creationDate = new Date(newCreationDate.getTime());
        }
    }
    
    public boolean creationDatePresent() {
        return creationDate != null;
    }
    
    public String parentId() {
        return parentId;
    }
    
    public void parentId(String newParentId) {
        parentId = newParentId;
    }
    
    public boolean parentIdPresent() {
        return parentId != null;
    }
    
    public CheckpointState state() {
        return state;
    }
    
    public void state(CheckpointState newState) {
        state = newState;
    }
    
    public boolean statePresent() {
        return state != null;
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
