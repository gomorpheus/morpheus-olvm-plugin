/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DnsContainer;
import org.ovirt.engine.sdk4.types.Dns;
import org.ovirt.engine.sdk4.types.Host;

public class DnsBuilder {
    private List<Host> searchDomains;
    private List<Host> servers;
    
    public DnsBuilder searchDomains(List<Host> newSearchDomains) {
        if (newSearchDomains != null) {
            if (searchDomains == null) {
                searchDomains = new ArrayList<>(newSearchDomains);
            }
            else {
                searchDomains.addAll(newSearchDomains);
            }
        }
        return this;
    }
    
    public DnsBuilder searchDomains(Host... newSearchDomains) {
        if (newSearchDomains != null) {
            if (searchDomains == null) {
                searchDomains = new ArrayList<>(newSearchDomains.length);
            }
            Collections.addAll(searchDomains, newSearchDomains);
        }
        return this;
    }
    
    public DnsBuilder searchDomains(HostBuilder... newSearchDomains) {
        if (newSearchDomains != null) {
            if (searchDomains == null) {
                searchDomains = new ArrayList<>(newSearchDomains.length);
            }
            for (HostBuilder builder : newSearchDomains) {
                searchDomains.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DnsBuilder servers(List<Host> newServers) {
        if (newServers != null) {
            if (servers == null) {
                servers = new ArrayList<>(newServers);
            }
            else {
                servers.addAll(newServers);
            }
        }
        return this;
    }
    
    public DnsBuilder servers(Host... newServers) {
        if (newServers != null) {
            if (servers == null) {
                servers = new ArrayList<>(newServers.length);
            }
            Collections.addAll(servers, newServers);
        }
        return this;
    }
    
    public DnsBuilder servers(HostBuilder... newServers) {
        if (newServers != null) {
            if (servers == null) {
                servers = new ArrayList<>(newServers.length);
            }
            for (HostBuilder builder : newServers) {
                servers.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Dns build() {
        DnsContainer container = new DnsContainer();
        container.searchDomains(searchDomains);
        container.servers(servers);
        return container;
    }
}
