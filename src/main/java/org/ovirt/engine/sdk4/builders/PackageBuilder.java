/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.PackageContainer;
import org.ovirt.engine.sdk4.types.Package;

public class PackageBuilder {
    private String name;
    
    public PackageBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Package build() {
        PackageContainer container = new PackageContainer();
        container.name(name);
        return container;
    }
}
