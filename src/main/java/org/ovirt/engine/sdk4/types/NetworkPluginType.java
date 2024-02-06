/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Network plug-in type.
 * 
 * Specifies the provider driver implementation on the host.
 * 
 * Since version 4.2 of the {engine-name}, this type has been deprecated in favour of the `external_plugin_type`
 * attribute of the `OpenStackNetworkProvider` type.
 */
public enum NetworkPluginType {
    /**
     * Open vSwitch.
     * 
     * Specifies that http://openvswitch.org[Open vSwitch] based driver implementation should be used for this provider.
     * 
     * Since version 4.2 of the {engine-name}, this value has been deprecated. Use the string `open_vswitch` in the
     * `OpenStackNetworkProvider.external_plugin_type` attribute instead.
     */
    OPEN_VSWITCH("open_vswitch"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NetworkPluginType.class);
    
    private String image;
    
    NetworkPluginType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NetworkPluginType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NetworkPluginType' enumerated type. " +
            "Valid value is 'open_vswitch'.",
            exception
            );
            return null;
        }
    }
    
}

