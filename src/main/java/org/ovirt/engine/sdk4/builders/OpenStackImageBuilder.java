/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.OpenStackImageContainer;
import org.ovirt.engine.sdk4.types.OpenStackImage;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public class OpenStackImageBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private OpenStackImageProvider openstackImageProvider;
    
    public OpenStackImageBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackImageBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackImageBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackImageBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackImageBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackImageBuilder openstackImageProvider(OpenStackImageProvider newOpenstackImageProvider) {
        openstackImageProvider = newOpenstackImageProvider;
        return this;
    }
    
    public OpenStackImageBuilder openstackImageProvider(OpenStackImageProviderBuilder newOpenstackImageProvider) {
        if (newOpenstackImageProvider == null) {
            openstackImageProvider = null;
        }
        else {
            openstackImageProvider = newOpenstackImageProvider.build();
        }
        return this;
    }
    
    
    public OpenStackImage build() {
        OpenStackImageContainer container = new OpenStackImageContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.openstackImageProvider(openstackImageProvider);
        return container;
    }
}
