/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.EntityProfileDetailContainer;
import org.ovirt.engine.sdk4.types.EntityProfileDetail;
import org.ovirt.engine.sdk4.types.ProfileDetail;

public class EntityProfileDetailBuilder {
    private List<ProfileDetail> profileDetails;
    
    public EntityProfileDetailBuilder profileDetails(List<ProfileDetail> newProfileDetails) {
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
    
    public EntityProfileDetailBuilder profileDetails(ProfileDetail... newProfileDetails) {
        if (newProfileDetails != null) {
            if (profileDetails == null) {
                profileDetails = new ArrayList<>(newProfileDetails.length);
            }
            Collections.addAll(profileDetails, newProfileDetails);
        }
        return this;
    }
    
    public EntityProfileDetailBuilder profileDetails(ProfileDetailBuilder... newProfileDetails) {
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
    
    
    public EntityProfileDetail build() {
        EntityProfileDetailContainer container = new EntityProfileDetailContainer();
        container.profileDetails(profileDetails);
        return container;
    }
}
