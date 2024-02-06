/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenStackVolumeType extends Identified {
    List<Property> properties();
    
    boolean propertiesPresent();
    
    OpenStackVolumeProvider openstackVolumeProvider();
    
    boolean openstackVolumeProviderPresent();
    
}
