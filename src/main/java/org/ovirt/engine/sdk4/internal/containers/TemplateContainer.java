/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Cdrom;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TemplateStatus;
import org.ovirt.engine.sdk4.types.TemplateVersion;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.Watchdog;

public class TemplateContainer extends VmBaseContainer implements Template {
    private TemplateStatus status;
    private TemplateVersion version;
    private Vm vm;
    private List<Cdrom> cdroms;
    private List<DiskAttachment> diskAttachments;
    private List<GraphicsConsole> graphicsConsoles;
    private List<Nic> nics;
    private List<Permission> permissions;
    private List<Tag> tags;
    private List<Watchdog> watchdogs;
    
    public TemplateStatus status() {
        return status;
    }
    
    public void status(TemplateStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public TemplateVersion version() {
        return version;
    }
    
    public void version(TemplateVersion newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
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
    
    public List<Cdrom> cdroms() {
        return makeUnmodifiableList(cdroms);
    }
    
    public void cdroms(List<Cdrom> newCdroms) {
        cdroms = makeArrayList(newCdroms);
    }
    
    public boolean cdromsPresent() {
        return cdroms != null && !cdroms.isEmpty();
    }
    
    public List<DiskAttachment> diskAttachments() {
        return makeUnmodifiableList(diskAttachments);
    }
    
    public void diskAttachments(List<DiskAttachment> newDiskAttachments) {
        diskAttachments = makeArrayList(newDiskAttachments);
    }
    
    public boolean diskAttachmentsPresent() {
        return diskAttachments != null && !diskAttachments.isEmpty();
    }
    
    public List<GraphicsConsole> graphicsConsoles() {
        return makeUnmodifiableList(graphicsConsoles);
    }
    
    public void graphicsConsoles(List<GraphicsConsole> newGraphicsConsoles) {
        graphicsConsoles = makeArrayList(newGraphicsConsoles);
    }
    
    public boolean graphicsConsolesPresent() {
        return graphicsConsoles != null && !graphicsConsoles.isEmpty();
    }
    
    public List<Nic> nics() {
        return makeUnmodifiableList(nics);
    }
    
    public void nics(List<Nic> newNics) {
        nics = makeArrayList(newNics);
    }
    
    public boolean nicsPresent() {
        return nics != null && !nics.isEmpty();
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public List<Tag> tags() {
        return makeUnmodifiableList(tags);
    }
    
    public void tags(List<Tag> newTags) {
        tags = makeArrayList(newTags);
    }
    
    public boolean tagsPresent() {
        return tags != null && !tags.isEmpty();
    }
    
    public List<Watchdog> watchdogs() {
        return makeUnmodifiableList(watchdogs);
    }
    
    public void watchdogs(List<Watchdog> newWatchdogs) {
        watchdogs = makeArrayList(newWatchdogs);
    }
    
    public boolean watchdogsPresent() {
        return watchdogs != null && !watchdogs.isEmpty();
    }
    
}
