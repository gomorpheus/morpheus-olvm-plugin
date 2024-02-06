/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type representing a transparent huge pages (THP) support.
 */
public interface TransparentHugePages {
    boolean enabled();
    
    boolean enabledPresent();
    
}
