/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Deprecated Message Broker type.
 * 
 * Ignored, because the deployment of OpenStack Neutron agent is dropped since {product-name} 4.4.0.
 */
public enum MessageBrokerType {
    QPID("qpid"),
    RABBIT_MQ("rabbit_mq"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(MessageBrokerType.class);
    
    private String image;
    
    MessageBrokerType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static MessageBrokerType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'MessageBrokerType' enumerated type. " +
            "Valid values are 'qpid' and 'rabbit_mq'.",
            exception
            );
            return null;
        }
    }
    
}

