/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.WatchdogContainer;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.Watchdog;
import org.ovirt.engine.sdk4.types.WatchdogAction;
import org.ovirt.engine.sdk4.types.WatchdogModel;

public class WatchdogBuilder {
    private WatchdogAction action;
    private String comment;
    private String description;
    private String href;
    private String id;
    private InstanceType instanceType;
    private WatchdogModel model;
    private String name;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public WatchdogBuilder action(WatchdogAction newAction) {
        action = newAction;
        return this;
    }
    
    
    public WatchdogBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public WatchdogBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public WatchdogBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public WatchdogBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public WatchdogBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public WatchdogBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public WatchdogBuilder model(WatchdogModel newModel) {
        model = newModel;
        return this;
    }
    
    
    public WatchdogBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public WatchdogBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public WatchdogBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public WatchdogBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public WatchdogBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public WatchdogBuilder vms(List<Vm> newVms) {
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
    
    public WatchdogBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public WatchdogBuilder vms(VmBuilder... newVms) {
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
    
    
    public Watchdog build() {
        WatchdogContainer container = new WatchdogContainer();
        container.action(action);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.model(model);
        container.name(name);
        container.template(template);
        container.vm(vm);
        container.vms(vms);
        return container;
    }
}
