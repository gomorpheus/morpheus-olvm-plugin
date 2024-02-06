/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.AffinityRuleContainer;
import org.ovirt.engine.sdk4.types.AffinityRule;

public class AffinityRuleBuilder {
    private Boolean enabled;
    private Boolean enforcing;
    private Boolean positive;
    
    public AffinityRuleBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public AffinityRuleBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public AffinityRuleBuilder enforcing(boolean newEnforcing) {
        enforcing = Boolean.valueOf(newEnforcing);
        return this;
    }
    
    public AffinityRuleBuilder enforcing(Boolean newEnforcing) {
        enforcing = newEnforcing;
        return this;
    }
    
    
    public AffinityRuleBuilder positive(boolean newPositive) {
        positive = Boolean.valueOf(newPositive);
        return this;
    }
    
    public AffinityRuleBuilder positive(Boolean newPositive) {
        positive = newPositive;
        return this;
    }
    
    
    public AffinityRule build() {
        AffinityRuleContainer container = new AffinityRuleContainer();
        container.enabled(enabled);
        container.enforcing(enforcing);
        container.positive(positive);
        return container;
    }
}
