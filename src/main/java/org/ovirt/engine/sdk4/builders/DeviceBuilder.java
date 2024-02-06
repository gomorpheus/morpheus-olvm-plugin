/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DeviceContainer;
import org.ovirt.engine.sdk4.types.Device;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class DeviceBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private InstanceType instanceType;
    private String name;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public DeviceBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DeviceBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DeviceBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DeviceBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DeviceBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public DeviceBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public DeviceBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DeviceBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public DeviceBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public DeviceBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public DeviceBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public DeviceBuilder vms(List<Vm> newVms) {
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
    
    public DeviceBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public DeviceBuilder vms(VmBuilder... newVms) {
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
    
    
    public Device build() {
        DeviceContainer container = new DeviceContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.name(name);
        container.template(template);
        container.vm(vm);
        container.vms(vms);
        return container;
    }
}
