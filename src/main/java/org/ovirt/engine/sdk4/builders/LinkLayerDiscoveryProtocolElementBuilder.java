/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.LinkLayerDiscoveryProtocolElementContainer;
import org.ovirt.engine.sdk4.types.LinkLayerDiscoveryProtocolElement;
import org.ovirt.engine.sdk4.types.Property;

public class LinkLayerDiscoveryProtocolElementBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private BigInteger oui;
    private List<Property> properties;
    private BigInteger subtype;
    private BigInteger type;
    
    public LinkLayerDiscoveryProtocolElementBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder oui(int newOui) {
        oui = BigInteger.valueOf((long) newOui);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder oui(Integer newOui) {
        if (newOui == null) {
            oui = null;
        }
        else {
            oui = BigInteger.valueOf(newOui.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder oui(long newOui) {
        oui = BigInteger.valueOf(newOui);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder oui(Long newOui) {
        if (newOui == null) {
            oui = null;
        }
        else {
            oui = BigInteger.valueOf(newOui.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder oui(BigInteger newOui) {
        oui = newOui;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder subtype(int newSubtype) {
        subtype = BigInteger.valueOf((long) newSubtype);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder subtype(Integer newSubtype) {
        if (newSubtype == null) {
            subtype = null;
        }
        else {
            subtype = BigInteger.valueOf(newSubtype.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder subtype(long newSubtype) {
        subtype = BigInteger.valueOf(newSubtype);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder subtype(Long newSubtype) {
        if (newSubtype == null) {
            subtype = null;
        }
        else {
            subtype = BigInteger.valueOf(newSubtype.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder subtype(BigInteger newSubtype) {
        subtype = newSubtype;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElementBuilder type(int newType) {
        type = BigInteger.valueOf((long) newType);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder type(Integer newType) {
        if (newType == null) {
            type = null;
        }
        else {
            type = BigInteger.valueOf(newType.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder type(long newType) {
        type = BigInteger.valueOf(newType);
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder type(Long newType) {
        if (newType == null) {
            type = null;
        }
        else {
            type = BigInteger.valueOf(newType.longValue());
        }
        return this;
    }
    
    public LinkLayerDiscoveryProtocolElementBuilder type(BigInteger newType) {
        type = newType;
        return this;
    }
    
    
    public LinkLayerDiscoveryProtocolElement build() {
        LinkLayerDiscoveryProtocolElementContainer container = new LinkLayerDiscoveryProtocolElementContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.oui(oui);
        container.properties(properties);
        container.subtype(subtype);
        container.type(type);
        return container;
    }
}
