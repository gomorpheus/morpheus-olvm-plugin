/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.LinkLayerDiscoveryProtocolElement;
import org.ovirt.engine.sdk4.types.Property;

public class LinkLayerDiscoveryProtocolElementContainer extends IdentifiedContainer implements LinkLayerDiscoveryProtocolElement {
    private BigInteger oui;
    private List<Property> properties;
    private BigInteger subtype;
    private BigInteger type;
    
    public BigInteger oui() {
        return oui;
    }
    
    public Byte ouiAsByte() {
        return asByte("LinkLayerDiscoveryProtocolElement", "oui", oui);
    }
    
    public Short ouiAsShort() {
        return asShort("LinkLayerDiscoveryProtocolElement", "oui", oui);
    }
    
    public Integer ouiAsInteger() {
        return asInteger("LinkLayerDiscoveryProtocolElement", "oui", oui);
    }
    
    public Long ouiAsLong() {
        return asLong("LinkLayerDiscoveryProtocolElement", "oui", oui);
    }
    
    public void oui(BigInteger newOui) {
        oui = newOui;
    }
    
    public boolean ouiPresent() {
        return oui != null;
    }
    
    public List<Property> properties() {
        return makeUnmodifiableList(properties);
    }
    
    public void properties(List<Property> newProperties) {
        properties = makeArrayList(newProperties);
    }
    
    public boolean propertiesPresent() {
        return properties != null && !properties.isEmpty();
    }
    
    public BigInteger subtype() {
        return subtype;
    }
    
    public Byte subtypeAsByte() {
        return asByte("LinkLayerDiscoveryProtocolElement", "subtype", subtype);
    }
    
    public Short subtypeAsShort() {
        return asShort("LinkLayerDiscoveryProtocolElement", "subtype", subtype);
    }
    
    public Integer subtypeAsInteger() {
        return asInteger("LinkLayerDiscoveryProtocolElement", "subtype", subtype);
    }
    
    public Long subtypeAsLong() {
        return asLong("LinkLayerDiscoveryProtocolElement", "subtype", subtype);
    }
    
    public void subtype(BigInteger newSubtype) {
        subtype = newSubtype;
    }
    
    public boolean subtypePresent() {
        return subtype != null;
    }
    
    public BigInteger type() {
        return type;
    }
    
    public Byte typeAsByte() {
        return asByte("LinkLayerDiscoveryProtocolElement", "type", type);
    }
    
    public Short typeAsShort() {
        return asShort("LinkLayerDiscoveryProtocolElement", "type", type);
    }
    
    public Integer typeAsInteger() {
        return asInteger("LinkLayerDiscoveryProtocolElement", "type", type);
    }
    
    public Long typeAsLong() {
        return asLong("LinkLayerDiscoveryProtocolElement", "type", type);
    }
    
    public void type(BigInteger newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
