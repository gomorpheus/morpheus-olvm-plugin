/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.VirtualNumaNodeContainer;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NumaNodePin;
import org.ovirt.engine.sdk4.types.NumaTuneMode;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.VirtualNumaNode;
import org.ovirt.engine.sdk4.types.Vm;

public class VirtualNumaNodeBuilder {
    private String comment;
    private Cpu cpu;
    private String description;
    private Host host;
    private String href;
    private String id;
    private BigInteger index;
    private BigInteger memory;
    private String name;
    private String nodeDistance;
    private List<NumaNodePin> numaNodePins;
    private NumaTuneMode numaTuneMode;
    private List<Statistic> statistics;
    private Vm vm;
    
    public VirtualNumaNodeBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public VirtualNumaNodeBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public VirtualNumaNodeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public VirtualNumaNodeBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public VirtualNumaNodeBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder index(int newIndex) {
        index = BigInteger.valueOf((long) newIndex);
        return this;
    }
    
    public VirtualNumaNodeBuilder index(Integer newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder index(long newIndex) {
        index = BigInteger.valueOf(newIndex);
        return this;
    }
    
    public VirtualNumaNodeBuilder index(Long newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder index(BigInteger newIndex) {
        index = newIndex;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public VirtualNumaNodeBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public VirtualNumaNodeBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder nodeDistance(String newNodeDistance) {
        nodeDistance = newNodeDistance;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder numaNodePins(List<NumaNodePin> newNumaNodePins) {
        if (newNumaNodePins != null) {
            if (numaNodePins == null) {
                numaNodePins = new ArrayList<>(newNumaNodePins);
            }
            else {
                numaNodePins.addAll(newNumaNodePins);
            }
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder numaNodePins(NumaNodePin... newNumaNodePins) {
        if (newNumaNodePins != null) {
            if (numaNodePins == null) {
                numaNodePins = new ArrayList<>(newNumaNodePins.length);
            }
            Collections.addAll(numaNodePins, newNumaNodePins);
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder numaNodePins(NumaNodePinBuilder... newNumaNodePins) {
        if (newNumaNodePins != null) {
            if (numaNodePins == null) {
                numaNodePins = new ArrayList<>(newNumaNodePins.length);
            }
            for (NumaNodePinBuilder builder : newNumaNodePins) {
                numaNodePins.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VirtualNumaNodeBuilder numaTuneMode(NumaTuneMode newNumaTuneMode) {
        numaTuneMode = newNumaTuneMode;
        return this;
    }
    
    
    public VirtualNumaNodeBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public VirtualNumaNodeBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VirtualNumaNodeBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public VirtualNumaNodeBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public VirtualNumaNode build() {
        VirtualNumaNodeContainer container = new VirtualNumaNodeContainer();
        container.comment(comment);
        container.cpu(cpu);
        container.description(description);
        container.host(host);
        container.href(href);
        container.id(id);
        container.index(index);
        container.memory(memory);
        container.name(name);
        container.nodeDistance(nodeDistance);
        container.numaNodePins(numaNodePins);
        container.numaTuneMode(numaTuneMode);
        container.statistics(statistics);
        container.vm(vm);
        return container;
    }
}
