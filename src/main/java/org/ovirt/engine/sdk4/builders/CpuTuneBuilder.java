/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.CpuTuneContainer;
import org.ovirt.engine.sdk4.types.CpuTune;
import org.ovirt.engine.sdk4.types.VcpuPin;

public class CpuTuneBuilder {
    private List<VcpuPin> vcpuPins;
    
    public CpuTuneBuilder vcpuPins(List<VcpuPin> newVcpuPins) {
        if (newVcpuPins != null) {
            if (vcpuPins == null) {
                vcpuPins = new ArrayList<>(newVcpuPins);
            }
            else {
                vcpuPins.addAll(newVcpuPins);
            }
        }
        return this;
    }
    
    public CpuTuneBuilder vcpuPins(VcpuPin... newVcpuPins) {
        if (newVcpuPins != null) {
            if (vcpuPins == null) {
                vcpuPins = new ArrayList<>(newVcpuPins.length);
            }
            Collections.addAll(vcpuPins, newVcpuPins);
        }
        return this;
    }
    
    public CpuTuneBuilder vcpuPins(VcpuPinBuilder... newVcpuPins) {
        if (newVcpuPins != null) {
            if (vcpuPins == null) {
                vcpuPins = new ArrayList<>(newVcpuPins.length);
            }
            for (VcpuPinBuilder builder : newVcpuPins) {
                vcpuPins.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CpuTune build() {
        CpuTuneContainer container = new CpuTuneContainer();
        container.vcpuPins(vcpuPins);
        return container;
    }
}
