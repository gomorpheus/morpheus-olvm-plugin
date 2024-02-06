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
import org.ovirt.engine.sdk4.internal.containers.NumaNodeContainer;
import org.ovirt.engine.sdk4.types.Cpu;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.Statistic;

public class NumaNodeBuilder {
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
    private List<Statistic> statistics;
    
    public NumaNodeBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NumaNodeBuilder cpu(Cpu newCpu) {
        cpu = newCpu;
        return this;
    }
    
    public NumaNodeBuilder cpu(CpuBuilder newCpu) {
        if (newCpu == null) {
            cpu = null;
        }
        else {
            cpu = newCpu.build();
        }
        return this;
    }
    
    
    public NumaNodeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NumaNodeBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public NumaNodeBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public NumaNodeBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NumaNodeBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NumaNodeBuilder index(int newIndex) {
        index = BigInteger.valueOf((long) newIndex);
        return this;
    }
    
    public NumaNodeBuilder index(Integer newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public NumaNodeBuilder index(long newIndex) {
        index = BigInteger.valueOf(newIndex);
        return this;
    }
    
    public NumaNodeBuilder index(Long newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public NumaNodeBuilder index(BigInteger newIndex) {
        index = newIndex;
        return this;
    }
    
    
    public NumaNodeBuilder memory(int newMemory) {
        memory = BigInteger.valueOf((long) newMemory);
        return this;
    }
    
    public NumaNodeBuilder memory(Integer newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public NumaNodeBuilder memory(long newMemory) {
        memory = BigInteger.valueOf(newMemory);
        return this;
    }
    
    public NumaNodeBuilder memory(Long newMemory) {
        if (newMemory == null) {
            memory = null;
        }
        else {
            memory = BigInteger.valueOf(newMemory.longValue());
        }
        return this;
    }
    
    public NumaNodeBuilder memory(BigInteger newMemory) {
        memory = newMemory;
        return this;
    }
    
    
    public NumaNodeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NumaNodeBuilder nodeDistance(String newNodeDistance) {
        nodeDistance = newNodeDistance;
        return this;
    }
    
    
    public NumaNodeBuilder statistics(List<Statistic> newStatistics) {
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
    
    public NumaNodeBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public NumaNodeBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public NumaNode build() {
        NumaNodeContainer container = new NumaNodeContainer();
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
        container.statistics(statistics);
        return container;
    }
}
