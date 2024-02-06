/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.NfsProfileDetailContainer;
import org.ovirt.engine.sdk4.types.NfsProfileDetail;
import org.ovirt.engine.sdk4.types.ProfileDetail;

public class NfsProfileDetailBuilder {
    private String nfsServerIp;
    private List<ProfileDetail> profileDetails;
    
    public NfsProfileDetailBuilder nfsServerIp(String newNfsServerIp) {
        nfsServerIp = newNfsServerIp;
        return this;
    }
    
    
    public NfsProfileDetailBuilder profileDetails(List<ProfileDetail> newProfileDetails) {
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
    
    public NfsProfileDetailBuilder profileDetails(ProfileDetail... newProfileDetails) {
        if (newProfileDetails != null) {
            if (profileDetails == null) {
                profileDetails = new ArrayList<>(newProfileDetails.length);
            }
            Collections.addAll(profileDetails, newProfileDetails);
        }
        return this;
    }
    
    public NfsProfileDetailBuilder profileDetails(ProfileDetailBuilder... newProfileDetails) {
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
    
    
    public NfsProfileDetail build() {
        NfsProfileDetailContainer container = new NfsProfileDetailContainer();
        container.nfsServerIp(nfsServerIp);
        container.profileDetails(profileDetails);
        return container;
    }
}
