/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Session;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class SessionContainer extends IdentifiedContainer implements Session {
    private Boolean consoleUser;
    private Ip ip;
    private String protocol;
    private User user;
    private Vm vm;
    
    public boolean consoleUser() {
        return consoleUser;
    }
    
    public void consoleUser(boolean newConsoleUser) {
        consoleUser = Boolean.valueOf(newConsoleUser);
    }
    
    public void consoleUser(Boolean newConsoleUser) {
        consoleUser = newConsoleUser;
    }
    
    public boolean consoleUserPresent() {
        return consoleUser != null;
    }
    
    public Ip ip() {
        return ip;
    }
    
    public void ip(Ip newIp) {
        ip = newIp;
    }
    
    public boolean ipPresent() {
        return ip != null;
    }
    
    public String protocol() {
        return protocol;
    }
    
    public void protocol(String newProtocol) {
        protocol = newProtocol;
    }
    
    public boolean protocolPresent() {
        return protocol != null;
    }
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
