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
import org.ovirt.engine.sdk4.internal.containers.ExternalHostProviderContainer;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Property;

public class ExternalHostProviderBuilder {
    private String authenticationUrl;
    private List<Certificate> certificates;
    private String comment;
    private List<ExternalComputeResource> computeResources;
    private String description;
    private List<ExternalDiscoveredHost> discoveredHosts;
    private List<ExternalHostGroup> hostGroups;
    private List<Host> hosts;
    private String href;
    private String id;
    private String name;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String url;
    private String username;
    
    public ExternalHostProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public ExternalHostProviderBuilder certificates(List<Certificate> newCertificates) {
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
    
    public ExternalHostProviderBuilder certificates(Certificate... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            Collections.addAll(certificates, newCertificates);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder certificates(CertificateBuilder... newCertificates) {
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
    
    
    public ExternalHostProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalHostProviderBuilder computeResources(List<ExternalComputeResource> newComputeResources) {
        if (newComputeResources != null) {
            if (computeResources == null) {
                computeResources = new ArrayList<>(newComputeResources);
            }
            else {
                computeResources.addAll(newComputeResources);
            }
        }
        return this;
    }
    
    public ExternalHostProviderBuilder computeResources(ExternalComputeResource... newComputeResources) {
        if (newComputeResources != null) {
            if (computeResources == null) {
                computeResources = new ArrayList<>(newComputeResources.length);
            }
            Collections.addAll(computeResources, newComputeResources);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder computeResources(ExternalComputeResourceBuilder... newComputeResources) {
        if (newComputeResources != null) {
            if (computeResources == null) {
                computeResources = new ArrayList<>(newComputeResources.length);
            }
            for (ExternalComputeResourceBuilder builder : newComputeResources) {
                computeResources.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ExternalHostProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalHostProviderBuilder discoveredHosts(List<ExternalDiscoveredHost> newDiscoveredHosts) {
        if (newDiscoveredHosts != null) {
            if (discoveredHosts == null) {
                discoveredHosts = new ArrayList<>(newDiscoveredHosts);
            }
            else {
                discoveredHosts.addAll(newDiscoveredHosts);
            }
        }
        return this;
    }
    
    public ExternalHostProviderBuilder discoveredHosts(ExternalDiscoveredHost... newDiscoveredHosts) {
        if (newDiscoveredHosts != null) {
            if (discoveredHosts == null) {
                discoveredHosts = new ArrayList<>(newDiscoveredHosts.length);
            }
            Collections.addAll(discoveredHosts, newDiscoveredHosts);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder discoveredHosts(ExternalDiscoveredHostBuilder... newDiscoveredHosts) {
        if (newDiscoveredHosts != null) {
            if (discoveredHosts == null) {
                discoveredHosts = new ArrayList<>(newDiscoveredHosts.length);
            }
            for (ExternalDiscoveredHostBuilder builder : newDiscoveredHosts) {
                discoveredHosts.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ExternalHostProviderBuilder hostGroups(List<ExternalHostGroup> newHostGroups) {
        if (newHostGroups != null) {
            if (hostGroups == null) {
                hostGroups = new ArrayList<>(newHostGroups);
            }
            else {
                hostGroups.addAll(newHostGroups);
            }
        }
        return this;
    }
    
    public ExternalHostProviderBuilder hostGroups(ExternalHostGroup... newHostGroups) {
        if (newHostGroups != null) {
            if (hostGroups == null) {
                hostGroups = new ArrayList<>(newHostGroups.length);
            }
            Collections.addAll(hostGroups, newHostGroups);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder hostGroups(ExternalHostGroupBuilder... newHostGroups) {
        if (newHostGroups != null) {
            if (hostGroups == null) {
                hostGroups = new ArrayList<>(newHostGroups.length);
            }
            for (ExternalHostGroupBuilder builder : newHostGroups) {
                hostGroups.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ExternalHostProviderBuilder hosts(List<Host> newHosts) {
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
    
    public ExternalHostProviderBuilder hosts(Host... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            Collections.addAll(hosts, newHosts);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder hosts(HostBuilder... newHosts) {
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
    
    
    public ExternalHostProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalHostProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalHostProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalHostProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public ExternalHostProviderBuilder properties(List<Property> newProperties) {
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
    
    public ExternalHostProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public ExternalHostProviderBuilder properties(PropertyBuilder... newProperties) {
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
    
    
    public ExternalHostProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public ExternalHostProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public ExternalHostProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public ExternalHostProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public ExternalHostProvider build() {
        ExternalHostProviderContainer container = new ExternalHostProviderContainer();
        container.authenticationUrl(authenticationUrl);
        container.certificates(certificates);
        container.comment(comment);
        container.computeResources(computeResources);
        container.description(description);
        container.discoveredHosts(discoveredHosts);
        container.hostGroups(hostGroups);
        container.hosts(hosts);
        container.href(href);
        container.id(id);
        container.name(name);
        container.password(password);
        container.properties(properties);
        container.requiresAuthentication(requiresAuthentication);
        container.url(url);
        container.username(username);
        return container;
    }
}
