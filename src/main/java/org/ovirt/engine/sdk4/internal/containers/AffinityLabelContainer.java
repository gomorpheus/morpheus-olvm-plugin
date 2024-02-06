/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class AffinityLabelContainer extends IdentifiedContainer implements AffinityLabel {
    private Boolean hasImplicitAffinityGroup;
    private Boolean readOnly;
    private List<Host> hosts;
    private List<Vm> vms;
    
    public boolean hasImplicitAffinityGroup() {
        return hasImplicitAffinityGroup;
    }
    
    public void hasImplicitAffinityGroup(boolean newHasImplicitAffinityGroup) {
        hasImplicitAffinityGroup = Boolean.valueOf(newHasImplicitAffinityGroup);
    }
    
    public void hasImplicitAffinityGroup(Boolean newHasImplicitAffinityGroup) {
        hasImplicitAffinityGroup = newHasImplicitAffinityGroup;
    }
    
    public boolean hasImplicitAffinityGroupPresent() {
        return hasImplicitAffinityGroup != null;
    }
    
    public boolean readOnly() {
        return readOnly;
    }
    
    public void readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
    }
    
    public void readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
    }
    
    public boolean readOnlyPresent() {
        return readOnly != null;
    }
    
    public List<Host> hosts() {
        return makeUnmodifiableList(hosts);
    }
    
    public void hosts(List<Host> newHosts) {
        hosts = makeArrayList(newHosts);
    }
    
    public boolean hostsPresent() {
        return hosts != null && !hosts.isEmpty();
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
