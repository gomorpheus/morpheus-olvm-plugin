/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Hook;
import org.ovirt.engine.sdk4.types.Host;

public class HookContainer extends IdentifiedContainer implements Hook {
    private String eventName;
    private String md5;
    private Host host;
    
    public String eventName() {
        return eventName;
    }
    
    public void eventName(String newEventName) {
        eventName = newEventName;
    }
    
    public boolean eventNamePresent() {
        return eventName != null;
    }
    
    public String md5() {
        return md5;
    }
    
    public void md5(String newMd5) {
        md5 = newMd5;
    }
    
    public boolean md5Present() {
        return md5 != null;
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
