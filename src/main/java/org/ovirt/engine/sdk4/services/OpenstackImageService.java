/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.TemplateBuilder;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.OpenStackImage;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

public interface OpenstackImageService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        OpenStackImage image();
    }
    
    GetRequest get();
    
    /**
     * Imports a virtual machine from a Glance image storage domain.
     * 
     * For example, to import the image with identifier `456` from the
     * storage domain with identifier `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackimageproviders/123/images/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>images0</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>images0</name>
     *   </cluster>
     * </action>
     * ----
     */
    public interface ImportRequest extends Request<ImportRequest, ImportResponse> {
        /**
         * Indicates if the import should be performed asynchronously.
         */
        ImportRequest async(Boolean async);
        ImportRequest cluster(Cluster cluster);
        /**
         * This parameter is mandatory in case of using `import_as_template` and indicates which cluster should be used
         * for import glance image as template.
         */
        ImportRequest cluster(ClusterBuilder cluster);
        ImportRequest disk(Disk disk);
        ImportRequest disk(DiskBuilder disk);
        /**
         * Indicates whether the image should be imported as a template.
         */
        ImportRequest importAsTemplate(Boolean importAsTemplate);
        ImportRequest storageDomain(StorageDomain storageDomain);
        ImportRequest storageDomain(StorageDomainBuilder storageDomain);
        ImportRequest template(Template template);
        ImportRequest template(TemplateBuilder template);
    }
    
    /**
     * Imports a virtual machine from a Glance image storage domain.
     * 
     * For example, to import the image with identifier `456` from the
     * storage domain with identifier `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackimageproviders/123/images/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>images0</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>images0</name>
     *   </cluster>
     * </action>
     * ----
     */
    public interface ImportResponse extends Response {
    }
    
    /**
     * Imports a virtual machine from a Glance image storage domain.
     * 
     * For example, to import the image with identifier `456` from the
     * storage domain with identifier `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackimageproviders/123/images/456/import
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>images0</name>
     *   </storage_domain>
     *   <cluster>
     *     <name>images0</name>
     *   </cluster>
     * </action>
     * ----
     */
    ImportRequest import_();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

