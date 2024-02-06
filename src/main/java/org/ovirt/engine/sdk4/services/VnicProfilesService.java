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
import org.ovirt.engine.sdk4.builders.VnicProfileBuilder;
import org.ovirt.engine.sdk4.types.VnicProfile;

/**
 * This service manages the collection of all vNIC profiles.
 */
public interface VnicProfilesService extends Service {
    /**
     * Add a vNIC profile.
     * 
     * For example to add vNIC profile `123` to network `456` send a request to:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/456/vnicprofiles
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vnic_profile id="123">
     *   <name>new_vNIC_name</name>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     * </vnic_profile>
     * ----
     * 
     * Please note that there is a default network filter to each VNIC profile.
     * For more details of how the default network filter is calculated please refer to
     * the documentation in <<services/network_filters,NetworkFilters>>.
     * 
     * NOTE: The automatically created vNIC profile for the external network will be without network filter.
     * 
     * The output of creating a new VNIC profile depends in the  body  arguments that were given.
     * In case no network filter was given, the default network filter will be configured. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile href="/ovirt-engine/api/vnicprofiles/123" id="123">
     *   <name>new_vNIC_name</name>
     *   <link href="/ovirt-engine/api/vnicprofiles/123/permissions" rel="permissions"/>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     *   <network href="/ovirt-engine/api/networks/456" id="456"/>
     *   <network_filter href="/ovirt-engine/api/networkfilters/789" id="789"/>
     * </vnic_profile>
     * ----
     * 
     * In case an empty network filter was given, no network filter will be configured for the specific VNIC profile
     * regardless of the VNIC profile's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>no_network_filter</name>
     *   <network_filter/>
     * </vnic_profile>
     * ----
     * 
     * In case that a specific valid network filter id was given, the VNIC profile will be configured with the given
     * network filter regardless of the VNIC profiles's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>user_choice_network_filter</name>
     *   <network_filter id= "0000001b-001b-001b-001b-0000000001d5"/>
     * </vnic_profile>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest profile(VnicProfile profile);
        /**
         * The vNIC profile that is being added.
         */
        AddRequest profile(VnicProfileBuilder profile);
    }
    
    /**
     * Add a vNIC profile.
     * 
     * For example to add vNIC profile `123` to network `456` send a request to:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/456/vnicprofiles
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vnic_profile id="123">
     *   <name>new_vNIC_name</name>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     * </vnic_profile>
     * ----
     * 
     * Please note that there is a default network filter to each VNIC profile.
     * For more details of how the default network filter is calculated please refer to
     * the documentation in <<services/network_filters,NetworkFilters>>.
     * 
     * NOTE: The automatically created vNIC profile for the external network will be without network filter.
     * 
     * The output of creating a new VNIC profile depends in the  body  arguments that were given.
     * In case no network filter was given, the default network filter will be configured. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile href="/ovirt-engine/api/vnicprofiles/123" id="123">
     *   <name>new_vNIC_name</name>
     *   <link href="/ovirt-engine/api/vnicprofiles/123/permissions" rel="permissions"/>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     *   <network href="/ovirt-engine/api/networks/456" id="456"/>
     *   <network_filter href="/ovirt-engine/api/networkfilters/789" id="789"/>
     * </vnic_profile>
     * ----
     * 
     * In case an empty network filter was given, no network filter will be configured for the specific VNIC profile
     * regardless of the VNIC profile's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>no_network_filter</name>
     *   <network_filter/>
     * </vnic_profile>
     * ----
     * 
     * In case that a specific valid network filter id was given, the VNIC profile will be configured with the given
     * network filter regardless of the VNIC profiles's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>user_choice_network_filter</name>
     *   <network_filter id= "0000001b-001b-001b-001b-0000000001d5"/>
     * </vnic_profile>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The vNIC profile that is being added.
         */
        VnicProfile profile();
    }
    
    /**
     * Add a vNIC profile.
     * 
     * For example to add vNIC profile `123` to network `456` send a request to:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/networks/456/vnicprofiles
     * ----
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vnic_profile id="123">
     *   <name>new_vNIC_name</name>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     * </vnic_profile>
     * ----
     * 
     * Please note that there is a default network filter to each VNIC profile.
     * For more details of how the default network filter is calculated please refer to
     * the documentation in <<services/network_filters,NetworkFilters>>.
     * 
     * NOTE: The automatically created vNIC profile for the external network will be without network filter.
     * 
     * The output of creating a new VNIC profile depends in the  body  arguments that were given.
     * In case no network filter was given, the default network filter will be configured. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile href="/ovirt-engine/api/vnicprofiles/123" id="123">
     *   <name>new_vNIC_name</name>
     *   <link href="/ovirt-engine/api/vnicprofiles/123/permissions" rel="permissions"/>
     *   <pass_through>
     *     <mode>disabled</mode>
     *   </pass_through>
     *   <port_mirroring>false</port_mirroring>
     *   <network href="/ovirt-engine/api/networks/456" id="456"/>
     *   <network_filter href="/ovirt-engine/api/networkfilters/789" id="789"/>
     * </vnic_profile>
     * ----
     * 
     * In case an empty network filter was given, no network filter will be configured for the specific VNIC profile
     * regardless of the VNIC profile's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>no_network_filter</name>
     *   <network_filter/>
     * </vnic_profile>
     * ----
     * 
     * In case that a specific valid network filter id was given, the VNIC profile will be configured with the given
     * network filter regardless of the VNIC profiles's default network filter. For example:
     * 
     * [source,xml]
     * ----
     * <vnic_profile>
     *   <name>user_choice_network_filter</name>
     *   <network_filter id= "0000001b-001b-001b-001b-0000000001d5"/>
     * </vnic_profile>
     * ----
     */
    AddRequest add();
    
    /**
     * List all vNIC profiles.
     * 
     * The order of the returned list of vNIC profiles isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of profiles to return. If not specified all the profiles are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of profiles to return. If not specified all the profiles are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of profiles to return. If not specified all the profiles are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List all vNIC profiles.
     * 
     * The order of the returned list of vNIC profiles isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of all vNIC profiles.
         */
        List<VnicProfile> profiles();
    }
    
    /**
     * List all vNIC profiles.
     * 
     * The order of the returned list of vNIC profiles isn't guaranteed.
     */
    ListRequest list();
    
    VnicProfileService profileService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

