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
import org.ovirt.engine.sdk4.builders.CpuProfileBuilder;
import org.ovirt.engine.sdk4.types.CpuProfile;

public interface CpuProfilesService extends Service {
    /**
     * Add a new cpu profile to the system.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest profile(CpuProfile profile);
        AddRequest profile(CpuProfileBuilder profile);
    }
    
    /**
     * Add a new cpu profile to the system.
     */
    public interface AddResponse extends Response {
        CpuProfile profile();
    }
    
    /**
     * Add a new cpu profile to the system.
     */
    AddRequest add();
    
    /**
     * Returns the list of CPU profiles of the system.
     * 
     * The order of the returned list of CPU profiles is random.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of profiles to return. If not specified, all the profiles are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of profiles to return. If not specified, all the profiles are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of profiles to return. If not specified, all the profiles are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of CPU profiles of the system.
     * 
     * The order of the returned list of CPU profiles is random.
     */
    public interface ListResponse extends Response {
        List<CpuProfile> profile();
    }
    
    /**
     * Returns the list of CPU profiles of the system.
     * 
     * The order of the returned list of CPU profiles is random.
     */
    ListRequest list();
    
    CpuProfileService profileService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

