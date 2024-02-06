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
import org.ovirt.engine.sdk4.internal.containers.OpenStackProviderContainer;
import org.ovirt.engine.sdk4.types.OpenStackProvider;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackProviderBuilder {
    private String authenticationUrl;
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String tenantName;
    private String url;
    private String username;
    
    public OpenStackProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public OpenStackProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public OpenStackProviderBuilder properties(List<Property> newProperties) {
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
    
    public OpenStackProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public OpenStackProviderBuilder properties(PropertyBuilder... newProperties) {
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
    
    
    public OpenStackProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public OpenStackProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public OpenStackProviderBuilder tenantName(String newTenantName) {
        tenantName = newTenantName;
        return this;
    }
    
    
    public OpenStackProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public OpenStackProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public OpenStackProvider build() {
        OpenStackProviderContainer container = new OpenStackProviderContainer();
        container.authenticationUrl(authenticationUrl);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.password(password);
        container.properties(properties);
        container.requiresAuthentication(requiresAuthentication);
        container.tenantName(tenantName);
        container.url(url);
        container.username(username);
        return container;
    }
}
