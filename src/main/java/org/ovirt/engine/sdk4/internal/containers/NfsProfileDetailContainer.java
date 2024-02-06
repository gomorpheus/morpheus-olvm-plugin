/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.NfsProfileDetail;

public class NfsProfileDetailContainer extends EntityProfileDetailContainer implements NfsProfileDetail {
    private String nfsServerIp;
    
    public String nfsServerIp() {
        return nfsServerIp;
    }
    
    public void nfsServerIp(String newNfsServerIp) {
        nfsServerIp = newNfsServerIp;
    }
    
    public boolean nfsServerIpPresent() {
        return nfsServerIp != null;
    }
    
}
