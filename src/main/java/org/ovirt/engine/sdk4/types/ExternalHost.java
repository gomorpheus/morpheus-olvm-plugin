/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents a host provisioned by a host
 * provider (such as Foreman/Satellite).
 * 
 * See https://www.theforeman.org/ for more details on Foreman.
 * See https://access.redhat.com/products/red-hat-satellite
 * for more details on Red Hat Satellite.
 */
public interface ExternalHost extends Identified {
    String address();
    
    boolean addressPresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
}
