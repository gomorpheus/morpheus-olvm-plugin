/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class QuotaContainer extends IdentifiedContainer implements Quota {
    private BigInteger clusterHardLimitPct;
    private BigInteger clusterSoftLimitPct;
    private DataCenter dataCenter;
    private List<Disk> disks;
    private BigInteger storageHardLimitPct;
    private BigInteger storageSoftLimitPct;
    private List<User> users;
    private List<Vm> vms;
    private List<Permission> permissions;
    private List<QuotaClusterLimit> quotaClusterLimits;
    private List<QuotaStorageLimit> quotaStorageLimits;
    
    public BigInteger clusterHardLimitPct() {
        return clusterHardLimitPct;
    }
    
    public Byte clusterHardLimitPctAsByte() {
        return asByte("Quota", "clusterHardLimitPct", clusterHardLimitPct);
    }
    
    public Short clusterHardLimitPctAsShort() {
        return asShort("Quota", "clusterHardLimitPct", clusterHardLimitPct);
    }
    
    public Integer clusterHardLimitPctAsInteger() {
        return asInteger("Quota", "clusterHardLimitPct", clusterHardLimitPct);
    }
    
    public Long clusterHardLimitPctAsLong() {
        return asLong("Quota", "clusterHardLimitPct", clusterHardLimitPct);
    }
    
    public void clusterHardLimitPct(BigInteger newClusterHardLimitPct) {
        clusterHardLimitPct = newClusterHardLimitPct;
    }
    
    public boolean clusterHardLimitPctPresent() {
        return clusterHardLimitPct != null;
    }
    
    public BigInteger clusterSoftLimitPct() {
        return clusterSoftLimitPct;
    }
    
    public Byte clusterSoftLimitPctAsByte() {
        return asByte("Quota", "clusterSoftLimitPct", clusterSoftLimitPct);
    }
    
    public Short clusterSoftLimitPctAsShort() {
        return asShort("Quota", "clusterSoftLimitPct", clusterSoftLimitPct);
    }
    
    public Integer clusterSoftLimitPctAsInteger() {
        return asInteger("Quota", "clusterSoftLimitPct", clusterSoftLimitPct);
    }
    
    public Long clusterSoftLimitPctAsLong() {
        return asLong("Quota", "clusterSoftLimitPct", clusterSoftLimitPct);
    }
    
    public void clusterSoftLimitPct(BigInteger newClusterSoftLimitPct) {
        clusterSoftLimitPct = newClusterSoftLimitPct;
    }
    
    public boolean clusterSoftLimitPctPresent() {
        return clusterSoftLimitPct != null;
    }
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
    public List<Disk> disks() {
        return makeUnmodifiableList(disks);
    }
    
    public void disks(List<Disk> newDisks) {
        disks = makeArrayList(newDisks);
    }
    
    public boolean disksPresent() {
        return disks != null && !disks.isEmpty();
    }
    
    public BigInteger storageHardLimitPct() {
        return storageHardLimitPct;
    }
    
    public Byte storageHardLimitPctAsByte() {
        return asByte("Quota", "storageHardLimitPct", storageHardLimitPct);
    }
    
    public Short storageHardLimitPctAsShort() {
        return asShort("Quota", "storageHardLimitPct", storageHardLimitPct);
    }
    
    public Integer storageHardLimitPctAsInteger() {
        return asInteger("Quota", "storageHardLimitPct", storageHardLimitPct);
    }
    
    public Long storageHardLimitPctAsLong() {
        return asLong("Quota", "storageHardLimitPct", storageHardLimitPct);
    }
    
    public void storageHardLimitPct(BigInteger newStorageHardLimitPct) {
        storageHardLimitPct = newStorageHardLimitPct;
    }
    
    public boolean storageHardLimitPctPresent() {
        return storageHardLimitPct != null;
    }
    
    public BigInteger storageSoftLimitPct() {
        return storageSoftLimitPct;
    }
    
    public Byte storageSoftLimitPctAsByte() {
        return asByte("Quota", "storageSoftLimitPct", storageSoftLimitPct);
    }
    
    public Short storageSoftLimitPctAsShort() {
        return asShort("Quota", "storageSoftLimitPct", storageSoftLimitPct);
    }
    
    public Integer storageSoftLimitPctAsInteger() {
        return asInteger("Quota", "storageSoftLimitPct", storageSoftLimitPct);
    }
    
    public Long storageSoftLimitPctAsLong() {
        return asLong("Quota", "storageSoftLimitPct", storageSoftLimitPct);
    }
    
    public void storageSoftLimitPct(BigInteger newStorageSoftLimitPct) {
        storageSoftLimitPct = newStorageSoftLimitPct;
    }
    
    public boolean storageSoftLimitPctPresent() {
        return storageSoftLimitPct != null;
    }
    
    public List<User> users() {
        return makeUnmodifiableList(users);
    }
    
    public void users(List<User> newUsers) {
        users = makeArrayList(newUsers);
    }
    
    public boolean usersPresent() {
        return users != null && !users.isEmpty();
    }
    
    public List<Vm> vms() {
        return makeUnmodifiableList(vms);
    }
    
    public void vms(List<Vm> newVms) {
        vms = makeArrayList(newVms);
    }
    
    public boolean vmsPresent() {
        return vms != null && !vms.isEmpty();
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public List<QuotaClusterLimit> quotaClusterLimits() {
        return makeUnmodifiableList(quotaClusterLimits);
    }
    
    public void quotaClusterLimits(List<QuotaClusterLimit> newQuotaClusterLimits) {
        quotaClusterLimits = makeArrayList(newQuotaClusterLimits);
    }
    
    public boolean quotaClusterLimitsPresent() {
        return quotaClusterLimits != null && !quotaClusterLimits.isEmpty();
    }
    
    public List<QuotaStorageLimit> quotaStorageLimits() {
        return makeUnmodifiableList(quotaStorageLimits);
    }
    
    public void quotaStorageLimits(List<QuotaStorageLimit> newQuotaStorageLimits) {
        quotaStorageLimits = makeArrayList(newQuotaStorageLimits);
    }
    
    public boolean quotaStorageLimitsPresent() {
        return quotaStorageLimits != null && !quotaStorageLimits.isEmpty();
    }
    
}
