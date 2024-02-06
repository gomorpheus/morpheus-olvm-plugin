/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.VnicProfileContainer;
import org.ovirt.engine.sdk4.types.CustomProperty;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkFilter;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.VnicPassThrough;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class VnicProfileBuilder {
    private String comment;
    private List<CustomProperty> customProperties;
    private String description;
    private VnicProfile failover;
    private String href;
    private String id;
    private Boolean migratable;
    private String name;
    private Network network;
    private NetworkFilter networkFilter;
    private VnicPassThrough passThrough;
    private List<Permission> permissions;
    private Boolean portMirroring;
    private Qos qos;
    
    public VnicProfileBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VnicProfileBuilder customProperties(List<CustomProperty> newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties);
            }
            else {
                customProperties.addAll(newCustomProperties);
            }
        }
        return this;
    }
    
    public VnicProfileBuilder customProperties(CustomProperty... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            Collections.addAll(customProperties, newCustomProperties);
        }
        return this;
    }
    
    public VnicProfileBuilder customProperties(CustomPropertyBuilder... newCustomProperties) {
        if (newCustomProperties != null) {
            if (customProperties == null) {
                customProperties = new ArrayList<>(newCustomProperties.length);
            }
            for (CustomPropertyBuilder builder : newCustomProperties) {
                customProperties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VnicProfileBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VnicProfileBuilder failover(VnicProfile newFailover) {
        failover = newFailover;
        return this;
    }
    
    public VnicProfileBuilder failover(VnicProfileBuilder newFailover) {
        if (newFailover == null) {
            failover = null;
        }
        else {
            failover = newFailover.build();
        }
        return this;
    }
    
    
    public VnicProfileBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VnicProfileBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VnicProfileBuilder migratable(boolean newMigratable) {
        migratable = Boolean.valueOf(newMigratable);
        return this;
    }
    
    public VnicProfileBuilder migratable(Boolean newMigratable) {
        migratable = newMigratable;
        return this;
    }
    
    
    public VnicProfileBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VnicProfileBuilder network(Network newNetwork) {
        network = newNetwork;
        return this;
    }
    
    public VnicProfileBuilder network(NetworkBuilder newNetwork) {
        if (newNetwork == null) {
            network = null;
        }
        else {
            network = newNetwork.build();
        }
        return this;
    }
    
    
    public VnicProfileBuilder networkFilter(NetworkFilter newNetworkFilter) {
        networkFilter = newNetworkFilter;
        return this;
    }
    
    public VnicProfileBuilder networkFilter(NetworkFilterBuilder newNetworkFilter) {
        if (newNetworkFilter == null) {
            networkFilter = null;
        }
        else {
            networkFilter = newNetworkFilter.build();
        }
        return this;
    }
    
    
    public VnicProfileBuilder passThrough(VnicPassThrough newPassThrough) {
        passThrough = newPassThrough;
        return this;
    }
    
    public VnicProfileBuilder passThrough(VnicPassThroughBuilder newPassThrough) {
        if (newPassThrough == null) {
            passThrough = null;
        }
        else {
            passThrough = newPassThrough.build();
        }
        return this;
    }
    
    
    public VnicProfileBuilder permissions(List<Permission> newPermissions) {
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
    
    public VnicProfileBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public VnicProfileBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public VnicProfileBuilder portMirroring(boolean newPortMirroring) {
        portMirroring = Boolean.valueOf(newPortMirroring);
        return this;
    }
    
    public VnicProfileBuilder portMirroring(Boolean newPortMirroring) {
        portMirroring = newPortMirroring;
        return this;
    }
    
    
    public VnicProfileBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public VnicProfileBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public VnicProfile build() {
        VnicProfileContainer container = new VnicProfileContainer();
        container.comment(comment);
        container.customProperties(customProperties);
        container.description(description);
        container.failover(failover);
        container.href(href);
        container.id(id);
        container.migratable(migratable);
        container.name(name);
        container.network(network);
        container.networkFilter(networkFilter);
        container.passThrough(passThrough);
        container.permissions(permissions);
        container.portMirroring(portMirroring);
        container.qos(qos);
        return container;
    }
}
