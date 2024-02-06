/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Dns;
import org.ovirt.engine.sdk4.types.Host;

public class DnsContainer extends Container implements Dns {
    private List<Host> searchDomains;
    private List<Host> servers;
    
    public List<Host> searchDomains() {
        return makeUnmodifiableList(searchDomains);
    }
    
    public void searchDomains(List<Host> newSearchDomains) {
        searchDomains = makeArrayList(newSearchDomains);
    }
    
    public boolean searchDomainsPresent() {
        return searchDomains != null && !searchDomains.isEmpty();
    }
    
    public List<Host> servers() {
        return makeUnmodifiableList(servers);
    }
    
    public void servers(List<Host> newServers) {
        servers = makeArrayList(newServers);
    }
    
    public boolean serversPresent() {
        return servers != null && !servers.isEmpty();
    }
    
}
