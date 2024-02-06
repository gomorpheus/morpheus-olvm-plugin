/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.AgentConfiguration;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.NetworkPluginType;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProviderType;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;

public class OpenStackNetworkProviderContainer extends OpenStackProviderContainer implements OpenStackNetworkProvider {
    private AgentConfiguration agentConfiguration;
    private Boolean autoSync;
    private String externalPluginType;
    private NetworkPluginType pluginType;
    private String projectDomainName;
    private String projectName;
    private Boolean readOnly;
    private OpenStackNetworkProviderType type;
    private Boolean unmanaged;
    private String userDomainName;
    private List<Certificate> certificates;
    private List<OpenStackNetwork> networks;
    private List<OpenStackSubnet> subnets;
    
    public AgentConfiguration agentConfiguration() {
        return agentConfiguration;
    }
    
    public void agentConfiguration(AgentConfiguration newAgentConfiguration) {
        agentConfiguration = newAgentConfiguration;
    }
    
    public boolean agentConfigurationPresent() {
        return agentConfiguration != null;
    }
    
    public boolean autoSync() {
        return autoSync;
    }
    
    public void autoSync(boolean newAutoSync) {
        autoSync = Boolean.valueOf(newAutoSync);
    }
    
    public void autoSync(Boolean newAutoSync) {
        autoSync = newAutoSync;
    }
    
    public boolean autoSyncPresent() {
        return autoSync != null;
    }
    
    public String externalPluginType() {
        return externalPluginType;
    }
    
    public void externalPluginType(String newExternalPluginType) {
        externalPluginType = newExternalPluginType;
    }
    
    public boolean externalPluginTypePresent() {
        return externalPluginType != null;
    }
    
    public NetworkPluginType pluginType() {
        return pluginType;
    }
    
    public void pluginType(NetworkPluginType newPluginType) {
        pluginType = newPluginType;
    }
    
    public boolean pluginTypePresent() {
        return pluginType != null;
    }
    
    public String projectDomainName() {
        return projectDomainName;
    }
    
    public void projectDomainName(String newProjectDomainName) {
        projectDomainName = newProjectDomainName;
    }
    
    public boolean projectDomainNamePresent() {
        return projectDomainName != null;
    }
    
    public String projectName() {
        return projectName;
    }
    
    public void projectName(String newProjectName) {
        projectName = newProjectName;
    }
    
    public boolean projectNamePresent() {
        return projectName != null;
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
    
    public OpenStackNetworkProviderType type() {
        return type;
    }
    
    public void type(OpenStackNetworkProviderType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public boolean unmanaged() {
        return unmanaged;
    }
    
    public void unmanaged(boolean newUnmanaged) {
        unmanaged = Boolean.valueOf(newUnmanaged);
    }
    
    public void unmanaged(Boolean newUnmanaged) {
        unmanaged = newUnmanaged;
    }
    
    public boolean unmanagedPresent() {
        return unmanaged != null;
    }
    
    public String userDomainName() {
        return userDomainName;
    }
    
    public void userDomainName(String newUserDomainName) {
        userDomainName = newUserDomainName;
    }
    
    public boolean userDomainNamePresent() {
        return userDomainName != null;
    }
    
    public List<Certificate> certificates() {
        return makeUnmodifiableList(certificates);
    }
    
    public void certificates(List<Certificate> newCertificates) {
        certificates = makeArrayList(newCertificates);
    }
    
    public boolean certificatesPresent() {
        return certificates != null && !certificates.isEmpty();
    }
    
    public List<OpenStackNetwork> networks() {
        return makeUnmodifiableList(networks);
    }
    
    public void networks(List<OpenStackNetwork> newNetworks) {
        networks = makeArrayList(newNetworks);
    }
    
    public boolean networksPresent() {
        return networks != null && !networks.isEmpty();
    }
    
    public List<OpenStackSubnet> subnets() {
        return makeUnmodifiableList(subnets);
    }
    
    public void subnets(List<OpenStackSubnet> newSubnets) {
        subnets = makeArrayList(newSubnets);
    }
    
    public boolean subnetsPresent() {
        return subnets != null && !subnets.isEmpty();
    }
    
}
