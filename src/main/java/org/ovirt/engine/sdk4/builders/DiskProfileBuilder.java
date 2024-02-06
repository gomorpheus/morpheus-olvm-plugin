/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DiskProfileContainer;
import org.ovirt.engine.sdk4.types.DiskProfile;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class DiskProfileBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<Permission> permissions;
    private Qos qos;
    private StorageDomain storageDomain;
    
    public DiskProfileBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DiskProfileBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DiskProfileBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DiskProfileBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DiskProfileBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DiskProfileBuilder permissions(List<Permission> newPermissions) {
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
    
    public DiskProfileBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public DiskProfileBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public DiskProfileBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public DiskProfileBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public DiskProfileBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public DiskProfileBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public DiskProfile build() {
        DiskProfileContainer container = new DiskProfileContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.permissions(permissions);
        container.qos(qos);
        container.storageDomain(storageDomain);
        return container;
    }
}
