/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.Backup;
import org.ovirt.engine.sdk4.types.BackupPhase;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class BackupContainer extends IdentifiedContainer implements Backup {
    private Date creationDate;
    private String fromCheckpointId;
    private Date modificationDate;
    private BackupPhase phase;
    private String toCheckpointId;
    private List<Disk> disks;
    private Host host;
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
    
    public String fromCheckpointId() {
        return fromCheckpointId;
    }
    
    public void fromCheckpointId(String newFromCheckpointId) {
        fromCheckpointId = newFromCheckpointId;
    }
    
    public boolean fromCheckpointIdPresent() {
        return fromCheckpointId != null;
    }
    
    public Date modificationDate() {
        if (modificationDate == null) {
            return null;
        }
        else {
            return new Date(modificationDate.getTime());
        }
    }
    
    public void modificationDate(Date newModificationDate) {
        if (newModificationDate == null) {
            modificationDate = null;
        }
        else {
            modificationDate = new Date(newModificationDate.getTime());
        }
    }
    
    public boolean modificationDatePresent() {
        return modificationDate != null;
    }
    
    public BackupPhase phase() {
        return phase;
    }
    
    public void phase(BackupPhase newPhase) {
        phase = newPhase;
    }
    
    public boolean phasePresent() {
        return phase != null;
    }
    
    public String toCheckpointId() {
        return toCheckpointId;
    }
    
    public void toCheckpointId(String newToCheckpointId) {
        toCheckpointId = newToCheckpointId;
    }
    
    public boolean toCheckpointIdPresent() {
        return toCheckpointId != null;
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
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
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
