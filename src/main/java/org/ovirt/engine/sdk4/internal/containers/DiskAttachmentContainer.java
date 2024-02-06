/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class DiskAttachmentContainer extends IdentifiedContainer implements DiskAttachment {
    private Boolean active;
    private Boolean bootable;
    private DiskInterface interface_;
    private String logicalName;
    private Boolean passDiscard;
    private Boolean readOnly;
    private Boolean usesScsiReservation;
    private Disk disk;
    private Template template;
    private Vm vm;
    
    public boolean active() {
        return active;
    }
    
    public void active(boolean newActive) {
        active = Boolean.valueOf(newActive);
    }
    
    public void active(Boolean newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public boolean bootable() {
        return bootable;
    }
    
    public void bootable(boolean newBootable) {
        bootable = Boolean.valueOf(newBootable);
    }
    
    public void bootable(Boolean newBootable) {
        bootable = newBootable;
    }
    
    public boolean bootablePresent() {
        return bootable != null;
    }
    
    public DiskInterface interface_() {
        return interface_;
    }
    
    public void interface_(DiskInterface newInterface) {
        interface_ = newInterface;
    }
    
    public boolean interface_Present() {
        return interface_ != null;
    }
    
    public String logicalName() {
        return logicalName;
    }
    
    public void logicalName(String newLogicalName) {
        logicalName = newLogicalName;
    }
    
    public boolean logicalNamePresent() {
        return logicalName != null;
    }
    
    public boolean passDiscard() {
        return passDiscard;
    }
    
    public void passDiscard(boolean newPassDiscard) {
        passDiscard = Boolean.valueOf(newPassDiscard);
    }
    
    public void passDiscard(Boolean newPassDiscard) {
        passDiscard = newPassDiscard;
    }
    
    public boolean passDiscardPresent() {
        return passDiscard != null;
    }
    
    public boolean readOnly() {
        return readOnly;
    }
    
    public void readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
    }
    
    public void readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
    }
    
    public boolean readOnlyPresent() {
        return readOnly != null;
    }
    
    public boolean usesScsiReservation() {
        return usesScsiReservation;
    }
    
    public void usesScsiReservation(boolean newUsesScsiReservation) {
        usesScsiReservation = Boolean.valueOf(newUsesScsiReservation);
    }
    
    public void usesScsiReservation(Boolean newUsesScsiReservation) {
        usesScsiReservation = newUsesScsiReservation;
    }
    
    public boolean usesScsiReservationPresent() {
        return usesScsiReservation != null;
    }
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
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
