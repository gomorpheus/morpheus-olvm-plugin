/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;

public class OpenStackNetworkContainer extends IdentifiedContainer implements OpenStackNetwork {
    private OpenStackNetworkProvider openstackNetworkProvider;
    
    public OpenStackNetworkProvider openstackNetworkProvider() {
        return openstackNetworkProvider;
    }
    
    public void openstackNetworkProvider(OpenStackNetworkProvider newOpenstackNetworkProvider) {
        openstackNetworkProvider = newOpenstackNetworkProvider;
    }
    
    public boolean openstackNetworkProviderPresent() {
        return openstackNetworkProvider != null;
    }
    
}
