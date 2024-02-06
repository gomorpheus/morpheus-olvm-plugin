/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Configuration of the USB device of a virtual machine.
 */
public interface Usb {
    boolean enabled();
    
    boolean enabledPresent();
    
    UsbType type();
    
    boolean typePresent();
    
}
