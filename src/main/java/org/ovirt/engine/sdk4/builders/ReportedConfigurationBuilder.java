/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ReportedConfigurationContainer;
import org.ovirt.engine.sdk4.types.ReportedConfiguration;

public class ReportedConfigurationBuilder {
    private String actualValue;
    private String expectedValue;
    private Boolean inSync;
    private String name;
    
    public ReportedConfigurationBuilder actualValue(String newActualValue) {
        actualValue = newActualValue;
        return this;
    }
    
    
    public ReportedConfigurationBuilder expectedValue(String newExpectedValue) {
        expectedValue = newExpectedValue;
        return this;
    }
    
    
    public ReportedConfigurationBuilder inSync(boolean newInSync) {
        inSync = Boolean.valueOf(newInSync);
        return this;
    }
    
    public ReportedConfigurationBuilder inSync(Boolean newInSync) {
        inSync = newInSync;
        return this;
    }
    
    
    public ReportedConfigurationBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ReportedConfiguration build() {
        ReportedConfigurationContainer container = new ReportedConfigurationContainer();
        container.actualValue(actualValue);
        container.expectedValue(expectedValue);
        container.inSync(inSync);
        container.name(name);
        return container;
    }
}
