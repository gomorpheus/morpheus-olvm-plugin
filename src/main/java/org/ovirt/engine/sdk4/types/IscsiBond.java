/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface IscsiBond extends Identified {
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    List<Network> networks();
    
    boolean networksPresent();
    
    List<StorageConnection> storageConnections();
    
    boolean storageConnectionsPresent();
    
}
