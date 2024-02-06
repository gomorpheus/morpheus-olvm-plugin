/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackVolumeTypeContainer extends IdentifiedContainer implements OpenStackVolumeType {
    private List<Property> properties;
    private OpenStackVolumeProvider openstackVolumeProvider;
    
    public List<Property> properties() {
        return makeUnmodifiableList(properties);
    }
    
    public void properties(List<Property> newProperties) {
        properties = makeArrayList(newProperties);
    }
    
    public boolean propertiesPresent() {
        return properties != null && !properties.isEmpty();
    }
    
    public OpenStackVolumeProvider openstackVolumeProvider() {
        return openstackVolumeProvider;
    }
    
    public void openstackVolumeProvider(OpenStackVolumeProvider newOpenstackVolumeProvider) {
        openstackVolumeProvider = newOpenstackVolumeProvider;
    }
    
    public boolean openstackVolumeProviderPresent() {
        return openstackVolumeProvider != null;
    }
    
}
