/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.MacPoolContainer;
import org.ovirt.engine.sdk4.types.MacPool;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Range;

public class MacPoolBuilder {
    private Boolean allowDuplicates;
    private String comment;
    private Boolean defaultPool;
    private String description;
    private String href;
    private String id;
    private String name;
    private List<Permission> permissions;
    private List<Range> ranges;
    
    public MacPoolBuilder allowDuplicates(boolean newAllowDuplicates) {
        allowDuplicates = Boolean.valueOf(newAllowDuplicates);
        return this;
    }
    
    public MacPoolBuilder allowDuplicates(Boolean newAllowDuplicates) {
        allowDuplicates = newAllowDuplicates;
        return this;
    }
    
    
    public MacPoolBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public MacPoolBuilder defaultPool(boolean newDefaultPool) {
        defaultPool = Boolean.valueOf(newDefaultPool);
        return this;
    }
    
    public MacPoolBuilder defaultPool(Boolean newDefaultPool) {
        defaultPool = newDefaultPool;
        return this;
    }
    
    
    public MacPoolBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public MacPoolBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public MacPoolBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public MacPoolBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public MacPoolBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public MacPoolBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public MacPoolBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public MacPoolBuilder ranges(List<Range> newRanges) {
        if (newRanges != null) {
            if (ranges == null) {
                ranges = new ArrayList<>(newRanges);
            }
            else {
                ranges.addAll(newRanges);
            }
        }
        return this;
    }
    
    public MacPoolBuilder ranges(Range... newRanges) {
        if (newRanges != null) {
            if (ranges == null) {
                ranges = new ArrayList<>(newRanges.length);
            }
            Collections.addAll(ranges, newRanges);
        }
        return this;
    }
    
    public MacPoolBuilder ranges(RangeBuilder... newRanges) {
        if (newRanges != null) {
            if (ranges == null) {
                ranges = new ArrayList<>(newRanges.length);
            }
            for (RangeBuilder builder : newRanges) {
                ranges.add(builder.build());
            }
        }
        return this;
    }
    
    
    public MacPool build() {
        MacPoolContainer container = new MacPoolContainer();
        container.allowDuplicates(allowDuplicates);
        container.comment(comment);
        container.defaultPool(defaultPool);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.permissions(permissions);
        container.ranges(ranges);
        return container;
    }
}
