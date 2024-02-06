/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkLabel;

public class NetworkLabelContainer extends IdentifiedContainer implements NetworkLabel {
    private HostNic hostNic;
    private Network network;
    
    public HostNic hostNic() {
        return hostNic;
    }
    
    public void hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
    }
    
    public boolean hostNicPresent() {
        return hostNic != null;
    }
    
    public Network network() {
        return network;
    }
    
    public void network(Network newNetwork) {
        network = newNetwork;
    }
    
    public boolean networkPresent() {
        return network != null;
    }
    
}
