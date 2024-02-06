/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.PermissionContainer;
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

public class PermissionBuilder {
    private Cluster cluster;
    private String comment;
    private DataCenter dataCenter;
    private String description;
    private Disk disk;
    private Group group;
    private Host host;
    private String href;
    private String id;
    private String name;
    private Role role;
    private StorageDomain storageDomain;
    private Template template;
    private User user;
    private Vm vm;
    private VmPool vmPool;
    
    public PermissionBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public PermissionBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public PermissionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public PermissionBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public PermissionBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public PermissionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public PermissionBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public PermissionBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public PermissionBuilder group(Group newGroup) {
        group = newGroup;
        return this;
    }
    
    public PermissionBuilder group(GroupBuilder newGroup) {
        if (newGroup == null) {
            group = null;
        }
        else {
            group = newGroup.build();
        }
        return this;
    }
    
    
    public PermissionBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public PermissionBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public PermissionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public PermissionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public PermissionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public PermissionBuilder role(Role newRole) {
        role = newRole;
        return this;
    }
    
    public PermissionBuilder role(RoleBuilder newRole) {
        if (newRole == null) {
            role = null;
        }
        else {
            role = newRole.build();
        }
        return this;
    }
    
    
    public PermissionBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public PermissionBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public PermissionBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public PermissionBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public PermissionBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public PermissionBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public PermissionBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public PermissionBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public PermissionBuilder vmPool(VmPool newVmPool) {
        vmPool = newVmPool;
        return this;
    }
    
    public PermissionBuilder vmPool(VmPoolBuilder newVmPool) {
        if (newVmPool == null) {
            vmPool = null;
        }
        else {
            vmPool = newVmPool.build();
        }
        return this;
    }
    
    
    public Permission build() {
        PermissionContainer container = new PermissionContainer();
        container.cluster(cluster);
        container.comment(comment);
        container.dataCenter(dataCenter);
        container.description(description);
        container.disk(disk);
        container.group(group);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        container.role(role);
        container.storageDomain(storageDomain);
        container.template(template);
        container.user(user);
        container.vm(vm);
        container.vmPool(vmPool);
        return container;
    }
}
