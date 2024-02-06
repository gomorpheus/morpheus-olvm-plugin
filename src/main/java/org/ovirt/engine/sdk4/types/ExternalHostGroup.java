/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface ExternalHostGroup extends Identified {
    String architectureName();
    
    boolean architectureNamePresent();
    
    String domainName();
    
    boolean domainNamePresent();
    
    String operatingSystemName();
    
    boolean operatingSystemNamePresent();
    
    String subnetName();
    
    boolean subnetNamePresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
}
