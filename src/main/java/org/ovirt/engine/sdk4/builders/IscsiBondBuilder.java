/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.IscsiBondContainer;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.IscsiBond;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.StorageConnection;

public class IscsiBondBuilder {
    private String comment;
    private DataCenter dataCenter;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<Network> networks;
    private List<StorageConnection> storageConnections;
    
    public IscsiBondBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public IscsiBondBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public IscsiBondBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public IscsiBondBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public IscsiBondBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public IscsiBondBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public IscsiBondBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public IscsiBondBuilder networks(List<Network> newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks);
            }
            else {
                networks.addAll(newNetworks);
            }
        }
        return this;
    }
    
    public IscsiBondBuilder networks(Network... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            Collections.addAll(networks, newNetworks);
        }
        return this;
    }
    
    public IscsiBondBuilder networks(NetworkBuilder... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            for (NetworkBuilder builder : newNetworks) {
                networks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public IscsiBondBuilder storageConnections(List<StorageConnection> newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections);
            }
            else {
                storageConnections.addAll(newStorageConnections);
            }
        }
        return this;
    }
    
    public IscsiBondBuilder storageConnections(StorageConnection... newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections.length);
            }
            Collections.addAll(storageConnections, newStorageConnections);
        }
        return this;
    }
    
    public IscsiBondBuilder storageConnections(StorageConnectionBuilder... newStorageConnections) {
        if (newStorageConnections != null) {
            if (storageConnections == null) {
                storageConnections = new ArrayList<>(newStorageConnections.length);
            }
            for (StorageConnectionBuilder builder : newStorageConnections) {
                storageConnections.add(builder.build());
            }
        }
        return this;
    }
    
    
    public IscsiBond build() {
        IscsiBondContainer container = new IscsiBondContainer();
        container.comment(comment);
        container.dataCenter(dataCenter);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.networks(networks);
        container.storageConnections(storageConnections);
        return container;
    }
}
