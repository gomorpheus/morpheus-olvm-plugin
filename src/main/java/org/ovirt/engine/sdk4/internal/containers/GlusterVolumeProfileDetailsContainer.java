/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.BrickProfileDetail;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;
import org.ovirt.engine.sdk4.types.NfsProfileDetail;

public class GlusterVolumeProfileDetailsContainer extends IdentifiedContainer implements GlusterVolumeProfileDetails {
    private List<BrickProfileDetail> brickProfileDetails;
    private List<NfsProfileDetail> nfsProfileDetails;
    
    public List<BrickProfileDetail> brickProfileDetails() {
        return makeUnmodifiableList(brickProfileDetails);
    }
    
    public void brickProfileDetails(List<BrickProfileDetail> newBrickProfileDetails) {
        brickProfileDetails = makeArrayList(newBrickProfileDetails);
    }
    
    public boolean brickProfileDetailsPresent() {
        return brickProfileDetails != null && !brickProfileDetails.isEmpty();
    }
    
    public List<NfsProfileDetail> nfsProfileDetails() {
        return makeUnmodifiableList(nfsProfileDetails);
    }
    
    public void nfsProfileDetails(List<NfsProfileDetail> newNfsProfileDetails) {
        nfsProfileDetails = makeArrayList(newNfsProfileDetails);
    }
    
    public boolean nfsProfileDetailsPresent() {
        return nfsProfileDetails != null && !nfsProfileDetails.isEmpty();
    }
    
}
