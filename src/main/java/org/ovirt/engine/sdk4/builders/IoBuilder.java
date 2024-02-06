/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.IoContainer;
import org.ovirt.engine.sdk4.types.Io;

public class IoBuilder {
    private BigInteger threads;
    
    public IoBuilder threads(int newThreads) {
        threads = BigInteger.valueOf((long) newThreads);
        return this;
    }
    
    public IoBuilder threads(Integer newThreads) {
        if (newThreads == null) {
            threads = null;
        }
        else {
            threads = BigInteger.valueOf(newThreads.longValue());
        }
        return this;
    }
    
    public IoBuilder threads(long newThreads) {
        threads = BigInteger.valueOf(newThreads);
        return this;
    }
    
    public IoBuilder threads(Long newThreads) {
        if (newThreads == null) {
            threads = null;
        }
        else {
            threads = BigInteger.valueOf(newThreads.longValue());
        }
        return this;
    }
    
    public IoBuilder threads(BigInteger newThreads) {
        threads = newThreads;
        return this;
    }
    
    
    public Io build() {
        IoContainer container = new IoContainer();
        container.threads(threads);
        return container;
    }
}
