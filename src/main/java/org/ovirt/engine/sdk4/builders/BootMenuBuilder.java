/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.BootMenuContainer;
import org.ovirt.engine.sdk4.types.BootMenu;

public class BootMenuBuilder {
    private Boolean enabled;
    
    public BootMenuBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public BootMenuBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public BootMenu build() {
        BootMenuContainer container = new BootMenuContainer();
        container.enabled(enabled);
        return container;
    }
}
