/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.PolicyUnitType;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class SchedulingPolicyUnitContainer extends IdentifiedContainer implements SchedulingPolicyUnit {
    private Boolean enabled;
    private Boolean internal;
    private List<Property> properties;
    private PolicyUnitType type;
    
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
    
    public boolean internal() {
        return internal;
    }
    
    public void internal(boolean newInternal) {
        internal = Boolean.valueOf(newInternal);
    }
    
    public void internal(Boolean newInternal) {
        internal = newInternal;
    }
    
    public boolean internalPresent() {
        return internal != null;
    }
    
    public List<Property> properties() {
        return makeUnmodifiableList(properties);
    }
    
    public void properties(List<Property> newProperties) {
        properties = makeArrayList(newProperties);
    }
    
    public boolean propertiesPresent() {
        return properties != null && !properties.isEmpty();
    }
    
    public PolicyUnitType type() {
        return type;
    }
    
    public void type(PolicyUnitType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
