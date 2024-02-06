/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the values for the cloud-init protocol.
 * This protocol decides how the cloud-init network
 * parameters are formatted before being passed to
 * the virtual machine in order to be processed by cloud-init.
 * 
 * Protocols supported are cloud-init version dependent.
 * For more information, see
 * http://cloudinit.readthedocs.io/en/latest/topics/network-config.html#network-configuration-sources[Network Configuration Sources]
 */
public enum CloudInitNetworkProtocol {
    /**
     * Legacy protocol. Does not support IPv6.
     * For more information, see
     * http://cloudinit.readthedocs.io/en/latest/topics/network-config-format-eni.html#network-config-eni[Network Configuration ENI (Legacy)]
     */
    ENI("eni"),
    /**
     * Successor of the ENI protocol, with support for IPv6 and more.
     * This is the default value.
     * For more information, see
     * http://specs.openstack.org/openstack/nova-specs/specs/liberty/implemented/metadata-service-network-info[API: Proxy neutron configuration to guest instance]
     */
    OPENSTACK_METADATA("openstack_metadata"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(CloudInitNetworkProtocol.class);
    
    private String image;
    
    CloudInitNetworkProtocol(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static CloudInitNetworkProtocol fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'CloudInitNetworkProtocol' enumerated type. " +
            "Valid values are 'eni' and 'openstack_metadata'.",
            exception
            );
            return null;
        }
    }
    
}

