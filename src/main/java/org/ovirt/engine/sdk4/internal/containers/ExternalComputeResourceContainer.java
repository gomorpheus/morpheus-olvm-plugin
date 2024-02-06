/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ExternalComputeResource;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalComputeResourceContainer extends IdentifiedContainer implements ExternalComputeResource {
    private String provider;
    private String url;
    private String user;
    private ExternalHostProvider externalHostProvider;
    
    public String provider() {
        return provider;
    }
    
    public void provider(String newProvider) {
        provider = newProvider;
    }
    
    public boolean providerPresent() {
        return provider != null;
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
    
    public String user() {
        return user;
    }
    
    public void user(String newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
    public ExternalHostProvider externalHostProvider() {
        return externalHostProvider;
    }
    
    public void externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
    }
    
    public boolean externalHostProviderPresent() {
        return externalHostProvider != null;
    }
    
}
