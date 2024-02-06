/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.UnmanagedNetwork;

public class UnmanagedNetworkContainer extends IdentifiedContainer implements UnmanagedNetwork {
    private Host host;
    private HostNic hostNic;
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public HostNic hostNic() {
        return hostNic;
    }
    
    public void hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
    }
    
    public boolean hostNicPresent() {
        return hostNic != null;
    }
    
}
