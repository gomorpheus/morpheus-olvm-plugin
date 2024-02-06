/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;

public class OpenStackSubnetContainer extends IdentifiedContainer implements OpenStackSubnet {
    private String cidr;
    private List<String> dnsServers;
    private String gateway;
    private String ipVersion;
    private OpenStackNetwork openstackNetwork;
    
    public String cidr() {
        return cidr;
    }
    
    public void cidr(String newCidr) {
        cidr = newCidr;
    }
    
    public boolean cidrPresent() {
        return cidr != null;
    }
    
    public List<String> dnsServers() {
        return makeUnmodifiableList(dnsServers);
    }
    
    public void dnsServers(List<String> newDnsServers) {
        dnsServers = makeArrayList(newDnsServers);
    }
    
    public boolean dnsServersPresent() {
        return dnsServers != null && !dnsServers.isEmpty();
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
    
    public String ipVersion() {
        return ipVersion;
    }
    
    public void ipVersion(String newIpVersion) {
        ipVersion = newIpVersion;
    }
    
    public boolean ipVersionPresent() {
        return ipVersion != null;
    }
    
    public OpenStackNetwork openstackNetwork() {
        return openstackNetwork;
    }
    
    public void openstackNetwork(OpenStackNetwork newOpenstackNetwork) {
        openstackNetwork = newOpenstackNetwork;
    }
    
    public boolean openstackNetworkPresent() {
        return openstackNetwork != null;
    }
    
}
