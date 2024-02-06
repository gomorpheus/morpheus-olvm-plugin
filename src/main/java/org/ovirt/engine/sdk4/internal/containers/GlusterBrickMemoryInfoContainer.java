/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.GlusterBrickMemoryInfo;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class GlusterBrickMemoryInfoContainer extends Container implements GlusterBrickMemoryInfo {
    private List<GlusterMemoryPool> memoryPools;
    
    public List<GlusterMemoryPool> memoryPools() {
        return makeUnmodifiableList(memoryPools);
    }
    
    public void memoryPools(List<GlusterMemoryPool> newMemoryPools) {
        memoryPools = makeArrayList(newMemoryPools);
    }
    
    public boolean memoryPoolsPresent() {
        return memoryPools != null && !memoryPools.isEmpty();
    }
    
}
