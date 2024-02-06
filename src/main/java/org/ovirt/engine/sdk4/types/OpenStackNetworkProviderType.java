/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The OpenStack network provider can either be implemented by OpenStack Neutron, in which case the Neutron
 * agent is automatically installed on the hosts, or it can be an external provider implementing the
 * OpenStack API, in which case the virtual interface driver is a custom solution installed manually.
 */
public enum OpenStackNetworkProviderType {
    /**
     * Indicates that the provider is an external one, implementing the OpenStack Neutron API.
     * The virtual interface driver in this case is implemented by the external provider.
     */
    EXTERNAL("external"),
    /**
     * Indicates that the provider is OpenStack Neutron.
     * The standard OpenStack Neutron agent is used as the virtual interface driver.
     */
    NEUTRON("neutron"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(OpenStackNetworkProviderType.class);
    
    private String image;
    
    OpenStackNetworkProviderType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static OpenStackNetworkProviderType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'OpenStackNetworkProviderType' enumerated type. " +
            "Valid values are 'external' and 'neutron'.",
            exception
            );
            return null;
        }
    }
    
}

