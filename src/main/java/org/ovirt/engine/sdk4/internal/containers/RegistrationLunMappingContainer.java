/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.RegistrationLunMapping;

public class RegistrationLunMappingContainer extends Container implements RegistrationLunMapping {
    private Disk from;
    private Disk to;
    
    public Disk from() {
        return from;
    }
    
    public void from(Disk newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public Disk to() {
        return to;
    }
    
    public void to(Disk newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
