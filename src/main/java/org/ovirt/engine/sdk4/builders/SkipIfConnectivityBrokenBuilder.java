/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.SkipIfConnectivityBrokenContainer;
import org.ovirt.engine.sdk4.types.SkipIfConnectivityBroken;

public class SkipIfConnectivityBrokenBuilder {
    private Boolean enabled;
    private BigInteger threshold;
    
    public SkipIfConnectivityBrokenBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public SkipIfConnectivityBrokenBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public SkipIfConnectivityBrokenBuilder threshold(int newThreshold) {
        threshold = BigInteger.valueOf((long) newThreshold);
        return this;
    }
    
    public SkipIfConnectivityBrokenBuilder threshold(Integer newThreshold) {
        if (newThreshold == null) {
            threshold = null;
        }
        else {
            threshold = BigInteger.valueOf(newThreshold.longValue());
        }
        return this;
    }
    
    public SkipIfConnectivityBrokenBuilder threshold(long newThreshold) {
        threshold = BigInteger.valueOf(newThreshold);
        return this;
    }
    
    public SkipIfConnectivityBrokenBuilder threshold(Long newThreshold) {
        if (newThreshold == null) {
            threshold = null;
        }
        else {
            threshold = BigInteger.valueOf(newThreshold.longValue());
        }
        return this;
    }
    
    public SkipIfConnectivityBrokenBuilder threshold(BigInteger newThreshold) {
        threshold = newThreshold;
        return this;
    }
    
    
    public SkipIfConnectivityBroken build() {
        SkipIfConnectivityBrokenContainer container = new SkipIfConnectivityBrokenContainer();
        container.enabled(enabled);
        container.threshold(threshold);
        return container;
    }
}
