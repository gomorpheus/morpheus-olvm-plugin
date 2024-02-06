/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.ClusterLevelContainer;
import org.ovirt.engine.sdk4.types.ClusterFeature;
import org.ovirt.engine.sdk4.types.ClusterLevel;
import org.ovirt.engine.sdk4.types.CpuType;
import org.ovirt.engine.sdk4.types.Permit;

public class ClusterLevelBuilder {
    private List<ClusterFeature> clusterFeatures;
    private String comment;
    private List<CpuType> cpuTypes;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<Permit> permits;
    
    public ClusterLevelBuilder clusterFeatures(List<ClusterFeature> newClusterFeatures) {
        if (newClusterFeatures != null) {
            if (clusterFeatures == null) {
                clusterFeatures = new ArrayList<>(newClusterFeatures);
            }
            else {
                clusterFeatures.addAll(newClusterFeatures);
            }
        }
        return this;
    }
    
    public ClusterLevelBuilder clusterFeatures(ClusterFeature... newClusterFeatures) {
        if (newClusterFeatures != null) {
            if (clusterFeatures == null) {
                clusterFeatures = new ArrayList<>(newClusterFeatures.length);
            }
            Collections.addAll(clusterFeatures, newClusterFeatures);
        }
        return this;
    }
    
    public ClusterLevelBuilder clusterFeatures(ClusterFeatureBuilder... newClusterFeatures) {
        if (newClusterFeatures != null) {
            if (clusterFeatures == null) {
                clusterFeatures = new ArrayList<>(newClusterFeatures.length);
            }
            for (ClusterFeatureBuilder builder : newClusterFeatures) {
                clusterFeatures.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterLevelBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ClusterLevelBuilder cpuTypes(List<CpuType> newCpuTypes) {
        if (newCpuTypes != null) {
            if (cpuTypes == null) {
                cpuTypes = new ArrayList<>(newCpuTypes);
            }
            else {
                cpuTypes.addAll(newCpuTypes);
            }
        }
        return this;
    }
    
    public ClusterLevelBuilder cpuTypes(CpuType... newCpuTypes) {
        if (newCpuTypes != null) {
            if (cpuTypes == null) {
                cpuTypes = new ArrayList<>(newCpuTypes.length);
            }
            Collections.addAll(cpuTypes, newCpuTypes);
        }
        return this;
    }
    
    public ClusterLevelBuilder cpuTypes(CpuTypeBuilder... newCpuTypes) {
        if (newCpuTypes != null) {
            if (cpuTypes == null) {
                cpuTypes = new ArrayList<>(newCpuTypes.length);
            }
            for (CpuTypeBuilder builder : newCpuTypes) {
                cpuTypes.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterLevelBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ClusterLevelBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ClusterLevelBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ClusterLevelBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ClusterLevelBuilder permits(List<Permit> newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits);
            }
            else {
                permits.addAll(newPermits);
            }
        }
        return this;
    }
    
    public ClusterLevelBuilder permits(Permit... newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits.length);
            }
            Collections.addAll(permits, newPermits);
        }
        return this;
    }
    
    public ClusterLevelBuilder permits(PermitBuilder... newPermits) {
        if (newPermits != null) {
            if (permits == null) {
                permits = new ArrayList<>(newPermits.length);
            }
            for (PermitBuilder builder : newPermits) {
                permits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ClusterLevel build() {
        ClusterLevelContainer container = new ClusterLevelContainer();
        container.clusterFeatures(clusterFeatures);
        container.comment(comment);
        container.cpuTypes(cpuTypes);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.permits(permits);
        return container;
    }
}
