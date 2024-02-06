/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describes the type of external hypervisor system.
 */
public enum ExternalVmProviderType {
    KVM("kvm"),
    VMWARE("vmware"),
    XEN("xen"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ExternalVmProviderType.class);
    
    private String image;
    
    ExternalVmProviderType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ExternalVmProviderType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ExternalVmProviderType' enumerated type. " +
            "Valid values are 'kvm', 'vmware' and 'xen'.",
            exception
            );
            return null;
        }
    }
    
}

