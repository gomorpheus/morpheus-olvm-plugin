/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface ExternalDiscoveredHost extends Identified {
    String ip();
    
    boolean ipPresent();
    
    String lastReport();
    
    boolean lastReportPresent();
    
    String mac();
    
    boolean macPresent();
    
    String subnetName();
    
    boolean subnetNamePresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
}
