/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Boot;
import org.ovirt.engine.sdk4.types.BootDevice;

public class BootContainer extends Container implements Boot {
    private List<BootDevice> devices;
    
    public List<BootDevice> devices() {
        return makeUnmodifiableList(devices);
    }
    
    public void devices(List<BootDevice> newDevices) {
        devices = makeArrayList(newDevices);
    }
    
    public boolean devicesPresent() {
        return devices != null && !devices.isEmpty();
    }
    
}
