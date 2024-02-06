/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ConfigurationContainer;
import org.ovirt.engine.sdk4.types.Configuration;
import org.ovirt.engine.sdk4.types.ConfigurationType;

public class ConfigurationBuilder {
    private String data;
    private ConfigurationType type;
    
    public ConfigurationBuilder data(String newData) {
        data = newData;
        return this;
    }
    
    
    public ConfigurationBuilder type(ConfigurationType newType) {
        type = newType;
        return this;
    }
    
    
    public Configuration build() {
        ConfigurationContainer container = new ConfigurationContainer();
        container.data(data);
        container.type(type);
        return container;
    }
}
