/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.ExternalHostGroup;

/**
 * This service manages a single host group information.
 * 
 * Host group is a term of host provider - the host group includes provision details that are applied to new discovered
 * host. Information such as subnet, operating system, domain, etc.
 */
public interface ExternalHostGroupService extends Service {
    /**
     * Get host group information.
     * 
     * For example, to get the details of hostgroup `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *   <name>rhel7</name>
     *   <architecture_name>x86_64</architecture_name>
     *   <domain_name>s.com</domain_name>
     *   <operating_system_name>RedHat 7.3</operating_system_name>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_host_group>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Get host group information.
     * 
     * For example, to get the details of hostgroup `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *   <name>rhel7</name>
     *   <architecture_name>x86_64</architecture_name>
     *   <domain_name>s.com</domain_name>
     *   <operating_system_name>RedHat 7.3</operating_system_name>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_host_group>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Host group information.
         */
        ExternalHostGroup group();
    }
    
    /**
     * Get host group information.
     * 
     * For example, to get the details of hostgroup `234` of provider `123`, send a request like this:
     * 
     * ....
     * GET /ovirt-engine/api/externalhostproviders/123/hostgroups/234
     * ....
     * 
     * It will return a response like this:
     * 
     * [source,xml]
     * ----
     * <external_host_group href="/ovirt-engine/api/externalhostproviders/123/hostgroups/234" id="234">
     *   <name>rhel7</name>
     *   <architecture_name>x86_64</architecture_name>
     *   <domain_name>s.com</domain_name>
     *   <operating_system_name>RedHat 7.3</operating_system_name>
     *   <subnet_name>sat0</subnet_name>
     *   <external_host_provider href="/ovirt-engine/api/externalhostproviders/123" id="123"/>
     * </external_host_group>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

