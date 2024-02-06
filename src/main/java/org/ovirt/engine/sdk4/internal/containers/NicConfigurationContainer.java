/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.NicConfiguration;

public class NicConfigurationContainer extends Container implements NicConfiguration {
    private BootProtocol bootProtocol;
    private Ip ip;
    private Ip ipv6;
    private BootProtocol ipv6BootProtocol;
    private String name;
    private Boolean onBoot;
    
    public BootProtocol bootProtocol() {
        return bootProtocol;
    }
    
    public void bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
    }
    
    public boolean bootProtocolPresent() {
        return bootProtocol != null;
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
    
    public Ip ipv6() {
        return ipv6;
    }
    
    public void ipv6(Ip newIpv6) {
        ipv6 = newIpv6;
    }
    
    public boolean ipv6Present() {
        return ipv6 != null;
    }
    
    public BootProtocol ipv6BootProtocol() {
        return ipv6BootProtocol;
    }
    
    public void ipv6BootProtocol(BootProtocol newIpv6BootProtocol) {
        ipv6BootProtocol = newIpv6BootProtocol;
    }
    
    public boolean ipv6BootProtocolPresent() {
        return ipv6BootProtocol != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
    public boolean onBoot() {
        return onBoot;
    }
    
    public void onBoot(boolean newOnBoot) {
        onBoot = Boolean.valueOf(newOnBoot);
    }
    
    public void onBoot(Boolean newOnBoot) {
        onBoot = newOnBoot;
    }
    
    public boolean onBootPresent() {
        return onBoot != null;
    }
    
}
