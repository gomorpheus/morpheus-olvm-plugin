/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.CpuProfileContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;

public class CpuProfileBuilder {
    private Cluster cluster;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<Permission> permissions;
    private Qos qos;
    
    public CpuProfileBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public CpuProfileBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public CpuProfileBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public CpuProfileBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public CpuProfileBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public CpuProfileBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public CpuProfileBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CpuProfileBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public CpuProfileBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public CpuProfileBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CpuProfileBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public CpuProfileBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public CpuProfile build() {
        CpuProfileContainer container = new CpuProfileContainer();
        container.cluster(cluster);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.permissions(permissions);
        container.qos(qos);
        return container;
    }
}
