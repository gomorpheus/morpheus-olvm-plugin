/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.ClusterFeature;
import org.ovirt.engine.sdk4.types.ClusterLevel;
import org.ovirt.engine.sdk4.types.CpuType;
import org.ovirt.engine.sdk4.types.Permit;

public class ClusterLevelContainer extends IdentifiedContainer implements ClusterLevel {
    private List<CpuType> cpuTypes;
    private List<Permit> permits;
    private List<ClusterFeature> clusterFeatures;
    
    public List<CpuType> cpuTypes() {
        return makeUnmodifiableList(cpuTypes);
    }
    
    public void cpuTypes(List<CpuType> newCpuTypes) {
        cpuTypes = makeArrayList(newCpuTypes);
    }
    
    public boolean cpuTypesPresent() {
        return cpuTypes != null && !cpuTypes.isEmpty();
    }
    
    public List<Permit> permits() {
        return makeUnmodifiableList(permits);
    }
    
    public void permits(List<Permit> newPermits) {
        permits = makeArrayList(newPermits);
    }
    
    public boolean permitsPresent() {
        return permits != null && !permits.isEmpty();
    }
    
    public List<ClusterFeature> clusterFeatures() {
        return makeUnmodifiableList(clusterFeatures);
    }
    
    public void clusterFeatures(List<ClusterFeature> newClusterFeatures) {
        clusterFeatures = makeArrayList(newClusterFeatures);
    }
    
    public boolean clusterFeaturesPresent() {
        return clusterFeatures != null && !clusterFeatures.isEmpty();
    }
    
}
