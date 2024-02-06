/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.SerialNumberContainer;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.SerialNumberPolicy;

public class SerialNumberBuilder {
    private SerialNumberPolicy policy;
    private String value;
    
    public SerialNumberBuilder policy(SerialNumberPolicy newPolicy) {
        policy = newPolicy;
        return this;
    }
    
    
    public SerialNumberBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public SerialNumber build() {
        SerialNumberContainer container = new SerialNumberContainer();
        container.policy(policy);
        container.value(value);
        return container;
    }
}
