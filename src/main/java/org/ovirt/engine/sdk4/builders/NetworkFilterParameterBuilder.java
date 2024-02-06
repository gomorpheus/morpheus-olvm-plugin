/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.NetworkFilterParameterContainer;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;
import org.ovirt.engine.sdk4.types.Nic;

public class NetworkFilterParameterBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private Nic nic;
    private String value;
    
    public NetworkFilterParameterBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NetworkFilterParameterBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NetworkFilterParameterBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NetworkFilterParameterBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NetworkFilterParameterBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NetworkFilterParameterBuilder nic(Nic newNic) {
        nic = newNic;
        return this;
    }
    
    public NetworkFilterParameterBuilder nic(NicBuilder newNic) {
        if (newNic == null) {
            nic = null;
        }
        else {
            nic = newNic.build();
        }
        return this;
    }
    
    
    public NetworkFilterParameterBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public NetworkFilterParameter build() {
        NetworkFilterParameterContainer container = new NetworkFilterParameterContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.nic(nic);
        container.value(value);
        return container;
    }
}
