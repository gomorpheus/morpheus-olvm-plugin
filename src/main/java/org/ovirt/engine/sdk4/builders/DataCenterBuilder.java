/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DataCenterContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.DataCenterStatus;
import org.ovirt.engine.sdk4.types.IscsiBond;
import org.ovirt.engine.sdk4.types.MacPool;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaModeType;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageFormat;
import org.ovirt.engine.sdk4.types.Version;

public class DataCenterBuilder {
    private List<Cluster> clusters;
    private String comment;
    private String description;
    private String href;
    private String id;
    private List<IscsiBond> iscsiBonds;
    private Boolean local;
    private MacPool macPool;
    private String name;
    private List<Network> networks;
    private List<Permission> permissions;
    private List<Qos> qoss;
    private QuotaModeType quotaMode;
    private List<Quota> quotas;
    private DataCenterStatus status;
    private List<StorageDomain> storageDomains;
    private StorageFormat storageFormat;
    private List<Version> supportedVersions;
    private Version version;
    
    public DataCenterBuilder clusters(List<Cluster> newClusters) {
        if (newClusters != null) {
            if (clusters == null) {
                clusters = new ArrayList<>(newClusters);
            }
            else {
                clusters.addAll(newClusters);
            }
        }
        return this;
    }
    
    public DataCenterBuilder clusters(Cluster... newClusters) {
        if (newClusters != null) {
            if (clusters == null) {
                clusters = new ArrayList<>(newClusters.length);
            }
            Collections.addAll(clusters, newClusters);
        }
        return this;
    }
    
