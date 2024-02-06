/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;

public class OpenStackVolumeProviderContainer extends OpenStackProviderContainer implements OpenStackVolumeProvider {
    private List<OpenstackVolumeAuthenticationKey> authenticationKeys;
    private List<Certificate> certificates;
    private DataCenter dataCenter;
    private List<OpenStackVolumeType> volumeTypes;
    
    public List<OpenstackVolumeAuthenticationKey> authenticationKeys() {
        return makeUnmodifiableList(authenticationKeys);
    }
    
    public void authenticationKeys(List<OpenstackVolumeAuthenticationKey> newAuthenticationKeys) {
        authenticationKeys = makeArrayList(newAuthenticationKeys);
    }
    
    public boolean authenticationKeysPresent() {
        return authenticationKeys != null && !authenticationKeys.isEmpty();
    }
    
    public List<Certificate> certificates() {
        return makeUnmodifiableList(certificates);
    }
    
    public void certificates(List<Certificate> newCertificates) {
        certificates = makeArrayList(newCertificates);
    }
    
    public boolean certificatesPresent() {
        return certificates != null && !certificates.isEmpty();
    }
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public List<OpenStackVolumeType> volumeTypes() {
        return makeUnmodifiableList(volumeTypes);
    }
    
    public void volumeTypes(List<OpenStackVolumeType> newVolumeTypes) {
        volumeTypes = makeArrayList(newVolumeTypes);
    }
    
    public boolean volumeTypesPresent() {
        return volumeTypes != null && !volumeTypes.isEmpty();
    }
    
}
