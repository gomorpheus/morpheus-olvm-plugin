/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.CustomProperty;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkFilter;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.VnicPassThrough;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class VnicProfileContainer extends IdentifiedContainer implements VnicProfile {
    private List<CustomProperty> customProperties;
    private Boolean migratable;
    private VnicPassThrough passThrough;
    private Boolean portMirroring;
    private VnicProfile failover;
    private Network network;
    private NetworkFilter networkFilter;
    private List<Permission> permissions;
    private Qos qos;
    
    public List<CustomProperty> customProperties() {
        return makeUnmodifiableList(customProperties);
    }
    
    public void customProperties(List<CustomProperty> newCustomProperties) {
        customProperties = makeArrayList(newCustomProperties);
    }
    
    public boolean customPropertiesPresent() {
        return customProperties != null && !customProperties.isEmpty();
    }
    
    public boolean migratable() {
        return migratable;
    }
    
    public void migratable(boolean newMigratable) {
        migratable = Boolean.valueOf(newMigratable);
    }
    
    public void migratable(Boolean newMigratable) {
        migratable = newMigratable;
    }
    
    public boolean migratablePresent() {
        return migratable != null;
    }
    
    public VnicPassThrough passThrough() {
        return passThrough;
    }
    
    public void passThrough(VnicPassThrough newPassThrough) {
        passThrough = newPassThrough;
    }
    
    public boolean passThroughPresent() {
        return passThrough != null;
    }
    
    public boolean portMirroring() {
        return portMirroring;
    }
    
    public void portMirroring(boolean newPortMirroring) {
        portMirroring = Boolean.valueOf(newPortMirroring);
    }
    
    public void portMirroring(Boolean newPortMirroring) {
        portMirroring = newPortMirroring;
    }
    
    public boolean portMirroringPresent() {
        return portMirroring != null;
    }
    
    public VnicProfile failover() {
        return failover;
    }
    
    public void failover(VnicProfile newFailover) {
        failover = newFailover;
    }
    
    public boolean failoverPresent() {
        return failover != null;
    }
    
    public Network network() {
        return network;
    }
    
    public void network(Network newNetwork) {
        network = newNetwork;
    }
    
    public boolean networkPresent() {
        return network != null;
    }
    
    public NetworkFilter networkFilter() {
        return networkFilter;
    }
    
    public void networkFilter(NetworkFilter newNetworkFilter) {
        networkFilter = newNetworkFilter;
    }
    
    public boolean networkFilterPresent() {
        return networkFilter != null;
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public Qos qos() {
        return qos;
    }
    
    public void qos(Qos newQos) {
        qos = newQos;
    }
    
    public boolean qosPresent() {
        return qos != null;
    }
    
}
