/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.RegistrationAffinityLabelMapping;

public class RegistrationAffinityLabelMappingContainer extends Container implements RegistrationAffinityLabelMapping {
    private AffinityLabel from;
    private AffinityLabel to;
    
    public AffinityLabel from() {
        return from;
    }
    
    public void from(AffinityLabel newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public AffinityLabel to() {
        return to;
    }
    
    public void to(AffinityLabel newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
