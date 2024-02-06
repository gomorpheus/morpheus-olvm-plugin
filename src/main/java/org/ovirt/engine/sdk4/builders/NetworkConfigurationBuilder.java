/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.NetworkConfigurationContainer;
import org.ovirt.engine.sdk4.types.Dns;
import org.ovirt.engine.sdk4.types.NetworkConfiguration;
import org.ovirt.engine.sdk4.types.Nic;

public class NetworkConfigurationBuilder {
    private Dns dns;
    private List<Nic> nics;
    
    public NetworkConfigurationBuilder dns(Dns newDns) {
        dns = newDns;
        return this;
    }
    
    public NetworkConfigurationBuilder dns(DnsBuilder newDns) {
        if (newDns == null) {
            dns = null;
        }
        else {
            dns = newDns.build();
        }
        return this;
    }
    
    
    public NetworkConfigurationBuilder nics(List<Nic> newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics);
            }
            else {
                nics.addAll(newNics);
            }
        }
        return this;
    }
    
    public NetworkConfigurationBuilder nics(Nic... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            Collections.addAll(nics, newNics);
        }
        return this;
    }
    
    public NetworkConfigurationBuilder nics(NicBuilder... newNics) {
        if (newNics != null) {
            if (nics == null) {
                nics = new ArrayList<>(newNics.length);
            }
            for (NicBuilder builder : newNics) {
                nics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NetworkConfiguration build() {
        NetworkConfigurationContainer container = new NetworkConfigurationContainer();
        container.dns(dns);
        container.nics(nics);
        return container;
    }
}
