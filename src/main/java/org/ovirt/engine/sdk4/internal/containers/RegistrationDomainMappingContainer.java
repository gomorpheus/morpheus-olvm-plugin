/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.RegistrationDomainMapping;

public class RegistrationDomainMappingContainer extends Container implements RegistrationDomainMapping {
    private Domain from;
    private Domain to;
    
    public Domain from() {
        return from;
    }
    
    public void from(Domain newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public Domain to() {
        return to;
    }
    
    public void to(Domain newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
