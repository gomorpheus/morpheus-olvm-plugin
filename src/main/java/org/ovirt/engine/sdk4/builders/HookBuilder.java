/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.HookContainer;
import org.ovirt.engine.sdk4.types.Hook;
import org.ovirt.engine.sdk4.types.Host;

public class HookBuilder {
    private String comment;
    private String description;
    private String eventName;
    private Host host;
    private String href;
    private String id;
    private String md5;
    private String name;
    
    public HookBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public HookBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public HookBuilder eventName(String newEventName) {
        eventName = newEventName;
        return this;
    }
    
    
    public HookBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public HookBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public HookBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public HookBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public HookBuilder md5(String newMd5) {
        md5 = newMd5;
        return this;
    }
    
    
    public HookBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Hook build() {
        HookContainer container = new HookContainer();
        container.comment(comment);
        container.description(description);
        container.eventName(eventName);
        container.host(host);
        container.href(href);
        container.id(id);
        container.md5(md5);
        container.name(name);
        return container;
    }
}
