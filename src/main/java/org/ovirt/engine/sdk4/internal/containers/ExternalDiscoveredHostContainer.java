/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ExternalDiscoveredHost;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalDiscoveredHostContainer extends IdentifiedContainer implements ExternalDiscoveredHost {
    private String ip;
    private String lastReport;
    private String mac;
    private String subnetName;
    private ExternalHostProvider externalHostProvider;
    
    public String ip() {
        return ip;
    }
    
    public void ip(String newIp) {
        ip = newIp;
    }
    
    public boolean ipPresent() {
        return ip != null;
    }
    
    public String lastReport() {
        return lastReport;
    }
    
    public void lastReport(String newLastReport) {
        lastReport = newLastReport;
    }
    
    public boolean lastReportPresent() {
        return lastReport != null;
    }
    
    public String mac() {
        return mac;
    }
    
    public void mac(String newMac) {
        mac = newMac;
    }
    
    public boolean macPresent() {
        return mac != null;
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
