/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.List;

/**
 * Represents an information element received by Link Layer Discovery Protocol (LLDP).
 * IEEE 802.1AB defines type, length, value (TLV) as a "short, variable length encoding of an information element".
 * This type represents such an information element.
 * 
 * The attribute `name` is a human-readable string used to describe what the value is about, and may not be unique.
 * The name is redundant, because it could be created from `type` and the optional `oui` and `subtype`.
 * The purpose of `name` is to simplify the reading of the information element.
 * The `name` of a property is exactly the same string which is used in IEEE 802.1AB chapter 8.
 * 
 * Organizationally-specific information elements have the `type` of `127` and the attributes
 * `oui` and `subtype`.
 * 
 * For example, the XML representation of an information element may look like this:
 * 
 * [source,xml]
 * ----
 * <link_layer_discovery_protocol_element>
 *   <name>Port VLAN Id</name>
 *   <oui>32962</oui>
 *   <properties>
 *     <property>
 *       <name>vlan id</name>
 *       <value>488</value>
 *     </property>
 *     <property>
 *       <name>vlan name</name>
 *       <value>v2-0488-03-0505</value>
 *     </property>
 *   </properties>
 *   <subtype>3</subtype>
 *   <type>127</type>
 * </link_layer_discovery_protocol_element>
 * ----
 */
public interface LinkLayerDiscoveryProtocolElement extends Identified {
    BigInteger oui();
    Byte ouiAsByte();
    Short ouiAsShort();
    Integer ouiAsInteger();
    Long ouiAsLong();
    
    boolean ouiPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    BigInteger subtype();
    Byte subtypeAsByte();
    Short subtypeAsShort();
    Integer subtypeAsInteger();
    Long subtypeAsLong();
    
    boolean subtypePresent();
    
    BigInteger type();
    Byte typeAsByte();
    Short typeAsShort();
    Integer typeAsInteger();
    Long typeAsLong();
    
    boolean typePresent();
    
}
