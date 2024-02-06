/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface SchedulingPolicyUnit extends Identified {
    boolean enabled();
    
    boolean enabledPresent();
    
    boolean internal();
    
    boolean internalPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    PolicyUnitType type();
    
    boolean typePresent();
    
}
