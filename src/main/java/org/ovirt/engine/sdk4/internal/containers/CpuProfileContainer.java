/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;

public class CpuProfileContainer extends IdentifiedContainer implements CpuProfile {
    private Cluster cluster;
    private List<Permission> permissions;
    private Qos qos;
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
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
