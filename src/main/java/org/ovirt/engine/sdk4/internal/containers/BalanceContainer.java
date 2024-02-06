/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Balance;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class BalanceContainer extends IdentifiedContainer implements Balance {
    private SchedulingPolicy schedulingPolicy;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public SchedulingPolicy schedulingPolicy() {
        return schedulingPolicy;
    }
    
    public void schedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
        schedulingPolicy = newSchedulingPolicy;
    }
    
    public boolean schedulingPolicyPresent() {
        return schedulingPolicy != null;
    }
    
    public SchedulingPolicyUnit schedulingPolicyUnit() {
        return schedulingPolicyUnit;
    }
    
    public void schedulingPolicyUnit(SchedulingPolicyUnit newSchedulingPolicyUnit) {
        schedulingPolicyUnit = newSchedulingPolicyUnit;
    }
    
    public boolean schedulingPolicyUnitPresent() {
        return schedulingPolicyUnit != null;
    }
    
}
