/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.KernelContainer;
import org.ovirt.engine.sdk4.types.Kernel;
import org.ovirt.engine.sdk4.types.Version;

public class KernelBuilder {
    private Version version;
    
    public KernelBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public KernelBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public Kernel build() {
        KernelContainer container = new KernelContainer();
        container.version(version);
        return container;
    }
}
