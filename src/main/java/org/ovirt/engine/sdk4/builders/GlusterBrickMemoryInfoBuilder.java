/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GlusterBrickMemoryInfoContainer;
import org.ovirt.engine.sdk4.types.GlusterBrickMemoryInfo;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class GlusterBrickMemoryInfoBuilder {
    private List<GlusterMemoryPool> memoryPools;
    
    public GlusterBrickMemoryInfoBuilder memoryPools(List<GlusterMemoryPool> newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools);
            }
            else {
                memoryPools.addAll(newMemoryPools);
            }
        }
        return this;
    }
    
    public GlusterBrickMemoryInfoBuilder memoryPools(GlusterMemoryPool... newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools.length);
            }
            Collections.addAll(memoryPools, newMemoryPools);
        }
        return this;
    }
    
    public GlusterBrickMemoryInfoBuilder memoryPools(GlusterMemoryPoolBuilder... newMemoryPools) {
        if (newMemoryPools != null) {
            if (memoryPools == null) {
                memoryPools = new ArrayList<>(newMemoryPools.length);
            }
            for (GlusterMemoryPoolBuilder builder : newMemoryPools) {
                memoryPools.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterBrickMemoryInfo build() {
        GlusterBrickMemoryInfoContainer container = new GlusterBrickMemoryInfoContainer();
        container.memoryPools(memoryPools);
        return container;
    }
}
