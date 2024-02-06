/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.Option;
import org.ovirt.engine.sdk4.types.PmProxy;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.PowerManagementStatus;

public class PowerManagementContainer extends Container implements PowerManagement {
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
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public List<Agent> agents() {
        return makeUnmodifiableList(agents);
    }
    
    public void agents(List<Agent> newAgents) {
        agents = makeArrayList(newAgents);
    }
    
    public boolean agentsPresent() {
        return agents != null && !agents.isEmpty();
    }
    
    public boolean automaticPmEnabled() {
        return automaticPmEnabled;
    }
    
    public void automaticPmEnabled(boolean newAutomaticPmEnabled) {
        automaticPmEnabled = Boolean.valueOf(newAutomaticPmEnabled);
    }
    
    public void automaticPmEnabled(Boolean newAutomaticPmEnabled) {
        automaticPmEnabled = newAutomaticPmEnabled;
    }
    
    public boolean automaticPmEnabledPresent() {
        return automaticPmEnabled != null;
    }
    
    public boolean enabled() {
        return enabled;
    }
    
    public void enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
    }
    
    public void enabled(Boolean newEnabled) {
        enabled = newEnabled;
    }
    
    public boolean enabledPresent() {
        return enabled != null;
    }
    
    public boolean kdumpDetection() {
        return kdumpDetection;
    }
    
    public void kdumpDetection(boolean newKdumpDetection) {
        kdumpDetection = Boolean.valueOf(newKdumpDetection);
    }
    
    public void kdumpDetection(Boolean newKdumpDetection) {
        kdumpDetection = newKdumpDetection;
    }
    
    public boolean kdumpDetectionPresent() {
        return kdumpDetection != null;
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
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public List<PmProxy> pmProxies() {
        return makeUnmodifiableList(pmProxies);
    }
    
    public void pmProxies(List<PmProxy> newPmProxies) {
        pmProxies = makeArrayList(newPmProxies);
    }
    
    public boolean pmProxiesPresent() {
        return pmProxies != null && !pmProxies.isEmpty();
    }
    
    public PowerManagementStatus status() {
        return status;
    }
    
    public void status(PowerManagementStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
}
