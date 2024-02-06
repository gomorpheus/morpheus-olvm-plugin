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
import org.ovirt.engine.sdk4.internal.containers.OpenStackNetworkProviderContainer;
import org.ovirt.engine.sdk4.types.AgentConfiguration;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.NetworkPluginType;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProviderType;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackNetworkProviderBuilder {
    private AgentConfiguration agentConfiguration;
    private String authenticationUrl;
    private Boolean autoSync;
    private List<Certificate> certificates;
    private String comment;
    private String description;
    private String externalPluginType;
    private String href;
    private String id;
    private String name;
    private List<OpenStackNetwork> networks;
    private String password;
    private NetworkPluginType pluginType;
    private String projectDomainName;
    private String projectName;
    private List<Property> properties;
    private Boolean readOnly;
    private Boolean requiresAuthentication;
    private List<OpenStackSubnet> subnets;
    private String tenantName;
    private OpenStackNetworkProviderType type;
    private Boolean unmanaged;
    private String url;
    private String userDomainName;
    private String username;
    
    public OpenStackNetworkProviderBuilder agentConfiguration(AgentConfiguration newAgentConfiguration) {
        agentConfiguration = newAgentConfiguration;
        return this;
    }
    
    public OpenStackNetworkProviderBuilder agentConfiguration(AgentConfigurationBuilder newAgentConfiguration) {
        if (newAgentConfiguration == null) {
            agentConfiguration = null;
        }
        else {
            agentConfiguration = newAgentConfiguration.build();
        }
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder autoSync(boolean newAutoSync) {
        autoSync = Boolean.valueOf(newAutoSync);
        return this;
    }
    
    public OpenStackNetworkProviderBuilder autoSync(Boolean newAutoSync) {
        autoSync = newAutoSync;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder certificates(List<Certificate> newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates);
            }
            else {
                certificates.addAll(newCertificates);
            }
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder certificates(Certificate... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            Collections.addAll(certificates, newCertificates);
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder certificates(CertificateBuilder... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            for (CertificateBuilder builder : newCertificates) {
                certificates.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder externalPluginType(String newExternalPluginType) {
        externalPluginType = newExternalPluginType;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder networks(List<OpenStackNetwork> newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks);
            }
            else {
                networks.addAll(newNetworks);
            }
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder networks(OpenStackNetwork... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            Collections.addAll(networks, newNetworks);
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder networks(OpenStackNetworkBuilder... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            for (OpenStackNetworkBuilder builder : newNetworks) {
                networks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder pluginType(NetworkPluginType newPluginType) {
        pluginType = newPluginType;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder projectDomainName(String newProjectDomainName) {
        projectDomainName = newProjectDomainName;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder projectName(String newProjectName) {
        projectName = newProjectName;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
        return this;
    }
    
    public OpenStackNetworkProviderBuilder readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public OpenStackNetworkProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder subnets(List<OpenStackSubnet> newSubnets) {
        if (newSubnets != null) {
            if (subnets == null) {
                subnets = new ArrayList<>(newSubnets);
            }
            else {
                subnets.addAll(newSubnets);
            }
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder subnets(OpenStackSubnet... newSubnets) {
        if (newSubnets != null) {
            if (subnets == null) {
                subnets = new ArrayList<>(newSubnets.length);
            }
            Collections.addAll(subnets, newSubnets);
        }
        return this;
    }
    
    public OpenStackNetworkProviderBuilder subnets(OpenStackSubnetBuilder... newSubnets) {
        if (newSubnets != null) {
            if (subnets == null) {
                subnets = new ArrayList<>(newSubnets.length);
            }
            for (OpenStackSubnetBuilder builder : newSubnets) {
                subnets.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder tenantName(String newTenantName) {
        tenantName = newTenantName;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder type(OpenStackNetworkProviderType newType) {
        type = newType;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder unmanaged(boolean newUnmanaged) {
        unmanaged = Boolean.valueOf(newUnmanaged);
        return this;
    }
    
    public OpenStackNetworkProviderBuilder unmanaged(Boolean newUnmanaged) {
        unmanaged = newUnmanaged;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder userDomainName(String newUserDomainName) {
        userDomainName = newUserDomainName;
        return this;
    }
    
    
    public OpenStackNetworkProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public OpenStackNetworkProvider build() {
        OpenStackNetworkProviderContainer container = new OpenStackNetworkProviderContainer();
        container.agentConfiguration(agentConfiguration);
        container.authenticationUrl(authenticationUrl);
        container.autoSync(autoSync);
        container.certificates(certificates);
        container.comment(comment);
        container.description(description);
        container.externalPluginType(externalPluginType);
        container.href(href);
        container.id(id);
        container.name(name);
        container.networks(networks);
        container.password(password);
        container.pluginType(pluginType);
        container.projectDomainName(projectDomainName);
        container.projectName(projectName);
        container.properties(properties);
        container.readOnly(readOnly);
        container.requiresAuthentication(requiresAuthentication);
        container.subnets(subnets);
        container.tenantName(tenantName);
        container.type(type);
        container.unmanaged(unmanaged);
        container.url(url);
        container.userDomainName(userDomainName);
        container.username(username);
        return container;
    }
}
