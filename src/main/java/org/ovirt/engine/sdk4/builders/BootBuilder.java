/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.BootContainer;
import org.ovirt.engine.sdk4.types.Boot;
import org.ovirt.engine.sdk4.types.BootDevice;

public class BootBuilder {
    private List<BootDevice> devices;
    
    public BootBuilder devices(List<BootDevice> newDevices) {
        if (newDevices != null) {
            if (devices == null) {
                devices = new ArrayList<>(newDevices);
            }
            else {
                devices.addAll(newDevices);
            }
        }
        return this;
    }
    
    public BootBuilder devices(BootDevice... newDevices) {
        if (newDevices != null) {
            if (devices == null) {
                devices = new ArrayList<>(newDevices.length);
            }
            Collections.addAll(devices, newDevices);
        }
        return this;
    }
    
    
    public Boot build() {
        BootContainer container = new BootContainer();
        container.devices(devices);
        return container;
    }
}
