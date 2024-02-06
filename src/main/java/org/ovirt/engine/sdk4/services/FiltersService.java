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
import org.ovirt.engine.sdk4.builders.FilterBuilder;
import org.ovirt.engine.sdk4.types.Filter;

/**
 * Manages the filters used by an scheduling policy.
 */
public interface FiltersService extends Service {
    /**
     * Add a filter to a specified user defined scheduling policy.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest filter(Filter filter);
        AddRequest filter(FilterBuilder filter);
    }
    
    /**
     * Add a filter to a specified user defined scheduling policy.
     */
    public interface AddResponse extends Response {
        Filter filter();
    }
    
    /**
     * Add a filter to a specified user defined scheduling policy.
     */
    AddRequest add();
    
    /**
     * Returns the list of filters used by the scheduling policy.
     * 
     * The order of the returned list of filters isn't guaranteed.
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
         * Sets the maximum number of filters to return. If not specified all the filters are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of filters to return. If not specified all the filters are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of filters to return. If not specified all the filters are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of filters used by the scheduling policy.
     * 
     * The order of the returned list of filters isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Filter> filters();
    }
    
    /**
     * Returns the list of filters used by the scheduling policy.
     * 
     * The order of the returned list of filters isn't guaranteed.
     */
    ListRequest list();
    
    FilterService filterService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

