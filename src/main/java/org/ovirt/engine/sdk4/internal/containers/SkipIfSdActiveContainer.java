/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.SkipIfSdActive;

public class SkipIfSdActiveContainer extends Container implements SkipIfSdActive {
    private Boolean enabled;
    
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
    
}
