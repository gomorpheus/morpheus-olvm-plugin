/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.ExternalVmImport;
import org.ovirt.engine.sdk4.types.ExternalVmProviderType;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

public class ExternalVmImportContainer extends Container implements ExternalVmImport {
    private String name;
    private String password;
    private ExternalVmProviderType provider;
    private Boolean sparse;
    private String url;
    private String username;
    private Cluster cluster;
    private CpuProfile cpuProfile;
    private File driversIso;
    private Host host;
    private Quota quota;
    private StorageDomain storageDomain;
    private Vm vm;
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public ExternalVmProviderType provider() {
        return provider;
    }
    
    public void provider(ExternalVmProviderType newProvider) {
        provider = newProvider;
    }
    
    public boolean providerPresent() {
        return provider != null;
    }
    
    public boolean sparse() {
        return sparse;
    }
    
    public void sparse(boolean newSparse) {
        sparse = Boolean.valueOf(newSparse);
    }
    
    public void sparse(Boolean newSparse) {
        sparse = newSparse;
    }
    
    public boolean sparsePresent() {
        return sparse != null;
    }
    
    public String url() {
        return url;
    }
    
    public void url(String newUrl) {
        url = newUrl;
    }
    
    public boolean urlPresent() {
        return url != null;
    }
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public CpuProfile cpuProfile() {
        return cpuProfile;
    }
    
    public void cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
    }
    
    public boolean cpuProfilePresent() {
        return cpuProfile != null;
    }
    
    public File driversIso() {
        return driversIso;
    }
    
    public void driversIso(File newDriversIso) {
        driversIso = newDriversIso;
    }
    
    public boolean driversIsoPresent() {
        return driversIso != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public Quota quota() {
        return quota;
    }
    
    public void quota(Quota newQuota) {
        quota = newQuota;
    }
    
    public boolean quotaPresent() {
        return quota != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
