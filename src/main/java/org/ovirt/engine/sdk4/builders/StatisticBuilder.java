/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.StatisticContainer;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StatisticKind;
import org.ovirt.engine.sdk4.types.StatisticUnit;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.Value;
import org.ovirt.engine.sdk4.types.ValueType;
import org.ovirt.engine.sdk4.types.Vm;

public class StatisticBuilder {
    private GlusterBrick brick;
    private String comment;
    private String description;
    private Disk disk;
    private GlusterVolume glusterVolume;
    private Host host;
    private HostNic hostNic;
    private NumaNode hostNumaNode;
    private String href;
    private String id;
    private StatisticKind kind;
    private String name;
    private Nic nic;
    private Step step;
    private ValueType type;
    private StatisticUnit unit;
    private List<Value> values;
    private Vm vm;
    
    public StatisticBuilder brick(GlusterBrick newBrick) {
        brick = newBrick;
        return this;
    }
    
    public StatisticBuilder brick(GlusterBrickBuilder newBrick) {
        if (newBrick == null) {
            brick = null;
        }
        else {
            brick = newBrick.build();
        }
        return this;
    }
    
    
    public StatisticBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public StatisticBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public StatisticBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public StatisticBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public StatisticBuilder glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
        return this;
    }
    
    public StatisticBuilder glusterVolume(GlusterVolumeBuilder newGlusterVolume) {
        if (newGlusterVolume == null) {
            glusterVolume = null;
        }
        else {
            glusterVolume = newGlusterVolume.build();
        }
        return this;
    }
    
    
    public StatisticBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public StatisticBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public StatisticBuilder hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
        return this;
    }
    
    public StatisticBuilder hostNic(HostNicBuilder newHostNic) {
        if (newHostNic == null) {
            hostNic = null;
        }
        else {
            hostNic = newHostNic.build();
        }
        return this;
    }
    
    
    public StatisticBuilder hostNumaNode(NumaNode newHostNumaNode) {
        hostNumaNode = newHostNumaNode;
        return this;
    }
    
    public StatisticBuilder hostNumaNode(NumaNodeBuilder newHostNumaNode) {
        if (newHostNumaNode == null) {
            hostNumaNode = null;
        }
        else {
            hostNumaNode = newHostNumaNode.build();
        }
        return this;
    }
    
    
    public StatisticBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public StatisticBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public StatisticBuilder kind(StatisticKind newKind) {
        kind = newKind;
        return this;
    }
    
    
    public StatisticBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public StatisticBuilder nic(Nic newNic) {
        nic = newNic;
        return this;
    }
    
    public StatisticBuilder nic(NicBuilder newNic) {
        if (newNic == null) {
            nic = null;
        }
        else {
            nic = newNic.build();
        }
        return this;
    }
    
    
    public StatisticBuilder step(Step newStep) {
        step = newStep;
        return this;
    }
    
    public StatisticBuilder step(StepBuilder newStep) {
        if (newStep == null) {
            step = null;
        }
        else {
            step = newStep.build();
        }
        return this;
    }
    
    
    public StatisticBuilder type(ValueType newType) {
        type = newType;
        return this;
    }
    
    
    public StatisticBuilder unit(StatisticUnit newUnit) {
        unit = newUnit;
        return this;
    }
    
    
    public StatisticBuilder values(List<Value> newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues);
            }
            else {
                values.addAll(newValues);
            }
        }
        return this;
    }
    
    public StatisticBuilder values(Value... newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues.length);
            }
            Collections.addAll(values, newValues);
        }
        return this;
    }
    
    public StatisticBuilder values(ValueBuilder... newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues.length);
            }
            for (ValueBuilder builder : newValues) {
                values.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StatisticBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public StatisticBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Statistic build() {
        StatisticContainer container = new StatisticContainer();
        container.brick(brick);
        container.comment(comment);
        container.description(description);
        container.disk(disk);
        container.glusterVolume(glusterVolume);
        container.host(host);
        container.hostNic(hostNic);
        container.hostNumaNode(hostNumaNode);
        container.href(href);
        container.id(id);
        container.kind(kind);
        container.name(name);
        container.nic(nic);
        container.step(step);
        container.type(type);
        container.unit(unit);
        container.values(values);
        container.vm(vm);
        return container;
    }
}
