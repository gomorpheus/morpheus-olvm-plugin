/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.SystemOptionContainer;
import org.ovirt.engine.sdk4.types.SystemOption;
import org.ovirt.engine.sdk4.types.SystemOptionValue;

public class SystemOptionBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<SystemOptionValue> values;
    
    public SystemOptionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SystemOptionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SystemOptionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SystemOptionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SystemOptionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SystemOptionBuilder values(List<SystemOptionValue> newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues);
            }
            else {
                values.addAll(newValues);
            }
        }
        return this;
    }
    
    public SystemOptionBuilder values(SystemOptionValue... newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues.length);
            }
            Collections.addAll(values, newValues);
        }
        return this;
    }
    
    public SystemOptionBuilder values(SystemOptionValueBuilder... newValues) {
        if (newValues != null) {
            if (values == null) {
                values = new ArrayList<>(newValues.length);
            }
            for (SystemOptionValueBuilder builder : newValues) {
                values.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SystemOption build() {
        SystemOptionContainer container = new SystemOptionContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.values(values);
        return container;
    }
}
