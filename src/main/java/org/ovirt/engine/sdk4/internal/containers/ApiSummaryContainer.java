/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.ApiSummary;
import org.ovirt.engine.sdk4.types.ApiSummaryItem;

public class ApiSummaryContainer extends Container implements ApiSummary {
    private ApiSummaryItem hosts;
    private ApiSummaryItem storageDomains;
    private ApiSummaryItem users;
    private ApiSummaryItem vms;
    
    public ApiSummaryItem hosts() {
        return hosts;
    }
    
    public void hosts(ApiSummaryItem newHosts) {
        hosts = newHosts;
    }
    
    public boolean hostsPresent() {
        return hosts != null;
    }
    
    public ApiSummaryItem storageDomains() {
        return storageDomains;
    }
    
    public void storageDomains(ApiSummaryItem newStorageDomains) {
        storageDomains = newStorageDomains;
    }
    
    public boolean storageDomainsPresent() {
        return storageDomains != null;
    }
    
    public ApiSummaryItem users() {
        return users;
    }
    
    public void users(ApiSummaryItem newUsers) {
        users = newUsers;
    }
    
    public boolean usersPresent() {
        return users != null;
    }
    
    public ApiSummaryItem vms() {
        return vms;
    }
    
    public void vms(ApiSummaryItem newVms) {
        vms = newVms;
    }
    
    public boolean vmsPresent() {
        return vms != null;
    }
    
}
