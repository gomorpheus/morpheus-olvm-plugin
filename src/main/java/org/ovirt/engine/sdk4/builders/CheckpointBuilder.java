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
import org.ovirt.engine.sdk4.internal.containers.CheckpointContainer;
import org.ovirt.engine.sdk4.types.Checkpoint;
import org.ovirt.engine.sdk4.types.CheckpointState;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Vm;

public class CheckpointBuilder {
    private String comment;
    private Date creationDate;
    private String description;
    private List<Disk> disks;
    private String href;
    private String id;
    private String name;
    private String parentId;
    private CheckpointState state;
    private Vm vm;
    
    public CheckpointBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public CheckpointBuilder creationDate(Date newCreationDate) {
        if (newCreationDate == null) {
            creationDate = null;
        }
        else {
            creationDate = new Date(newCreationDate.getTime());
        }
        return this;
    }
    
    
    public CheckpointBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public CheckpointBuilder disks(List<Disk> newDisks) {
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
    
    public CheckpointBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public CheckpointBuilder disks(DiskBuilder... newDisks) {
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
    
    
    public CheckpointBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public CheckpointBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public CheckpointBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CheckpointBuilder parentId(String newParentId) {
        parentId = newParentId;
        return this;
    }
    
    
    public CheckpointBuilder state(CheckpointState newState) {
        state = newState;
        return this;
    }
    
    
    public CheckpointBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public CheckpointBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Checkpoint build() {
        CheckpointContainer container = new CheckpointContainer();
        container.comment(comment);
        container.creationDate(creationDate);
        container.description(description);
        container.disks(disks);
        container.href(href);
        container.id(id);
        container.name(name);
        container.parentId(parentId);
        container.state(state);
        container.vm(vm);
        return container;
    }
}
