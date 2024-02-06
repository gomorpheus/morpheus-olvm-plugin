/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.CustomPropertyContainer;
import org.ovirt.engine.sdk4.types.CustomProperty;

public class CustomPropertyBuilder {
    private String name;
    private String regexp;
    private String value;
    
    public CustomPropertyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CustomPropertyBuilder regexp(String newRegexp) {
        regexp = newRegexp;
        return this;
    }
    
    
    public CustomPropertyBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public CustomProperty build() {
        CustomPropertyContainer container = new CustomPropertyContainer();
        container.name(name);
        container.regexp(regexp);
        container.value(value);
        return container;
    }
}
