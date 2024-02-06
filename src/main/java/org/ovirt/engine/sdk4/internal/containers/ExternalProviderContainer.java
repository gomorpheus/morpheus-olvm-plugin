/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.ExternalProvider;
import org.ovirt.engine.sdk4.types.Property;

public class ExternalProviderContainer extends IdentifiedContainer implements ExternalProvider {
    private String authenticationUrl;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String url;
    private String username;
    
    public String authenticationUrl() {
        return authenticationUrl;
    }
    
    public void authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
    }
    
    public boolean authenticationUrlPresent() {
        return authenticationUrl != null;
    }
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public List<Property> properties() {
        return makeUnmodifiableList(properties);
    }
    
    public void properties(List<Property> newProperties) {
        properties = makeArrayList(newProperties);
    }
    
    public boolean propertiesPresent() {
        return properties != null && !properties.isEmpty();
    }
    
    public boolean requiresAuthentication() {
        return requiresAuthentication;
    }
    
    public void requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
    }
    
    public void requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
    }
    
    public boolean requiresAuthenticationPresent() {
        return requiresAuthentication != null;
    }
    
    public String url() {
        return url;
    }
    
    public void url(String newUrl) {
        url = newUrl;
    }
    
    public boolean urlPresent() {
        return url != null;
    }
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
}
