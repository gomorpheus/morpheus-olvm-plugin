/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.SsoContainer;
import org.ovirt.engine.sdk4.types.Method;
import org.ovirt.engine.sdk4.types.Sso;

public class SsoBuilder {
    private List<Method> methods;
    
    public SsoBuilder methods(List<Method> newMethods) {
        if (newMethods != null) {
            if (methods == null) {
                methods = new ArrayList<>(newMethods);
            }
            else {
                methods.addAll(newMethods);
            }
        }
        return this;
    }
    
    public SsoBuilder methods(Method... newMethods) {
        if (newMethods != null) {
            if (methods == null) {
                methods = new ArrayList<>(newMethods.length);
            }
            Collections.addAll(methods, newMethods);
        }
        return this;
    }
    
    public SsoBuilder methods(MethodBuilder... newMethods) {
        if (newMethods != null) {
            if (methods == null) {
                methods = new ArrayList<>(newMethods.length);
            }
            for (MethodBuilder builder : newMethods) {
                methods.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Sso build() {
        SsoContainer container = new SsoContainer();
        container.methods(methods);
        return container;
    }
}
