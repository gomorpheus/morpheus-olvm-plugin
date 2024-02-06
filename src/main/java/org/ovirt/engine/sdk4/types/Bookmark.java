/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents a bookmark in the system.
 */
public interface Bookmark extends Identified {
    String value();
    
    boolean valuePresent();
    
}
