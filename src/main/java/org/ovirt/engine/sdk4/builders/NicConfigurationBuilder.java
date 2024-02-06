/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.NicConfigurationContainer;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.NicConfiguration;

public class NicConfigurationBuilder {
    private BootProtocol bootProtocol;
    private Ip ip;
    private Ip ipv6;
    private BootProtocol ipv6BootProtocol;
    private String name;
    private Boolean onBoot;
    
    public NicConfigurationBuilder bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
        return this;
    }
    
    
    public NicConfigurationBuilder ip(Ip newIp) {
        ip = newIp;
        return this;
    }
    
    public NicConfigurationBuilder ip(IpBuilder newIp) {
        if (newIp == null) {
            ip = null;
        }
        else {
            ip = newIp.build();
        }
        return this;
    }
    
    
    public NicConfigurationBuilder ipv6(Ip newIpv6) {
        ipv6 = newIpv6;
        return this;
    }
    
    public NicConfigurationBuilder ipv6(IpBuilder newIpv6) {
        if (newIpv6 == null) {
            ipv6 = null;
        }
        else {
            ipv6 = newIpv6.build();
        }
        return this;
    }
    
    
    public NicConfigurationBuilder ipv6BootProtocol(BootProtocol newIpv6BootProtocol) {
        ipv6BootProtocol = newIpv6BootProtocol;
        return this;
    }
    
    
    public NicConfigurationBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NicConfigurationBuilder onBoot(boolean newOnBoot) {
        onBoot = Boolean.valueOf(newOnBoot);
        return this;
    }
    
    public NicConfigurationBuilder onBoot(Boolean newOnBoot) {
        onBoot = newOnBoot;
        return this;
    }
    
    
    public NicConfiguration build() {
        NicConfigurationContainer container = new NicConfigurationContainer();
        container.bootProtocol(bootProtocol);
        container.ip(ip);
        container.ipv6(ipv6);
        container.ipv6BootProtocol(ipv6BootProtocol);
        container.name(name);
        container.onBoot(onBoot);
        return container;
    }
}
