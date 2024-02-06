/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.VolumeGroupContainer;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.VolumeGroup;

public class VolumeGroupBuilder {
    private String id;
    private List<LogicalUnit> logicalUnits;
    private String name;
    
    public VolumeGroupBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VolumeGroupBuilder logicalUnits(List<LogicalUnit> newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits);
            }
            else {
                logicalUnits.addAll(newLogicalUnits);
            }
        }
        return this;
    }
    
    public VolumeGroupBuilder logicalUnits(LogicalUnit... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            Collections.addAll(logicalUnits, newLogicalUnits);
        }
        return this;
    }
    
    public VolumeGroupBuilder logicalUnits(LogicalUnitBuilder... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            for (LogicalUnitBuilder builder : newLogicalUnits) {
                logicalUnits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VolumeGroupBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VolumeGroup build() {
        VolumeGroupContainer container = new VolumeGroupContainer();
        container.id(id);
        container.logicalUnits(logicalUnits);
        container.name(name);
        return container;
    }
}
