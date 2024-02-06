/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface Weight extends Identified {
    BigInteger factor();
    Byte factorAsByte();
    Short factorAsShort();
    Integer factorAsInteger();
    Long factorAsLong();
    
    boolean factorPresent();
    
    SchedulingPolicy schedulingPolicy();
    
    boolean schedulingPolicyPresent();
    
    SchedulingPolicyUnit schedulingPolicyUnit();
    
    boolean schedulingPolicyUnitPresent();
    
}
