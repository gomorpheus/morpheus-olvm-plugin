/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.Usb;
import org.ovirt.engine.sdk4.types.UsbType;

public class UsbContainer extends Container implements Usb {
    private Boolean enabled;
    private UsbType type;
    
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
    
    public UsbType type() {
        return type;
    }
    
    public void type(UsbType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
