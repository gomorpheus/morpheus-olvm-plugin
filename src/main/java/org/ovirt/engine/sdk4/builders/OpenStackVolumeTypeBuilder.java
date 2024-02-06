/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.OpenStackVolumeTypeContainer;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackVolumeTypeBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private OpenStackVolumeProvider openstackVolumeProvider;
    private List<Property> properties;
    
    public OpenStackVolumeTypeBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder openstackVolumeProvider(OpenStackVolumeProvider newOpenstackVolumeProvider) {
        openstackVolumeProvider = newOpenstackVolumeProvider;
        return this;
    }
    
    public OpenStackVolumeTypeBuilder openstackVolumeProvider(OpenStackVolumeProviderBuilder newOpenstackVolumeProvider) {
        if (newOpenstackVolumeProvider == null) {
            openstackVolumeProvider = null;
        }
        else {
            openstackVolumeProvider = newOpenstackVolumeProvider.build();
        }
        return this;
    }
    
    
    public OpenStackVolumeTypeBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public OpenStackVolumeTypeBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public OpenStackVolumeTypeBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackVolumeType build() {
        OpenStackVolumeTypeContainer container = new OpenStackVolumeTypeContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.openstackVolumeProvider(openstackVolumeProvider);
        container.properties(properties);
        return container;
    }
}
