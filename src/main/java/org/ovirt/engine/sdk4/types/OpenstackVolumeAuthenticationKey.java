/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.Date;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenstackVolumeAuthenticationKey extends Identified {
    Date creationDate();
    
    boolean creationDatePresent();
    
    OpenstackVolumeAuthenticationKeyUsageType usageType();
    
    boolean usageTypePresent();
    
    String uuid();
    
    boolean uuidPresent();
    
    String value();
    
    boolean valuePresent();
    
    OpenStackVolumeProvider openstackVolumeProvider();
    
    boolean openstackVolumeProviderPresent();
    
}
