/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StatisticKind {
    COUNTER("counter"),
    GAUGE("gauge"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StatisticKind.class);
    
    private String image;
    
    StatisticKind(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StatisticKind fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StatisticKind' enumerated type. " +
            "Valid values are 'counter' and 'gauge'.",
            exception
            );
            return null;
        }
    }
    
}

