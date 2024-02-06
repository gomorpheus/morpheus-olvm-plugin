/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.SeLinuxContainer;
import org.ovirt.engine.sdk4.types.SeLinux;
import org.ovirt.engine.sdk4.types.SeLinuxMode;

public class SeLinuxBuilder {
    private SeLinuxMode mode;
    
    public SeLinuxBuilder mode(SeLinuxMode newMode) {
        mode = newMode;
        return this;
    }
    
    
    public SeLinux build() {
        SeLinuxContainer container = new SeLinuxContainer();
        container.mode(mode);
        return container;
    }
}
