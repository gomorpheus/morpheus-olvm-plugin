/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.MethodContainer;
import org.ovirt.engine.sdk4.types.Method;
import org.ovirt.engine.sdk4.types.SsoMethod;

public class MethodBuilder {
    private SsoMethod id;
    
    public MethodBuilder id(SsoMethod newId) {
        id = newId;
        return this;
    }
    
    
    public Method build() {
        MethodContainer container = new MethodContainer();
        container.id(id);
        return container;
    }
}
