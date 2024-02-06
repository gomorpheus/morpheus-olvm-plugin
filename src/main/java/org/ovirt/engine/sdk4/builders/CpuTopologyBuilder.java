/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.CpuTopologyContainer;
import org.ovirt.engine.sdk4.types.CpuTopology;

public class CpuTopologyBuilder {
    private BigInteger cores;
    private BigInteger sockets;
    private BigInteger threads;
    
    public CpuTopologyBuilder cores(int newCores) {
        cores = BigInteger.valueOf((long) newCores);
        return this;
    }
    
    public CpuTopologyBuilder cores(Integer newCores) {
        if (newCores == null) {
            cores = null;
        }
        else {
            cores = BigInteger.valueOf(newCores.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder cores(long newCores) {
        cores = BigInteger.valueOf(newCores);
        return this;
    }
    
    public CpuTopologyBuilder cores(Long newCores) {
        if (newCores == null) {
            cores = null;
        }
        else {
            cores = BigInteger.valueOf(newCores.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder cores(BigInteger newCores) {
        cores = newCores;
        return this;
    }
    
    
    public CpuTopologyBuilder sockets(int newSockets) {
        sockets = BigInteger.valueOf((long) newSockets);
        return this;
    }
    
    public CpuTopologyBuilder sockets(Integer newSockets) {
        if (newSockets == null) {
            sockets = null;
        }
        else {
            sockets = BigInteger.valueOf(newSockets.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder sockets(long newSockets) {
        sockets = BigInteger.valueOf(newSockets);
        return this;
    }
    
    public CpuTopologyBuilder sockets(Long newSockets) {
        if (newSockets == null) {
            sockets = null;
        }
        else {
            sockets = BigInteger.valueOf(newSockets.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder sockets(BigInteger newSockets) {
        sockets = newSockets;
        return this;
    }
    
    
    public CpuTopologyBuilder threads(int newThreads) {
        threads = BigInteger.valueOf((long) newThreads);
        return this;
    }
    
    public CpuTopologyBuilder threads(Integer newThreads) {
        if (newThreads == null) {
            threads = null;
        }
        else {
            threads = BigInteger.valueOf(newThreads.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder threads(long newThreads) {
        threads = BigInteger.valueOf(newThreads);
        return this;
    }
    
    public CpuTopologyBuilder threads(Long newThreads) {
        if (newThreads == null) {
            threads = null;
        }
        else {
            threads = BigInteger.valueOf(newThreads.longValue());
        }
        return this;
    }
    
    public CpuTopologyBuilder threads(BigInteger newThreads) {
        threads = newThreads;
        return this;
    }
    
    
    public CpuTopology build() {
        CpuTopologyContainer container = new CpuTopologyContainer();
        container.cores(cores);
        container.sockets(sockets);
        container.threads(threads);
        return container;
    }
}
