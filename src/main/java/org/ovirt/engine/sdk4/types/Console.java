/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Representation for serial console device.
 */
public interface Console {
    boolean enabled();
    
    boolean enabledPresent();
    
}
