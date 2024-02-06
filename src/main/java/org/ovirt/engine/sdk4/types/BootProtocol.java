/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the options of the IP address assignment method to a NIC.
 */
public enum BootProtocol {
    /**
     * Stateless address auto-configuration.
     * 
     * The mechanism is defined by http://tools.ietf.org/html/rfc4862[RFC 4862]. Please refer to
     * https://en.wikipedia.org/wiki/IPv6_address#Stateless_address_autoconfiguration[this wikipedia article] for more
     * information.
     * 
     * NOTE: The value is valid for IPv6 addresses only.
     */
    AUTOCONF("autoconf"),
    /**
     * Dynamic host configuration protocol.
     * 
     * Please refer to https://en.wikipedia.org/wiki/Dynamic_Host_Configuration_Protocol[this wikipedia article] for
     * more information.
     */
    DHCP("dhcp"),
    /**
     * No address configuration.
     */
    NONE("none"),
    /**
     * DHCP alongside Stateless address auto-configuration (SLAAC).
     * 
     * The SLAAC mechanism is defined by http://tools.ietf.org/html/rfc4862[RFC 4862]. Please refer to the
     * https://en.wikipedia.org/wiki/IPv6_address#Stateless_address_autoconfiguration[Stateless address auto-configuration] article
     * and the https://en.wikipedia.org/wiki/Dynamic_Host_Configuration_Protocol[DHCP] article for
     * more information.
     * 
     * NOTE: The value is valid for IPv6 addresses only.
     */
    POLY_DHCP_AUTOCONF("poly_dhcp_autoconf"),
    /**
     * Statically-defined address, mask and gateway.
     */
    STATIC("static"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(BootProtocol.class);
    
    private String image;
    
    BootProtocol(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static BootProtocol fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'BootProtocol' enumerated type. " +
            "Valid values are 'autoconf', 'dhcp', 'none', 'poly_dhcp_autoconf' and 'static'.",
            exception
            );
            return null;
        }
    }
    
}

