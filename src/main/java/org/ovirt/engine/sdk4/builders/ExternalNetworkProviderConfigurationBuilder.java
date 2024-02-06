/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalNetworkProviderConfigurationContainer;
import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;
import org.ovirt.engine.sdk4.types.ExternalProvider;
import org.ovirt.engine.sdk4.types.Host;

public class ExternalNetworkProviderConfigurationBuilder {
    private String comment;
    private String description;
    private ExternalProvider externalNetworkProvider;
    private Host host;
    private String href;
    private String id;
    private String name;
    
    public ExternalNetworkProviderConfigurationBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder externalNetworkProvider(ExternalProvider newExternalNetworkProvider) {
        externalNetworkProvider = newExternalNetworkProvider;
        return this;
    }
    
    public ExternalNetworkProviderConfigurationBuilder externalNetworkProvider(ExternalProviderBuilder newExternalNetworkProvider) {
        if (newExternalNetworkProvider == null) {
            externalNetworkProvider = null;
        }
        else {
            externalNetworkProvider = newExternalNetworkProvider.build();
        }
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public ExternalNetworkProviderConfigurationBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalNetworkProviderConfigurationBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalNetworkProviderConfiguration build() {
        ExternalNetworkProviderConfigurationContainer container = new ExternalNetworkProviderConfigurationContainer();
        container.comment(comment);
        container.description(description);
        container.externalNetworkProvider(externalNetworkProvider);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
