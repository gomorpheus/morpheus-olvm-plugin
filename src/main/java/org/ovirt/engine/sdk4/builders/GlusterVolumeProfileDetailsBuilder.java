/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GlusterVolumeProfileDetailsContainer;
import org.ovirt.engine.sdk4.types.BrickProfileDetail;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;
import org.ovirt.engine.sdk4.types.NfsProfileDetail;

public class GlusterVolumeProfileDetailsBuilder {
    private List<BrickProfileDetail> brickProfileDetails;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<NfsProfileDetail> nfsProfileDetails;
    
    public GlusterVolumeProfileDetailsBuilder brickProfileDetails(List<BrickProfileDetail> newBrickProfileDetails) {
        if (newBrickProfileDetails != null) {
            if (brickProfileDetails == null) {
                brickProfileDetails = new ArrayList<>(newBrickProfileDetails);
            }
            else {
                brickProfileDetails.addAll(newBrickProfileDetails);
            }
        }
        return this;
    }
    
    public GlusterVolumeProfileDetailsBuilder brickProfileDetails(BrickProfileDetail... newBrickProfileDetails) {
        if (newBrickProfileDetails != null) {
            if (brickProfileDetails == null) {
                brickProfileDetails = new ArrayList<>(newBrickProfileDetails.length);
            }
            Collections.addAll(brickProfileDetails, newBrickProfileDetails);
        }
        return this;
    }
    
    public GlusterVolumeProfileDetailsBuilder brickProfileDetails(BrickProfileDetailBuilder... newBrickProfileDetails) {
        if (newBrickProfileDetails != null) {
            if (brickProfileDetails == null) {
                brickProfileDetails = new ArrayList<>(newBrickProfileDetails.length);
            }
            for (BrickProfileDetailBuilder builder : newBrickProfileDetails) {
                brickProfileDetails.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterVolumeProfileDetailsBuilder nfsProfileDetails(List<NfsProfileDetail> newNfsProfileDetails) {
        if (newNfsProfileDetails != null) {
            if (nfsProfileDetails == null) {
                nfsProfileDetails = new ArrayList<>(newNfsProfileDetails);
            }
            else {
                nfsProfileDetails.addAll(newNfsProfileDetails);
            }
        }
        return this;
    }
    
    public GlusterVolumeProfileDetailsBuilder nfsProfileDetails(NfsProfileDetail... newNfsProfileDetails) {
        if (newNfsProfileDetails != null) {
            if (nfsProfileDetails == null) {
                nfsProfileDetails = new ArrayList<>(newNfsProfileDetails.length);
            }
            Collections.addAll(nfsProfileDetails, newNfsProfileDetails);
        }
        return this;
    }
    
    public GlusterVolumeProfileDetailsBuilder nfsProfileDetails(NfsProfileDetailBuilder... newNfsProfileDetails) {
        if (newNfsProfileDetails != null) {
            if (nfsProfileDetails == null) {
                nfsProfileDetails = new ArrayList<>(newNfsProfileDetails.length);
            }
            for (NfsProfileDetailBuilder builder : newNfsProfileDetails) {
                nfsProfileDetails.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterVolumeProfileDetails build() {
        GlusterVolumeProfileDetailsContainer container = new GlusterVolumeProfileDetailsContainer();
        container.brickProfileDetails(brickProfileDetails);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.nfsProfileDetails(nfsProfileDetails);
        return container;
    }
}
