/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ClusterFeatureContainer;
import org.ovirt.engine.sdk4.types.ClusterFeature;
import org.ovirt.engine.sdk4.types.ClusterLevel;

public class ClusterFeatureBuilder {
    private ClusterLevel clusterLevel;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public ClusterFeatureBuilder clusterLevel(ClusterLevel newClusterLevel) {
        clusterLevel = newClusterLevel;
        return this;
    }
    
    public ClusterFeatureBuilder clusterLevel(ClusterLevelBuilder newClusterLevel) {
        if (newClusterLevel == null) {
            clusterLevel = null;
        }
        else {
            clusterLevel = newClusterLevel.build();
        }
        return this;
    }
    
    
    public ClusterFeatureBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ClusterFeatureBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ClusterFeatureBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ClusterFeatureBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ClusterFeatureBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ClusterFeature build() {
        ClusterFeatureContainer container = new ClusterFeatureContainer();
        container.clusterLevel(clusterLevel);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
