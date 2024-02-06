/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.SerialNumber;
import org.ovirt.engine.sdk4.types.SerialNumberPolicy;

public class SerialNumberContainer extends Container implements SerialNumber {
    private SerialNumberPolicy policy;
    private String value;
    
    public SerialNumberPolicy policy() {
        return policy;
    }
    
    public void policy(SerialNumberPolicy newPolicy) {
        policy = newPolicy;
    }
    
    public boolean policyPresent() {
        return policy != null;
    }
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
}
