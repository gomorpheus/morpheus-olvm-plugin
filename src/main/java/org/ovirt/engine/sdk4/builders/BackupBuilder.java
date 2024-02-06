/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.BackupContainer;
import org.ovirt.engine.sdk4.types.Backup;
import org.ovirt.engine.sdk4.types.BackupPhase;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class BackupBuilder {
    private String comment;
    private Date creationDate;
    private String description;
    private List<Disk> disks;
    private String fromCheckpointId;
    private Host host;
    private String href;
    private String id;
    private Date modificationDate;
    private String name;
    private BackupPhase phase;
    private String toCheckpointId;
    private Vm vm;
    
    public BackupBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public BackupBuilder creationDate(Date newCreationDate) {
        if (newCreationDate == null) {
            creationDate = null;
        }
        else {
            creationDate = new Date(newCreationDate.getTime());
        }
        return this;
    }
    
    
    public BackupBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public BackupBuilder disks(List<Disk> newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks);
            }
            else {
                disks.addAll(newDisks);
            }
        }
        return this;
    }
    
    public BackupBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public BackupBuilder disks(DiskBuilder... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            for (DiskBuilder builder : newDisks) {
                disks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public BackupBuilder fromCheckpointId(String newFromCheckpointId) {
        fromCheckpointId = newFromCheckpointId;
        return this;
    }
    
    
    public BackupBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public BackupBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public BackupBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public BackupBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public BackupBuilder modificationDate(Date newModificationDate) {
        if (newModificationDate == null) {
            modificationDate = null;
        }
        else {
            modificationDate = new Date(newModificationDate.getTime());
        }
        return this;
    }
    
    
    public BackupBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public BackupBuilder phase(BackupPhase newPhase) {
        phase = newPhase;
        return this;
    }
    
    
    public BackupBuilder toCheckpointId(String newToCheckpointId) {
        toCheckpointId = newToCheckpointId;
        return this;
    }
    
    
    public BackupBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public BackupBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Backup build() {
        BackupContainer container = new BackupContainer();
        container.comment(comment);
        container.creationDate(creationDate);
        container.description(description);
        container.disks(disks);
        container.fromCheckpointId(fromCheckpointId);
        container.host(host);
        container.href(href);
        container.id(id);
        container.modificationDate(modificationDate);
        container.name(name);
        container.phase(phase);
        container.toCheckpointId(toCheckpointId);
        container.vm(vm);
        return container;
    }
}
