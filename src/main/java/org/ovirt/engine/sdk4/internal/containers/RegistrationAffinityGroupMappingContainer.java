/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.AffinityGroup;
import org.ovirt.engine.sdk4.types.RegistrationAffinityGroupMapping;

public class RegistrationAffinityGroupMappingContainer extends Container implements RegistrationAffinityGroupMapping {
    private AffinityGroup from;
    private AffinityGroup to;
    
    public AffinityGroup from() {
        return from;
    }
    
    public void from(AffinityGroup newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public AffinityGroup to() {
        return to;
    }
    
    public void to(AffinityGroup newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
