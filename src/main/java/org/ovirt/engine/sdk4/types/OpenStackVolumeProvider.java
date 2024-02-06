/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenStackVolumeProvider extends OpenStackProvider {
    List<OpenstackVolumeAuthenticationKey> authenticationKeys();
    
    boolean authenticationKeysPresent();
    
    List<Certificate> certificates();
    
    boolean certificatesPresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    List<OpenStackVolumeType> volumeTypes();
    
    boolean volumeTypesPresent();
    
}
