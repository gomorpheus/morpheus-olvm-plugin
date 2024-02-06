/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.StorageConnectionExtension;

public class StorageConnectionExtensionContainer extends IdentifiedContainer implements StorageConnectionExtension {
    private String password;
    private String target;
    private String username;
    private Host host;
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public String target() {
        return target;
    }
    
    public void target(String newTarget) {
        target = newTarget;
    }
    
    public boolean targetPresent() {
        return target != null;
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
