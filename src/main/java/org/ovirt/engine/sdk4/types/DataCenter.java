/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface DataCenter extends Identified {
    boolean local();
    
    boolean localPresent();
    
    QuotaModeType quotaMode();
    
    boolean quotaModePresent();
    
    DataCenterStatus status();
    
    boolean statusPresent();
    
    StorageFormat storageFormat();
    
    boolean storageFormatPresent();
    
    List<Version> supportedVersions();
    
    boolean supportedVersionsPresent();
    
    Version version();
    
    boolean versionPresent();
    
    List<Cluster> clusters();
    
    boolean clustersPresent();
    
    List<IscsiBond> iscsiBonds();
    
    boolean iscsiBondsPresent();
    
    MacPool macPool();
    
    boolean macPoolPresent();
    
    List<Network> networks();
    
    boolean networksPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<Qos> qoss();
    
    boolean qossPresent();
    
    List<Quota> quotas();
    
    boolean quotasPresent();
    
    List<StorageDomain> storageDomains();
    
    boolean storageDomainsPresent();
    
}
