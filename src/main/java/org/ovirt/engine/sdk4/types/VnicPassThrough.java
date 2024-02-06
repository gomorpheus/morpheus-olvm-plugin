/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


public interface VnicPassThrough {
    VnicPassThroughMode mode();
    
    boolean modePresent();
    
}
