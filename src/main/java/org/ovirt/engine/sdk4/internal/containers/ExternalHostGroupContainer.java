/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalHostGroupContainer extends IdentifiedContainer implements ExternalHostGroup {
    private String architectureName;
    private String domainName;
    private String operatingSystemName;
    private String subnetName;
    private ExternalHostProvider externalHostProvider;
    
    public String architectureName() {
        return architectureName;
    }
    
    public void architectureName(String newArchitectureName) {
        architectureName = newArchitectureName;
    }
    
    public boolean architectureNamePresent() {
        return architectureName != null;
    }
    
    public String domainName() {
        return domainName;
    }
    
    public void domainName(String newDomainName) {
        domainName = newDomainName;
    }
    
    public boolean domainNamePresent() {
        return domainName != null;
    }
    
    public String operatingSystemName() {
        return operatingSystemName;
    }
    
    public void operatingSystemName(String newOperatingSystemName) {
        operatingSystemName = newOperatingSystemName;
    }
    
    public boolean operatingSystemNamePresent() {
        return operatingSystemName != null;
    }
    
    public String subnetName() {
        return subnetName;
    }
    
    public void subnetName(String newSubnetName) {
        subnetName = newSubnetName;
    }
    
    public boolean subnetNamePresent() {
        return subnetName != null;
    }
    
    public ExternalHostProvider externalHostProvider() {
        return externalHostProvider;
    }
    
    public void externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
    }
    
    public boolean externalHostProviderPresent() {
        return externalHostProvider != null;
    }
    
}
