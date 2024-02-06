/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.List;

/**
 * Represents a quota object.
 * 
 * An example XML representation of a quota:
 * 
 * [source,xml]
 * ----
 * <quota href="/ovirt-engine/api/datacenters/7044934e/quotas/dcad5ddc" id="dcad5ddc">
 *   <name>My Quota</name>
 *   <description>A quota for my oVirt environment</description>
 *   <cluster_hard_limit_pct>0</cluster_hard_limit_pct>
 *   <cluster_soft_limit_pct>0</cluster_soft_limit_pct>
 *   <data_center href="/ovirt-engine/api/datacenters/7044934e" id="7044934e"/>
 *   <storage_hard_limit_pct>0</storage_hard_limit_pct>
 *   <storage_soft_limit_pct>0</storage_soft_limit_pct>
 * </quota>
 * ----
 */
public interface Quota extends Identified {
    BigInteger clusterHardLimitPct();
    Byte clusterHardLimitPctAsByte();
    Short clusterHardLimitPctAsShort();
    Integer clusterHardLimitPctAsInteger();
    Long clusterHardLimitPctAsLong();
    
    boolean clusterHardLimitPctPresent();
    
    BigInteger clusterSoftLimitPct();
    Byte clusterSoftLimitPctAsByte();
    Short clusterSoftLimitPctAsShort();
    Integer clusterSoftLimitPctAsInteger();
    Long clusterSoftLimitPctAsLong();
    
    boolean clusterSoftLimitPctPresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    BigInteger storageHardLimitPct();
    Byte storageHardLimitPctAsByte();
    Short storageHardLimitPctAsShort();
    Integer storageHardLimitPctAsInteger();
    Long storageHardLimitPctAsLong();
    
    boolean storageHardLimitPctPresent();
    
    BigInteger storageSoftLimitPct();
    Byte storageSoftLimitPctAsByte();
    Short storageSoftLimitPctAsShort();
    Integer storageSoftLimitPctAsInteger();
    Long storageSoftLimitPctAsLong();
    
    boolean storageSoftLimitPctPresent();
    
    List<User> users();
    
    boolean usersPresent();
    
    List<Vm> vms();
    
    boolean vmsPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<QuotaClusterLimit> quotaClusterLimits();
    
    boolean quotaClusterLimitsPresent();
    
    List<QuotaStorageLimit> quotaStorageLimits();
    
    boolean quotaStorageLimitsPresent();
    
}
