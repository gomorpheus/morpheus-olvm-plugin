/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Time zone representation.
 */
public interface TimeZone {
    String name();
    
    boolean namePresent();
    
    String utcOffset();
    
    boolean utcOffsetPresent();
    
}
