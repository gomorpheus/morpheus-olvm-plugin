/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.EntityProfileDetail;
import org.ovirt.engine.sdk4.types.ProfileDetail;

public class EntityProfileDetailContainer extends Container implements EntityProfileDetail {
    private List<ProfileDetail> profileDetails;
    
    public List<ProfileDetail> profileDetails() {
        return makeUnmodifiableList(profileDetails);
    }
    
    public void profileDetails(List<ProfileDetail> newProfileDetails) {
        profileDetails = makeArrayList(newProfileDetails);
    }
    
    public boolean profileDetailsPresent() {
        return profileDetails != null && !profileDetails.isEmpty();
    }
    
}
