/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ExternalTemplateImportBuilder;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;

/**
 * Provides capability to import external templates.
 * Currently supports OVA only.
 */
public interface ExternalTemplateImportsService extends Service {
    /**
     * This operation is used to import a template from external hypervisor.
     * 
     * For example import of a template OVA can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externaltemplateimports
     * ----
     * 
     * With request body of type <<types/external_template_import,ExternalTemplateImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_template_import>
     *   <template>
     *     <name>my_template</name>
     *   </template>
     *   <cluster id="2b18aca2-4469-11eb-9449-482ae35a5f83" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <url>ova:///mnt/ova/ova_template.ova</url>
     *   <host id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     * </external_template_import>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest import_(ExternalTemplateImport import_);
        AddRequest import_(ExternalTemplateImportBuilder import_);
    }
    
    /**
     * This operation is used to import a template from external hypervisor.
     * 
     * For example import of a template OVA can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externaltemplateimports
     * ----
     * 
     * With request body of type <<types/external_template_import,ExternalTemplateImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_template_import>
     *   <template>
     *     <name>my_template</name>
     *   </template>
     *   <cluster id="2b18aca2-4469-11eb-9449-482ae35a5f83" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <url>ova:///mnt/ova/ova_template.ova</url>
     *   <host id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     * </external_template_import>
     * ----
     */
    public interface AddResponse extends Response {
        ExternalTemplateImport import_();
    }
    
    /**
     * This operation is used to import a template from external hypervisor.
     * 
     * For example import of a template OVA can be facilitated using the following request:
     * 
     * [source]
     * ----
     * POST /externaltemplateimports
     * ----
     * 
     * With request body of type <<types/external_template_import,ExternalTemplateImport>>, for example:
     * 
     * [source,xml]
     * ----
     * <external_template_import>
     *   <template>
     *     <name>my_template</name>
     *   </template>
     *   <cluster id="2b18aca2-4469-11eb-9449-482ae35a5f83" />
     *   <storage_domain id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     *   <url>ova:///mnt/ova/ova_template.ova</url>
     *   <host id="8bb5ade5-e988-4000-8b93-dbfc6717fe50" />
     * </external_template_import>
     * ----
     */
    AddRequest add();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

