/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.FilterContainer;
import org.ovirt.engine.sdk4.types.Filter;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class FilterBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private BigInteger position;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public FilterBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public FilterBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public FilterBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public FilterBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public FilterBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public FilterBuilder position(int newPosition) {
        position = BigInteger.valueOf((long) newPosition);
        return this;
    }
    
    public FilterBuilder position(Integer newPosition) {
        if (newPosition == null) {
            position = null;
        }
        else {
            position = BigInteger.valueOf(newPosition.longValue());
        }
        return this;
    }
    
    public FilterBuilder position(long newPosition) {
        position = BigInteger.valueOf(newPosition);
        return this;
    }
    
    public FilterBuilder position(Long newPosition) {
        if (newPosition == null) {
            position = null;
        }
        else {
            position = BigInteger.valueOf(newPosition.longValue());
        }
        return this;
    }
    
    public FilterBuilder position(BigInteger newPosition) {
        position = newPosition;
        return this;
    }
    
    
    public FilterBuilder schedulingPolicyUnit(SchedulingPolicyUnit newSchedulingPolicyUnit) {
        schedulingPolicyUnit = newSchedulingPolicyUnit;
        return this;
    }
    
    public FilterBuilder schedulingPolicyUnit(SchedulingPolicyUnitBuilder newSchedulingPolicyUnit) {
        if (newSchedulingPolicyUnit == null) {
            schedulingPolicyUnit = null;
        }
        else {
            schedulingPolicyUnit = newSchedulingPolicyUnit.build();
        }
        return this;
    }
    
    
    public Filter build() {
        FilterContainer container = new FilterContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.position(position);
        container.schedulingPolicyUnit(schedulingPolicyUnit);
        return container;
    }
}
