/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalDiscoveredHostContainer;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalDiscoveredHostBuilder {
    private String comment;
    private String description;
    private ExternalHostProvider externalHostProvider;
    private String href;
    private String id;
    private String ip;
    private String lastReport;
    private String mac;
    private String name;
    private String subnetName;
    
    public ExternalDiscoveredHostBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public ExternalDiscoveredHostBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder ip(String newIp) {
        ip = newIp;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder lastReport(String newLastReport) {
        lastReport = newLastReport;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder mac(String newMac) {
        mac = newMac;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalDiscoveredHostBuilder subnetName(String newSubnetName) {
        subnetName = newSubnetName;
        return this;
    }
    
    
    public ExternalDiscoveredHost build() {
        ExternalDiscoveredHostContainer container = new ExternalDiscoveredHostContainer();
        container.comment(comment);
        container.description(description);
        container.externalHostProvider(externalHostProvider);
        container.href(href);
        container.id(id);
        container.ip(ip);
        container.lastReport(lastReport);
        container.mac(mac);
        container.name(name);
        container.subnetName(subnetName);
        return container;
    }
}
