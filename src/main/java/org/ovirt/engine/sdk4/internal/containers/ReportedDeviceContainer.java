/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.ReportedDeviceType;
import org.ovirt.engine.sdk4.types.Vm;

public class ReportedDeviceContainer extends IdentifiedContainer implements ReportedDevice {
    private List<Ip> ips;
    private Mac mac;
    private ReportedDeviceType type;
    private Vm vm;
    
    public List<Ip> ips() {
        return makeUnmodifiableList(ips);
    }
    
    public void ips(List<Ip> newIps) {
        ips = makeArrayList(newIps);
    }
    
    public boolean ipsPresent() {
        return ips != null && !ips.isEmpty();
    }
    
    public Mac mac() {
        return mac;
    }
    
    public void mac(Mac newMac) {
        mac = newMac;
    }
    
    public boolean macPresent() {
        return mac != null;
    }
    
    public ReportedDeviceType type() {
        return type;
    }
    
    public void type(ReportedDeviceType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
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
