/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.types.Host;

/**
 * This service represents list of hosts that have a specific
 * label when accessed through the affinitylabels/hosts
 * subcollection.
 */
public interface AffinityLabelHostsService extends Service {
    /**
     * Add a label to a host.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest host(Host host);
        AddRequest host(HostBuilder host);
    }
    
    /**
     * Add a label to a host.
     */
    public interface AddResponse extends Response {
        Host host();
    }
    
    /**
     * Add a label to a host.
     */
    AddRequest add();
    
    /**
     * List all hosts with the label.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * List all hosts with the label.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Host> hosts();
    }
    
    /**
     * List all hosts with the label.
     * 
     * The order of the returned hosts isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * A link to the specific label-host assignment to
     * allow label removal.
     */
    AffinityLabelHostService hostService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

