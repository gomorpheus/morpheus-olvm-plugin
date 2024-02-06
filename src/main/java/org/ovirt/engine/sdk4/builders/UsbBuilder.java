/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.UsbContainer;
import org.ovirt.engine.sdk4.types.Usb;
import org.ovirt.engine.sdk4.types.UsbType;

public class UsbBuilder {
    private Boolean enabled;
    private UsbType type;
    
    public UsbBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public UsbBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public UsbBuilder type(UsbType newType) {
        type = newType;
        return this;
    }
    
    
    public Usb build() {
        UsbContainer container = new UsbContainer();
        container.enabled(enabled);
        container.type(type);
        return container;
    }
}
