/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.SkipIfConnectivityBroken;

public class SkipIfConnectivityBrokenContainer extends Container implements SkipIfConnectivityBroken {
    private Boolean enabled;
    private BigInteger threshold;
    
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
    
    public BigInteger threshold() {
        return threshold;
    }
    
    public Byte thresholdAsByte() {
        return asByte("SkipIfConnectivityBroken", "threshold", threshold);
    }
    
    public Short thresholdAsShort() {
        return asShort("SkipIfConnectivityBroken", "threshold", threshold);
    }
    
    public Integer thresholdAsInteger() {
        return asInteger("SkipIfConnectivityBroken", "threshold", threshold);
    }
    
    public Long thresholdAsLong() {
        return asLong("SkipIfConnectivityBroken", "threshold", threshold);
    }
    
    public void threshold(BigInteger newThreshold) {
        threshold = newThreshold;
    }
    
    public boolean thresholdPresent() {
        return threshold != null;
    }
    
}
