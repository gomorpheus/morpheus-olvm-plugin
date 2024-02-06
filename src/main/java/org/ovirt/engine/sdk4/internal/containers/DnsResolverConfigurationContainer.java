/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;

public class DnsResolverConfigurationContainer extends Container implements DnsResolverConfiguration {
    private List<String> nameServers;
    
    public List<String> nameServers() {
        return makeUnmodifiableList(nameServers);
    }
    
    public void nameServers(List<String> newNameServers) {
        nameServers = makeArrayList(newNameServers);
    }
    
    public boolean nameServersPresent() {
        return nameServers != null && !nameServers.isEmpty();
    }
    
}
