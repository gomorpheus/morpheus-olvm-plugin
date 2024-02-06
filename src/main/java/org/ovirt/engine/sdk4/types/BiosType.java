/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a chipset and a BIOS type combination.
 */
public enum BiosType {
    /**
     * Use the cluster-wide default.
     * 
     * This value cannot be used for cluster.
     */
    CLUSTER_DEFAULT("cluster_default"),
    /**
     * i440fx chipset with SeaBIOS.
     * 
     * For non-x86 architectures this is the only non-default value allowed.
     */
    I440FX_SEA_BIOS("i440fx_sea_bios"),
    /**
     * q35 chipset with OVMF (UEFI) BIOS.
     */
    Q35_OVMF("q35_ovmf"),
    /**
     * q35 chipset with SeaBIOS.
     */
    Q35_SEA_BIOS("q35_sea_bios"),
    /**
     * q35 chipset with OVMF (UEFI) BIOS with SecureBoot enabled.
     */
    Q35_SECURE_BOOT("q35_secure_boot"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(BiosType.class);
    
    private String image;
    
    BiosType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static BiosType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'BiosType' enumerated type. " +
            "Valid values are 'cluster_default', 'i440fx_sea_bios', 'q35_ovmf', 'q35_sea_bios' and 'q35_secure_boot'.",
            exception
            );
            return null;
        }
    }
    
}

