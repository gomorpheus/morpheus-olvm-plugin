/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.FloppyContainer;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Floppy;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class FloppyBuilder {
    private String comment;
    private String description;
    private File file;
    private String href;
    private String id;
    private InstanceType instanceType;
    private String name;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public FloppyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public FloppyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public FloppyBuilder file(File newFile) {
        file = newFile;
        return this;
    }
    
    public FloppyBuilder file(FileBuilder newFile) {
        if (newFile == null) {
            file = null;
        }
        else {
            file = newFile.build();
        }
        return this;
    }
    
    
    public FloppyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public FloppyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public FloppyBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public FloppyBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public FloppyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public FloppyBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public FloppyBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public FloppyBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public FloppyBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public FloppyBuilder vms(List<Vm> newVms) {
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
    
    public FloppyBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public FloppyBuilder vms(VmBuilder... newVms) {
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
    
    
    public Floppy build() {
        FloppyContainer container = new FloppyContainer();
        container.comment(comment);
        container.description(description);
        container.file(file);
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
