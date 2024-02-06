/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Role;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPool;

public class PermissionContainer extends IdentifiedContainer implements Permission {
    private Cluster cluster;
    private DataCenter dataCenter;
    private Disk disk;
    private Group group;
    private Host host;
    private Role role;
    private StorageDomain storageDomain;
    private Template template;
    private User user;
    private Vm vm;
    private VmPool vmPool;
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
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
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public Group group() {
        return group;
    }
    
    public void group(Group newGroup) {
        group = newGroup;
    }
    
    public boolean groupPresent() {
        return group != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public Role role() {
        return role;
    }
    
    public void role(Role newRole) {
        role = newRole;
    }
    
    public boolean rolePresent() {
        return role != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
    }
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
    public VmPool vmPool() {
        return vmPool;
    }
    
    public void vmPool(VmPool newVmPool) {
        vmPool = newVmPool;
    }
    
    public boolean vmPoolPresent() {
        return vmPool != null;
    }
    
}
