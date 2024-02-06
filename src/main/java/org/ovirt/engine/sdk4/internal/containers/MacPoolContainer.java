/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.MacPool;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Range;

public class MacPoolContainer extends IdentifiedContainer implements MacPool {
    private Boolean allowDuplicates;
    private Boolean defaultPool;
    private List<Range> ranges;
    private List<Permission> permissions;
    
    public boolean allowDuplicates() {
        return allowDuplicates;
    }
    
    public void allowDuplicates(boolean newAllowDuplicates) {
        allowDuplicates = Boolean.valueOf(newAllowDuplicates);
    }
    
    public void allowDuplicates(Boolean newAllowDuplicates) {
        allowDuplicates = newAllowDuplicates;
    }
    
    public boolean allowDuplicatesPresent() {
        return allowDuplicates != null;
    }
    
    public boolean defaultPool() {
        return defaultPool;
    }
    
    public void defaultPool(boolean newDefaultPool) {
        defaultPool = Boolean.valueOf(newDefaultPool);
    }
    
    public void defaultPool(Boolean newDefaultPool) {
        defaultPool = newDefaultPool;
    }
    
    public boolean defaultPoolPresent() {
        return defaultPool != null;
    }
    
    public List<Range> ranges() {
        return makeUnmodifiableList(ranges);
    }
    
    public void ranges(List<Range> newRanges) {
        ranges = makeArrayList(newRanges);
    }
    
    public boolean rangesPresent() {
        return ranges != null && !ranges.isEmpty();
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
}
