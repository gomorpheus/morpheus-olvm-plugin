/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.NetworkLabelContainer;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkLabel;

public class NetworkLabelBuilder {
    private String comment;
    private String description;
    private HostNic hostNic;
    private String href;
    private String id;
    private String name;
    private Network network;
    
    public NetworkLabelBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NetworkLabelBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NetworkLabelBuilder hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
        return this;
    }
    
    public NetworkLabelBuilder hostNic(HostNicBuilder newHostNic) {
        if (newHostNic == null) {
            hostNic = null;
        }
        else {
            hostNic = newHostNic.build();
        }
        return this;
    }
    
    
    public NetworkLabelBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NetworkLabelBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NetworkLabelBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NetworkLabelBuilder network(Network newNetwork) {
        network = newNetwork;
        return this;
    }
    
    public NetworkLabelBuilder network(NetworkBuilder newNetwork) {
        if (newNetwork == null) {
            network = null;
        }
        else {
            network = newNetwork.build();
        }
        return this;
    }
    
    
    public NetworkLabel build() {
        NetworkLabelContainer container = new NetworkLabelContainer();
        container.comment(comment);
        container.description(description);
        container.hostNic(hostNic);
        container.href(href);
        container.id(id);
        container.name(name);
        container.network(network);
        return container;
    }
}
