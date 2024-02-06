/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Dns;
import org.ovirt.engine.sdk4.types.NetworkConfiguration;
import org.ovirt.engine.sdk4.types.Nic;

public class NetworkConfigurationContainer extends Container implements NetworkConfiguration {
    private Dns dns;
    private List<Nic> nics;
    
    public Dns dns() {
        return dns;
    }
    
    public void dns(Dns newDns) {
        dns = newDns;
    }
    
    public boolean dnsPresent() {
        return dns != null;
    }
    
    public List<Nic> nics() {
        return makeUnmodifiableList(nics);
    }
    
    public void nics(List<Nic> newNics) {
        nics = makeArrayList(newNics);
    }
    
    public boolean nicsPresent() {
        return nics != null && !nics.isEmpty();
    }
    
}
