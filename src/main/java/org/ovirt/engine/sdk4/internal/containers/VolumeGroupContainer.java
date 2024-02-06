/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.VolumeGroup;

public class VolumeGroupContainer extends Container implements VolumeGroup {
    private String id;
    private List<LogicalUnit> logicalUnits;
    private String name;
    
    public String id() {
        return id;
    }
    
    public void id(String newId) {
        id = newId;
    }
    
    public boolean idPresent() {
        return id != null;
    }
    
    public List<LogicalUnit> logicalUnits() {
        return makeUnmodifiableList(logicalUnits);
    }
    
    public void logicalUnits(List<LogicalUnit> newLogicalUnits) {
        logicalUnits = makeArrayList(newLogicalUnits);
    }
    
    public boolean logicalUnitsPresent() {
        return logicalUnits != null && !logicalUnits.isEmpty();
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
}
