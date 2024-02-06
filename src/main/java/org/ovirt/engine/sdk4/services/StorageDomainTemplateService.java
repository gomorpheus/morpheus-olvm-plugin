/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.RegistrationConfigurationBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.builders.VnicProfileMappingBuilder;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public interface StorageDomainTemplateService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Template template();
    }
    
    GetRequest get();
    
    /**
     * Action to import a template from an export storage domain.
     * 
     * For example, to import the template `456` from the storage domain `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/templates/456/import
     * ----
     * 
     * With the following request body:
     * 
     * [source, xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    public interface ImportRequest extends Request<ImportRequest, ImportResponse> {
        /**
         * Indicates if the import should be performed asynchronously.
         */
        ImportRequest async(Boolean async);
        /**
         * Use the optional `clone` parameter to generate new UUIDs for the imported template and its entities.
         * 
         * You can import a template with the `clone` parameter set to `false` when importing a template
         * from an export domain, with templates that were exported by a different {product-name} environment.
         */
        ImportRequest clone_(Boolean clone_);
        ImportRequest cluster(Cluster cluster);
        ImportRequest cluster(ClusterBuilder cluster);
        ImportRequest exclusive(Boolean exclusive);
        ImportRequest storageDomain(StorageDomain storageDomain);
        ImportRequest storageDomain(StorageDomainBuilder storageDomain);
        ImportRequest template(Template template);
        ImportRequest template(TemplateBuilder template);
        ImportRequest vm(Vm vm);
        ImportRequest vm(VmBuilder vm);
    }
    
    /**
     * Action to import a template from an export storage domain.
     * 
     * For example, to import the template `456` from the storage domain `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/templates/456/import
     * ----
     * 
     * With the following request body:
     * 
     * [source, xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    public interface ImportResponse extends Response {
    }
    
    /**
     * Action to import a template from an export storage domain.
     * 
     * For example, to import the template `456` from the storage domain `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storagedomains/123/templates/456/import
     * ----
     * 
     * With the following request body:
     * 
     * [source, xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>mycluster</name>
     *   </cluster>
     * </action>
     * ----
     * 
     * If you register an entity without specifying the cluster ID or name,
     * the cluster name from the entity's OVF will be used (unless the register request also includes the
     * cluster mapping).
     */
    ImportRequest import_();
    
    /**
     * Register the Template means importing the Template from the data domain by inserting the configuration of the
     * Template and disks into the database without the copy process.
     */
    public interface RegisterRequest extends Request<RegisterRequest, RegisterResponse> {
        /**
         * Indicates whether a template is allowed to be registered with only some of its disks.
         * 
         * If this flag is `true`, the system will not fail in the validation process if an image is not found, but
         * instead it will allow the template to be registered without the missing disks. This is mainly used during
         * registration of a template when some of the storage domains are not available. The default value is `false`.
         */
        RegisterRequest allowPartialImport(Boolean allowPartialImport);
        /**
         * Indicates if the registration should be performed asynchronously.
         */
        RegisterRequest async(Boolean async);
        RegisterRequest clone_(Boolean clone_);
        RegisterRequest cluster(Cluster cluster);
        RegisterRequest cluster(ClusterBuilder cluster);
        RegisterRequest exclusive(Boolean exclusive);
        RegisterRequest registrationConfiguration(RegistrationConfiguration registrationConfiguration);
        /**
         * This parameter describes how the template should be
         * registered.
         * 
         * This parameter is optional. If the parameter is not specified, the template
         * will be registered with the same configuration that
         * it had in the original environment where it was created.
         */
        RegisterRequest registrationConfiguration(RegistrationConfigurationBuilder registrationConfiguration);
        RegisterRequest template(Template template);
        RegisterRequest template(TemplateBuilder template);
        RegisterRequest vnicProfileMappings(List<VnicProfileMapping> vnicProfileMappings);
        /**
         * Deprecated attribute describing mapping rules for virtual NIC profiles that will be applied during the import\register process.
         * 
         * WARNING: Please note that this attribute has been deprecated since version 4.2.1 of the engine, and preserved only for backward
         * compatibility. It will be removed in the future. To specify `vnic_profile_mappings` use the `vnic_profile_mappings`
         * attribute inside the <<types/registration_configuration, RegistrationConfiguration>> type.
         */
        RegisterRequest vnicProfileMappings(VnicProfileMapping... vnicProfileMappings);
        /**
         * Deprecated attribute describing mapping rules for virtual NIC profiles that will be applied during the import\register process.
         * 
         * WARNING: Please note that this attribute has been deprecated since version 4.2.1 of the engine, and preserved only for backward
         * compatibility. It will be removed in the future. To specify `vnic_profile_mappings` use the `vnic_profile_mappings`
         * attribute inside the <<types/registration_configuration, RegistrationConfiguration>> type.
         */
        RegisterRequest vnicProfileMappings(VnicProfileMappingBuilder... vnicProfileMappings);
    }
    
    /**
     * Register the Template means importing the Template from the data domain by inserting the configuration of the
     * Template and disks into the database without the copy process.
     */
    public interface RegisterResponse extends Response {
    }
    
    /**
     * Register the Template means importing the Template from the data domain by inserting the configuration of the
     * Template and disks into the database without the copy process.
     */
    RegisterRequest register();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    StorageDomainContentDisksService disksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

