/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * A summary containing the total number of relevant objects, such as virtual machines, hosts, and storage domains.
 */
public interface ApiSummary {
    ApiSummaryItem hosts();
    
    boolean hostsPresent();
    
    ApiSummaryItem storageDomains();
    
    boolean storageDomainsPresent();
    
    ApiSummaryItem users();
    
    boolean usersPresent();
    
    ApiSummaryItem vms();
    
    boolean vmsPresent();
    
}
