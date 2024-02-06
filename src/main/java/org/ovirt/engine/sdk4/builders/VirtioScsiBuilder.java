/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.VirtioScsiContainer;
import org.ovirt.engine.sdk4.types.VirtioScsi;

public class VirtioScsiBuilder {
    private Boolean enabled;
    
    public VirtioScsiBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public VirtioScsiBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public VirtioScsi build() {
        VirtioScsiContainer container = new VirtioScsiContainer();
        container.enabled(enabled);
        return container;
    }
}
