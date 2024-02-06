/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.VnicProfile;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public class VnicProfileMappingContainer extends Container implements VnicProfileMapping {
    private String sourceNetworkName;
    private String sourceNetworkProfileName;
    private VnicProfile targetVnicProfile;
    
    public String sourceNetworkName() {
        return sourceNetworkName;
    }
    
    public void sourceNetworkName(String newSourceNetworkName) {
        sourceNetworkName = newSourceNetworkName;
    }
    
    public boolean sourceNetworkNamePresent() {
        return sourceNetworkName != null;
    }
    
    public String sourceNetworkProfileName() {
        return sourceNetworkProfileName;
    }
    
    public void sourceNetworkProfileName(String newSourceNetworkProfileName) {
        sourceNetworkProfileName = newSourceNetworkProfileName;
    }
    
    public boolean sourceNetworkProfileNamePresent() {
        return sourceNetworkProfileName != null;
    }
    
    public VnicProfile targetVnicProfile() {
        return targetVnicProfile;
    }
    
    public void targetVnicProfile(VnicProfile newTargetVnicProfile) {
        targetVnicProfile = newTargetVnicProfile;
    }
    
    public boolean targetVnicProfilePresent() {
        return targetVnicProfile != null;
    }
    
}
