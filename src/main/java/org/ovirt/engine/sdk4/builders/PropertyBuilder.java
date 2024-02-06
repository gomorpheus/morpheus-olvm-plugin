/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.PropertyContainer;
import org.ovirt.engine.sdk4.types.Property;

public class PropertyBuilder {
    private String name;
    private String value;
    
    public PropertyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public PropertyBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public Property build() {
        PropertyContainer container = new PropertyContainer();
        container.name(name);
        container.value(value);
        return container;
    }
}
