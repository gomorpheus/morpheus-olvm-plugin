/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface VolumeGroup {
    String id();
    
    boolean idPresent();
    
    List<LogicalUnit> logicalUnits();
    
    boolean logicalUnitsPresent();
    
    String name();
    
    boolean namePresent();
    
}
