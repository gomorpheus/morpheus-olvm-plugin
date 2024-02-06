/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface Filter extends Identified {
    BigInteger position();
    Byte positionAsByte();
    Short positionAsShort();
    Integer positionAsInteger();
    Long positionAsLong();
    
    boolean positionPresent();
    
    SchedulingPolicyUnit schedulingPolicyUnit();
    
    boolean schedulingPolicyUnitPresent();
    
}
