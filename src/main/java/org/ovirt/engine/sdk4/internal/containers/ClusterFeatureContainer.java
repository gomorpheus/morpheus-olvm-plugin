/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.ClusterFeature;
import org.ovirt.engine.sdk4.types.ClusterLevel;

public class ClusterFeatureContainer extends IdentifiedContainer implements ClusterFeature {
    private ClusterLevel clusterLevel;
    
    public ClusterLevel clusterLevel() {
        return clusterLevel;
    }
    
    public void clusterLevel(ClusterLevel newClusterLevel) {
        clusterLevel = newClusterLevel;
    }
    
    public boolean clusterLevelPresent() {
        return clusterLevel != null;
    }
    
}
