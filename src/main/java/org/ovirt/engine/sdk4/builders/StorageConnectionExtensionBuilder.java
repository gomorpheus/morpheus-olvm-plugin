/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.StorageConnectionExtensionContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;

public class StorageConnectionExtensionBuilder {
    private String comment;
    private String description;
    private Host host;
    private String href;
    private String id;
    private String name;
    private String password;
    private String target;
    private String username;
    
    public StorageConnectionExtensionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public StorageConnectionExtensionBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder target(String newTarget) {
        target = newTarget;
        return this;
    }
    
    
    public StorageConnectionExtensionBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public StorageConnectionExtension build() {
        StorageConnectionExtensionContainer container = new StorageConnectionExtensionContainer();
        container.comment(comment);
        container.description(description);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        container.password(password);
        container.target(target);
        container.username(username);
        return container;
    }
}
