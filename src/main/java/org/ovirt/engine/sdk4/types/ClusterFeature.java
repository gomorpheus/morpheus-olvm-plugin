/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type represents an additional feature that is available at a cluster level.
 */
public interface ClusterFeature extends Identified {
    ClusterLevel clusterLevel();
    
    boolean clusterLevelPresent();
    
}
