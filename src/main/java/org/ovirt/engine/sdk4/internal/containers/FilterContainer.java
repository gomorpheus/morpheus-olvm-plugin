/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Filter;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class FilterContainer extends IdentifiedContainer implements Filter {
    private BigInteger position;
    private SchedulingPolicyUnit schedulingPolicyUnit;
    
    public BigInteger position() {
        return position;
    }
    
    public Byte positionAsByte() {
        return asByte("Filter", "position", position);
    }
    
    public Short positionAsShort() {
        return asShort("Filter", "position", position);
    }
    
    public Integer positionAsInteger() {
        return asInteger("Filter", "position", position);
    }
    
    public Long positionAsLong() {
        return asLong("Filter", "position", position);
    }
    
    public void position(BigInteger newPosition) {
        position = newPosition;
    }
    
    public boolean positionPresent() {
        return position != null;
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
