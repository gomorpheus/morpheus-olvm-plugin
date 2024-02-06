/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents the DNS resolver configuration.
 */
public interface Dns {
    List<Host> searchDomains();
    
    boolean searchDomainsPresent();
    
    List<Host> servers();
    
    boolean serversPresent();
    
}
