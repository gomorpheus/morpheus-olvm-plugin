/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.VmPlacementPolicyContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.VmAffinity;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;

public class VmPlacementPolicyBuilder {
    private VmAffinity affinity;
    private List<Host> hosts;
    
    public VmPlacementPolicyBuilder affinity(VmAffinity newAffinity) {
        affinity = newAffinity;
        return this;
    }
    
    
    public VmPlacementPolicyBuilder hosts(List<Host> newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts);
            }
            else {
                hosts.addAll(newHosts);
            }
        }
        return this;
    }
    
    public VmPlacementPolicyBuilder hosts(Host... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            Collections.addAll(hosts, newHosts);
        }
        return this;
    }
    
    public VmPlacementPolicyBuilder hosts(HostBuilder... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            for (HostBuilder builder : newHosts) {
                hosts.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VmPlacementPolicy build() {
        VmPlacementPolicyContainer container = new VmPlacementPolicyContainer();
        container.affinity(affinity);
        container.hosts(hosts);
        return container;
    }
}
