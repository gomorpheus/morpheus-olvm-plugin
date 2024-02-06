/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.IpContainer;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.IpVersion;

public class IpBuilder {
    private String address;
    private String gateway;
    private String netmask;
    private IpVersion version;
    
    public IpBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public IpBuilder gateway(String newGateway) {
        gateway = newGateway;
        return this;
    }
    
    
    public IpBuilder netmask(String newNetmask) {
        netmask = newNetmask;
        return this;
    }
    
    
    public IpBuilder version(IpVersion newVersion) {
        version = newVersion;
        return this;
    }
    
    
    public Ip build() {
        IpContainer container = new IpContainer();
        container.address(address);
        container.gateway(gateway);
        container.netmask(netmask);
        container.version(version);
        return container;
    }
}
