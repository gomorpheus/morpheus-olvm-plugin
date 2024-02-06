/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * Represents the DNS resolver configuration.
 */
public interface DnsResolverConfiguration {
    List<String> nameServers();
    
    boolean nameServersPresent();
    
}
