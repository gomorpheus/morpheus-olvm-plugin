/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface OpenStackSubnet extends Identified {
    String cidr();
    
    boolean cidrPresent();
    
    List<String> dnsServers();
    
    boolean dnsServersPresent();
    
    String gateway();
    
    boolean gatewayPresent();
    
    String ipVersion();
    
    boolean ipVersionPresent();
    
    OpenStackNetwork openstackNetwork();
    
    boolean openstackNetworkPresent();
    
}
