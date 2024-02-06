/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

/**
 * Manages the virtual machine template and template versions.
 */
public interface TemplateService extends Service {
    /**
     * Exports a template to the data center export domain.
     * 
     * For example, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <exclusive>true<exclusive/>
     * </action>
     * ----
     */
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        /**
         * Indicates if the existing templates with the same name should be overwritten.
         * 
         * The export action reports a failed action if a template of the same name exists in the destination domain.
         * Set this parameter to `true` to change this behavior and overwrite any existing template.
         */
        ExportRequest exclusive(Boolean exclusive);
        ExportRequest storageDomain(StorageDomain storageDomain);
        /**
         * Specifies the destination export storage domain.
         */
        ExportRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a template to the data center export domain.
     * 
     * For example, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <exclusive>true<exclusive/>
     * </action>
     * ----
     */
    public interface ExportResponse extends Response {
    }
    
    /**
     * Exports a template to the data center export domain.
     * 
     * For example, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain id="456"/>
     *   <exclusive>true<exclusive/>
     * </action>
     * ----
     */
    ExportRequest export();
    
    /**
     * Returns the information about this template or template version.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the information about this template or template version.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the template or template version.
         */
        Template template();
    }
    
    /**
     * Returns the information about this template or template version.
     */
    GetRequest get();
    
    /**
     * Removes a virtual machine template.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the removal should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes a virtual machine template.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes a virtual machine template.
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/templates/123
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Exports a template to an export domain.
     */
    public interface ExportToExportDomainRequest extends Request<ExportToExportDomainRequest, ExportToExportDomainResponse> {
        /**
         * Indicates if the existing templates with the same name should be overwritten.
         * 
         * The export action reports a failed action if a template of the same name exists in the destination domain.
         * Set this parameter to `true` to change this behavior and overwrite any existing template.
         */
        ExportToExportDomainRequest exclusive(Boolean exclusive);
        ExportToExportDomainRequest storageDomain(StorageDomain storageDomain);
        /**
         * Specifies the destination export storage domain.
         */
        ExportToExportDomainRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a template to an export domain.
     */
    public interface ExportToExportDomainResponse extends Response {
    }
    
    /**
     * Exports a template to an export domain.
     */
    ExportToExportDomainRequest exportToExportDomain();
    
    /**
     * Exports a template as an OVA file to a given path on a specified host.
     */
    public interface ExportToPathOnHostRequest extends Request<ExportToPathOnHostRequest, ExportToPathOnHostResponse> {
        /**
         * An absolute path of a directory on the host to generate the OVA file in.
         */
        ExportToPathOnHostRequest directory(String directory);
        /**
         * Indicates if the existing templates with the same name should be overwritten.
         * 
         * The export action reports a failed action if a template of the same name exists in the destination domain.
         * Set this parameter to `true` to change this behavior and overwrite any existing template.
         */
        ExportToPathOnHostRequest exclusive(Boolean exclusive);
        /**
         * The name of the OVA file.
         * 
         * This is an optional parameter. If it is not specified, the name of the OVA file is determined according
         * to the name of the template. It will conform to the following pattern: "<template name>.ova".
         */
        ExportToPathOnHostRequest filename(String filename);
        ExportToPathOnHostRequest host(Host host);
        /**
         * The host to generate the OVA file on.
         */
        ExportToPathOnHostRequest host(HostBuilder host);
        ExportToPathOnHostRequest storageDomain(StorageDomain storageDomain);
        /**
         * Specifies the destination export storage domain.
         */
        ExportToPathOnHostRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a template as an OVA file to a given path on a specified host.
     */
    public interface ExportToPathOnHostResponse extends Response {
    }
    
    /**
     * Exports a template as an OVA file to a given path on a specified host.
     */
    ExportToPathOnHostRequest exportToPathOnHost();
    
    /**
     * Updates the template.
     * 
     * The `name`, `description`, `type`, `memory`, `cpu`, `topology`, `os`, `high_availability`, `display`,
     * `stateless`, `usb`, and `timezone` elements can be updated after a template has been created.
     * 
     * For example, to update a template so that it has 1 GiB of memory send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/templates/123
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <memory>1073741824</memory>
     * </template>
     * ----
     * 
     * The `version_name` name attribute is the only one that can be updated within the `version` attribute used for
     * template versions:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <version>
     *     <version_name>mytemplate_2</version_name>
     *   </version>
     * </template>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest template(Template template);
        UpdateRequest template(TemplateBuilder template);
    }
    
    /**
     * Updates the template.
     * 
     * The `name`, `description`, `type`, `memory`, `cpu`, `topology`, `os`, `high_availability`, `display`,
     * `stateless`, `usb`, and `timezone` elements can be updated after a template has been created.
     * 
     * For example, to update a template so that it has 1 GiB of memory send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/templates/123
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <memory>1073741824</memory>
     * </template>
     * ----
     * 
     * The `version_name` name attribute is the only one that can be updated within the `version` attribute used for
     * template versions:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <version>
     *     <version_name>mytemplate_2</version_name>
     *   </version>
     * </template>
     * ----
     */
    public interface UpdateResponse extends Response {
        Template template();
    }
    
    /**
     * Updates the template.
     * 
     * The `name`, `description`, `type`, `memory`, `cpu`, `topology`, `os`, `high_availability`, `display`,
     * `stateless`, `usb`, and `timezone` elements can be updated after a template has been created.
     * 
     * For example, to update a template so that it has 1 GiB of memory send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/templates/123
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <memory>1073741824</memory>
     * </template>
     * ----
     * 
     * The `version_name` name attribute is the only one that can be updated within the `version` attribute used for
     * template versions:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <version>
     *     <version_name>mytemplate_2</version_name>
     *   </version>
     * </template>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Returns a reference to the service that manages the CD-ROMs that are associated with the template.
     */
    TemplateCdromsService cdromsService();
    /**
     * Returns a reference to the service that manages a specific
     * disk attachment of the template.
     */
    TemplateDiskAttachmentsService diskAttachmentsService();
    /**
     * Returns a reference to the service that manages the graphical consoles that are associated with the template.
     */
    TemplateGraphicsConsolesService graphicsConsolesService();
    /**
     * Returns a reference to the service that manages the NICs that are associated with the template.
     */
    TemplateNicsService nicsService();
    /**
     * Returns a reference to the service that manages the permissions that are associated with the template.
     */
    AssignedPermissionsService permissionsService();
    /**
     * Returns a reference to the service that manages the tags that are associated with the template.
     */
    AssignedTagsService tagsService();
    /**
     * Returns a reference to the service that manages the _watchdogs_ that are associated with the template.
     */
    TemplateWatchdogsService watchdogsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

