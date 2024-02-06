/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.ReportedConfiguration;

public class ReportedConfigurationContainer extends Container implements ReportedConfiguration {
    private String actualValue;
    private String expectedValue;
    private Boolean inSync;
    private String name;
    
    public String actualValue() {
        return actualValue;
    }
    
    public void actualValue(String newActualValue) {
        actualValue = newActualValue;
    }
    
    public boolean actualValuePresent() {
        return actualValue != null;
    }
    
    public String expectedValue() {
        return expectedValue;
    }
    
    public void expectedValue(String newExpectedValue) {
        expectedValue = newExpectedValue;
    }
    
    public boolean expectedValuePresent() {
        return expectedValue != null;
    }
    
    public boolean inSync() {
        return inSync;
    }
    
    public void inSync(boolean newInSync) {
        inSync = Boolean.valueOf(newInSync);
    }
    
    public void inSync(Boolean newInSync) {
        inSync = newInSync;
    }
    
    public boolean inSyncPresent() {
        return inSync != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
}
