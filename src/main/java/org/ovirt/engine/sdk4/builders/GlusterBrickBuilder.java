/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GlusterBrickContainer;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterBrickStatus;
import org.ovirt.engine.sdk4.types.GlusterClient;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class GlusterBrickBuilder {
    private String brickDir;
    private String comment;
    private String description;
    private String device;
    private String fsName;
    private List<GlusterClient> glusterClients;
    private GlusterVolume glusterVolume;
    private String href;
    private String id;
    private InstanceType instanceType;
    private List<GlusterMemoryPool> memoryPools;
    private String mntOptions;
    private String name;
    private BigInteger pid;
    private BigInteger port;
    private String serverId;
    private List<Statistic> statistics;
    private GlusterBrickStatus status;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public GlusterBrickBuilder brickDir(String newBrickDir) {
        brickDir = newBrickDir;
        return this;
    }
    
    
    public GlusterBrickBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterBrickBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterBrickBuilder device(String newDevice) {
        device = newDevice;
        return this;
    }
    
    
    public GlusterBrickBuilder fsName(String newFsName) {
        fsName = newFsName;
        return this;
    }
    
    
    public GlusterBrickBuilder glusterClients(List<GlusterClient> newGlusterClients) {
        if (newGlusterClients != null) {
            if (glusterClients == null) {
                glusterClients = new ArrayList<>(newGlusterClients);
            }
            else {
                glusterClients.addAll(newGlusterClients);
            }
        }
        return this;
    }
    
    public GlusterBrickBuilder glusterClients(GlusterClient... newGlusterClients) {
        if (newGlusterClients != null) {
            if (glusterClients == null) {
                glusterClients = new ArrayList<>(newGlusterClients.length);
            }
            Collections.addAll(glusterClients, newGlusterClients);
        }
        return this;
    }
    
    public GlusterBrickBuilder glusterClients(GlusterClientBuilder... newGlusterClients) {
        if (newGlusterClients != null) {
            if (glusterClients == null) {
                glusterClients = new ArrayList<>(newGlusterClients.length);
            }
            for (GlusterClientBuilder builder : newGlusterClients) {
                glusterClients.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterBrickBuilder glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
        return this;
    }
    
    public GlusterBrickBuilder glusterVolume(GlusterVolumeBuilder newGlusterVolume) {
        if (newGlusterVolume == null) {
            glusterVolume = null;
        }
        else {
            glusterVolume = newGlusterVolume.build();
        }
        return this;
    }
    
    
    public GlusterBrickBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterBrickBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterBrickBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public GlusterBrickBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public GlusterBrickBuilder memoryPools(List<GlusterMemoryPool> newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools);
            }
            else {
                memoryPools.addAll(newMemoryPools);
            }
        }
        return this;
    }
    
    public GlusterBrickBuilder memoryPools(GlusterMemoryPool... newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools.length);
            }
            Collections.addAll(memoryPools, newMemoryPools);
        }
        return this;
    }
    
    public GlusterBrickBuilder memoryPools(GlusterMemoryPoolBuilder... newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools.length);
            }
            for (GlusterMemoryPoolBuilder builder : newMemoryPools) {
                memoryPools.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterBrickBuilder mntOptions(String newMntOptions) {
        mntOptions = newMntOptions;
        return this;
    }
    
    
    public GlusterBrickBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterBrickBuilder pid(int newPid) {
        pid = BigInteger.valueOf((long) newPid);
        return this;
    }
    
    public GlusterBrickBuilder pid(Integer newPid) {
        if (newPid == null) {
            pid = null;
        }
        else {
            pid = BigInteger.valueOf(newPid.longValue());
        }
        return this;
    }
    
    public GlusterBrickBuilder pid(long newPid) {
        pid = BigInteger.valueOf(newPid);
        return this;
    }
    
    public GlusterBrickBuilder pid(Long newPid) {
        if (newPid == null) {
            pid = null;
        }
        else {
            pid = BigInteger.valueOf(newPid.longValue());
        }
        return this;
    }
    
    public GlusterBrickBuilder pid(BigInteger newPid) {
        pid = newPid;
        return this;
    }
    
    
    public GlusterBrickBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public GlusterBrickBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GlusterBrickBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public GlusterBrickBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GlusterBrickBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public GlusterBrickBuilder serverId(String newServerId) {
        serverId = newServerId;
        return this;
    }
    
    
    public GlusterBrickBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public GlusterBrickBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public GlusterBrickBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterBrickBuilder status(GlusterBrickStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public GlusterBrickBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public GlusterBrickBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public GlusterBrickBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public GlusterBrickBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public GlusterBrickBuilder vms(List<Vm> newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms);
            }
            else {
                vms.addAll(newVms);
            }
        }
        return this;
    }
    
    public GlusterBrickBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public GlusterBrickBuilder vms(VmBuilder... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            for (VmBuilder builder : newVms) {
                vms.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterBrick build() {
        GlusterBrickContainer container = new GlusterBrickContainer();
        container.brickDir(brickDir);
        container.comment(comment);
        container.description(description);
        container.device(device);
        container.fsName(fsName);
        container.glusterClients(glusterClients);
        container.glusterVolume(glusterVolume);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.memoryPools(memoryPools);
        container.mntOptions(mntOptions);
        container.name(name);
        container.pid(pid);
        container.port(port);
        container.serverId(serverId);
        container.statistics(statistics);
        container.status(status);
        container.template(template);
        container.vm(vm);
        container.vms(vms);
        return container;
    }
}
