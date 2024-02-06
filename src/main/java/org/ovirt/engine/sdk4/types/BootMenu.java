/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents boot menu configuration
 * for virtual machines and templates.
 */
public interface BootMenu {
    boolean enabled();
    
    boolean enabledPresent();
    
}
