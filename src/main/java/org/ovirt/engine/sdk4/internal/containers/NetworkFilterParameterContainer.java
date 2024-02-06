/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;
import org.ovirt.engine.sdk4.types.Nic;

public class NetworkFilterParameterContainer extends IdentifiedContainer implements NetworkFilterParameter {
    private String value;
    private Nic nic;
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
    public Nic nic() {
        return nic;
    }
    
    public void nic(Nic newNic) {
        nic = newNic;
    }
    
    public boolean nicPresent() {
        return nic != null;
    }
    
}
