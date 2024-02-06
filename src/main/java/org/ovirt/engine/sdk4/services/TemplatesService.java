/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.types.Template;

/**
 * This service manages the virtual machine templates available in the system.
 */
public interface TemplatesService extends Service {
    /**
     * Creates a new template.
     * 
     * This requires the `name` and `vm` elements. To identify the virtual machine use the `vm.id` or `vm.name`
     * attributes. For example, to create a template from a virtual machine with the identifier `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     * </template>
     * ----
     * 
     * Since version 4.3, in order to create virtual machine template from a snapshot send a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <snapshots>
     *       <snapshot id="456"/>
     *     </snapshots>
     *   </vm>
     * </template>
     * ----
     * 
     * The disks of the template can be customized, making some of their characteristics different from the disks of the
     * original virtual machine. To do so use the `vm.disk_attachments` attribute, specifying the identifier of the disk
     * of the original virtual machine and the characteristics that you want to change. For example, if the original
     * virtual machine has a disk with the identifier `456`, and, for that disk, you want to change the name to `mydisk`
     * the format to <<types/disk_format, _Copy On Write_>> and make it <<types/disk, sparse>>, send a request body like
     * this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <name>mydisk</name>
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * The template can be created as a sub-version of an existing template. This requires the `name` and `vm` attributes
     * for the new template, and the `base_template` and `version_name` attributes for the new template version. The
     * `base_template` and `version_name` attributes must be specified within a `version` section enclosed in the
     * `template` section. Identify the virtual machine with the `id` or `name` attributes.
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     *   <version>
     *     <base_template id="456"/>
     *     <version_name>mytemplate_001</version_name>
     *   </version>
     * </template>
     * ----
     * 
     * The destination storage domain of the template can be customized, in one of two ways:
     * 
     * 1. Globally, at the request level. The request must list the desired disk attachments to be created on the
     * storage domain. If the disk attachments are not listed, the global storage domain parameter will be ignored.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <storage_domain id="123"/>
     *   <vm id="456">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="789">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * 2. Per each disk attachment. Specify the desired storage domain for each disk attachment.
     * Specifying the global storage definition will override the storage domain per disk attachment specification.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *           <storage_domains>
     *              <storage_domain id="789"/>
     *           </storage_domains>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        /**
         * Specifies if the permissions of the virtual machine should be copied to the template.
         * 
         * If this optional parameter is provided, and its value is `true`, then the permissions of the virtual machine
         * (only the direct ones, not the inherited ones) will be copied to the created template. For example, to create
         * a template from the `myvm` virtual machine copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/templates?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <template>
         *   <name>mytemplate<name>
         *   <vm>
         *     <name>myvm<name>
         *   </vm>
         * </template>
         * ----
         */
        AddRequest clonePermissions(Boolean clonePermissions);
        /**
         * Seals the template.
         * 
         * If this optional parameter is provided and its value is `true`,
         * then the template is sealed after creation.
         * 
         * Sealing erases all host-specific configuration from the filesystem:
         * SSH keys, UDEV rules, MAC addresses, system ID, hostname, and so on,
         * thus making it easier to use the template to create multiple virtual
         * machines without manual intervention.
         * 
         * Currently, sealing is supported only for Linux operating systems.
         */
        AddRequest seal(Boolean seal);
        AddRequest template(Template template);
        /**
         * The information about the template or template version.
         */
        AddRequest template(TemplateBuilder template);
    }
    
    /**
     * Creates a new template.
     * 
     * This requires the `name` and `vm` elements. To identify the virtual machine use the `vm.id` or `vm.name`
     * attributes. For example, to create a template from a virtual machine with the identifier `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     * </template>
     * ----
     * 
     * Since version 4.3, in order to create virtual machine template from a snapshot send a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <snapshots>
     *       <snapshot id="456"/>
     *     </snapshots>
     *   </vm>
     * </template>
     * ----
     * 
     * The disks of the template can be customized, making some of their characteristics different from the disks of the
     * original virtual machine. To do so use the `vm.disk_attachments` attribute, specifying the identifier of the disk
     * of the original virtual machine and the characteristics that you want to change. For example, if the original
     * virtual machine has a disk with the identifier `456`, and, for that disk, you want to change the name to `mydisk`
     * the format to <<types/disk_format, _Copy On Write_>> and make it <<types/disk, sparse>>, send a request body like
     * this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <name>mydisk</name>
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * The template can be created as a sub-version of an existing template. This requires the `name` and `vm` attributes
     * for the new template, and the `base_template` and `version_name` attributes for the new template version. The
     * `base_template` and `version_name` attributes must be specified within a `version` section enclosed in the
     * `template` section. Identify the virtual machine with the `id` or `name` attributes.
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     *   <version>
     *     <base_template id="456"/>
     *     <version_name>mytemplate_001</version_name>
     *   </version>
     * </template>
     * ----
     * 
     * The destination storage domain of the template can be customized, in one of two ways:
     * 
     * 1. Globally, at the request level. The request must list the desired disk attachments to be created on the
     * storage domain. If the disk attachments are not listed, the global storage domain parameter will be ignored.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <storage_domain id="123"/>
     *   <vm id="456">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="789">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * 2. Per each disk attachment. Specify the desired storage domain for each disk attachment.
     * Specifying the global storage definition will override the storage domain per disk attachment specification.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *           <storage_domains>
     *              <storage_domain id="789"/>
     *           </storage_domains>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The information about the template or template version.
         */
        Template template();
    }
    
    /**
     * Creates a new template.
     * 
     * This requires the `name` and `vm` elements. To identify the virtual machine use the `vm.id` or `vm.name`
     * attributes. For example, to create a template from a virtual machine with the identifier `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/templates
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     * </template>
     * ----
     * 
     * Since version 4.3, in order to create virtual machine template from a snapshot send a request body like this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <snapshots>
     *       <snapshot id="456"/>
     *     </snapshots>
     *   </vm>
     * </template>
     * ----
     * 
     * The disks of the template can be customized, making some of their characteristics different from the disks of the
     * original virtual machine. To do so use the `vm.disk_attachments` attribute, specifying the identifier of the disk
     * of the original virtual machine and the characteristics that you want to change. For example, if the original
     * virtual machine has a disk with the identifier `456`, and, for that disk, you want to change the name to `mydisk`
     * the format to <<types/disk_format, _Copy On Write_>> and make it <<types/disk, sparse>>, send a request body like
     * this:
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <name>mydisk</name>
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * The template can be created as a sub-version of an existing template. This requires the `name` and `vm` attributes
     * for the new template, and the `base_template` and `version_name` attributes for the new template version. The
     * `base_template` and `version_name` attributes must be specified within a `version` section enclosed in the
     * `template` section. Identify the virtual machine with the `id` or `name` attributes.
     * 
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123"/>
     *   <version>
     *     <base_template id="456"/>
     *     <version_name>mytemplate_001</version_name>
     *   </version>
     * </template>
     * ----
     * 
     * The destination storage domain of the template can be customized, in one of two ways:
     * 
     * 1. Globally, at the request level. The request must list the desired disk attachments to be created on the
     * storage domain. If the disk attachments are not listed, the global storage domain parameter will be ignored.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <storage_domain id="123"/>
     *   <vm id="456">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="789">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     * 
     * 2. Per each disk attachment. Specify the desired storage domain for each disk attachment.
     * Specifying the global storage definition will override the storage domain per disk attachment specification.
     * +
     * [source,xml]
     * ----
     * <template>
     *   <name>mytemplate</name>
     *   <vm id="123">
     *     <disk_attachments>
     *       <disk_attachment>
     *         <disk id="456">
     *           <format>cow</format>
     *           <sparse>true</sparse>
     *           <storage_domains>
     *              <storage_domain id="789"/>
     *           </storage_domains>
     *         </disk>
     *       </disk_attachment>
     *     </disk_attachments>
     *   </vm>
     * </template>
     * ----
     */
    AddRequest add();
    
    /**
     * Add a virtual machine template to the system from a configuration. Requires the configuration type, the configuration data, and the target cluster.
     */
    public interface AddFromConfigurationRequest extends Request<AddFromConfigurationRequest, AddFromConfigurationResponse> {
        /**
         * Specifies if the permissions of the virtual machine should be copied to the template.
         * 
         * If this optional parameter is provided, and its value is `true`, then the permissions of the virtual machine
         * (only the direct ones, not the inherited ones) will be copied to the created template. For example, to create
         * a template from the `myvm` virtual machine copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/templates?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <template>
         *   <name>mytemplate<name>
         *   <vm>
         *     <name>myvm<name>
         *   </vm>
         * </template>
         * ----
         */
        AddFromConfigurationRequest clonePermissions(Boolean clonePermissions);
        /**
         * Seals the template.
         * 
         * If this optional parameter is provided and its value is `true`,
         * then the template is sealed after creation.
         * 
         * Sealing erases all host-specific configuration from the filesystem:
         * SSH keys, UDEV rules, MAC addresses, system ID, hostname, and so on,
         * thus making it easier to use the template to create multiple virtual
         * machines without manual intervention.
         * 
         * Currently, sealing is supported only for Linux operating systems.
         */
        AddFromConfigurationRequest seal(Boolean seal);
        AddFromConfigurationRequest template(Template template);
        /**
         * The information about the template or template version.
         */
        AddFromConfigurationRequest template(TemplateBuilder template);
    }
    
    /**
     * Add a virtual machine template to the system from a configuration. Requires the configuration type, the configuration data, and the target cluster.
     */
    public interface AddFromConfigurationResponse extends Response {
        /**
         * The information about the template or template version.
         */
        Template template();
    }
    
    /**
     * Add a virtual machine template to the system from a configuration. Requires the configuration type, the configuration data, and the target cluster.
     */
    AddFromConfigurationRequest addFromConfiguration();
    
    /**
     * Add a virtual machine template to the system from an existing virtual machine.
     */
    public interface AddFromVmRequest extends Request<AddFromVmRequest, AddFromVmResponse> {
        /**
         * Specifies if the permissions of the virtual machine should be copied to the template.
         * 
         * If this optional parameter is provided, and its value is `true`, then the permissions of the virtual machine
         * (only the direct ones, not the inherited ones) will be copied to the created template. For example, to create
         * a template from the `myvm` virtual machine copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/templates?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <template>
         *   <name>mytemplate<name>
         *   <vm>
         *     <name>myvm<name>
         *   </vm>
         * </template>
         * ----
         */
        AddFromVmRequest clonePermissions(Boolean clonePermissions);
        /**
         * Seals the template.
         * 
         * If this optional parameter is provided and its value is `true`,
         * then the template is sealed after creation.
         * 
         * Sealing erases all host-specific configuration from the filesystem:
         * SSH keys, UDEV rules, MAC addresses, system ID, hostname, and so on,
         * thus making it easier to use the template to create multiple virtual
         * machines without manual intervention.
         * 
         * Currently, sealing is supported only for Linux operating systems.
         */
        AddFromVmRequest seal(Boolean seal);
        AddFromVmRequest template(Template template);
        /**
         * The information about the template or template version.
         */
        AddFromVmRequest template(TemplateBuilder template);
    }
    
    /**
     * Add a virtual machine template to the system from an existing virtual machine.
     */
    public interface AddFromVmResponse extends Response {
        /**
         * The information about the template or template version.
         */
        Template template();
    }
    
    /**
     * Add a virtual machine template to the system from an existing virtual machine.
     */
    AddFromVmRequest addFromVm();
    
    /**
     * Add a virtual machine template to the system from a snapshot.
     */
    public interface AddFromVmSnapshotRequest extends Request<AddFromVmSnapshotRequest, AddFromVmSnapshotResponse> {
        /**
         * Specifies if the permissions of the virtual machine should be copied to the template.
         * 
         * If this optional parameter is provided, and its value is `true`, then the permissions of the virtual machine
         * (only the direct ones, not the inherited ones) will be copied to the created template. For example, to create
         * a template from the `myvm` virtual machine copying its permissions, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/templates?clone_permissions=true
         * ----
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <template>
         *   <name>mytemplate<name>
         *   <vm>
         *     <name>myvm<name>
         *   </vm>
         * </template>
         * ----
         */
        AddFromVmSnapshotRequest clonePermissions(Boolean clonePermissions);
        /**
         * Seals the template.
         * 
         * If this optional parameter is provided and its value is `true`,
         * then the template is sealed after creation.
         * 
         * Sealing erases all host-specific configuration from the filesystem:
         * SSH keys, UDEV rules, MAC addresses, system ID, hostname, and so on,
         * thus making it easier to use the template to create multiple virtual
         * machines without manual intervention.
         * 
         * Currently, sealing is supported only for Linux operating systems.
         */
        AddFromVmSnapshotRequest seal(Boolean seal);
        AddFromVmSnapshotRequest template(Template template);
        /**
         * The information about the template or template version.
         */
        AddFromVmSnapshotRequest template(TemplateBuilder template);
    }
    
    /**
     * Add a virtual machine template to the system from a snapshot.
     */
    public interface AddFromVmSnapshotResponse extends Response {
        /**
         * The information about the template or template version.
         */
        Template template();
    }
    
    /**
     * Add a virtual machine template to the system from a snapshot.
     */
    AddFromVmSnapshotRequest addFromVmSnapshot();
    
    /**
     * Returns the list of virtual machine templates.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates
     * ----
     * 
     * Will return the list of virtual machines and virtual machine templates.
     * 
     * The order of the returned list of templates is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of templates to return. If not specified, all the templates are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of templates to return. If not specified, all the templates are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of templates to return. If not specified, all the templates are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned templates.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of virtual machine templates.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates
     * ----
     * 
     * Will return the list of virtual machines and virtual machine templates.
     * 
     * The order of the returned list of templates is not guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of virtual machine templates.
         */
        List<Template> templates();
    }
    
    /**
     * Returns the list of virtual machine templates.
     * 
     * For example:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates
     * ----
     * 
     * Will return the list of virtual machines and virtual machine templates.
     * 
     * The order of the returned list of templates is not guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific virtual machine template.
     */
    TemplateService templateService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

