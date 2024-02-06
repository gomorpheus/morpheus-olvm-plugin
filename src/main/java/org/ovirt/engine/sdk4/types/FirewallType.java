/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describes all firewall types supported by the system.
 */
public enum FirewallType {
    /**
     * FirewallD firewall type.
     * 
     * When a cluster has the firewall type set to `firewalld`, the firewalls of all hosts in the cluster will be configured
     * using `firewalld`. http://www.firewalld.org[FirewallD] replaced IPTables in version 4.2. It simplifies
     * configuration using a command line program and dynamic configuration.
     */
    FIREWALLD("firewalld"),
    /**
     * IPTables firewall type.
     * 
     * `iptables` is deprecated.
     */
    IPTABLES("iptables"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(FirewallType.class);
    
    private String image;
    
    FirewallType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static FirewallType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'FirewallType' enumerated type. " +
            "Valid values are 'firewalld' and 'iptables'.",
            exception
            );
            return null;
        }
    }
    
}

