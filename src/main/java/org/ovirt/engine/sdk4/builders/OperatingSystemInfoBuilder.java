/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.OperatingSystemInfoContainer;
import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.Icon;
import org.ovirt.engine.sdk4.types.OperatingSystemInfo;

public class OperatingSystemInfoBuilder {
    private Architecture architecture;
    private String comment;
    private String description;
    private String href;
    private String id;
    private Icon largeIcon;
    private String name;
    private Icon smallIcon;
    
    public OperatingSystemInfoBuilder architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
        return this;
    }
    
    public OperatingSystemInfoBuilder largeIcon(IconBuilder newLargeIcon) {
        if (newLargeIcon == null) {
            largeIcon = null;
        }
        else {
            largeIcon = newLargeIcon.build();
        }
        return this;
    }
    
    
    public OperatingSystemInfoBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OperatingSystemInfoBuilder smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
        return this;
    }
    
    public OperatingSystemInfoBuilder smallIcon(IconBuilder newSmallIcon) {
        if (newSmallIcon == null) {
            smallIcon = null;
        }
        else {
            smallIcon = newSmallIcon.build();
        }
        return this;
    }
    
    
    public OperatingSystemInfo build() {
        OperatingSystemInfoContainer container = new OperatingSystemInfoContainer();
        container.architecture(architecture);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.largeIcon(largeIcon);
        container.name(name);
        container.smallIcon(smallIcon);
        return container;
    }
}
