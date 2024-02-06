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
import org.ovirt.engine.sdk4.types.ExternalHostGroup;

/**
 * This service manages hostgroups.
 */
public interface ExternalHostGroupsService extends Service {
    /**
     * Get host groups list from external host provider.
     * 
     * Host group is a term of host providers - the host group includes provision details. This API returns all possible
     * hostgroups exposed by the external provider.
     * 
     * For example, to get the details of all host groups of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_groups>
     *   <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *     <name>rhel7</name>
     *     <architecture_name>x86_64</architecture_name>
     *     <domain_name>example.com</domain_name>
     *     <operating_system_name>RedHat 7.3</operating_system_name>
     *     <subnet_name>sat0</subnet_name>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *   </external_host_group>
     *   ...
     * </external_host_groups>
     * ----
     * 
     * The order of the returned list of host groups isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of groups to return. If not specified all the groups are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Get host groups list from external host provider.
     * 
     * Host group is a term of host providers - the host group includes provision details. This API returns all possible
     * hostgroups exposed by the external provider.
     * 
     * For example, to get the details of all host groups of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_groups>
     *   <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *     <name>rhel7</name>
     *     <architecture_name>x86_64</architecture_name>
     *     <domain_name>example.com</domain_name>
     *     <operating_system_name>RedHat 7.3</operating_system_name>
     *     <subnet_name>sat0</subnet_name>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *   </external_host_group>
     *   ...
     * </external_host_groups>
     * ----
     * 
     * The order of the returned list of host groups isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of all hostgroups available for external host provider
         */
        List<ExternalHostGroup> groups();
    }
    
    /**
     * Get host groups list from external host provider.
     * 
     * Host group is a term of host providers - the host group includes provision details. This API returns all possible
     * hostgroups exposed by the external provider.
     * 
     * For example, to get the details of all host groups of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups
     * ....
     * 
     * The response will be like this:
     * 
     * [source,xml]
     * ----
     * <external_host_groups>
     *   <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *     <name>rhel7</name>
     *     <architecture_name>x86_64</architecture_name>
     *     <domain_name>example.com</domain_name>
     *     <operating_system_name>RedHat 7.3</operating_system_name>
     *     <subnet_name>sat0</subnet_name>
     *     <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     *   </external_host_group>
     *   ...
     * </external_host_groups>
     * ----
     * 
     * The order of the returned list of host groups isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * This service manages hostgroup instance.
     */
    ExternalHostGroupService groupService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

