/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.NumaNodePin;
import org.ovirt.engine.sdk4.types.NumaTuneMode;
import org.ovirt.engine.sdk4.types.VirtualNumaNode;
import org.ovirt.engine.sdk4.types.Vm;

public class VirtualNumaNodeContainer extends NumaNodeContainer implements VirtualNumaNode {
    private List<NumaNodePin> numaNodePins;
    private NumaTuneMode numaTuneMode;
    private Vm vm;
    
    public List<NumaNodePin> numaNodePins() {
        return makeUnmodifiableList(numaNodePins);
    }
    
    public void numaNodePins(List<NumaNodePin> newNumaNodePins) {
        numaNodePins = makeArrayList(newNumaNodePins);
    }
    
    public boolean numaNodePinsPresent() {
        return numaNodePins != null && !numaNodePins.isEmpty();
    }
    
    public NumaTuneMode numaTuneMode() {
        return numaTuneMode;
    }
    
    public void numaTuneMode(NumaTuneMode newNumaTuneMode) {
        numaTuneMode = newNumaTuneMode;
    }
    
    public boolean numaTuneModePresent() {
        return numaTuneMode != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
