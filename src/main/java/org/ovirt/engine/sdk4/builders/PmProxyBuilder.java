/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.PmProxyContainer;
import org.ovirt.engine.sdk4.types.PmProxy;
import org.ovirt.engine.sdk4.types.PmProxyType;

public class PmProxyBuilder {
    private PmProxyType type;
    
    public PmProxyBuilder type(PmProxyType newType) {
        type = newType;
        return this;
    }
    
    
    public PmProxy build() {
        PmProxyContainer container = new PmProxyContainer();
        container.type(type);
        return container;
    }
}
