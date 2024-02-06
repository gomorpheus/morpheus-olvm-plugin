/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface SchedulingPolicy extends Identified {
    boolean defaultPolicy();
    
    boolean defaultPolicyPresent();
    
    boolean locked();
    
    boolean lockedPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    List<Balance> balances();
    
    boolean balancesPresent();
    
    List<Filter> filters();
    
    boolean filtersPresent();
    
    List<Weight> weight();
    
    boolean weightPresent();
    
}
