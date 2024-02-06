/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.NetworkFilterContainer;
import org.ovirt.engine.sdk4.types.NetworkFilter;
import org.ovirt.engine.sdk4.types.Version;

public class NetworkFilterBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private Version version;
    
    public NetworkFilterBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NetworkFilterBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NetworkFilterBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NetworkFilterBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NetworkFilterBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NetworkFilterBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public NetworkFilterBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public NetworkFilter build() {
        NetworkFilterContainer container = new NetworkFilterContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.version(version);
        return container;
    }
}
