/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.ApiSummaryContainer;
import org.ovirt.engine.sdk4.types.ApiSummary;
import org.ovirt.engine.sdk4.types.ApiSummaryItem;

public class ApiSummaryBuilder {
    private ApiSummaryItem hosts;
    private ApiSummaryItem storageDomains;
    private ApiSummaryItem users;
    private ApiSummaryItem vms;
    
    public ApiSummaryBuilder hosts(ApiSummaryItem newHosts) {
        hosts = newHosts;
        return this;
    }
    
    public ApiSummaryBuilder hosts(ApiSummaryItemBuilder newHosts) {
        if (newHosts == null) {
            hosts = null;
        }
        else {
            hosts = newHosts.build();
        }
        return this;
    }
    
    
    public ApiSummaryBuilder storageDomains(ApiSummaryItem newStorageDomains) {
        storageDomains = newStorageDomains;
        return this;
    }
    
    public ApiSummaryBuilder storageDomains(ApiSummaryItemBuilder newStorageDomains) {
        if (newStorageDomains == null) {
            storageDomains = null;
        }
        else {
            storageDomains = newStorageDomains.build();
        }
        return this;
    }
    
    
    public ApiSummaryBuilder users(ApiSummaryItem newUsers) {
        users = newUsers;
        return this;
    }
    
    public ApiSummaryBuilder users(ApiSummaryItemBuilder newUsers) {
        if (newUsers == null) {
            users = null;
        }
        else {
            users = newUsers.build();
        }
        return this;
    }
    
    
    public ApiSummaryBuilder vms(ApiSummaryItem newVms) {
        vms = newVms;
        return this;
    }
    
    public ApiSummaryBuilder vms(ApiSummaryItemBuilder newVms) {
        if (newVms == null) {
            vms = null;
        }
        else {
            vms = newVms.build();
        }
        return this;
    }
    
    
    public ApiSummary build() {
        ApiSummaryContainer container = new ApiSummaryContainer();
        container.hosts(hosts);
        container.storageDomains(storageDomains);
        container.users(users);
        container.vms(vms);
        return container;
    }
}
