/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Describes the capabilities supported by a specific cluster level.
 */
public interface ClusterLevel extends Identified {
    List<CpuType> cpuTypes();
    
    boolean cpuTypesPresent();
    
    List<Permit> permits();
    
    boolean permitsPresent();
    
    List<ClusterFeature> clusterFeatures();
    
    boolean clusterFeaturesPresent();
    
}
