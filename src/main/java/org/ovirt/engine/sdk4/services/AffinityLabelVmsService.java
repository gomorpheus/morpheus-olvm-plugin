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
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.types.Vm;

/**
 * This service represents list of vms that have a specific
 * label when accessed through the affinitylabels/vms
 * subcollection.
 */
public interface AffinityLabelVmsService extends Service {
    /**
     * Add a label to a vm.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest vm(Vm vm);
        AddRequest vm(VmBuilder vm);
    }
    
    /**
     * Add a label to a vm.
     */
    public interface AddResponse extends Response {
        Vm vm();
    }
    
    /**
     * Add a label to a vm.
     */
    AddRequest add();
    
    /**
     * List all virtual machines with the label.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * List all virtual machines with the label.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Vm> vms();
    }
    
    /**
     * List all virtual machines with the label.
     * 
     * The order of the returned virtual machines isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * A link to the specific label-vm assignment to
     * allow label removal.
     */
    AffinityLabelVmService vmService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

