/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.CpuTune;
import org.ovirt.engine.sdk4.types.VcpuPin;

public class CpuTuneContainer extends Container implements CpuTune {
    private List<VcpuPin> vcpuPins;
    
    public List<VcpuPin> vcpuPins() {
        return makeUnmodifiableList(vcpuPins);
    }
    
    public void vcpuPins(List<VcpuPin> newVcpuPins) {
        vcpuPins = makeArrayList(newVcpuPins);
    }
    
    public boolean vcpuPinsPresent() {
        return vcpuPins != null && !vcpuPins.isEmpty();
    }
    
}
