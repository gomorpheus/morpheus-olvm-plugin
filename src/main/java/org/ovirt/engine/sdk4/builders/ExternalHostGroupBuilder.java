/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalHostGroupContainer;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalHostGroupBuilder {
    private String architectureName;
    private String comment;
    private String description;
    private String domainName;
    private ExternalHostProvider externalHostProvider;
    private String href;
    private String id;
    private String name;
    private String operatingSystemName;
    private String subnetName;
    
    public ExternalHostGroupBuilder architectureName(String newArchitectureName) {
        architectureName = newArchitectureName;
        return this;
    }
    
    
    public ExternalHostGroupBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalHostGroupBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalHostGroupBuilder domainName(String newDomainName) {
        domainName = newDomainName;
        return this;
    }
    
    
    public ExternalHostGroupBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public ExternalHostGroupBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public ExternalHostGroupBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalHostGroupBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalHostGroupBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalHostGroupBuilder operatingSystemName(String newOperatingSystemName) {
        operatingSystemName = newOperatingSystemName;
        return this;
    }
    
    
    public ExternalHostGroupBuilder subnetName(String newSubnetName) {
        subnetName = newSubnetName;
        return this;
    }
    
    
    public ExternalHostGroup build() {
        ExternalHostGroupContainer container = new ExternalHostGroupContainer();
        container.architectureName(architectureName);
        container.comment(comment);
        container.description(description);
        container.domainName(domainName);
        container.externalHostProvider(externalHostProvider);
        container.href(href);
        container.id(id);
        container.name(name);
        container.operatingSystemName(operatingSystemName);
        container.subnetName(subnetName);
        return container;
    }
}
