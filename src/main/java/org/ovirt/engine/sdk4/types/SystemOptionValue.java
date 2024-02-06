/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Type representing a pair of value and version of a configuration option.
 */
public interface SystemOptionValue {
    String value();
    
    boolean valuePresent();
    
    String version();
    
    boolean versionPresent();
    
}
