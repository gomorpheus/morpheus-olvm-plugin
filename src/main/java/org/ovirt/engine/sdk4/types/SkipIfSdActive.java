/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type represents the storage related
 * configuration in the fencing policy.
 */
public interface SkipIfSdActive {
    boolean enabled();
    
    boolean enabledPresent();
    
}
