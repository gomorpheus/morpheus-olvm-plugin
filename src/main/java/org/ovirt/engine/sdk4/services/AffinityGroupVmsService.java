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
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.types.Vm;

/**
 * This service manages a collection of all the virtual machines assigned to an affinity group.
 */
public interface AffinityGroupVmsService extends Service {
    /**
     * Adds a virtual machine to the affinity group.
     * 
     * For example, to add the virtual machine `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vms
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vm id="789"/>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest vm(Vm vm);
        AddRequest vm(VmBuilder vm);
    }
    
    /**
     * Adds a virtual machine to the affinity group.
     * 
     * For example, to add the virtual machine `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vms
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vm id="789"/>
     * ----
     */
    public interface AddResponse extends Response {
        Vm vm();
    }
    
    /**
     * Adds a virtual machine to the affinity group.
     * 
     * For example, to add the virtual machine `789` to the affinity group `456` of cluster `123`, send a request like
     * this:
     * 
     * ....
     * POST /ovirt-engine/api/clusters/123/affinitygroups/456/vms
     * ....
     * 
     * With the following body:
     * 
     * [source,xml]
     * ----
     * <vm id="789"/>
     * ----
     */
    AddRequest add();
    
    /**
     * List all virtual machines assigned to this affinity group.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of virtual machines to return. If not specified, all the virtual machines are
         * returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of virtual machines to return. If not specified, all the virtual machines are
         * returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of virtual machines to return. If not specified, all the virtual machines are
         * returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * List all virtual machines assigned to this affinity group.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Vm> vms();
    }
    
    /**
     * List all virtual machines assigned to this affinity group.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Access the service that manages the virtual machine assignment to this affinity group.
     */
    AffinityGroupVmService vmService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

