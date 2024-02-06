/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Configuration;
import org.ovirt.engine.sdk4.types.ConfigurationType;

public class ConfigurationContainer extends Container implements Configuration {
    private String data;
    private ConfigurationType type;
    
    public String data() {
        return data;
    }
    
    public void data(String newData) {
        data = newData;
    }
    
    public boolean dataPresent() {
        return data != null;
    }
    
    public ConfigurationType type() {
        return type;
    }
    
    public void type(ConfigurationType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
