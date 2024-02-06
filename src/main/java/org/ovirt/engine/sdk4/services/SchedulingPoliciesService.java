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
import org.ovirt.engine.sdk4.builders.SchedulingPolicyBuilder;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;

/**
 * Manages the set of scheduling policies available in the system.
 */
public interface SchedulingPoliciesService extends Service {
    /**
     * Add a new scheduling policy to the system.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest policy(SchedulingPolicy policy);
        AddRequest policy(SchedulingPolicyBuilder policy);
    }
    
    /**
     * Add a new scheduling policy to the system.
     */
    public interface AddResponse extends Response {
        SchedulingPolicy policy();
    }
    
    /**
     * Add a new scheduling policy to the system.
     */
    AddRequest add();
    
    /**
     * Returns the list of scheduling policies available in the system.
     * 
     * The order of the returned list of scheduling policies isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
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
         * Sets the maximum number of policies to return. If not specified all the policies are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of policies to return. If not specified all the policies are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of policies to return. If not specified all the policies are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of scheduling policies available in the system.
     * 
     * The order of the returned list of scheduling policies isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<SchedulingPolicy> policies();
    }
    
    /**
     * Returns the list of scheduling policies available in the system.
     * 
     * The order of the returned list of scheduling policies isn't guaranteed.
     */
    ListRequest list();
    
    SchedulingPolicyService policyService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

