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
 * A service that manages hosts.
 */
public interface HostsService extends Service {
    /**
     * Creates a new host.
     * 
     * The host is created based on the attributes of the `host` parameter. The `name`, `address`, and `root_password`
     * properties are required.
     * 
     * For example, to add a host, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>myrootpassword</root_password>
     * </host>
     * ----
     * 
     * NOTE: The `root_password` element is only included in the client-provided initial representation and is not
     * exposed in the representations returned from subsequent requests.
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is newly added, the host's firewall
     * definitions are overridden by default.
     * 
     * To add a hosted engine host, use the optional `deploy_hosted_engine` parameter:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts?deploy_hosted_engine=true
     * ----
     * 
     * If the cluster has a default external network provider that is supported for automatic deployment,
     * the external network provider is deployed when adding the host.
     * Only external network providers for OVN are supported for the automatic deployment.
     * To deploy an external network provider other than the one defined in the clusters, overwrite the external
     * network provider when adding hosts, by sending the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With a request body that contains a reference to the desired provider in the
     * `external_network_provider_configuration`:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>123456</root_password>
     *   <external_network_provider_configurations>
     *     <external_network_provider_configuration>
     *       <external_network_provider name="ovirt-provider-ovn"/>
     *     </external_network_provider_configuration>
     *   </external_network_provider_configurations>
     * </host>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        /**
         * When set to `true`, this host will be activated after its installation completes. When set to `false`
         * the host will remain in `maintenance` status after its installation. Absence of this parameter will be
         * interpreted as `true`, since the desired default behavior is activating the host after install.
         */
        AddRequest activate(Boolean activate);
        /**
         * When set to `true`, this host deploys the hosted engine components. A missing value is treated
         * as `true`, i.e., deploy the hosted engine components. Omitting this parameter equals `false`, and
         * the host performs no operation in the hosted engine area.
         */
        AddRequest deployHostedEngine(Boolean deployHostedEngine);
        AddRequest host(Host host);
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        AddRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        AddRequest reboot(Boolean reboot);
        /**
         * When set to `true`, this host un-deploys the hosted engine components and does not
         * function as part of the High Availability cluster. A missing value is treated as `true`, i.e., un-deploy.
         * Omitting this parameter equals `false` and the host performs no operation in the hosted engine area.
         */
        AddRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Creates a new host.
     * 
     * The host is created based on the attributes of the `host` parameter. The `name`, `address`, and `root_password`
     * properties are required.
     * 
     * For example, to add a host, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>myrootpassword</root_password>
     * </host>
     * ----
     * 
     * NOTE: The `root_password` element is only included in the client-provided initial representation and is not
     * exposed in the representations returned from subsequent requests.
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is newly added, the host's firewall
     * definitions are overridden by default.
     * 
     * To add a hosted engine host, use the optional `deploy_hosted_engine` parameter:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts?deploy_hosted_engine=true
     * ----
     * 
     * If the cluster has a default external network provider that is supported for automatic deployment,
     * the external network provider is deployed when adding the host.
     * Only external network providers for OVN are supported for the automatic deployment.
     * To deploy an external network provider other than the one defined in the clusters, overwrite the external
     * network provider when adding hosts, by sending the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With a request body that contains a reference to the desired provider in the
     * `external_network_provider_configuration`:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>123456</root_password>
     *   <external_network_provider_configurations>
     *     <external_network_provider_configuration>
     *       <external_network_provider name="ovirt-provider-ovn"/>
     *     </external_network_provider_configuration>
     *   </external_network_provider_configurations>
     * </host>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        Host host();
    }
    
    /**
     * Creates a new host.
     * 
     * The host is created based on the attributes of the `host` parameter. The `name`, `address`, and `root_password`
     * properties are required.
     * 
     * For example, to add a host, send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>myrootpassword</root_password>
     * </host>
     * ----
     * 
     * NOTE: The `root_password` element is only included in the client-provided initial representation and is not
     * exposed in the representations returned from subsequent requests.
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is newly added, the host's firewall
     * definitions are overridden by default.
     * 
     * To add a hosted engine host, use the optional `deploy_hosted_engine` parameter:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts?deploy_hosted_engine=true
     * ----
     * 
     * If the cluster has a default external network provider that is supported for automatic deployment,
     * the external network provider is deployed when adding the host.
     * Only external network providers for OVN are supported for the automatic deployment.
     * To deploy an external network provider other than the one defined in the clusters, overwrite the external
     * network provider when adding hosts, by sending the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts
     * ----
     * 
     * With a request body that contains a reference to the desired provider in the
     * `external_network_provider_configuration`:
     * 
     * [source,xml]
     * ----
     * <host>
     *   <name>myhost</name>
     *   <address>myhost.example.com</address>
     *   <root_password>123456</root_password>
     *   <external_network_provider_configurations>
     *     <external_network_provider_configuration>
     *       <external_network_provider name="ovirt-provider-ovn"/>
     *     </external_network_provider_configuration>
     *   </external_network_provider_configurations>
     * </host>
     * ----
     */
    AddRequest add();
    
    /**
     * Get a list of all available hosts.
     * 
     * For example, to list the hosts send the following request:
     * 
     * ....
     * GET /ovirt-engine/api/hosts
     * ....
     * 
     * The response body will be similar to this:
     * 
     * [source,xml]
     * ----
     * <hosts>
     *   <host href="/ovirt-engine/api/hosts/123" id="123">
     *     ...
     *   </host>
     *   <host href="/ovirt-engine/api/hosts/456" id="456">
     *     ...
     *   </host>
     *   ...
     * </host>
     * ----
     * 
     * The order of the returned list of hosts is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if all of the attributes of the hosts should be included in the response.
         * 
         * By default the following host attributes are excluded:
         * 
         * - `hosted_engine`
         * 
         * For example, to retrieve the complete representation of the hosts:
         * 
         * ....
         * GET /ovirt-engine/api/hosts?all_content=true
         * ....
         * 
         * NOTE: These attributes are not included by default because retrieving them impacts performance. They are
         * seldom used and require additional queries to the database. Use this parameter with caution and only when
         * specifically required.
         */
        ListRequest allContent(Boolean allContent);
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * This parameter can be used with `migration_target_of`
         * to get valid migration targets for the listed virtual machines
         * and all other virtual machines that are in positive enforcing
         * affinity with the listed virtual machines.
         * 
         * This is useful in case the virtual machines will be migrated
         * together with others in positive affinity groups.
         * 
         * The default value is `false`.
         * 
         * ....
         * GET /ovirt-engine/api/hosts?migration_target_of=123,456&check_vms_in_affinity_closure=true
         * ....
         */
        ListRequest checkVmsInAffinityClosure(Boolean checkVmsInAffinityClosure);
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
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of hosts to return. If not specified all the hosts are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * Accepts a comma-separated list of virtual machine IDs and returns the hosts
         * that these virtual machines can be migrated to.
         * 
         * For example, to retrieve the list of hosts to which the virtual machine with ID 123 and
         * the virtual machine with ID 456 can be migrated to, send the following request:
         * 
         * ....
         * GET /ovirt-engine/api/hosts?migration_target_of=123,456
         * ....
         */
        ListRequest migrationTargetOf(String migrationTargetOf);
        /**
         * A query string used to restrict the returned hosts.
         */
        ListRequest search(String search);
    }
    
    /**
     * Get a list of all available hosts.
     * 
     * For example, to list the hosts send the following request:
     * 
     * ....
     * GET /ovirt-engine/api/hosts
     * ....
     * 
     * The response body will be similar to this:
     * 
     * [source,xml]
     * ----
     * <hosts>
     *   <host href="/ovirt-engine/api/hosts/123" id="123">
     *     ...
     *   </host>
     *   <host href="/ovirt-engine/api/hosts/456" id="456">
     *     ...
     *   </host>
     *   ...
     * </host>
     * ----
     * 
     * The order of the returned list of hosts is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    public interface ListResponse extends Response {
        List<Host> hosts();
    }
    
    /**
     * Get a list of all available hosts.
     * 
     * For example, to list the hosts send the following request:
     * 
     * ....
     * GET /ovirt-engine/api/hosts
     * ....
     * 
     * The response body will be similar to this:
     * 
     * [source,xml]
     * ----
     * <hosts>
     *   <host href="/ovirt-engine/api/hosts/123" id="123">
     *     ...
     *   </host>
     *   <host href="/ovirt-engine/api/hosts/456" id="456">
     *     ...
     *   </host>
     *   ...
     * </host>
     * ----
     * 
     * The order of the returned list of hosts is guaranteed only if the `sortby` clause is included in
     * the `search` parameter.
     */
    ListRequest list();
    
    /**
     * Add a new host to the system providing the host root password. This has been deprecated and provided for backwards compatibility.
     */
    public interface AddUsingRootPasswordRequest extends Request<AddUsingRootPasswordRequest, AddUsingRootPasswordResponse> {
        /**
         * When set to `true`, this host will be activated after its installation completes. When set to `false`
         * the host will remain in `maintenance` status after its installation. Absence of this parameter will be
         * interpreted as `true`, since the desired default behavior is activating the host after install.
         */
        AddUsingRootPasswordRequest activate(Boolean activate);
        /**
         * When set to `true`, this host deploys the hosted engine components. A missing value is treated
         * as `true`, i.e., deploy the hosted engine components. Omitting this parameter equals `false`, and
         * the host performs no operation in the hosted engine area.
         */
        AddUsingRootPasswordRequest deployHostedEngine(Boolean deployHostedEngine);
        AddUsingRootPasswordRequest host(Host host);
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        AddUsingRootPasswordRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        AddUsingRootPasswordRequest reboot(Boolean reboot);
        /**
         * When set to `true`, this host un-deploys the hosted engine components and does not
         * function as part of the High Availability cluster. A missing value is treated as `true`, i.e., un-deploy.
         * Omitting this parameter equals `false` and the host performs no operation in the hosted engine area.
         */
        AddUsingRootPasswordRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Add a new host to the system providing the host root password. This has been deprecated and provided for backwards compatibility.
     */
    public interface AddUsingRootPasswordResponse extends Response {
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        Host host();
    }
    
    /**
     * Add a new host to the system providing the host root password. This has been deprecated and provided for backwards compatibility.
     */
    AddUsingRootPasswordRequest addUsingRootPassword();
    
    /**
     * Add a new host to the system providing the ssh password, fingerprint or public key.
     */
    public interface AddUsingSshRequest extends Request<AddUsingSshRequest, AddUsingSshResponse> {
        /**
         * When set to `true`, this host will be activated after its installation completes. When set to `false`
         * the host will remain in `maintenance` status after its installation. Absence of this parameter will be
         * interpreted as `true`, since the desired default behavior is activating the host after install.
         */
        AddUsingSshRequest activate(Boolean activate);
        /**
         * When set to `true`, this host deploys the hosted engine components. A missing value is treated
         * as `true`, i.e., deploy the hosted engine components. Omitting this parameter equals `false`, and
         * the host performs no operation in the hosted engine area.
         */
        AddUsingSshRequest deployHostedEngine(Boolean deployHostedEngine);
        AddUsingSshRequest host(Host host);
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        AddUsingSshRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        AddUsingSshRequest reboot(Boolean reboot);
        /**
         * When set to `true`, this host un-deploys the hosted engine components and does not
         * function as part of the High Availability cluster. A missing value is treated as `true`, i.e., un-deploy.
         * Omitting this parameter equals `false` and the host performs no operation in the hosted engine area.
         */
        AddUsingSshRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Add a new host to the system providing the ssh password, fingerprint or public key.
     */
    public interface AddUsingSshResponse extends Response {
        /**
         * The host definition with which the new host is created is passed as a parameter, and the newly created host
         * is returned.
         */
        Host host();
    }
    
    /**
     * Add a new host to the system providing the ssh password, fingerprint or public key.
     */
    AddUsingSshRequest addUsingSsh();
    
    /**
     * A Reference to service managing a specific host.
     */
    HostService hostService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

