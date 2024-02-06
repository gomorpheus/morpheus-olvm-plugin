/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.HighAvailabilityContainer;
import org.ovirt.engine.sdk4.types.HighAvailability;

public class HighAvailabilityBuilder {
    private Boolean enabled;
    private BigInteger priority;
    
    public HighAvailabilityBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public HighAvailabilityBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public HighAvailabilityBuilder priority(int newPriority) {
        priority = BigInteger.valueOf((long) newPriority);
        return this;
    }
    
    public HighAvailabilityBuilder priority(Integer newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigInteger.valueOf(newPriority.longValue());
        }
        return this;
    }
    
    public HighAvailabilityBuilder priority(long newPriority) {
        priority = BigInteger.valueOf(newPriority);
        return this;
    }
    
    public HighAvailabilityBuilder priority(Long newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigInteger.valueOf(newPriority.longValue());
        }
        return this;
    }
    
    public HighAvailabilityBuilder priority(BigInteger newPriority) {
        priority = newPriority;
        return this;
    }
    
    
    public HighAvailability build() {
        HighAvailabilityContainer container = new HighAvailabilityContainer();
        container.enabled(enabled);
        container.priority(priority);
        return container;
    }
}
