/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Architecture {
    PPC64("ppc64"),
    /**
     * IBM S390X CPU architecture.
     * 
     * Needs to be specified for virtual machines and clusters running
     * on the S390X architecture.
     * 
     * Note that S390 is often used in an ambiguous way to describe
     * either the general machine architecture as such or its 31-bit variant.
     * S390X is used specifically for the 64-bit architecture, which is
     * in line with the other architectures, like X86_64 or PPC64.
     */
    S390X("s390x"),
    UNDEFINED("undefined"),
    X86_64("x86_64"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(Architecture.class);
    
    private String image;
    
    Architecture(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static Architecture fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'Architecture' enumerated type. " +
            "Valid values are 'ppc64', 's390x', 'undefined' and 'x86_64'.",
            exception
            );
            return null;
        }
    }
    
}

