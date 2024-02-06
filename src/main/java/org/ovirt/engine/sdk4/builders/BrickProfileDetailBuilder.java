/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.BrickProfileDetailContainer;
import org.ovirt.engine.sdk4.types.BrickProfileDetail;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.ProfileDetail;

public class BrickProfileDetailBuilder {
    private GlusterBrick brick;
    private List<ProfileDetail> profileDetails;
    
    public BrickProfileDetailBuilder brick(GlusterBrick newBrick) {
        brick = newBrick;
        return this;
    }
    
    public BrickProfileDetailBuilder brick(GlusterBrickBuilder newBrick) {
        if (newBrick == null) {
            brick = null;
        }
        else {
            brick = newBrick.build();
        }
        return this;
    }
    
    
    public BrickProfileDetailBuilder profileDetails(List<ProfileDetail> newProfileDetails) {
        if (newProfileDetails != null) {
            if (profileDetails == null) {
                profileDetails = new ArrayList<>(newProfileDetails);
            }
            else {
                profileDetails.addAll(newProfileDetails);
            }
        }
        return this;
    }
    
    public BrickProfileDetailBuilder profileDetails(ProfileDetail... newProfileDetails) {
        if (newProfileDetails != null) {
            if (profileDetails == null) {
                profileDetails = new ArrayList<>(newProfileDetails.length);
            }
            Collections.addAll(profileDetails, newProfileDetails);
        }
        return this;
    }
    
    public BrickProfileDetailBuilder profileDetails(ProfileDetailBuilder... newProfileDetails) {
        if (newProfileDetails != null) {
            if (profileDetails == null) {
                profileDetails = new ArrayList<>(newProfileDetails.length);
            }
            for (ProfileDetailBuilder builder : newProfileDetails) {
                profileDetails.add(builder.build());
            }
        }
        return this;
    }
    
    
    public BrickProfileDetail build() {
        BrickProfileDetailContainer container = new BrickProfileDetailContainer();
        container.brick(brick);
        container.profileDetails(profileDetails);
        return container;
    }
}
