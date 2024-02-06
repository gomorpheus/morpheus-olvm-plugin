/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.DiskAttachmentContainer;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class DiskAttachmentBuilder {
    private Boolean active;
    private Boolean bootable;
    private String comment;
    private String description;
    private Disk disk;
    private String href;
    private String id;
    private DiskInterface interface_;
    private String logicalName;
    private String name;
    private Boolean passDiscard;
    private Boolean readOnly;
    private Template template;
    private Boolean usesScsiReservation;
    private Vm vm;
    
    public DiskAttachmentBuilder active(boolean newActive) {
        active = Boolean.valueOf(newActive);
        return this;
    }
    
    public DiskAttachmentBuilder active(Boolean newActive) {
        active = newActive;
        return this;
    }
    
    
    public DiskAttachmentBuilder bootable(boolean newBootable) {
        bootable = Boolean.valueOf(newBootable);
        return this;
    }
    
    public DiskAttachmentBuilder bootable(Boolean newBootable) {
        bootable = newBootable;
        return this;
    }
    
    
    public DiskAttachmentBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DiskAttachmentBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DiskAttachmentBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public DiskAttachmentBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public DiskAttachmentBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DiskAttachmentBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DiskAttachmentBuilder interface_(DiskInterface newInterface) {
        interface_ = newInterface;
        return this;
    }
    
    
    public DiskAttachmentBuilder logicalName(String newLogicalName) {
        logicalName = newLogicalName;
        return this;
    }
    
    
    public DiskAttachmentBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DiskAttachmentBuilder passDiscard(boolean newPassDiscard) {
        passDiscard = Boolean.valueOf(newPassDiscard);
        return this;
    }
    
    public DiskAttachmentBuilder passDiscard(Boolean newPassDiscard) {
        passDiscard = newPassDiscard;
        return this;
    }
    
    
    public DiskAttachmentBuilder readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
        return this;
    }
    
    public DiskAttachmentBuilder readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
        return this;
    }
    
    
    public DiskAttachmentBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public DiskAttachmentBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public DiskAttachmentBuilder usesScsiReservation(boolean newUsesScsiReservation) {
        usesScsiReservation = Boolean.valueOf(newUsesScsiReservation);
        return this;
    }
    
    public DiskAttachmentBuilder usesScsiReservation(Boolean newUsesScsiReservation) {
        usesScsiReservation = newUsesScsiReservation;
        return this;
    }
    
    
    public DiskAttachmentBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public DiskAttachmentBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public DiskAttachment build() {
        DiskAttachmentContainer container = new DiskAttachmentContainer();
        container.active(active);
        container.bootable(bootable);
        container.comment(comment);
        container.description(description);
        container.disk(disk);
        container.href(href);
        container.id(id);
        container.interface_(interface_);
        container.logicalName(logicalName);
        container.name(name);
        container.passDiscard(passDiscard);
        container.readOnly(readOnly);
        container.template(template);
        container.usesScsiReservation(usesScsiReservation);
        container.vm(vm);
        return container;
    }
}
