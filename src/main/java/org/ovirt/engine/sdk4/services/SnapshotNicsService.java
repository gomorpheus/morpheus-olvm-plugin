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
import org.ovirt.engine.sdk4.types.Nic;

/**
 * Manages the set of NICs of an snapshot.
 */
public interface SnapshotNicsService extends Service {
    /**
     * Returns the list of NICs of the snapshot.
     * 
     * The order of the returned list of NICs isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of NICs to return. If not specified all the NICs are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of NICs of the snapshot.
     * 
     * The order of the returned list of NICs isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Nic> nics();
    }
    
    /**
     * Returns the list of NICs of the snapshot.
     * 
     * The order of the returned list of NICs isn't guaranteed.
     */
    ListRequest list();
    
    SnapshotNicService nicService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

