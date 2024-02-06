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
import org.ovirt.engine.sdk4.internal.containers.GlusterBrickAdvancedDetailsContainer;
import org.ovirt.engine.sdk4.types.GlusterBrickAdvancedDetails;
import org.ovirt.engine.sdk4.types.GlusterClient;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class GlusterBrickAdvancedDetailsBuilder {
    private String comment;
    private String description;
    private String device;
    private String fsName;
    private List<GlusterClient> glusterClients;
    private String href;
    private String id;
    private InstanceType instanceType;
    private List<GlusterMemoryPool> memoryPools;
    private String mntOptions;
    private String name;
    private BigInteger pid;
    private BigInteger port;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public GlusterBrickAdvancedDetailsBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder device(String newDevice) {
        device = newDevice;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder fsName(String newFsName) {
        fsName = newFsName;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder glusterClients(List<GlusterClient> newGlusterClients) {
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
    
    public GlusterBrickAdvancedDetailsBuilder glusterClients(GlusterClient... newGlusterClients) {
        if (newGlusterClients != null) {
            if (glusterClients == null) {
                glusterClients = new ArrayList<>(newGlusterClients.length);
            }
            Collections.addAll(glusterClients, newGlusterClients);
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder glusterClients(GlusterClientBuilder... newGlusterClients) {
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
    
    
    public GlusterBrickAdvancedDetailsBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder memoryPools(List<GlusterMemoryPool> newMemoryPools) {
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
    
    public GlusterBrickAdvancedDetailsBuilder memoryPools(GlusterMemoryPool... newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools.length);
            }
            Collections.addAll(memoryPools, newMemoryPools);
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder memoryPools(GlusterMemoryPoolBuilder... newMemoryPools) {
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
    
    
    public GlusterBrickAdvancedDetailsBuilder mntOptions(String newMntOptions) {
        mntOptions = newMntOptions;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder pid(int newPid) {
        pid = BigInteger.valueOf((long) newPid);
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder pid(Integer newPid) {
        if (newPid == null) {
            pid = null;
        }
        else {
            pid = BigInteger.valueOf(newPid.longValue());
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder pid(long newPid) {
        pid = BigInteger.valueOf(newPid);
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder pid(Long newPid) {
        if (newPid == null) {
            pid = null;
        }
        else {
            pid = BigInteger.valueOf(newPid.longValue());
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder pid(BigInteger newPid) {
        pid = newPid;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public GlusterBrickAdvancedDetailsBuilder vms(List<Vm> newVms) {
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
    
    public GlusterBrickAdvancedDetailsBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public GlusterBrickAdvancedDetailsBuilder vms(VmBuilder... newVms) {
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
    
    
    public GlusterBrickAdvancedDetails build() {
        GlusterBrickAdvancedDetailsContainer container = new GlusterBrickAdvancedDetailsContainer();
        container.comment(comment);
        container.description(description);
        container.device(device);
        container.fsName(fsName);
        container.glusterClients(glusterClients);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.memoryPools(memoryPools);
        container.mntOptions(mntOptions);
        container.name(name);
        container.pid(pid);
        container.port(port);
        container.template(template);
        container.vm(vm);
        container.vms(vms);
        return container;
    }
}
