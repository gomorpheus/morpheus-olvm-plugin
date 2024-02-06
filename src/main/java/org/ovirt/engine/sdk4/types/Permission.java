/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type represents a permission.
 */
public interface Permission extends Identified {
    Cluster cluster();
    
    boolean clusterPresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    Disk disk();
    
    boolean diskPresent();
    
    Group group();
    
    boolean groupPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Role role();
    
    boolean rolePresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    Template template();
    
    boolean templatePresent();
    
    User user();
    
    boolean userPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
    VmPool vmPool();
    
    boolean vmPoolPresent();
    
}
