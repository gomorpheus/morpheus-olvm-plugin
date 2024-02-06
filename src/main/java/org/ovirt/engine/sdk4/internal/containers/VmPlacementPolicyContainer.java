/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.VmAffinity;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;

public class VmPlacementPolicyContainer extends Container implements VmPlacementPolicy {
    private VmAffinity affinity;
    private List<Host> hosts;
    
    public VmAffinity affinity() {
        return affinity;
    }
    
    public void affinity(VmAffinity newAffinity) {
        affinity = newAffinity;
    }
    
    public boolean affinityPresent() {
        return affinity != null;
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
    
}
