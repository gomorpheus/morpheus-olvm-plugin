/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the options for an emulated virtual network interface device model.
 */
public enum NicInterface {
    /**
     * e1000.
     */
    E1000("e1000"),
    /**
     * PCI Passthrough.
     */
    PCI_PASSTHROUGH("pci_passthrough"),
    /**
     * rtl8139.
     */
    RTL8139("rtl8139"),
    /**
     * Dual mode rtl8139, VirtIO.
     */
    RTL8139_VIRTIO("rtl8139_virtio"),
    /**
     * sPAPR VLAN.
     */
    SPAPR_VLAN("spapr_vlan"),
    /**
     * VirtIO.
     */
    VIRTIO("virtio"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NicInterface.class);
    
    private String image;
    
    NicInterface(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NicInterface fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NicInterface' enumerated type. " +
            "Valid values are 'e1000', 'pci_passthrough', 'rtl8139', 'rtl8139_virtio', 'spapr_vlan' and 'virtio'.",
            exception
            );
            return null;
        }
    }
    
}

