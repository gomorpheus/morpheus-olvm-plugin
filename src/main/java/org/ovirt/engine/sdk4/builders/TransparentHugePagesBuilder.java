/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.TransparentHugePagesContainer;
import org.ovirt.engine.sdk4.types.TransparentHugePages;

public class TransparentHugePagesBuilder {
    private Boolean enabled;
    
    public TransparentHugePagesBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public TransparentHugePagesBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public TransparentHugePages build() {
        TransparentHugePagesContainer container = new TransparentHugePagesContainer();
        container.enabled(enabled);
        return container;
    }
}
