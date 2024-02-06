/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface Range {
    String from();
    
    boolean fromPresent();
    
    String to();
    
    boolean toPresent();
    
}
