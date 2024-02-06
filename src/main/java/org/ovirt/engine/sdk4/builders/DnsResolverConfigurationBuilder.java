/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DnsResolverConfigurationContainer;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;

public class DnsResolverConfigurationBuilder {
    private List<String> nameServers;
    
    public DnsResolverConfigurationBuilder nameServers(List<String> newNameServers) {
        if (newNameServers != null) {
            if (nameServers == null) {
                nameServers = new ArrayList<>(newNameServers);
            }
            else {
                nameServers.addAll(newNameServers);
            }
        }
        return this;
    }
    
    public DnsResolverConfigurationBuilder nameServers(String... newNameServers) {
        if (newNameServers != null) {
            if (nameServers == null) {
                nameServers = new ArrayList<>(newNameServers.length);
            }
            Collections.addAll(nameServers, newNameServers);
        }
        return this;
    }
    
    
    public DnsResolverConfiguration build() {
        DnsResolverConfigurationContainer container = new DnsResolverConfigurationContainer();
        container.nameServers(nameServers);
        return container;
    }
}
