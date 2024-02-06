/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.PowerManagementContainer;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.Option;
import org.ovirt.engine.sdk4.types.PmProxy;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.PowerManagementStatus;

public class PowerManagementBuilder {
    private String address;
    private List<Agent> agents;
    private Boolean automaticPmEnabled;
    private Boolean enabled;
    private Boolean kdumpDetection;
    private List<Option> options;
    private String password;
    private List<PmProxy> pmProxies;
    private PowerManagementStatus status;
    private String type;
    private String username;
    
    public PowerManagementBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public PowerManagementBuilder agents(List<Agent> newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents);
            }
            else {
                agents.addAll(newAgents);
            }
        }
        return this;
    }
    
    public PowerManagementBuilder agents(Agent... newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents.length);
            }
            Collections.addAll(agents, newAgents);
        }
        return this;
    }
    
    public PowerManagementBuilder agents(AgentBuilder... newAgents) {
        if (newAgents != null) {
            if (agents == null) {
                agents = new ArrayList<>(newAgents.length);
            }
            for (AgentBuilder builder : newAgents) {
                agents.add(builder.build());
            }
        }
        return this;
    }
    
    
    public PowerManagementBuilder automaticPmEnabled(boolean newAutomaticPmEnabled) {
        automaticPmEnabled = Boolean.valueOf(newAutomaticPmEnabled);
        return this;
    }
    
    public PowerManagementBuilder automaticPmEnabled(Boolean newAutomaticPmEnabled) {
        automaticPmEnabled = newAutomaticPmEnabled;
        return this;
    }
    
    
    public PowerManagementBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public PowerManagementBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public PowerManagementBuilder kdumpDetection(boolean newKdumpDetection) {
        kdumpDetection = Boolean.valueOf(newKdumpDetection);
        return this;
    }
    
    public PowerManagementBuilder kdumpDetection(Boolean newKdumpDetection) {
        kdumpDetection = newKdumpDetection;
        return this;
    }
    
    
    public PowerManagementBuilder options(List<Option> newOptions) {
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
    
    public PowerManagementBuilder options(Option... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            Collections.addAll(options, newOptions);
        }
        return this;
    }
    
    public PowerManagementBuilder options(OptionBuilder... newOptions) {
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
    
    
    public PowerManagementBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public PowerManagementBuilder pmProxies(List<PmProxy> newPmProxies) {
        if (newPmProxies != null) {
            if (pmProxies == null) {
                pmProxies = new ArrayList<>(newPmProxies);
            }
            else {
                pmProxies.addAll(newPmProxies);
            }
        }
        return this;
    }
    
    public PowerManagementBuilder pmProxies(PmProxy... newPmProxies) {
        if (newPmProxies != null) {
            if (pmProxies == null) {
                pmProxies = new ArrayList<>(newPmProxies.length);
            }
            Collections.addAll(pmProxies, newPmProxies);
        }
        return this;
    }
    
    public PowerManagementBuilder pmProxies(PmProxyBuilder... newPmProxies) {
        if (newPmProxies != null) {
            if (pmProxies == null) {
                pmProxies = new ArrayList<>(newPmProxies.length);
            }
            for (PmProxyBuilder builder : newPmProxies) {
                pmProxies.add(builder.build());
            }
        }
        return this;
    }
    
    
    public PowerManagementBuilder status(PowerManagementStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public PowerManagementBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public PowerManagementBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public PowerManagement build() {
        PowerManagementContainer container = new PowerManagementContainer();
        container.address(address);
        container.agents(agents);
        container.automaticPmEnabled(automaticPmEnabled);
        container.enabled(enabled);
        container.kdumpDetection(kdumpDetection);
        container.options(options);
        container.password(password);
        container.pmProxies(pmProxies);
        container.status(status);
        container.type(type);
        container.username(username);
        return container;
    }
}
