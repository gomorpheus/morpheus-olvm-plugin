/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StatisticUnit {
    BITS_PER_SECOND("bits_per_second"),
    BYTES("bytes"),
    BYTES_PER_SECOND("bytes_per_second"),
    COUNT_PER_SECOND("count_per_second"),
    NONE("none"),
    PERCENT("percent"),
    SECONDS("seconds"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StatisticUnit.class);
    
    private String image;
    
    StatisticUnit(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StatisticUnit fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StatisticUnit' enumerated type. " +
            "Valid values are 'bits_per_second', 'bytes', 'bytes_per_second', 'count_per_second', 'none', 'percent' and 'seconds'.",
            exception
            );
            return null;
        }
    }
    
}

