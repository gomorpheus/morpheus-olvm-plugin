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
import org.ovirt.engine.sdk4.types.Group;

public interface DomainGroupsService extends Service {
    /**
     * Returns the list of groups.
     * 
     * The order of the returned list of groups isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
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
        /**
         * A query string used to restrict the returned groups.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of groups.
     * 
     * The order of the returned list of groups isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Group> groups();
    }
    
    /**
     * Returns the list of groups.
     * 
     * The order of the returned list of groups isn't guaranteed.
     */
    ListRequest list();
    
    DomainGroupService groupService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

