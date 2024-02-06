/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.Statistic;

public class NumaNodeContainer extends IdentifiedContainer implements NumaNode {
    private Cpu cpu;
    private BigInteger index;
    private BigInteger memory;
    private String nodeDistance;
    private Host host;
    private List<Statistic> statistics;
    
    public Cpu cpu() {
        return cpu;
    }
    
    public void cpu(Cpu newCpu) {
        cpu = newCpu;
    }
    
    public boolean cpuPresent() {
        return cpu != null;
    }
    
    public BigInteger index() {
        return index;
    }
    
    public Byte indexAsByte() {
        return asByte("NumaNode", "index", index);
    }
    
    public Short indexAsShort() {
        return asShort("NumaNode", "index", index);
    }
    
    public Integer indexAsInteger() {
        return asInteger("NumaNode", "index", index);
    }
    
    public Long indexAsLong() {
        return asLong("NumaNode", "index", index);
    }
    
    public void index(BigInteger newIndex) {
        index = newIndex;
    }
    
    public boolean indexPresent() {
        return index != null;
    }
    
    public BigInteger memory() {
        return memory;
    }
    
    public Byte memoryAsByte() {
        return asByte("NumaNode", "memory", memory);
    }
    
    public Short memoryAsShort() {
        return asShort("NumaNode", "memory", memory);
    }
    
    public Integer memoryAsInteger() {
        return asInteger("NumaNode", "memory", memory);
    }
    
    public Long memoryAsLong() {
        return asLong("NumaNode", "memory", memory);
    }
    
    public void memory(BigInteger newMemory) {
        memory = newMemory;
    }
    
    public boolean memoryPresent() {
        return memory != null;
    }
    
    public String nodeDistance() {
        return nodeDistance;
    }
    
    public void nodeDistance(String newNodeDistance) {
        nodeDistance = newNodeDistance;
    }
    
    public boolean nodeDistancePresent() {
        return nodeDistance != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
}
