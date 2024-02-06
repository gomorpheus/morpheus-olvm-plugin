/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.TagContainer;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class TagBuilder {
    private String comment;
    private String description;
    private Group group;
    private Host host;
    private String href;
    private String id;
    private String name;
    private Tag parent;
    private Template template;
    private User user;
    private Vm vm;
    
    public TagBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public TagBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public TagBuilder group(Group newGroup) {
        group = newGroup;
        return this;
    }
    
    public TagBuilder group(GroupBuilder newGroup) {
        if (newGroup == null) {
            group = null;
        }
        else {
            group = newGroup.build();
        }
        return this;
    }
    
    
    public TagBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public TagBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public TagBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public TagBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public TagBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public TagBuilder parent(Tag newParent) {
        parent = newParent;
        return this;
    }
    
    public TagBuilder parent(TagBuilder newParent) {
        if (newParent == null) {
            parent = null;
        }
        else {
            parent = newParent.build();
        }
        return this;
    }
    
    
    public TagBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public TagBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public TagBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public TagBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public TagBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public TagBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Tag build() {
        TagContainer container = new TagContainer();
        container.comment(comment);
        container.description(description);
        container.group(group);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        container.parent(parent);
        container.template(template);
        container.user(user);
        container.vm(vm);
        return container;
    }
}
