/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.IpVersion;

public class IpContainer extends Container implements Ip {
    private String address;
    private String gateway;
    private String netmask;
    private IpVersion version;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public String gateway() {
        return gateway;
    }
    
    public void gateway(String newGateway) {
        gateway = newGateway;
    }
    
    public boolean gatewayPresent() {
        return gateway != null;
    }
    
    public String netmask() {
        return netmask;
    }
    
    public void netmask(String newNetmask) {
        netmask = newNetmask;
    }
    
    public boolean netmaskPresent() {
        return netmask != null;
    }
    
    public IpVersion version() {
        return version;
    }
    
    public void version(IpVersion newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
}
