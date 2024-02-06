/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Custom property representation.
 */
public interface CustomProperty {
    String name();
    
    boolean namePresent();
    
    String regexp();
    
    boolean regexpPresent();
    
    String value();
    
    boolean valuePresent();
    
}
