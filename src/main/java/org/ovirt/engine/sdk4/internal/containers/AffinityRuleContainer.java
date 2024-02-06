/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.AffinityRule;

public class AffinityRuleContainer extends Container implements AffinityRule {
    private Boolean enabled;
    private Boolean enforcing;
    private Boolean positive;
    
    public boolean enabled() {
        return enabled;
    }
    
    public void enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
    }
    
    public void enabled(Boolean newEnabled) {
        enabled = newEnabled;
    }
    
    public boolean enabledPresent() {
        return enabled != null;
    }
    
    public boolean enforcing() {
        return enforcing;
    }
    
    public void enforcing(boolean newEnforcing) {
        enforcing = Boolean.valueOf(newEnforcing);
    }
    
    public void enforcing(Boolean newEnforcing) {
        enforcing = newEnforcing;
    }
    
    public boolean enforcingPresent() {
        return enforcing != null;
    }
    
    public boolean positive() {
        return positive;
    }
    
    public void positive(boolean newPositive) {
        positive = Boolean.valueOf(newPositive);
    }
    
    public void positive(Boolean newPositive) {
        positive = newPositive;
    }
    
    public boolean positivePresent() {
        return positive != null;
    }
    
}
