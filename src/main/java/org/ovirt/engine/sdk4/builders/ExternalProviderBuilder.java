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
import org.ovirt.engine.sdk4.internal.containers.ExternalProviderContainer;
import org.ovirt.engine.sdk4.types.ExternalProvider;
import org.ovirt.engine.sdk4.types.Property;

public class ExternalProviderBuilder {
    private String authenticationUrl;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String url;
    private String username;
    
    public ExternalProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public ExternalProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ExternalProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ExternalProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ExternalProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ExternalProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public ExternalProviderBuilder properties(List<Property> newProperties) {
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
    
    public ExternalProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public ExternalProviderBuilder properties(PropertyBuilder... newProperties) {
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
    
    
    public ExternalProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public ExternalProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public ExternalProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public ExternalProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public ExternalProvider build() {
        ExternalProviderContainer container = new ExternalProviderContainer();
        container.authenticationUrl(authenticationUrl);
        container.comment(comment);
        container.description(description);
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
