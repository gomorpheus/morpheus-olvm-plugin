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
import org.ovirt.engine.sdk4.builders.CdromBuilder;
import org.ovirt.engine.sdk4.types.Cdrom;

/**
 * Manages the CDROM devices of a virtual machine.
 * 
 * Currently virtual machines have exactly one CDROM device. No new devices can be added, and the existing one can't
 * be removed, thus there are no `add` or `remove` methods. Changing and ejecting CDROM disks is done with the
 * <<services/vm_cdrom/methods/update, update>> method of the <<services/vm_cdrom, service>> that manages the
 * CDROM device.
 */
public interface VmCdromsService extends Service {
    /**
     * Add a cdrom to a virtual machine identified by the given id.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest cdrom(Cdrom cdrom);
        AddRequest cdrom(CdromBuilder cdrom);
    }
    
    /**
     * Add a cdrom to a virtual machine identified by the given id.
     */
    public interface AddResponse extends Response {
        Cdrom cdrom();
    }
    
    /**
     * Add a cdrom to a virtual machine identified by the given id.
     */
    AddRequest add();
    
    /**
     * Returns the list of CDROM devices of the virtual machine.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of CDROMs to return. If not specified all the CDROMs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of CDROMs to return. If not specified all the CDROMs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of CDROMs to return. If not specified all the CDROMs are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of CDROM devices of the virtual machine.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of CDROM devices of the virtual machine.
         */
        List<Cdrom> cdroms();
    }
    
    /**
     * Returns the list of CDROM devices of the virtual machine.
     * 
     * The order of the returned list of CD-ROM devices isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific CDROM device.
     */
    VmCdromService cdromService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

