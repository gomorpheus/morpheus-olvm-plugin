/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.CoreContainer;
import org.ovirt.engine.sdk4.types.Core;

public class CoreBuilder {
    private BigInteger index;
    private BigInteger socket;
    
    public CoreBuilder index(int newIndex) {
        index = BigInteger.valueOf((long) newIndex);
        return this;
    }
    
    public CoreBuilder index(Integer newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public CoreBuilder index(long newIndex) {
        index = BigInteger.valueOf(newIndex);
        return this;
    }
    
    public CoreBuilder index(Long newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public CoreBuilder index(BigInteger newIndex) {
        index = newIndex;
        return this;
    }
    
    
    public CoreBuilder socket(int newSocket) {
        socket = BigInteger.valueOf((long) newSocket);
        return this;
    }
    
    public CoreBuilder socket(Integer newSocket) {
        if (newSocket == null) {
            socket = null;
        }
        else {
            socket = BigInteger.valueOf(newSocket.longValue());
        }
        return this;
    }
    
    public CoreBuilder socket(long newSocket) {
        socket = BigInteger.valueOf(newSocket);
        return this;
    }
    
    public CoreBuilder socket(Long newSocket) {
        if (newSocket == null) {
            socket = null;
        }
        else {
            socket = BigInteger.valueOf(newSocket.longValue());
        }
        return this;
    }
    
    public CoreBuilder socket(BigInteger newSocket) {
        socket = newSocket;
        return this;
    }
    
    
    public Core build() {
        CoreContainer container = new CoreContainer();
        container.index(index);
        container.socket(socket);
        return container;
    }
}
