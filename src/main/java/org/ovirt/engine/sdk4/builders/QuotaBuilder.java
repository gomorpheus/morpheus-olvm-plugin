/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.QuotaContainer;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class QuotaBuilder {
    private BigInteger clusterHardLimitPct;
    private BigInteger clusterSoftLimitPct;
    private String comment;
    private DataCenter dataCenter;
    private String description;
    private List<Disk> disks;
    private String href;
    private String id;
    private String name;
    private List<Permission> permissions;
    private List<QuotaClusterLimit> quotaClusterLimits;
    private List<QuotaStorageLimit> quotaStorageLimits;
    private BigInteger storageHardLimitPct;
    private BigInteger storageSoftLimitPct;
    private List<User> users;
    private List<Vm> vms;
    
    public QuotaBuilder clusterHardLimitPct(int newClusterHardLimitPct) {
        clusterHardLimitPct = BigInteger.valueOf((long) newClusterHardLimitPct);
        return this;
    }
    
    public QuotaBuilder clusterHardLimitPct(Integer newClusterHardLimitPct) {
        if (newClusterHardLimitPct == null) {
            clusterHardLimitPct = null;
        }
        else {
            clusterHardLimitPct = BigInteger.valueOf(newClusterHardLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder clusterHardLimitPct(long newClusterHardLimitPct) {
        clusterHardLimitPct = BigInteger.valueOf(newClusterHardLimitPct);
        return this;
    }
    
    public QuotaBuilder clusterHardLimitPct(Long newClusterHardLimitPct) {
        if (newClusterHardLimitPct == null) {
            clusterHardLimitPct = null;
        }
        else {
            clusterHardLimitPct = BigInteger.valueOf(newClusterHardLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder clusterHardLimitPct(BigInteger newClusterHardLimitPct) {
        clusterHardLimitPct = newClusterHardLimitPct;
        return this;
    }
    
    
    public QuotaBuilder clusterSoftLimitPct(int newClusterSoftLimitPct) {
        clusterSoftLimitPct = BigInteger.valueOf((long) newClusterSoftLimitPct);
        return this;
    }
    
    public QuotaBuilder clusterSoftLimitPct(Integer newClusterSoftLimitPct) {
        if (newClusterSoftLimitPct == null) {
            clusterSoftLimitPct = null;
        }
        else {
            clusterSoftLimitPct = BigInteger.valueOf(newClusterSoftLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder clusterSoftLimitPct(long newClusterSoftLimitPct) {
        clusterSoftLimitPct = BigInteger.valueOf(newClusterSoftLimitPct);
        return this;
    }
    
    public QuotaBuilder clusterSoftLimitPct(Long newClusterSoftLimitPct) {
        if (newClusterSoftLimitPct == null) {
            clusterSoftLimitPct = null;
        }
        else {
            clusterSoftLimitPct = BigInteger.valueOf(newClusterSoftLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder clusterSoftLimitPct(BigInteger newClusterSoftLimitPct) {
        clusterSoftLimitPct = newClusterSoftLimitPct;
        return this;
    }
    
    
    public QuotaBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public QuotaBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public QuotaBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public QuotaBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public QuotaBuilder disks(List<Disk> newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks);
            }
            else {
                disks.addAll(newDisks);
            }
        }
        return this;
    }
    
    public QuotaBuilder disks(Disk... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            Collections.addAll(disks, newDisks);
        }
        return this;
    }
    
    public QuotaBuilder disks(DiskBuilder... newDisks) {
        if (newDisks != null) {
            if (disks == null) {
                disks = new ArrayList<>(newDisks.length);
            }
            for (DiskBuilder builder : newDisks) {
                disks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public QuotaBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public QuotaBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public QuotaBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public QuotaBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public QuotaBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public QuotaBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public QuotaBuilder quotaClusterLimits(List<QuotaClusterLimit> newQuotaClusterLimits) {
        if (newQuotaClusterLimits != null) {
            if (quotaClusterLimits == null) {
                quotaClusterLimits = new ArrayList<>(newQuotaClusterLimits);
            }
            else {
                quotaClusterLimits.addAll(newQuotaClusterLimits);
            }
        }
        return this;
    }
    
    public QuotaBuilder quotaClusterLimits(QuotaClusterLimit... newQuotaClusterLimits) {
        if (newQuotaClusterLimits != null) {
            if (quotaClusterLimits == null) {
                quotaClusterLimits = new ArrayList<>(newQuotaClusterLimits.length);
            }
            Collections.addAll(quotaClusterLimits, newQuotaClusterLimits);
        }
        return this;
    }
    
    public QuotaBuilder quotaClusterLimits(QuotaClusterLimitBuilder... newQuotaClusterLimits) {
        if (newQuotaClusterLimits != null) {
            if (quotaClusterLimits == null) {
                quotaClusterLimits = new ArrayList<>(newQuotaClusterLimits.length);
            }
            for (QuotaClusterLimitBuilder builder : newQuotaClusterLimits) {
                quotaClusterLimits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public QuotaBuilder quotaStorageLimits(List<QuotaStorageLimit> newQuotaStorageLimits) {
        if (newQuotaStorageLimits != null) {
            if (quotaStorageLimits == null) {
                quotaStorageLimits = new ArrayList<>(newQuotaStorageLimits);
            }
            else {
                quotaStorageLimits.addAll(newQuotaStorageLimits);
            }
        }
        return this;
    }
    
    public QuotaBuilder quotaStorageLimits(QuotaStorageLimit... newQuotaStorageLimits) {
        if (newQuotaStorageLimits != null) {
            if (quotaStorageLimits == null) {
                quotaStorageLimits = new ArrayList<>(newQuotaStorageLimits.length);
            }
            Collections.addAll(quotaStorageLimits, newQuotaStorageLimits);
        }
        return this;
    }
    
    public QuotaBuilder quotaStorageLimits(QuotaStorageLimitBuilder... newQuotaStorageLimits) {
        if (newQuotaStorageLimits != null) {
            if (quotaStorageLimits == null) {
                quotaStorageLimits = new ArrayList<>(newQuotaStorageLimits.length);
            }
            for (QuotaStorageLimitBuilder builder : newQuotaStorageLimits) {
                quotaStorageLimits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public QuotaBuilder storageHardLimitPct(int newStorageHardLimitPct) {
        storageHardLimitPct = BigInteger.valueOf((long) newStorageHardLimitPct);
        return this;
    }
    
    public QuotaBuilder storageHardLimitPct(Integer newStorageHardLimitPct) {
        if (newStorageHardLimitPct == null) {
            storageHardLimitPct = null;
        }
        else {
            storageHardLimitPct = BigInteger.valueOf(newStorageHardLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder storageHardLimitPct(long newStorageHardLimitPct) {
        storageHardLimitPct = BigInteger.valueOf(newStorageHardLimitPct);
        return this;
    }
    
    public QuotaBuilder storageHardLimitPct(Long newStorageHardLimitPct) {
        if (newStorageHardLimitPct == null) {
            storageHardLimitPct = null;
        }
        else {
            storageHardLimitPct = BigInteger.valueOf(newStorageHardLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder storageHardLimitPct(BigInteger newStorageHardLimitPct) {
        storageHardLimitPct = newStorageHardLimitPct;
        return this;
    }
    
    
    public QuotaBuilder storageSoftLimitPct(int newStorageSoftLimitPct) {
        storageSoftLimitPct = BigInteger.valueOf((long) newStorageSoftLimitPct);
        return this;
    }
    
    public QuotaBuilder storageSoftLimitPct(Integer newStorageSoftLimitPct) {
        if (newStorageSoftLimitPct == null) {
            storageSoftLimitPct = null;
        }
        else {
            storageSoftLimitPct = BigInteger.valueOf(newStorageSoftLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder storageSoftLimitPct(long newStorageSoftLimitPct) {
        storageSoftLimitPct = BigInteger.valueOf(newStorageSoftLimitPct);
        return this;
    }
    
    public QuotaBuilder storageSoftLimitPct(Long newStorageSoftLimitPct) {
        if (newStorageSoftLimitPct == null) {
            storageSoftLimitPct = null;
        }
        else {
            storageSoftLimitPct = BigInteger.valueOf(newStorageSoftLimitPct.longValue());
        }
        return this;
    }
    
    public QuotaBuilder storageSoftLimitPct(BigInteger newStorageSoftLimitPct) {
        storageSoftLimitPct = newStorageSoftLimitPct;
        return this;
    }
    
    
    public QuotaBuilder users(List<User> newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers);
            }
            else {
                users.addAll(newUsers);
            }
        }
        return this;
    }
    
    public QuotaBuilder users(User... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            Collections.addAll(users, newUsers);
        }
        return this;
    }
    
    public QuotaBuilder users(UserBuilder... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            for (UserBuilder builder : newUsers) {
                users.add(builder.build());
            }
        }
        return this;
    }
    
    
    public QuotaBuilder vms(List<Vm> newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms);
            }
            else {
                vms.addAll(newVms);
            }
        }
        return this;
    }
    
    public QuotaBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public QuotaBuilder vms(VmBuilder... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            for (VmBuilder builder : newVms) {
                vms.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Quota build() {
        QuotaContainer container = new QuotaContainer();
        container.clusterHardLimitPct(clusterHardLimitPct);
        container.clusterSoftLimitPct(clusterSoftLimitPct);
        container.comment(comment);
        container.dataCenter(dataCenter);
        container.description(description);
        container.disks(disks);
        container.href(href);
        container.id(id);
        container.name(name);
        container.permissions(permissions);
        container.quotaClusterLimits(quotaClusterLimits);
        container.quotaStorageLimits(quotaStorageLimits);
        container.storageHardLimitPct(storageHardLimitPct);
        container.storageSoftLimitPct(storageSoftLimitPct);
        container.users(users);
        container.vms(vms);
        return container;
    }
}
