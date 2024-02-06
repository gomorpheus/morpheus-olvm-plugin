/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.OpenStackSubnetContainer;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;
import org.ovirt.engine.sdk4.types.OpenStackSubnet;

public class OpenStackSubnetBuilder {
    private String cidr;
    private String comment;
    private String description;
    private List<String> dnsServers;
    private String gateway;
    private String href;
    private String id;
    private String ipVersion;
    private String name;
    private OpenStackNetwork openstackNetwork;
    
    public OpenStackSubnetBuilder cidr(String newCidr) {
        cidr = newCidr;
        return this;
    }
    
    
    public OpenStackSubnetBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackSubnetBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackSubnetBuilder dnsServers(List<String> newDnsServers) {
        if (newDnsServers != null) {
            if (dnsServers == null) {
                dnsServers = new ArrayList<>(newDnsServers);
            }
            else {
                dnsServers.addAll(newDnsServers);
            }
        }
        return this;
    }
    
    public OpenStackSubnetBuilder dnsServers(String... newDnsServers) {
        if (newDnsServers != null) {
            if (dnsServers == null) {
                dnsServers = new ArrayList<>(newDnsServers.length);
            }
            Collections.addAll(dnsServers, newDnsServers);
        }
        return this;
    }
    
    
    public OpenStackSubnetBuilder gateway(String newGateway) {
        gateway = newGateway;
        return this;
    }
    
    
    public OpenStackSubnetBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackSubnetBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackSubnetBuilder ipVersion(String newIpVersion) {
        ipVersion = newIpVersion;
        return this;
    }
    
    
    public OpenStackSubnetBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackSubnetBuilder openstackNetwork(OpenStackNetwork newOpenstackNetwork) {
        openstackNetwork = newOpenstackNetwork;
        return this;
    }
    
    public OpenStackSubnetBuilder openstackNetwork(OpenStackNetworkBuilder newOpenstackNetwork) {
        if (newOpenstackNetwork == null) {
            openstackNetwork = null;
        }
        else {
            openstackNetwork = newOpenstackNetwork.build();
        }
        return this;
    }
    
    
    public OpenStackSubnet build() {
        OpenStackSubnetContainer container = new OpenStackSubnetContainer();
        container.cidr(cidr);
        container.comment(comment);
        container.description(description);
        container.dnsServers(dnsServers);
        container.gateway(gateway);
        container.href(href);
        container.id(id);
        container.ipVersion(ipVersion);
        container.name(name);
        container.openstackNetwork(openstackNetwork);
        return container;
    }
}
