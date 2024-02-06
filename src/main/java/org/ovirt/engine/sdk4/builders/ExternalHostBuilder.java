/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalHostContainer;
import org.ovirt.engine.sdk4.types.ExternalHost;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalHostBuilder {
    private String address;
    private String comment;
    private String description;
    private ExternalHostProvider externalHostProvider;
    private String href;
    private String id;
    private String name;
    
    public ExternalHostBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public ExternalHostBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalHostBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalHostBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public ExternalHostBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public ExternalHostBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalHostBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalHostBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalHost build() {
        ExternalHostContainer container = new ExternalHostContainer();
        container.address(address);
        container.comment(comment);
        container.description(description);
        container.externalHostProvider(externalHostProvider);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
