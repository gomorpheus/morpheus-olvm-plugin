/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This type indicates the purpose that the network is used for in the cluster.
 */
public enum NetworkUsage {
    /**
     * The default gateway and the DNS resolver configuration of the host will be taken from this network.
     * 
     * If this network is attached to the host, then the DNS resolver configuration will be taken from the
     * `dns_resolver_configuration` attribute of the network attachment. If there is no `dns_resolver_configuration`
     * attribute in this network attachment, then they will be taken from the `dns_resolver_configuration` of the
     * network itself. If `dns_resolver_configuration` attribute isn't present even there, DNS resolver configuration
     * won't be set.
     * 
     * If you set this flag on a network, then the the default gateway for the host will be taken from the `gateway`
     * attribute of the `ip_address_assignment` of the network attachment.
     */
    DEFAULT_ROUTE("default_route"),
    /**
     * The network will be used for SPICE and VNC traffic.
     */
    DISPLAY("display"),
    /**
     * The network will be used for Gluster (bricks) data traffic.
     */
    GLUSTER("gluster"),
    /**
     * The network will be used for communication between the {engine-name} and the nodes.
     * This is the network where the ovirtmgmt bridge will be created.
     */
    MANAGEMENT("management"),
    /**
     * The network will be used for virtual machine migration.
     */
    MIGRATION("migration"),
    VM("vm"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NetworkUsage.class);
    
    private String image;
    
    NetworkUsage(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NetworkUsage fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NetworkUsage' enumerated type. " +
            "Valid values are 'default_route', 'display', 'gluster', 'management', 'migration' and 'vm'.",
            exception
            );
            return null;
        }
    }
    
}

