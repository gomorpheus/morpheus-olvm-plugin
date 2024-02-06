/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
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

public class DataCenterContainer extends IdentifiedContainer implements DataCenter {
    private Boolean local;
    private QuotaModeType quotaMode;
    private DataCenterStatus status;
    private StorageFormat storageFormat;
    private List<Version> supportedVersions;
    private Version version;
    private List<Cluster> clusters;
    private List<IscsiBond> iscsiBonds;
    private MacPool macPool;
    private List<Network> networks;
    private List<Permission> permissions;
    private List<Qos> qoss;
    private List<Quota> quotas;
    private List<StorageDomain> storageDomains;
    
    public boolean local() {
        return local;
    }
    
    public void local(boolean newLocal) {
        local = Boolean.valueOf(newLocal);
    }
    
    public void local(Boolean newLocal) {
        local = newLocal;
    }
    
    public boolean localPresent() {
        return local != null;
    }
    
    public QuotaModeType quotaMode() {
        return quotaMode;
    }
    
    public void quotaMode(QuotaModeType newQuotaMode) {
        quotaMode = newQuotaMode;
    }
    
    public boolean quotaModePresent() {
        return quotaMode != null;
    }
    
    public DataCenterStatus status() {
        return status;
    }
    
    public void status(DataCenterStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public StorageFormat storageFormat() {
        return storageFormat;
    }
    
    public void storageFormat(StorageFormat newStorageFormat) {
        storageFormat = newStorageFormat;
    }
    
    public boolean storageFormatPresent() {
        return storageFormat != null;
    }
    
    public List<Version> supportedVersions() {
        return makeUnmodifiableList(supportedVersions);
    }
    
    public void supportedVersions(List<Version> newSupportedVersions) {
        supportedVersions = makeArrayList(newSupportedVersions);
    }
    
    public boolean supportedVersionsPresent() {
        return supportedVersions != null && !supportedVersions.isEmpty();
    }
    
    public Version version() {
        return version;
    }
    
    public void version(Version newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
    public List<Cluster> clusters() {
        return makeUnmodifiableList(clusters);
    }
    
    public void clusters(List<Cluster> newClusters) {
        clusters = makeArrayList(newClusters);
    }
    
    public boolean clustersPresent() {
        return clusters != null && !clusters.isEmpty();
    }
    
    public List<IscsiBond> iscsiBonds() {
        return makeUnmodifiableList(iscsiBonds);
    }
    
    public void iscsiBonds(List<IscsiBond> newIscsiBonds) {
        iscsiBonds = makeArrayList(newIscsiBonds);
    }
    
    public boolean iscsiBondsPresent() {
        return iscsiBonds != null && !iscsiBonds.isEmpty();
    }
    
    public MacPool macPool() {
        return macPool;
    }
    
    public void macPool(MacPool newMacPool) {
        macPool = newMacPool;
    }
    
    public boolean macPoolPresent() {
        return macPool != null;
    }
    
    public List<Network> networks() {
        return makeUnmodifiableList(networks);
    }
    
    public void networks(List<Network> newNetworks) {
        networks = makeArrayList(newNetworks);
    }
    
    public boolean networksPresent() {
        return networks != null && !networks.isEmpty();
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
    
    public List<Qos> qoss() {
        return makeUnmodifiableList(qoss);
    }
    
    public void qoss(List<Qos> newQoss) {
        qoss = makeArrayList(newQoss);
    }
    
    public boolean qossPresent() {
        return qoss != null && !qoss.isEmpty();
    }
    
    public List<Quota> quotas() {
        return makeUnmodifiableList(quotas);
    }
    
    public void quotas(List<Quota> newQuotas) {
        quotas = makeArrayList(newQuotas);
    }
    
    public boolean quotasPresent() {
        return quotas != null && !quotas.isEmpty();
    }
    
    public List<StorageDomain> storageDomains() {
        return makeUnmodifiableList(storageDomains);
    }
    
    public void storageDomains(List<StorageDomain> newStorageDomains) {
        storageDomains = makeArrayList(newStorageDomains);
    }
    
    public boolean storageDomainsPresent() {
        return storageDomains != null && !storageDomains.isEmpty();
    }
    
}