    public DataCenterBuilder clusters(ClusterBuilder... newClusters) {
        if (newClusters != null) {
            if (clusters == null) {
                clusters = new ArrayList<>(newClusters.length);
            }
            for (ClusterBuilder builder : newClusters) {
                clusters.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DataCenterBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DataCenterBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DataCenterBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DataCenterBuilder iscsiBonds(List<IscsiBond> newIscsiBonds) {
        if (newIscsiBonds != null) {
            if (iscsiBonds == null) {
                iscsiBonds = new ArrayList<>(newIscsiBonds);
            }
            else {
                iscsiBonds.addAll(newIscsiBonds);
            }
        }
        return this;
    }
    
    public DataCenterBuilder iscsiBonds(IscsiBond... newIscsiBonds) {
        if (newIscsiBonds != null) {
            if (iscsiBonds == null) {
                iscsiBonds = new ArrayList<>(newIscsiBonds.length);
            }
            Collections.addAll(iscsiBonds, newIscsiBonds);
        }
        return this;
    }
    
    public DataCenterBuilder iscsiBonds(IscsiBondBuilder... newIscsiBonds) {
        if (newIscsiBonds != null) {
            if (iscsiBonds == null) {
                iscsiBonds = new ArrayList<>(newIscsiBonds.length);
            }
            for (IscsiBondBuilder builder : newIscsiBonds) {
                iscsiBonds.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder local(boolean newLocal) {
        local = Boolean.valueOf(newLocal);
        return this;
    }
    
    public DataCenterBuilder local(Boolean newLocal) {
        local = newLocal;
        return this;
    }
    
    
    public DataCenterBuilder macPool(MacPool newMacPool) {
        macPool = newMacPool;
        return this;
    }
    
    public DataCenterBuilder macPool(MacPoolBuilder newMacPool) {
        if (newMacPool == null) {
            macPool = null;
        }
        else {
            macPool = newMacPool.build();
        }
        return this;
    }
    
    
    public DataCenterBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DataCenterBuilder networks(List<Network> newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks);
            }
            else {
                networks.addAll(newNetworks);
            }
        }
        return this;
    }
    
    public DataCenterBuilder networks(Network... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            Collections.addAll(networks, newNetworks);
        }
        return this;
    }
    
    public DataCenterBuilder networks(NetworkBuilder... newNetworks) {
        if (newNetworks != null) {
            if (networks == null) {
                networks = new ArrayList<>(newNetworks.length);
            }
            for (NetworkBuilder builder : newNetworks) {
                networks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder permissions(List<Permission> newPermissions) {
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
    
    public DataCenterBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public DataCenterBuilder permissions(PermissionBuilder... newPermissions) {
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
    
    
    public DataCenterBuilder qoss(List<Qos> newQoss) {
        if (newQoss != null) {
            if (qoss == null) {
                qoss = new ArrayList<>(newQoss);
            }
            else {
                qoss.addAll(newQoss);
            }
        }
        return this;
    }
    
    public DataCenterBuilder qoss(Qos... newQoss) {
        if (newQoss != null) {
            if (qoss == null) {
                qoss = new ArrayList<>(newQoss.length);
            }
            Collections.addAll(qoss, newQoss);
        }
        return this;
    }
    
    public DataCenterBuilder qoss(QosBuilder... newQoss) {
        if (newQoss != null) {
            if (qoss == null) {
                qoss = new ArrayList<>(newQoss.length);
            }
            for (QosBuilder builder : newQoss) {
                qoss.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder quotaMode(QuotaModeType newQuotaMode) {
        quotaMode = newQuotaMode;
        return this;
    }
    
    
    public DataCenterBuilder quotas(List<Quota> newQuotas) {
        if (newQuotas != null) {
            if (quotas == null) {
                quotas = new ArrayList<>(newQuotas);
            }
            else {
                quotas.addAll(newQuotas);
            }
        }
        return this;
    }
    
    public DataCenterBuilder quotas(Quota... newQuotas) {
        if (newQuotas != null) {
            if (quotas == null) {
                quotas = new ArrayList<>(newQuotas.length);
            }
            Collections.addAll(quotas, newQuotas);
        }
        return this;
    }
    
    public DataCenterBuilder quotas(QuotaBuilder... newQuotas) {
        if (newQuotas != null) {
            if (quotas == null) {
                quotas = new ArrayList<>(newQuotas.length);
            }
            for (QuotaBuilder builder : newQuotas) {
                quotas.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder status(DataCenterStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public DataCenterBuilder storageDomains(List<StorageDomain> newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains);
            }
            else {
                storageDomains.addAll(newStorageDomains);
            }
        }
        return this;
    }
    
    public DataCenterBuilder storageDomains(StorageDomain... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            Collections.addAll(storageDomains, newStorageDomains);
        }
        return this;
    }
    
    public DataCenterBuilder storageDomains(StorageDomainBuilder... newStorageDomains) {
        if (newStorageDomains != null) {
            if (storageDomains == null) {
                storageDomains = new ArrayList<>(newStorageDomains.length);
            }
            for (StorageDomainBuilder builder : newStorageDomains) {
                storageDomains.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder storageFormat(StorageFormat newStorageFormat) {
        storageFormat = newStorageFormat;
        return this;
    }
    
    
    public DataCenterBuilder supportedVersions(List<Version> newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions);
            }
            else {
                supportedVersions.addAll(newSupportedVersions);
            }
        }
        return this;
    }
    
    public DataCenterBuilder supportedVersions(Version... newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions.length);
            }
            Collections.addAll(supportedVersions, newSupportedVersions);
        }
        return this;
    }
    
    public DataCenterBuilder supportedVersions(VersionBuilder... newSupportedVersions) {
        if (newSupportedVersions != null) {
            if (supportedVersions == null) {
                supportedVersions = new ArrayList<>(newSupportedVersions.length);
            }
            for (VersionBuilder builder : newSupportedVersions) {
                supportedVersions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DataCenterBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public DataCenterBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public DataCenter build() {
        DataCenterContainer container = new DataCenterContainer();
        container.clusters(clusters);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.iscsiBonds(iscsiBonds);
        container.local(local);
        container.macPool(macPool);
        container.name(name);
        container.networks(networks);
        container.permissions(permissions);
        container.qoss(qoss);
        container.quotaMode(quotaMode);
        container.quotas(quotas);
        container.status(status);
        container.storageDomains(storageDomains);
        container.storageFormat(storageFormat);
        container.supportedVersions(supportedVersions);
        container.version(version);
        return container;
    }
}
