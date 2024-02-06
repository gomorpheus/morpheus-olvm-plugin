/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.BondingContainer;
import org.ovirt.engine.sdk4.types.Bonding;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.Option;

public class BondingBuilder {
    private HostNic activeSlave;
    private Mac adPartnerMac;
    private List<Option> options;
    private List<HostNic> slaves;
    
    public BondingBuilder activeSlave(HostNic newActiveSlave) {
        activeSlave = newActiveSlave;
        return this;
    }
    
    public BondingBuilder activeSlave(HostNicBuilder newActiveSlave) {
        if (newActiveSlave == null) {
            activeSlave = null;
        }
        else {
            activeSlave = newActiveSlave.build();
        }
        return this;
    }
    
    
    public BondingBuilder adPartnerMac(Mac newAdPartnerMac) {
        adPartnerMac = newAdPartnerMac;
        return this;
    }
    
    public BondingBuilder adPartnerMac(MacBuilder newAdPartnerMac) {
        if (newAdPartnerMac == null) {
            adPartnerMac = null;
        }
        else {
            adPartnerMac = newAdPartnerMac.build();
        }
        return this;
    }
    
    
    public BondingBuilder options(List<Option> newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions);
            }
            else {
                options.addAll(newOptions);
            }
        }
        return this;
    }
    
    public BondingBuilder options(Option... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            Collections.addAll(options, newOptions);
        }
        return this;
    }
    
    public BondingBuilder options(OptionBuilder... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            for (OptionBuilder builder : newOptions) {
                options.add(builder.build());
            }
        }
        return this;
    }
    
    
    public BondingBuilder slaves(List<HostNic> newSlaves) {
        if (newSlaves != null) {
            if (slaves == null) {
                slaves = new ArrayList<>(newSlaves);
            }
            else {
                slaves.addAll(newSlaves);
            }
        }
        return this;
    }
    
    public BondingBuilder slaves(HostNic... newSlaves) {
        if (newSlaves != null) {
            if (slaves == null) {
                slaves = new ArrayList<>(newSlaves.length);
            }
            Collections.addAll(slaves, newSlaves);
        }
        return this;
    }
    
    public BondingBuilder slaves(HostNicBuilder... newSlaves) {
        if (newSlaves != null) {
            if (slaves == null) {
                slaves = new ArrayList<>(newSlaves.length);
            }
            for (HostNicBuilder builder : newSlaves) {
                slaves.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Bonding build() {
        BondingContainer container = new BondingContainer();
        container.activeSlave(activeSlave);
        container.adPartnerMac(adPartnerMac);
        container.options(options);
        container.slaves(slaves);
        return container;
    }
}
