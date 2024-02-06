/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Bonding;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.Option;

public class BondingContainer extends Container implements Bonding {
    private Mac adPartnerMac;
    private List<Option> options;
    private List<HostNic> slaves;
    private HostNic activeSlave;
    
    public Mac adPartnerMac() {
        return adPartnerMac;
    }
    
    public void adPartnerMac(Mac newAdPartnerMac) {
        adPartnerMac = newAdPartnerMac;
    }
    
    public boolean adPartnerMacPresent() {
        return adPartnerMac != null;
    }
    
    public List<Option> options() {
        return makeUnmodifiableList(options);
    }
    
    public void options(List<Option> newOptions) {
        options = makeArrayList(newOptions);
    }
    
    public boolean optionsPresent() {
        return options != null && !options.isEmpty();
    }
    
    public List<HostNic> slaves() {
        return makeUnmodifiableList(slaves);
    }
    
    public void slaves(List<HostNic> newSlaves) {
        slaves = makeArrayList(newSlaves);
    }
    
    public boolean slavesPresent() {
        return slaves != null && !slaves.isEmpty();
    }
    
    public HostNic activeSlave() {
        return activeSlave;
    }
    
    public void activeSlave(HostNic newActiveSlave) {
        activeSlave = newActiveSlave;
    }
    
    public boolean activeSlavePresent() {
        return activeSlave != null;
    }
    
}
