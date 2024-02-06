/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.PortMirroringContainer;
import org.ovirt.engine.sdk4.types.PortMirroring;

public class PortMirroringBuilder {
    
    public PortMirroring build() {
        PortMirroringContainer container = new PortMirroringContainer();
        return container;
    }
}
