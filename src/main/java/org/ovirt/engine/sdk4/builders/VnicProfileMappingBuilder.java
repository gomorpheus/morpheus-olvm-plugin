/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.VnicProfileMappingContainer;
import org.ovirt.engine.sdk4.types.VnicProfile;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public class VnicProfileMappingBuilder {
    private String sourceNetworkName;
    private String sourceNetworkProfileName;
    private VnicProfile targetVnicProfile;
    
    public VnicProfileMappingBuilder sourceNetworkName(String newSourceNetworkName) {
        sourceNetworkName = newSourceNetworkName;
        return this;
    }
    
    
    public VnicProfileMappingBuilder sourceNetworkProfileName(String newSourceNetworkProfileName) {
        sourceNetworkProfileName = newSourceNetworkProfileName;
        return this;
    }
    
    
    public VnicProfileMappingBuilder targetVnicProfile(VnicProfile newTargetVnicProfile) {
        targetVnicProfile = newTargetVnicProfile;
        return this;
    }
    
    public VnicProfileMappingBuilder targetVnicProfile(VnicProfileBuilder newTargetVnicProfile) {
        if (newTargetVnicProfile == null) {
            targetVnicProfile = null;
        }
        else {
            targetVnicProfile = newTargetVnicProfile.build();
        }
        return this;
    }
    
    
    public VnicProfileMapping build() {
        VnicProfileMappingContainer container = new VnicProfileMappingContainer();
        container.sourceNetworkName(sourceNetworkName);
        container.sourceNetworkProfileName(sourceNetworkProfileName);
        container.targetVnicProfile(targetVnicProfile);
        return container;
    }
}
