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
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.types.Host;

/**
 * This service manages a collection of all hosts assigned to an affinity group.
 */
public interface AffinityGroupHostsService extends Service {
    /**
     * Adds a host to the affinity group.
     * 
     * For example, to add the host `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/hosts
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <host id="789"/>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest host(Host host);
        /**
         * The host to be added to the affinity group.
         */
        AddRequest host(HostBuilder host);
    }
    
    /**
     * Adds a host to the affinity group.
     * 
     * For example, to add the host `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/hosts
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <host id="789"/>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The host to be added to the affinity group.
         */
        Host host();
    }
    
    /**
     * Adds a host to the affinity group.
     * 
     * For example, to add the host `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/hosts
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <host id="789"/>
     * ----
     */
    AddRequest add();
    
    /**
     * List all hosts assigned to this affinity group.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of hosts to return. If not specified, all the hosts are
         * returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of hosts to return. If not specified, all the hosts are
         * returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of hosts to return. If not specified, all the hosts are
         * returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List all hosts assigned to this affinity group.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of hosts assigned to this affinity group.
         */
        List<Host> hosts();
    }
    
    /**
     * List all hosts assigned to this affinity group.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the service that manages the host assignment to this affinity group.
     */
    AffinityGroupHostService hostService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

