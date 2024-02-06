/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.HighAvailability;

public class HighAvailabilityContainer extends Container implements HighAvailability {
    private Boolean enabled;
    private BigInteger priority;
    
    public boolean enabled() {
        return enabled;
    }
    
    public void enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
    }
    
    public void enabled(Boolean newEnabled) {
        enabled = newEnabled;
    }
    
    public boolean enabledPresent() {
        return enabled != null;
    }
    
    public BigInteger priority() {
        return priority;
    }
    
    public Byte priorityAsByte() {
        return asByte("HighAvailability", "priority", priority);
    }
    
    public Short priorityAsShort() {
        return asShort("HighAvailability", "priority", priority);
    }
    
    public Integer priorityAsInteger() {
        return asInteger("HighAvailability", "priority", priority);
    }
    
    public Long priorityAsLong() {
        return asLong("HighAvailability", "priority", priority);
    }
    
    public void priority(BigInteger newPriority) {
        priority = newPriority;
    }
    
    public boolean priorityPresent() {
        return priority != null;
    }
    
}
