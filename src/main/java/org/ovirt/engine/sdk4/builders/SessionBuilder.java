/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.SessionContainer;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Session;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class SessionBuilder {
    private String comment;
    private Boolean consoleUser;
    private String description;
    private String href;
    private String id;
    private Ip ip;
    private String name;
    private String protocol;
    private User user;
    private Vm vm;
    
    public SessionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SessionBuilder consoleUser(boolean newConsoleUser) {
        consoleUser = Boolean.valueOf(newConsoleUser);
        return this;
    }
    
    public SessionBuilder consoleUser(Boolean newConsoleUser) {
        consoleUser = newConsoleUser;
        return this;
    }
    
    
    public SessionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SessionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SessionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SessionBuilder ip(Ip newIp) {
        ip = newIp;
        return this;
    }
    
    public SessionBuilder ip(IpBuilder newIp) {
        if (newIp == null) {
            ip = null;
        }
        else {
            ip = newIp.build();
        }
        return this;
    }
    
    
    public SessionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SessionBuilder protocol(String newProtocol) {
        protocol = newProtocol;
        return this;
    }
    
    
    public SessionBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public SessionBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public SessionBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public SessionBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Session build() {
        SessionContainer container = new SessionContainer();
        container.comment(comment);
        container.consoleUser(consoleUser);
        container.description(description);
        container.href(href);
        container.id(id);
        container.ip(ip);
        container.name(name);
        container.protocol(protocol);
        container.user(user);
        container.vm(vm);
        return container;
    }
}
