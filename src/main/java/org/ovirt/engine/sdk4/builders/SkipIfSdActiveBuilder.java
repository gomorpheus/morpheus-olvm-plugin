/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.SkipIfSdActiveContainer;
import org.ovirt.engine.sdk4.types.SkipIfSdActive;

public class SkipIfSdActiveBuilder {
    private Boolean enabled;
    
    public SkipIfSdActiveBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public SkipIfSdActiveBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public SkipIfSdActive build() {
        SkipIfSdActiveContainer container = new SkipIfSdActiveContainer();
        container.enabled(enabled);
        return container;
    }
}
