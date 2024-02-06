/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The protocol used by the engine to communicate with
 * a host.
 * 
 * WARNING: Since version 4.1 of the engine the protocol
 * is always set to `stomp` since `xml` was removed.
 */
public enum HostProtocol {
    /**
     * JSON-RPC protocol on top of STOMP.
     */
    STOMP("stomp"),
    /**
     * XML-RPC protocol.
     */
    XML("xml"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(HostProtocol.class);
    
    private String image;
    
    HostProtocol(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static HostProtocol fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'HostProtocol' enumerated type. " +
            "Valid values are 'stomp' and 'xml'.",
            exception
            );
            return null;
        }
    }
    
}

