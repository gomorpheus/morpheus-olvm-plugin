/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Method;
import org.ovirt.engine.sdk4.types.Sso;

public class SsoContainer extends Container implements Sso {
    private List<Method> methods;
    
    public List<Method> methods() {
        return makeUnmodifiableList(methods);
    }
    
    public void methods(List<Method> newMethods) {
        methods = makeArrayList(newMethods);
    }
    
    public boolean methodsPresent() {
        return methods != null && !methods.isEmpty();
    }
    
}
