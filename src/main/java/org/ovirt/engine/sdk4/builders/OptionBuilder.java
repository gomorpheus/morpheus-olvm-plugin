/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.OptionContainer;
import org.ovirt.engine.sdk4.types.Option;

public class OptionBuilder {
    private String name;
    private String type;
    private String value;
    
    public OptionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OptionBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public OptionBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public Option build() {
        OptionContainer container = new OptionContainer();
        container.name(name);
        container.type(type);
        container.value(value);
        return container;
    }
}
