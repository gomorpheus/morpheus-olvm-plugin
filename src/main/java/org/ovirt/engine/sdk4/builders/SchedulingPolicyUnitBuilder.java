/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.SchedulingPolicyUnitContainer;
import org.ovirt.engine.sdk4.types.PolicyUnitType;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class SchedulingPolicyUnitBuilder {
    private String comment;
    private String description;
    private Boolean enabled;
    private String href;
    private String id;
    private Boolean internal;
    private String name;
    private List<Property> properties;
    private PolicyUnitType type;
    
    public SchedulingPolicyUnitBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public SchedulingPolicyUnitBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder internal(boolean newInternal) {
        internal = Boolean.valueOf(newInternal);
        return this;
    }
    
    public SchedulingPolicyUnitBuilder internal(Boolean newInternal) {
        internal = newInternal;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SchedulingPolicyUnitBuilder properties(List<Property> newProperties) {
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
    
    public SchedulingPolicyUnitBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public SchedulingPolicyUnitBuilder properties(PropertyBuilder... newProperties) {
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
    
    
    public SchedulingPolicyUnitBuilder type(PolicyUnitType newType) {
        type = newType;
        return this;
    }
    
    
    public SchedulingPolicyUnit build() {
        SchedulingPolicyUnitContainer container = new SchedulingPolicyUnitContainer();
        container.comment(comment);
        container.description(description);
        container.enabled(enabled);
        container.href(href);
        container.id(id);
        container.internal(internal);
        container.name(name);
        container.properties(properties);
        container.type(type);
        return container;
    }
}
