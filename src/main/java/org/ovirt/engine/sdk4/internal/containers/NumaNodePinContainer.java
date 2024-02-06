/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.NumaNodePin;

public class NumaNodePinContainer extends Container implements NumaNodePin {
    private NumaNode hostNumaNode;
    private BigInteger index;
    private Boolean pinned;
    
    public NumaNode hostNumaNode() {
        return hostNumaNode;
    }
    
    public void hostNumaNode(NumaNode newHostNumaNode) {
        hostNumaNode = newHostNumaNode;
    }
    
    public boolean hostNumaNodePresent() {
        return hostNumaNode != null;
    }
    
    public BigInteger index() {
        return index;
    }
    
    public Byte indexAsByte() {
        return asByte("NumaNodePin", "index", index);
    }
    
    public Short indexAsShort() {
        return asShort("NumaNodePin", "index", index);
    }
    
    public Integer indexAsInteger() {
        return asInteger("NumaNodePin", "index", index);
    }
    
    public Long indexAsLong() {
        return asLong("NumaNodePin", "index", index);
    }
    
    public void index(BigInteger newIndex) {
        index = newIndex;
    }
    
    public boolean indexPresent() {
        return index != null;
    }
    
    public boolean pinned() {
        return pinned;
    }
    
    public void pinned(boolean newPinned) {
        pinned = Boolean.valueOf(newPinned);
    }
    
    public void pinned(Boolean newPinned) {
        pinned = newPinned;
    }
    
    public boolean pinnedPresent() {
        return pinned != null;
    }
    
}
