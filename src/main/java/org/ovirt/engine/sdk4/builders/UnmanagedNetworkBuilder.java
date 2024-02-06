/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.UnmanagedNetworkContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.UnmanagedNetwork;

public class UnmanagedNetworkBuilder {
    private String comment;
    private String description;
    private Host host;
    private HostNic hostNic;
    private String href;
    private String id;
    private String name;
    
    public UnmanagedNetworkBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public UnmanagedNetworkBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public UnmanagedNetworkBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public UnmanagedNetworkBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public UnmanagedNetworkBuilder hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
        return this;
    }
    
    public UnmanagedNetworkBuilder hostNic(HostNicBuilder newHostNic) {
        if (newHostNic == null) {
            hostNic = null;
        }
        else {
            hostNic = newHostNic.build();
        }
        return this;
    }
    
    
    public UnmanagedNetworkBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public UnmanagedNetworkBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public UnmanagedNetworkBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public UnmanagedNetwork build() {
        UnmanagedNetworkContainer container = new UnmanagedNetworkContainer();
        container.comment(comment);
        container.description(description);
        container.host(host);
        container.hostNic(hostNic);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
