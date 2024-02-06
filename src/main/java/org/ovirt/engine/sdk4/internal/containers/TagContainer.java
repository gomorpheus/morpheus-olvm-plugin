/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class TagContainer extends IdentifiedContainer implements Tag {
    private Group group;
    private Host host;
    private Tag parent;
    private Template template;
    private User user;
    private Vm vm;
    
    public Group group() {
        return group;
    }
    
    public void group(Group newGroup) {
        group = newGroup;
    }
    
    public boolean groupPresent() {
        return group != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public Tag parent() {
        return parent;
    }
    
    public void parent(Tag newParent) {
        parent = newParent;
    }
    
    public boolean parentPresent() {
        return parent != null;
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
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
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
