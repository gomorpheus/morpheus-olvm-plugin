/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.SystemOptionValueContainer;
import org.ovirt.engine.sdk4.types.SystemOptionValue;

public class SystemOptionValueBuilder {
    private String value;
    private String version;
    
    public SystemOptionValueBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public SystemOptionValueBuilder version(String newVersion) {
        version = newVersion;
        return this;
    }
    
    
    public SystemOptionValue build() {
        SystemOptionValueContainer container = new SystemOptionValueContainer();
        container.value(value);
        container.version(version);
        return container;
    }
}
