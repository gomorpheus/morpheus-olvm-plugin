/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.VnicPassThrough;
import org.ovirt.engine.sdk4.types.VnicPassThroughMode;

public class VnicPassThroughContainer extends Container implements VnicPassThrough {
    private VnicPassThroughMode mode;
    
    public VnicPassThroughMode mode() {
        return mode;
    }
    
    public void mode(VnicPassThroughMode newMode) {
        mode = newMode;
    }
    
    public boolean modePresent() {
        return mode != null;
    }
    
}
