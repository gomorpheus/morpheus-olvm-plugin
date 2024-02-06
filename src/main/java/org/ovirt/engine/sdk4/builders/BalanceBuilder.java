/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.BalanceContainer;
import org.ovirt.engine.sdk4.types.Balance;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class BalanceBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private SchedulingPolicy schedulingPolicy;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public BalanceBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public BalanceBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public BalanceBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public BalanceBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public BalanceBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public BalanceBuilder schedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        schedulingPolicy = newSchedulingPolicy;
        return this;
    }
    
    public BalanceBuilder schedulingPolicy(SchedulingPolicyBuilder newSchedulingPolicy) {
        if (newSchedulingPolicy == null) {
            schedulingPolicy = null;
        }
        else {
            schedulingPolicy = newSchedulingPolicy.build();
        }
        return this;
    }
    
    
    public BalanceBuilder schedulingPolicyUnit(SchedulingPolicyUnit newSchedulingPolicyUnit) {
        schedulingPolicyUnit = newSchedulingPolicyUnit;
        return this;
    }
    
    public BalanceBuilder schedulingPolicyUnit(SchedulingPolicyUnitBuilder newSchedulingPolicyUnit) {
        if (newSchedulingPolicyUnit == null) {
            schedulingPolicyUnit = null;
        }
        else {
            schedulingPolicyUnit = newSchedulingPolicyUnit.build();
        }
        return this;
    }
    
    
    public Balance build() {
        BalanceContainer container = new BalanceContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.schedulingPolicy(schedulingPolicy);
        container.schedulingPolicyUnit(schedulingPolicyUnit);
        return container;
    }
}
