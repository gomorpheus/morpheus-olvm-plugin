/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ExternalTemplateImportContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.CpuProfile;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

public class ExternalTemplateImportBuilder {
    private Boolean clone_;
    private Cluster cluster;
    private CpuProfile cpuProfile;
    private Host host;
    private Quota quota;
    private StorageDomain storageDomain;
    private Template template;
    private String url;
    
    public ExternalTemplateImportBuilder clone_(boolean newClone) {
        clone_ = Boolean.valueOf(newClone);
        return this;
    }
    
    public ExternalTemplateImportBuilder clone_(Boolean newClone) {
        clone_ = newClone;
        return this;
    }
    
    
    public ExternalTemplateImportBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public ExternalTemplateImportBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder cpuProfile(CpuProfile newCpuProfile) {
        cpuProfile = newCpuProfile;
        return this;
    }
    
    public ExternalTemplateImportBuilder cpuProfile(CpuProfileBuilder newCpuProfile) {
        if (newCpuProfile == null) {
            cpuProfile = null;
        }
        else {
            cpuProfile = newCpuProfile.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public ExternalTemplateImportBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder quota(Quota newQuota) {
        quota = newQuota;
        return this;
    }
    
    public ExternalTemplateImportBuilder quota(QuotaBuilder newQuota) {
        if (newQuota == null) {
            quota = null;
        }
        else {
            quota = newQuota.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public ExternalTemplateImportBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public ExternalTemplateImportBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public ExternalTemplateImportBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public ExternalTemplateImport build() {
        ExternalTemplateImportContainer container = new ExternalTemplateImportContainer();
        container.clone_(clone_);
        container.cluster(cluster);
        container.cpuProfile(cpuProfile);
        container.host(host);
        container.quota(quota);
        container.storageDomain(storageDomain);
        container.template(template);
        container.url(url);
        return container;
    }
}
