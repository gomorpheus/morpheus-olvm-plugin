/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Type representing a configuration option of the system.
 */
public interface SystemOption extends Identified {
    List<SystemOptionValue> values();
    
    boolean valuesPresent();
    
}
