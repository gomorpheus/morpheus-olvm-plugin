/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalVmImportContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.ExternalVmImport;
import org.ovirt.engine.sdk4.types.ExternalVmProviderType;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

public class ExternalVmImportBuilder {
    private Cluster cluster;
    private CpuProfile cpuProfile;
    private File driversIso;
    private Host host;
    private String name;
    private String password;
    private ExternalVmProviderType provider;
    private Quota quota;
    private Boolean sparse;
    private StorageDomain storageDomain;
    private String url;
    private String username;
    private Vm vm;
    
    public ExternalVmImportBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public ExternalVmImportBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public ExternalVmImportBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder driversIso(File newDriversIso) {
        driversIso = newDriversIso;
        return this;
    }
    
    public ExternalVmImportBuilder driversIso(FileBuilder newDriversIso) {
        if (newDriversIso == null) {
            driversIso = null;
        }
        else {
            driversIso = newDriversIso.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public ExternalVmImportBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ExternalVmImportBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public ExternalVmImportBuilder provider(ExternalVmProviderType newProvider) {
        provider = newProvider;
        return this;
    }
    
    
    public ExternalVmImportBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public ExternalVmImportBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder sparse(boolean newSparse) {
        sparse = Boolean.valueOf(newSparse);
        return this;
    }
    
    public ExternalVmImportBuilder sparse(Boolean newSparse) {
        sparse = newSparse;
        return this;
    }
    
    
    public ExternalVmImportBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public ExternalVmImportBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public ExternalVmImportBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public ExternalVmImportBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public ExternalVmImportBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public ExternalVmImportBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public ExternalVmImport build() {
        ExternalVmImportContainer container = new ExternalVmImportContainer();
        container.cluster(cluster);
        container.cpuProfile(cpuProfile);
        container.driversIso(driversIso);
        container.host(host);
        container.name(name);
        container.password(password);
        container.provider(provider);
        container.quota(quota);
        container.sparse(sparse);
        container.storageDomain(storageDomain);
        container.url(url);
        container.username(username);
        container.vm(vm);
        return container;
    }
}
