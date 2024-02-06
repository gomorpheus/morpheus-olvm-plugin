/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;
import org.ovirt.engine.sdk4.types.Weight;

public class WeightContainer extends IdentifiedContainer implements Weight {
    private BigInteger factor;
    private SchedulingPolicy schedulingPolicy;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public BigInteger factor() {
        return factor;
    }
    
    public Byte factorAsByte() {
        return asByte("Weight", "factor", factor);
    }
    
    public Short factorAsShort() {
        return asShort("Weight", "factor", factor);
    }
    
    public Integer factorAsInteger() {
        return asInteger("Weight", "factor", factor);
    }
    
    public Long factorAsLong() {
        return asLong("Weight", "factor", factor);
    }
    
    public void factor(BigInteger newFactor) {
        factor = newFactor;
    }
    
    public boolean factorPresent() {
        return factor != null;
    }
    
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
