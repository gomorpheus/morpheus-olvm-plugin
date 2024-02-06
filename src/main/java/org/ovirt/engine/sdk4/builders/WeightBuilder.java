/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.WeightContainer;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;
import org.ovirt.engine.sdk4.types.Weight;

public class WeightBuilder {
    private String comment;
    private String description;
    private BigInteger factor;
    private String href;
    private String id;
    private String name;
    private SchedulingPolicy schedulingPolicy;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public WeightBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public WeightBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public WeightBuilder factor(int newFactor) {
        factor = BigInteger.valueOf((long) newFactor);
        return this;
    }
    
    public WeightBuilder factor(Integer newFactor) {
        if (newFactor == null) {
            factor = null;
        }
        else {
            factor = BigInteger.valueOf(newFactor.longValue());
        }
        return this;
    }
    
    public WeightBuilder factor(long newFactor) {
        factor = BigInteger.valueOf(newFactor);
        return this;
    }
    
    public WeightBuilder factor(Long newFactor) {
        if (newFactor == null) {
            factor = null;
        }
        else {
            factor = BigInteger.valueOf(newFactor.longValue());
        }
        return this;
    }
    
    public WeightBuilder factor(BigInteger newFactor) {
        factor = newFactor;
        return this;
    }
    
    
    public WeightBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public WeightBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public WeightBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public WeightBuilder schedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        schedulingPolicy = newSchedulingPolicy;
        return this;
    }
    
    public WeightBuilder schedulingPolicy(SchedulingPolicyBuilder newSchedulingPolicy) {
        if (newSchedulingPolicy == null) {
            schedulingPolicy = null;
        }
        else {
            schedulingPolicy = newSchedulingPolicy.build();
        }
        return this;
    }
    
    
    public WeightBuilder schedulingPolicyUnit(SchedulingPolicyUnit newSchedulingPolicyUnit) {
        schedulingPolicyUnit = newSchedulingPolicyUnit;
        return this;
    }
    
    public WeightBuilder schedulingPolicyUnit(SchedulingPolicyUnitBuilder newSchedulingPolicyUnit) {
        if (newSchedulingPolicyUnit == null) {
            schedulingPolicyUnit = null;
        }
        else {
            schedulingPolicyUnit = newSchedulingPolicyUnit.build();
        }
        return this;
    }
    
    
    public Weight build() {
        WeightContainer container = new WeightContainer();
        container.comment(comment);
        container.description(description);
        container.factor(factor);
        container.href(href);
        container.id(id);
        container.name(name);
        container.schedulingPolicy(schedulingPolicy);
        container.schedulingPolicyUnit(schedulingPolicyUnit);
        return container;
    }
}
