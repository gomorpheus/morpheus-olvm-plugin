/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.OpenStackNetworkContainer;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;

public class OpenStackNetworkBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private OpenStackNetworkProvider openstackNetworkProvider;
    
    public OpenStackNetworkBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackNetworkBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackNetworkBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackNetworkBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackNetworkBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackNetworkBuilder openstackNetworkProvider(OpenStackNetworkProvider newOpenstackNetworkProvider) {
        openstackNetworkProvider = newOpenstackNetworkProvider;
        return this;
    }
    
    public OpenStackNetworkBuilder openstackNetworkProvider(OpenStackNetworkProviderBuilder newOpenstackNetworkProvider) {
        if (newOpenstackNetworkProvider == null) {
            openstackNetworkProvider = null;
        }
        else {
            openstackNetworkProvider = newOpenstackNetworkProvider.build();
        }
        return this;
    }
    
    
    public OpenStackNetwork build() {
        OpenStackNetworkContainer container = new OpenStackNetworkContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.openstackNetworkProvider(openstackNetworkProvider);
        return container;
    }
}
