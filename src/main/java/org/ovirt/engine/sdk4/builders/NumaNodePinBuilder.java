/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.NumaNodePinContainer;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.NumaNodePin;

public class NumaNodePinBuilder {
    private NumaNode hostNumaNode;
    private BigInteger index;
    private Boolean pinned;
    
    public NumaNodePinBuilder hostNumaNode(NumaNode newHostNumaNode) {
        hostNumaNode = newHostNumaNode;
        return this;
    }
    
    public NumaNodePinBuilder hostNumaNode(NumaNodeBuilder newHostNumaNode) {
        if (newHostNumaNode == null) {
            hostNumaNode = null;
        }
        else {
            hostNumaNode = newHostNumaNode.build();
        }
        return this;
    }
    
    
    public NumaNodePinBuilder index(int newIndex) {
        index = BigInteger.valueOf((long) newIndex);
        return this;
    }
    
    public NumaNodePinBuilder index(Integer newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public NumaNodePinBuilder index(long newIndex) {
        index = BigInteger.valueOf(newIndex);
        return this;
    }
    
    public NumaNodePinBuilder index(Long newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public NumaNodePinBuilder index(BigInteger newIndex) {
        index = newIndex;
        return this;
    }
    
    
    public NumaNodePinBuilder pinned(boolean newPinned) {
        pinned = Boolean.valueOf(newPinned);
        return this;
    }
    
    public NumaNodePinBuilder pinned(Boolean newPinned) {
        pinned = newPinned;
        return this;
    }
    
    
    public NumaNodePin build() {
        NumaNodePinContainer container = new NumaNodePinContainer();
        container.hostNumaNode(hostNumaNode);
        container.index(index);
        container.pinned(pinned);
        return container;
    }
}
