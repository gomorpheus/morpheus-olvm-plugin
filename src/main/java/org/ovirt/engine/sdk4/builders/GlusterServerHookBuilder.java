/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.GlusterServerHookContainer;
import org.ovirt.engine.sdk4.types.GlusterHookStatus;
import org.ovirt.engine.sdk4.types.GlusterServerHook;
import org.ovirt.engine.sdk4.types.HookContentType;
import org.ovirt.engine.sdk4.types.Host;

public class GlusterServerHookBuilder {
    private String checksum;
    private String comment;
    private HookContentType contentType;
    private String description;
    private Host host;
    private String href;
    private String id;
    private String name;
    private GlusterHookStatus status;
    
    public GlusterServerHookBuilder checksum(String newChecksum) {
        checksum = newChecksum;
        return this;
    }
    
    
    public GlusterServerHookBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterServerHookBuilder contentType(HookContentType newContentType) {
        contentType = newContentType;
        return this;
    }
    
    
    public GlusterServerHookBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterServerHookBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public GlusterServerHookBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public GlusterServerHookBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterServerHookBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterServerHookBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterServerHookBuilder status(GlusterHookStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public GlusterServerHook build() {
        GlusterServerHookContainer container = new GlusterServerHookContainer();
        container.checksum(checksum);
        container.comment(comment);
        container.contentType(contentType);
        container.description(description);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        container.status(status);
        return container;
    }
}
