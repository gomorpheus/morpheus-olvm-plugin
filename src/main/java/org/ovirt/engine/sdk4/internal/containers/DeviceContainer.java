/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Device;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class DeviceContainer extends IdentifiedContainer implements Device {
    private InstanceType instanceType;
    private Template template;
    private Vm vm;
    private List<Vm> vms;
    
    public InstanceType instanceType() {
        return instanceType;
    }
    
    public void instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
    }
    
    public boolean instanceTypePresent() {
        return instanceType != null;
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
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
    
    public List<Vm> vms() {
        return makeUnmodifiableList(vms);
    }
    
    public void vms(List<Vm> newVms) {
        vms = makeArrayList(newVms);
    }
    
    public boolean vmsPresent() {
        return vms != null && !vms.isEmpty();
    }
    
}
