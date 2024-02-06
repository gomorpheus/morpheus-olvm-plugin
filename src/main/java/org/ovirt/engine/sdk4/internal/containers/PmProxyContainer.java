/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.PmProxy;
import org.ovirt.engine.sdk4.types.PmProxyType;

public class PmProxyContainer extends Container implements PmProxy {
    private PmProxyType type;
    
    public PmProxyType type() {
        return type;
    }
    
    public void type(PmProxyType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
