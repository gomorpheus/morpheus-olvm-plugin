/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.RegistrationVnicProfileMapping;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class RegistrationVnicProfileMappingContainer extends Container implements RegistrationVnicProfileMapping {
    private VnicProfile from;
    private VnicProfile to;
    
    public VnicProfile from() {
        return from;
    }
    
    public void from(VnicProfile newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public VnicProfile to() {
        return to;
    }
    
    public void to(VnicProfile newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
