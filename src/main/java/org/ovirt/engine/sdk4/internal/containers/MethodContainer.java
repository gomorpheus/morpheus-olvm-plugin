/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Method;
import org.ovirt.engine.sdk4.types.SsoMethod;

public class MethodContainer extends Container implements Method {
    private SsoMethod id;
    
    public SsoMethod id() {
        return id;
    }
    
    public void id(SsoMethod newId) {
        id = newId;
    }
    
    public boolean idPresent() {
        return id != null;
    }
    
}
