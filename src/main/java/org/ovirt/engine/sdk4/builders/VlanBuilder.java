/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.VlanContainer;
import org.ovirt.engine.sdk4.types.Vlan;

public class VlanBuilder {
    private BigInteger id;
    
    public VlanBuilder id(int newId) {
        id = BigInteger.valueOf((long) newId);
        return this;
    }
    
    public VlanBuilder id(Integer newId) {
        if (newId == null) {
            id = null;
        }
        else {
            id = BigInteger.valueOf(newId.longValue());
        }
        return this;
    }
    
    public VlanBuilder id(long newId) {
        id = BigInteger.valueOf(newId);
        return this;
    }
    
    public VlanBuilder id(Long newId) {
        if (newId == null) {
            id = null;
        }
        else {
            id = BigInteger.valueOf(newId.longValue());
        }
        return this;
    }
    
    public VlanBuilder id(BigInteger newId) {
        id = newId;
        return this;
    }
    
    
    public Vlan build() {
        VlanContainer container = new VlanContainer();
        container.id(id);
        return container;
    }
}
