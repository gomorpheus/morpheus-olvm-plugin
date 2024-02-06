/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.ExternalNetworkProviderConfiguration;
import org.ovirt.engine.sdk4.types.ExternalProvider;
import org.ovirt.engine.sdk4.types.Host;

public class ExternalNetworkProviderConfigurationContainer extends IdentifiedContainer implements ExternalNetworkProviderConfiguration {
    private ExternalProvider externalNetworkProvider;
    private Host host;
    
    public ExternalProvider externalNetworkProvider() {
        return externalNetworkProvider;
    }
    
    public void externalNetworkProvider(ExternalProvider newExternalNetworkProvider) {
        externalNetworkProvider = newExternalNetworkProvider;
    }
    
    public boolean externalNetworkProviderPresent() {
        return externalNetworkProvider != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
}
