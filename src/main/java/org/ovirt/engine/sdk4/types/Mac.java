/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents a MAC address of a virtual network interface.
 */
public interface Mac {
    String address();
    
    boolean addressPresent();
    
}
