/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Io;

public class IoContainer extends Container implements Io {
    private BigInteger threads;
    
    public BigInteger threads() {
        return threads;
    }
    
    public Byte threadsAsByte() {
        return asByte("Io", "threads", threads);
    }
    
    public Short threadsAsShort() {
        return asShort("Io", "threads", threads);
    }
    
    public Integer threadsAsInteger() {
        return asInteger("Io", "threads", threads);
    }
    
    public Long threadsAsLong() {
        return asLong("Io", "threads", threads);
    }
    
    public void threads(BigInteger newThreads) {
        threads = newThreads;
    }
    
    public boolean threadsPresent() {
        return threads != null;
    }
    
}
