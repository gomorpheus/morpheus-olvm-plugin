/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface ExternalComputeResource extends Identified {
    String provider();
    
    boolean providerPresent();
    
    String url();
    
    boolean urlPresent();
    
    String user();
    
    boolean userPresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
}
