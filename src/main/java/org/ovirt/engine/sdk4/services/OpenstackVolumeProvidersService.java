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
import org.ovirt.engine.sdk4.builders.OpenStackVolumeProviderBuilder;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenstackVolumeProvidersService extends Service {
    /**
     * Adds a new volume provider.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackvolumeproviders
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_volume_provider>
     *   <name>mycinder</name>
     *   <url>https://mycinder.example.com:8776</url>
     *   <data_center>
     *     <name>mydc</name>
     *   </data_center>
     *   <requires_authentication>true</requires_authentication>
     *   <username>admin</username>
     *   <password>mypassword</password>
     *   <tenant_name>mytenant</tenant_name>
     * </openstack_volume_provider>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest provider(OpenStackVolumeProvider provider);
        AddRequest provider(OpenStackVolumeProviderBuilder provider);
    }
    
    /**
     * Adds a new volume provider.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackvolumeproviders
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_volume_provider>
     *   <name>mycinder</name>
     *   <url>https://mycinder.example.com:8776</url>
     *   <data_center>
     *     <name>mydc</name>
     *   </data_center>
     *   <requires_authentication>true</requires_authentication>
     *   <username>admin</username>
     *   <password>mypassword</password>
     *   <tenant_name>mytenant</tenant_name>
     * </openstack_volume_provider>
     * ----
     */
    public interface AddResponse extends Response {
        OpenStackVolumeProvider provider();
    }
    
    /**
     * Adds a new volume provider.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/openstackvolumeproviders
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <openstack_volume_provider>
     *   <name>mycinder</name>
     *   <url>https://mycinder.example.com:8776</url>
     *   <data_center>
     *     <name>mydc</name>
     *   </data_center>
     *   <requires_authentication>true</requires_authentication>
     *   <username>admin</username>
     *   <password>mypassword</password>
     *   <tenant_name>mytenant</tenant_name>
     * </openstack_volume_provider>
     * ----
     */
    AddRequest add();
    
    /**
     * Retrieves the list of volume providers.
     * 
     * The order of the returned list of volume providers isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of providers to return. If not specified all the providers are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned volume providers.
         */
        ListRequest search(String search);
    }
    
    /**
     * Retrieves the list of volume providers.
     * 
     * The order of the returned list of volume providers isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenStackVolumeProvider> providers();
    }
    
    /**
     * Retrieves the list of volume providers.
     * 
     * The order of the returned list of volume providers isn't guaranteed.
     */
    ListRequest list();
    
    OpenstackVolumeProviderService providerService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

