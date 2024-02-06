/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface OpenStackNetworkProvider extends OpenStackProvider {
    AgentConfiguration agentConfiguration();
    
    boolean agentConfigurationPresent();
    
    boolean autoSync();
    
    boolean autoSyncPresent();
    
    String externalPluginType();
    
    boolean externalPluginTypePresent();
    
    NetworkPluginType pluginType();
    
    boolean pluginTypePresent();
    
    String projectDomainName();
    
    boolean projectDomainNamePresent();
    
    String projectName();
    
    boolean projectNamePresent();
    
    boolean readOnly();
    
    boolean readOnlyPresent();
    
    OpenStackNetworkProviderType type();
    
    boolean typePresent();
    
    boolean unmanaged();
    
    boolean unmanagedPresent();
    
    String userDomainName();
    
    boolean userDomainNamePresent();
    
    List<Certificate> certificates();
    
    boolean certificatesPresent();
    
    List<OpenStackNetwork> networks();
    
    boolean networksPresent();
    
    List<OpenStackSubnet> subnets();
    
    boolean subnetsPresent();
    
}
