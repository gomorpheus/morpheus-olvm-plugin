/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

public class ExternalTemplateImportContainer extends Container implements ExternalTemplateImport {
    private Boolean clone_;
    private String url;
    private Cluster cluster;
    private CpuProfile cpuProfile;
    private Host host;
    private Quota quota;
    private StorageDomain storageDomain;
    private Template template;
    
    public boolean clone_() {
        return clone_;
    }
    
    public void clone_(boolean newClone) {
        clone_ = Boolean.valueOf(newClone);
    }
    
    public void clone_(Boolean newClone) {
        clone_ = newClone;
    }
    
    public boolean clone_Present() {
        return clone_ != null;
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
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
    }
    
}
