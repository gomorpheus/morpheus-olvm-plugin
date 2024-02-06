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
import org.ovirt.engine.sdk4.types.Template;

/**
 * Manages the set of templates available in a storage domain.
 */
public interface StorageDomainTemplatesService extends Service {
    /**
     * Returns the list of templates availalbe in the storage domain.
     * 
     * The order of the returned list of templates isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of templates to return. If not specified all the templates are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of templates to return. If not specified all the templates are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of templates to return. If not specified all the templates are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * Indicates whether to retrieve a list of registered or unregistered templates which contain disks on the storage domain.
         * To get a list of unregistered templates the call should indicate the unregistered flag.
         * For example, to get a list of unregistered templates the REST API call should look like this:
         * 
         * ....
         * GET /ovirt-engine/api/storagedomains/123/templates?unregistered=true
         * ....
         * 
         * The default value of the unregisterd flag is `false`.
         * The request only apply to storage domains that are attached.
         */
        ListRequest unregistered(Boolean unregistered);
    }
    
    /**
     * Returns the list of templates availalbe in the storage domain.
     * 
     * The order of the returned list of templates isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Template> templates();
    }
    
    /**
     * Returns the list of templates availalbe in the storage domain.
     * 
     * The order of the returned list of templates isn't guaranteed.
     */
    ListRequest list();
    
    StorageDomainTemplateService templateService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

