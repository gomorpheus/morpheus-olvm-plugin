/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Describes how an external network provider is provisioned on a host.
 */
public interface ExternalNetworkProviderConfiguration extends Identified {
    ExternalProvider externalNetworkProvider();
    
    boolean externalNetworkProviderPresent();
    
    Host host();
    
    boolean hostPresent();
    
}
