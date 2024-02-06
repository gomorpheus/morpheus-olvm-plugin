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
import org.ovirt.engine.sdk4.builders.NicBuilder;
import org.ovirt.engine.sdk4.types.Nic;

public interface VmNicsService extends Service {
    /**
     * Adds a NIC to the virtual machine.
     * 
     * The following example adds to the virtual machine `123` a network interface named `mynic` using `virtio` and the
     * NIC profile `456`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/nics
     * ----
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ----
     * 
     * The following example sends that request using `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --data '
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ' \
     * https://myengine.example.com/ovirt-engine/api/vms/123/nics
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
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest nic(Nic nic);
        AddRequest nic(NicBuilder nic);
    }
    
    /**
     * Adds a NIC to the virtual machine.
     * 
     * The following example adds to the virtual machine `123` a network interface named `mynic` using `virtio` and the
     * NIC profile `456`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/nics
     * ----
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ----
     * 
     * The following example sends that request using `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --data '
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ' \
     * https://myengine.example.com/ovirt-engine/api/vms/123/nics
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
    public interface AddResponse extends Response {
        Nic nic();
    }
    
    /**
     * Adds a NIC to the virtual machine.
     * 
     * The following example adds to the virtual machine `123` a network interface named `mynic` using `virtio` and the
     * NIC profile `456`.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/nics
     * ----
     * 
     * [source,xml]
     * ----
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ----
     * 
     * The following example sends that request using `curl`:
     * 
     * [source,bash]
     * ----
     * curl \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --user "admin@internal:mypassword" \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --data '
     * <nic>
     *   <name>mynic</name>
     *   <interface>virtio</interface>
     *   <vnic_profile id="456"/>
     * </nic>
     * ' \
     * https://myengine.example.com/ovirt-engine/api/vms/123/nics
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
    AddRequest add();
    
    /**
     * Returns the list of NICs of the virtual machine.
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
     * Returns the list of NICs of the virtual machine.
     * 
     * The order of the returned list of NICs isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Nic> nics();
    }
    
    /**
     * Returns the list of NICs of the virtual machine.
     * 
     * The order of the returned list of NICs isn't guaranteed.
     */
    ListRequest list();
    
    VmNicService nicService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

