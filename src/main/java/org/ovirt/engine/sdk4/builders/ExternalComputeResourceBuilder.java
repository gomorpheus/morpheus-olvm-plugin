/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalComputeResourceContainer;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalComputeResourceBuilder {
    private String comment;
    private String description;
    private ExternalHostProvider externalHostProvider;
    private String href;
    private String id;
    private String name;
    private String provider;
    private String url;
    private String user;
    
    public ExternalComputeResourceBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
        return this;
    }
    
    public ExternalComputeResourceBuilder externalHostProvider(ExternalHostProviderBuilder newExternalHostProvider) {
        if (newExternalHostProvider == null) {
            externalHostProvider = null;
        }
        else {
            externalHostProvider = newExternalHostProvider.build();
        }
        return this;
    }
    
    
    public ExternalComputeResourceBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder provider(String newProvider) {
        provider = newProvider;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public ExternalComputeResourceBuilder user(String newUser) {
        user = newUser;
        return this;
    }
    
    
    public ExternalComputeResource build() {
        ExternalComputeResourceContainer container = new ExternalComputeResourceContainer();
        container.comment(comment);
        container.description(description);
        container.externalHostProvider(externalHostProvider);
        container.href(href);
        container.id(id);
        container.name(name);
        container.provider(provider);
        container.url(url);
        container.user(user);
        return container;
    }
}
