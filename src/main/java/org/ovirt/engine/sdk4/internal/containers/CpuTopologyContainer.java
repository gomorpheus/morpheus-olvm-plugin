/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.CpuTopology;

public class CpuTopologyContainer extends Container implements CpuTopology {
    private BigInteger cores;
    private BigInteger sockets;
    private BigInteger threads;
    
    public BigInteger cores() {
        return cores;
    }
    
    public Byte coresAsByte() {
        return asByte("CpuTopology", "cores", cores);
    }
    
    public Short coresAsShort() {
        return asShort("CpuTopology", "cores", cores);
    }
    
    public Integer coresAsInteger() {
        return asInteger("CpuTopology", "cores", cores);
    }
    
    public Long coresAsLong() {
        return asLong("CpuTopology", "cores", cores);
    }
    
    public void cores(BigInteger newCores) {
        cores = newCores;
    }
    
    public boolean coresPresent() {
        return cores != null;
    }
    
    public BigInteger sockets() {
        return sockets;
    }
    
    public Byte socketsAsByte() {
        return asByte("CpuTopology", "sockets", sockets);
    }
    
    public Short socketsAsShort() {
        return asShort("CpuTopology", "sockets", sockets);
    }
    
    public Integer socketsAsInteger() {
        return asInteger("CpuTopology", "sockets", sockets);
    }
    
    public Long socketsAsLong() {
        return asLong("CpuTopology", "sockets", sockets);
    }
    
    public void sockets(BigInteger newSockets) {
        sockets = newSockets;
    }
    
    public boolean socketsPresent() {
        return sockets != null;
    }
    
    public BigInteger threads() {
        return threads;
    }
    
    public Byte threadsAsByte() {
        return asByte("CpuTopology", "threads", threads);
    }
    
    public Short threadsAsShort() {
        return asShort("CpuTopology", "threads", threads);
    }
    
    public Integer threadsAsInteger() {
        return asInteger("CpuTopology", "threads", threads);
    }
    
    public Long threadsAsLong() {
        return asLong("CpuTopology", "threads", threads);
    }
    
    public void threads(BigInteger newThreads) {
        threads = newThreads;
    }
    
    public boolean threadsPresent() {
        return threads != null;
    }
    
}
