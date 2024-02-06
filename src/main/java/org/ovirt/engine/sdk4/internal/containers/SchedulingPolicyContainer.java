/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.Balance;
import org.ovirt.engine.sdk4.types.Filter;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.Weight;

public class SchedulingPolicyContainer extends IdentifiedContainer implements SchedulingPolicy {
    private Boolean defaultPolicy;
    private Boolean locked;
    private List<Property> properties;
    private List<Balance> balances;
    private List<Filter> filters;
    private List<Weight> weight;
    
    public boolean defaultPolicy() {
        return defaultPolicy;
    }
    
    public void defaultPolicy(boolean newDefaultPolicy) {
        defaultPolicy = Boolean.valueOf(newDefaultPolicy);
    }
    
    public void defaultPolicy(Boolean newDefaultPolicy) {
        defaultPolicy = newDefaultPolicy;
    }
    
    public boolean defaultPolicyPresent() {
        return defaultPolicy != null;
    }
    
    public boolean locked() {
        return locked;
    }
    
    public void locked(boolean newLocked) {
        locked = Boolean.valueOf(newLocked);
    }
    
    public void locked(Boolean newLocked) {
        locked = newLocked;
    }
    
    public boolean lockedPresent() {
        return locked != null;
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
    
    public List<Balance> balances() {
        return makeUnmodifiableList(balances);
    }
    
    public void balances(List<Balance> newBalances) {
        balances = makeArrayList(newBalances);
    }
    
    public boolean balancesPresent() {
        return balances != null && !balances.isEmpty();
    }
    
    public List<Filter> filters() {
        return makeUnmodifiableList(filters);
    }
    
    public void filters(List<Filter> newFilters) {
        filters = makeArrayList(newFilters);
    }
    
    public boolean filtersPresent() {
        return filters != null && !filters.isEmpty();
    }
    
    public List<Weight> weight() {
        return makeUnmodifiableList(weight);
    }
    
    public void weight(List<Weight> newWeight) {
        weight = makeArrayList(newWeight);
    }
    
    public boolean weightPresent() {
        return weight != null && !weight.isEmpty();
    }
    
}
