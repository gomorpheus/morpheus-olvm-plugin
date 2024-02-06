/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.IscsiBond;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.StorageConnection;

public class IscsiBondContainer extends IdentifiedContainer implements IscsiBond {
    private DataCenter dataCenter;
    private List<Network> networks;
    private List<StorageConnection> storageConnections;
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public List<Network> networks() {
        return makeUnmodifiableList(networks);
    }
    
    public void networks(List<Network> newNetworks) {
        networks = makeArrayList(newNetworks);
    }
    
    public boolean networksPresent() {
        return networks != null && !networks.isEmpty();
    }
    
    public List<StorageConnection> storageConnections() {
        return makeUnmodifiableList(storageConnections);
    }
    
    public void storageConnections(List<StorageConnection> newStorageConnections) {
        storageConnections = makeArrayList(newStorageConnections);
    }
    
    public boolean storageConnectionsPresent() {
        return storageConnections != null && !storageConnections.isEmpty();
    }
    
}
