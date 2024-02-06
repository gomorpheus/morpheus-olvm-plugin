/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.SchedulingPolicyContainer;
import org.ovirt.engine.sdk4.types.Balance;
import org.ovirt.engine.sdk4.types.Filter;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.Weight;

public class SchedulingPolicyBuilder {
    private List<Balance> balances;
    private String comment;
    private Boolean defaultPolicy;
    private String description;
    private List<Filter> filters;
    private String href;
    private String id;
    private Boolean locked;
    private String name;
    private List<Property> properties;
    private List<Weight> weight;
    
    public SchedulingPolicyBuilder balances(List<Balance> newBalances) {
        if (newBalances != null) {
            if (balances == null) {
                balances = new ArrayList<>(newBalances);
            }
            else {
                balances.addAll(newBalances);
            }
        }
        return this;
    }
    
    public SchedulingPolicyBuilder balances(Balance... newBalances) {
        if (newBalances != null) {
            if (balances == null) {
                balances = new ArrayList<>(newBalances.length);
            }
            Collections.addAll(balances, newBalances);
        }
        return this;
    }
    
    public SchedulingPolicyBuilder balances(BalanceBuilder... newBalances) {
        if (newBalances != null) {
            if (balances == null) {
                balances = new ArrayList<>(newBalances.length);
            }
            for (BalanceBuilder builder : newBalances) {
                balances.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SchedulingPolicyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SchedulingPolicyBuilder defaultPolicy(boolean newDefaultPolicy) {
        defaultPolicy = Boolean.valueOf(newDefaultPolicy);
        return this;
    }
    
    public SchedulingPolicyBuilder defaultPolicy(Boolean newDefaultPolicy) {
        defaultPolicy = newDefaultPolicy;
        return this;
    }
    
    
    public SchedulingPolicyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SchedulingPolicyBuilder filters(List<Filter> newFilters) {
        if (newFilters != null) {
            if (filters == null) {
                filters = new ArrayList<>(newFilters);
            }
            else {
                filters.addAll(newFilters);
            }
        }
        return this;
    }
    
    public SchedulingPolicyBuilder filters(Filter... newFilters) {
        if (newFilters != null) {
            if (filters == null) {
                filters = new ArrayList<>(newFilters.length);
            }
            Collections.addAll(filters, newFilters);
        }
        return this;
    }
    
    public SchedulingPolicyBuilder filters(FilterBuilder... newFilters) {
        if (newFilters != null) {
            if (filters == null) {
                filters = new ArrayList<>(newFilters.length);
            }
            for (FilterBuilder builder : newFilters) {
                filters.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SchedulingPolicyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SchedulingPolicyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SchedulingPolicyBuilder locked(boolean newLocked) {
        locked = Boolean.valueOf(newLocked);
        return this;
    }
    
    public SchedulingPolicyBuilder locked(Boolean newLocked) {
        locked = newLocked;
        return this;
    }
    
    
    public SchedulingPolicyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SchedulingPolicyBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public SchedulingPolicyBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public SchedulingPolicyBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SchedulingPolicyBuilder weight(List<Weight> newWeight) {
        if (newWeight != null) {
            if (weight == null) {
                weight = new ArrayList<>(newWeight);
            }
            else {
                weight.addAll(newWeight);
            }
        }
        return this;
    }
    
    public SchedulingPolicyBuilder weight(Weight... newWeight) {
        if (newWeight != null) {
            if (weight == null) {
                weight = new ArrayList<>(newWeight.length);
            }
            Collections.addAll(weight, newWeight);
        }
        return this;
    }
    
    public SchedulingPolicyBuilder weight(WeightBuilder... newWeight) {
        if (newWeight != null) {
            if (weight == null) {
                weight = new ArrayList<>(newWeight.length);
            }
            for (WeightBuilder builder : newWeight) {
                weight.add(builder.build());
            }
        }
        return this;
    }
    
    
    public SchedulingPolicy build() {
        SchedulingPolicyContainer container = new SchedulingPolicyContainer();
        container.balances(balances);
        container.comment(comment);
        container.defaultPolicy(defaultPolicy);
        container.description(description);
        container.filters(filters);
        container.href(href);
        container.id(id);
        container.locked(locked);
        container.name(name);
        container.properties(properties);
        container.weight(weight);
        return container;
    }
}
