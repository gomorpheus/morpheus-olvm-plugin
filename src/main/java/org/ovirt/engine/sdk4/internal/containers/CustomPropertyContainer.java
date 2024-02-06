/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.CustomProperty;

public class CustomPropertyContainer extends Container implements CustomProperty {
    private String name;
    private String regexp;
    private String value;
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
    public String regexp() {
        return regexp;
    }
    
    public void regexp(String newRegexp) {
        regexp = newRegexp;
    }
    
    public boolean regexpPresent() {
        return regexp != null;
    }
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
}
