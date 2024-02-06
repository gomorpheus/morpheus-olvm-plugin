/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This type represents the kind of resource the <<types/qos,Quality of service (QoS)>> can be assigned to.
 */
public enum QosType {
    /**
     * The <<types/qos,Quality of service (QoS)>> can be assigned to resources with computing capabilities.
     */
    CPU("cpu"),
    /**
     * The <<types/qos,Quality of service (QoS)>> can be assigned to host networks.
     */
    HOSTNETWORK("hostnetwork"),
    /**
     * The <<types/qos,Quality of service (QoS)>> can be assigned to virtual machines networks.
     */
    NETWORK("network"),
    /**
     * The <<types/qos,Quality of service (QoS)>> can be assigned to storage.
     */
    STORAGE("storage"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(QosType.class);
    
    private String image;
    
    QosType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static QosType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'QosType' enumerated type. " +
            "Valid values are 'cpu', 'hostnetwork', 'network' and 'storage'.",
            exception
            );
            return null;
        }
    }
    
}

