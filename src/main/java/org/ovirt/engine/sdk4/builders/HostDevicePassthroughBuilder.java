/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.HostDevicePassthroughContainer;
import org.ovirt.engine.sdk4.types.HostDevicePassthrough;

public class HostDevicePassthroughBuilder {
    private Boolean enabled;
    
    public HostDevicePassthroughBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public HostDevicePassthroughBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public HostDevicePassthrough build() {
        HostDevicePassthroughContainer container = new HostDevicePassthroughContainer();
        container.enabled(enabled);
        return container;
    }
}
