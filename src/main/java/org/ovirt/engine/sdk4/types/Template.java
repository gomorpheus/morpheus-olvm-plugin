/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * The type that represents a virtual machine template.
 * Templates allow for a rapid instantiation of virtual machines with common configuration and disk states.
 */
public interface Template extends VmBase {
    TemplateStatus status();
    
    boolean statusPresent();
    
    TemplateVersion version();
    
    boolean versionPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
    List<Cdrom> cdroms();
    
    boolean cdromsPresent();
    
    List<DiskAttachment> diskAttachments();
    
    boolean diskAttachmentsPresent();
    
    List<GraphicsConsole> graphicsConsoles();
    
    boolean graphicsConsolesPresent();
    
    List<Nic> nics();
    
    boolean nicsPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<Tag> tags();
    
    boolean tagsPresent();
    
    List<Watchdog> watchdogs();
    
    boolean watchdogsPresent();
    
}
