/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface Option {
    String name();
    
    boolean namePresent();
    
    String type();
    
    boolean typePresent();
    
    String value();
    
    boolean valuePresent();
    
}
