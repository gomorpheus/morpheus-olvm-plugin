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
import org.ovirt.engine.sdk4.types.Vm;

/**
 * Lists the virtual machines of an export storage domain.
 * 
 * For example, to retrieve the virtual machines that are available in the storage domain with identifier `123` send the
 * following request:
 * 
 * [source]
 * ----
 * GET /ovirt-engine/api/storagedomains/123/vms
 * ----
 * 
 * This will return the following response body:
 * 
 * [source,xml]
 * ----
 * <vms>
 *   <vm id="456" href="/api/storagedomains/123/vms/456">
 *     <name>vm1</name>
 *     ...
 *     <storage_domain id="123" href="/api/storagedomains/123"/>
 *     <actions>
 *       <link rel="import" href="/api/storagedomains/123/vms/456/import"/>
 *     </actions>
 *   </vm>
 * </vms>
 * ----
 * 
 * Virtual machines and templates in these collections have a similar representation to their counterparts in the
 * top-level <<types/vm, Vm>> and <<types/template, Template>> collections, except they also contain a
 * <<types/storage_domain, StorageDomain>> reference and an <<services/storage_domain_vm/methods/import, import>>
 * action.
 */
public interface StorageDomainVmsService extends Service {
    /**
     * Returns the list of virtual machines of the export storage domain.
     * 
     * The order of the returned list of virtual machines isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of virtual machines to return. If not specified all the virtual machines are
         * returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of virtual machines to return. If not specified all the virtual machines are
         * returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of virtual machines to return. If not specified all the virtual machines are
         * returned.
         */
        ListRequest max(BigInteger max);
        /**
         * Indicates whether to retrieve a list of registered or unregistered virtual machines which
         * contain disks on the storage domain.
         * To get a list of unregistered virtual machines the call should indicate the unregistered flag.
         * For example, to get a list of unregistered virtual machines the REST API call should look like this:
         * 
         * ....
         * GET /ovirt-engine/api/storagedomains/123/vms?unregistered=true
         * ....
         * 
         * The default value of the unregisterd flag is `false`.
         * The request only apply to storage domains that are attached.
         */
        ListRequest unregistered(Boolean unregistered);
    }
    
    /**
     * Returns the list of virtual machines of the export storage domain.
     * 
     * The order of the returned list of virtual machines isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Vm> vm();
    }
    
    /**
     * Returns the list of virtual machines of the export storage domain.
     * 
     * The order of the returned list of virtual machines isn't guaranteed.
     */
    ListRequest list();
    
    StorageDomainVmService vmService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

