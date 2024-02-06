/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Vlan;

public class VlanContainer extends Container implements Vlan {
    private BigInteger id;
    
    public BigInteger id() {
        return id;
    }
    
    public Byte idAsByte() {
        return asByte("Vlan", "id", id);
    }
    
    public Short idAsShort() {
        return asShort("Vlan", "id", id);
    }
    
    public Integer idAsInteger() {
        return asInteger("Vlan", "id", id);
    }
    
    public Long idAsLong() {
        return asLong("Vlan", "id", id);
    }
    
    public void id(BigInteger newId) {
        id = newId;
    }
    
    public boolean idPresent() {
        return id != null;
    }
    
}
