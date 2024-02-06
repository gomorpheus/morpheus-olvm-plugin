/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.VnicPassThroughContainer;
import org.ovirt.engine.sdk4.types.VnicPassThrough;
import org.ovirt.engine.sdk4.types.VnicPassThroughMode;

public class VnicPassThroughBuilder {
    private VnicPassThroughMode mode;
    
    public VnicPassThroughBuilder mode(VnicPassThroughMode newMode) {
        mode = newMode;
        return this;
    }
    
    
    public VnicPassThrough build() {
        VnicPassThroughContainer container = new VnicPassThroughContainer();
        container.mode(mode);
        return container;
    }
}
