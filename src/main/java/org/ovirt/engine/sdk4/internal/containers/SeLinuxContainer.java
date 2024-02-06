/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.SeLinux;
import org.ovirt.engine.sdk4.types.SeLinuxMode;

public class SeLinuxContainer extends Container implements SeLinux {
    private SeLinuxMode mode;
    
    public SeLinuxMode mode() {
        return mode;
    }
    
    public void mode(SeLinuxMode newMode) {
        mode = newMode;
    }
    
    public boolean modePresent() {
        return mode != null;
    }
    
}
