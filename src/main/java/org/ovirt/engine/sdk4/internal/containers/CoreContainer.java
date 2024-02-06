/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Core;

public class CoreContainer extends Container implements Core {
    private BigInteger index;
    private BigInteger socket;
    
    public BigInteger index() {
        return index;
    }
    
    public Byte indexAsByte() {
        return asByte("Core", "index", index);
    }
    
    public Short indexAsShort() {
        return asShort("Core", "index", index);
    }
    
    public Integer indexAsInteger() {
        return asInteger("Core", "index", index);
    }
    
    public Long indexAsLong() {
        return asLong("Core", "index", index);
    }
    
    public void index(BigInteger newIndex) {
        index = newIndex;
    }
    
    public boolean indexPresent() {
        return index != null;
    }
    
    public BigInteger socket() {
        return socket;
    }
    
    public Byte socketAsByte() {
        return asByte("Core", "socket", socket);
    }
    
    public Short socketAsShort() {
        return asShort("Core", "socket", socket);
    }
    
    public Integer socketAsInteger() {
        return asInteger("Core", "socket", socket);
    }
    
    public Long socketAsLong() {
        return asLong("Core", "socket", socket);
    }
    
    public void socket(BigInteger newSocket) {
        socket = newSocket;
    }
    
    public boolean socketPresent() {
        return socket != null;
    }
    
}
