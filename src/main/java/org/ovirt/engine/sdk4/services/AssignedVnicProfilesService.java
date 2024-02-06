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

public interface AssignedVnicProfilesService extends Service {
    /**
     * Add a new virtual network interface card profile for the network.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest profile(VnicProfile profile);
        AddRequest profile(VnicProfileBuilder profile);
    }
    
    /**
     * Add a new virtual network interface card profile for the network.
     */
    public interface AddResponse extends Response {
        VnicProfile profile();
    }
    
    /**
     * Add a new virtual network interface card profile for the network.
     */
    AddRequest add();
    
    /**
     * Returns the list of VNIC profiles assifned to the network.
     * 
     * The order of the returned VNIC profiles isn't guaranteed.
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
     * Returns the list of VNIC profiles assifned to the network.
     * 
     * The order of the returned VNIC profiles isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<VnicProfile> profiles();
    }
    
    /**
     * Returns the list of VNIC profiles assifned to the network.
     * 
     * The order of the returned VNIC profiles isn't guaranteed.
     */
    ListRequest list();
    
    AssignedVnicProfileService profileService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

