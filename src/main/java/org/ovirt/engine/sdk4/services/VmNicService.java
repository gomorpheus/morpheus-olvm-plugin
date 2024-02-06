/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.NicBuilder;
import org.ovirt.engine.sdk4.types.Nic;

public interface VmNicService extends MeasurableService {
    public interface ActivateRequest extends Request<ActivateRequest, ActivateResponse> {
        /**
         * Indicates if the activation should be performed asynchronously.
         */
        ActivateRequest async(Boolean async);
    }
    
    public interface ActivateResponse extends Response {
    }
    
    ActivateRequest activate();
    
    public interface DeactivateRequest extends Request<DeactivateRequest, DeactivateResponse> {
        /**
         * Indicates if the deactivation should be performed asynchronously.
         */
        DeactivateRequest async(Boolean async);
    }
    
    public interface DeactivateResponse extends Response {
    }
    
    DeactivateRequest deactivate();
    
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Nic nic();
    }
    
    GetRequest get();
    
    /**
     * Removes the NIC.
     * 
     * For example, to remove the NIC with id `456` from the virtual machine with id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes the NIC.
     * 
     * For example, to remove the NIC with id `456` from the virtual machine with id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the NIC.
     * 
     * For example, to remove the NIC with id `456` from the virtual machine with id `123` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    RemoveRequest remove();
    
    /**
     * Updates the NIC.
     * 
     * For example, to update the NIC having with `456` belonging to virtual the machine with id `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>e1000</interface>
     *   <vnic_profile id='789'/>
     * </nic>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest nic(Nic nic);
        UpdateRequest nic(NicBuilder nic);
    }
    
    /**
     * Updates the NIC.
     * 
     * For example, to update the NIC having with `456` belonging to virtual the machine with id `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>e1000</interface>
     *   <vnic_profile id='789'/>
     * </nic>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    public interface UpdateResponse extends Response {
        Nic nic();
    }
    
    /**
     * Updates the NIC.
     * 
     * For example, to update the NIC having with `456` belonging to virtual the machine with id `123` send a request
     * like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/nics/456
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>e1000</interface>
     *   <vnic_profile id='789'/>
     * </nic>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * The hotplugging feature only supports virtual machine operating systems with hotplugging operations.
     * Example operating systems include:
     * 
     * - Red Hat Enterprise Linux 6
     * - Red Hat Enterprise Linux 5
     * - Windows Server 2008 and
     * - Windows Server 2003
     * ====
     */
    UpdateRequest update();
    
    /**
     * Reference to the service that manages the network filter parameters of the NIC.
     * 
     * A single top-level network filter may assigned to the NIC by the NIC's <<types/vnic_profile,vNIC Profile>>.
     */
    NicNetworkFilterParametersService networkFilterParametersService();
    VmReportedDevicesService reportedDevicesService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

