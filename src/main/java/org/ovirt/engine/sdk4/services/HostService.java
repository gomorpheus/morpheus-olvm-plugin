/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.HostNicBuilder;
import org.ovirt.engine.sdk4.builders.IscsiDetailsBuilder;
import org.ovirt.engine.sdk4.builders.NetworkAttachmentBuilder;
import org.ovirt.engine.sdk4.builders.NetworkLabelBuilder;
import org.ovirt.engine.sdk4.builders.SshBuilder;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.IscsiDetails;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.PowerManagement;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * A service to manage a host.
 */
public interface HostService extends MeasurableService {
    /**
     * Activates the host for use, for example to run virtual machines.
     */
    public interface ActivateRequest extends Request<ActivateRequest, ActivateResponse> {
        /**
         * Indicates if the activation should be performed asynchronously.
         */
        ActivateRequest async(Boolean async);
    }
    
    /**
     * Activates the host for use, for example to run virtual machines.
     */
    public interface ActivateResponse extends Response {
    }
    
    /**
     * Activates the host for use, for example to run virtual machines.
     */
    ActivateRequest activate();
    
    /**
     * Approve a pre-installed Hypervisor host for usage in the virtualization environment.
     * 
     * This action also accepts an optional cluster element to define the target cluster for this host.
     */
    public interface ApproveRequest extends Request<ApproveRequest, ApproveResponse> {
        /**
         * When set to 'true', this host will be activated after its approval completes. When set to 'false'
         * the host will remain in 'maintenance' status after its approval. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after approval.
         */
        ApproveRequest activate(Boolean activate);
        /**
         * Indicates if the approval should be performed asynchronously.
         */
        ApproveRequest async(Boolean async);
        ApproveRequest cluster(Cluster cluster);
        /**
         * The cluster where the host will be added after it is approved.
         */
        ApproveRequest cluster(ClusterBuilder cluster);
        ApproveRequest host(Host host);
        /**
         * The host to approve.
         */
        ApproveRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        ApproveRequest reboot(Boolean reboot);
    }
    
    /**
     * Approve a pre-installed Hypervisor host for usage in the virtualization environment.
     * 
     * This action also accepts an optional cluster element to define the target cluster for this host.
     */
    public interface ApproveResponse extends Response {
    }
    
    /**
     * Approve a pre-installed Hypervisor host for usage in the virtualization environment.
     * 
     * This action also accepts an optional cluster element to define the target cluster for this host.
     */
    ApproveRequest approve();
    
    /**
     * Marks the network configuration as good and persists it inside the host.
     * 
     * An API user commits the network configuration to persist a host network interface attachment or detachment, or
     * persist the creation and deletion of a bonded interface.
     * 
     * IMPORTANT: Networking configuration is only committed after the engine has established that host connectivity is
     * not lost as a result of the configuration changes. If host connectivity is lost, the host requires a reboot and
     * automatically reverts to the previous networking configuration.
     * 
     * For example, to commit the network configuration of host with id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/commitnetconfig
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    public interface CommitNetConfigRequest extends Request<CommitNetConfigRequest, CommitNetConfigResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        CommitNetConfigRequest async(Boolean async);
    }
    
    /**
     * Marks the network configuration as good and persists it inside the host.
     * 
     * An API user commits the network configuration to persist a host network interface attachment or detachment, or
     * persist the creation and deletion of a bonded interface.
     * 
     * IMPORTANT: Networking configuration is only committed after the engine has established that host connectivity is
     * not lost as a result of the configuration changes. If host connectivity is lost, the host requires a reboot and
     * automatically reverts to the previous networking configuration.
     * 
     * For example, to commit the network configuration of host with id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/commitnetconfig
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    public interface CommitNetConfigResponse extends Response {
    }
    
    /**
     * Marks the network configuration as good and persists it inside the host.
     * 
     * An API user commits the network configuration to persist a host network interface attachment or detachment, or
     * persist the creation and deletion of a bonded interface.
     * 
     * IMPORTANT: Networking configuration is only committed after the engine has established that host connectivity is
     * not lost as a result of the configuration changes. If host connectivity is lost, the host requires a reboot and
     * automatically reverts to the previous networking configuration.
     * 
     * For example, to commit the network configuration of host with id `123` send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/commitnetconfig
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    CommitNetConfigRequest commitNetConfig();
    
    /**
     * Copy the network configuration of the specified host to current host.
     * 
     * IMPORTANT: Any network attachments that are not present on the source host will be erased from the target host
     * by the copy operation.
     * 
     * To copy networks from another host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/copyhostnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *    <source_host id="456"/>
     * </action>
     * ----
     */
    public interface CopyHostNetworksRequest extends Request<CopyHostNetworksRequest, CopyHostNetworksResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        CopyHostNetworksRequest async(Boolean async);
        CopyHostNetworksRequest sourceHost(Host sourceHost);
        /**
         * The host to copy networks from.
         */
        CopyHostNetworksRequest sourceHost(HostBuilder sourceHost);
    }
    
    /**
     * Copy the network configuration of the specified host to current host.
     * 
     * IMPORTANT: Any network attachments that are not present on the source host will be erased from the target host
     * by the copy operation.
     * 
     * To copy networks from another host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/copyhostnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *    <source_host id="456"/>
     * </action>
     * ----
     */
    public interface CopyHostNetworksResponse extends Response {
    }
    
    /**
     * Copy the network configuration of the specified host to current host.
     * 
     * IMPORTANT: Any network attachments that are not present on the source host will be erased from the target host
     * by the copy operation.
     * 
     * To copy networks from another host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/copyhostnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *    <source_host id="456"/>
     * </action>
     * ----
     */
    CopyHostNetworksRequest copyHostNetworks();
    
    /**
     * Deactivates the host to perform maintenance tasks.
     */
    public interface DeactivateRequest extends Request<DeactivateRequest, DeactivateResponse> {
        /**
         * Indicates if the deactivation should be performed asynchronously.
         */
        DeactivateRequest async(Boolean async);
        DeactivateRequest reason(String reason);
        /**
         * Indicates if the gluster service should be stopped as part of deactivating the host. It can be used while
         * performing maintenance operations on the gluster host. Default value for this variable is `false`.
         */
        DeactivateRequest stopGlusterService(Boolean stopGlusterService);
    }
    
    /**
     * Deactivates the host to perform maintenance tasks.
     */
    public interface DeactivateResponse extends Response {
    }
    
    /**
     * Deactivates the host to perform maintenance tasks.
     */
    DeactivateRequest deactivate();
    
    /**
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns a list of IscsiDetails objects containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/discoveriscsi
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <discovered_targets>
     *   <iscsi_details>
     *     <address>10.35.1.72</address>
     *     <port>3260</port>
     *     <portal>10.35.1.72:3260,1</portal>
     *     <target>iqn.2015-08.com.tgt:444</target>
     *   </iscsi_details>
     * </discovered_targets>
     * ----
     * 
     * IMPORTANT: When using this method to discover iscsi targets, you can use an FQDN or an
     * IP address, but you must use the iscsi details from the discovered targets results to log in
     * using the  iscsilogin method.
     */
    public interface DiscoverIscsiRequest extends Request<DiscoverIscsiRequest, DiscoverIscsiResponse> {
        /**
         * Indicates if the discovery should be performed asynchronously.
         */
        DiscoverIscsiRequest async(Boolean async);
        DiscoverIscsiRequest iscsi(IscsiDetails iscsi);
        /**
         * The target iSCSI device.
         */
        DiscoverIscsiRequest iscsi(IscsiDetailsBuilder iscsi);
    }
    
    /**
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns a list of IscsiDetails objects containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/discoveriscsi
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <discovered_targets>
     *   <iscsi_details>
     *     <address>10.35.1.72</address>
     *     <port>3260</port>
     *     <portal>10.35.1.72:3260,1</portal>
     *     <target>iqn.2015-08.com.tgt:444</target>
     *   </iscsi_details>
     * </discovered_targets>
     * ----
     * 
     * IMPORTANT: When using this method to discover iscsi targets, you can use an FQDN or an
     * IP address, but you must use the iscsi details from the discovered targets results to log in
     * using the  iscsilogin method.
     */
    public interface DiscoverIscsiResponse extends Response {
        /**
         * The discovered targets including all connection information.
         */
        List<IscsiDetails> discoveredTargets();
    }
    
    /**
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns a list of IscsiDetails objects containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/discoveriscsi
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     * 
     * The result will be like this:
     * 
     * [source,xml]
     * ----
     * <discovered_targets>
     *   <iscsi_details>
     *     <address>10.35.1.72</address>
     *     <port>3260</port>
     *     <portal>10.35.1.72:3260,1</portal>
     *     <target>iqn.2015-08.com.tgt:444</target>
     *   </iscsi_details>
     * </discovered_targets>
     * ----
     * 
     * IMPORTANT: When using this method to discover iscsi targets, you can use an FQDN or an
     * IP address, but you must use the iscsi details from the discovered targets results to log in
     * using the  iscsilogin method.
     */
    DiscoverIscsiRequest discoverIscsi();
    
    /**
     * Enrolls the certificate of the host. Useful in case you get a warning that it is about to expire or has already
     * expired.
     */
    public interface EnrollCertificateRequest extends Request<EnrollCertificateRequest, EnrollCertificateResponse> {
        /**
         * Indicates if the enrollment should be performed asynchronously.
         */
        EnrollCertificateRequest async(Boolean async);
    }
    
    /**
     * Enrolls the certificate of the host. Useful in case you get a warning that it is about to expire or has already
     * expired.
     */
    public interface EnrollCertificateResponse extends Response {
    }
    
    /**
     * Enrolls the certificate of the host. Useful in case you get a warning that it is about to expire or has already
     * expired.
     */
    EnrollCertificateRequest enrollCertificate();
    
    /**
     * Controls the host's power management device.
     * 
     * For example, to start the host. This can be done via:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <fence_type>start</fence_type>
     * </action>
     * ' \
     * "${url}/hosts/123/fence"
     * ----
     */
    public interface FenceRequest extends Request<FenceRequest, FenceResponse> {
        /**
         * Indicates if the fencing should be performed asynchronously.
         */
        FenceRequest async(Boolean async);
        FenceRequest fenceType(String fenceType);
        /**
         * Indicates if host should be put into maintenance after restart.
         */
        FenceRequest maintenanceAfterRestart(Boolean maintenanceAfterRestart);
    }
    
    /**
     * Controls the host's power management device.
     * 
     * For example, to start the host. This can be done via:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <fence_type>start</fence_type>
     * </action>
     * ' \
     * "${url}/hosts/123/fence"
     * ----
     */
    public interface FenceResponse extends Response {
        PowerManagement powerManagement();
    }
    
    /**
     * Controls the host's power management device.
     * 
     * For example, to start the host. This can be done via:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <fence_type>start</fence_type>
     * </action>
     * ' \
     * "${url}/hosts/123/fence"
     * ----
     */
    FenceRequest fence();
    
    /**
     * To manually set a host as the storage pool manager (SPM).
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/forceselectspm
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ForceSelectSpmRequest extends Request<ForceSelectSpmRequest, ForceSelectSpmResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        ForceSelectSpmRequest async(Boolean async);
    }
    
    /**
     * To manually set a host as the storage pool manager (SPM).
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/forceselectspm
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ForceSelectSpmResponse extends Response {
    }
    
    /**
     * To manually set a host as the storage pool manager (SPM).
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/forceselectspm
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    ForceSelectSpmRequest forceSelectSpm();
    
    /**
     * Gets the host details.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if all of the attributes of the host should be included in the response.
         * 
         * By default the following attributes are excluded:
         * 
         * - `hosted_engine`
         * 
         * For example, to retrieve the complete representation of host '123':
         * 
         * ....
         * GET /ovirt-engine/api/hosts/123?all_content=true
         * ....
         * 
         * NOTE: These attributes are not included by default because retrieving them impacts performance. They are
         * seldom used and require additional queries to the database. Use this parameter with caution and only when
         * specifically required.
         */
        GetRequest allContent(Boolean allContent);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Gets the host details.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The queried host.
         */
        Host host();
    }
    
    /**
     * Gets the host details.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123
     * ----
     */
    GetRequest get();
    
    /**
     * Installs the latest version of VDSM and related software on the host.
     * 
     * The action also performs every configuration steps on the host which is done during adding host to the engine:
     * kdump configuration, hosted-engine deploy, kernel options changes, etc.
     * 
     * The host type defines additional parameters for the action.
     * 
     * Example of installing a host, using `curl` and JSON, plain:
     * 
     * [source,bash]
     * ----
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * Example of installing a host using `curl` and JSON with hosted engine components:
     * 
     * [source,bash]
     * ----
     * curl \
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
         * "deploy_hosted_engine" : "true"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is reinstalled we override the host firewall
     * definitions by default.
     */
    public interface InstallRequest extends Request<InstallRequest, InstallResponse> {
        /**
         * When set to 'true', this host will be activated after its installation completes. When set to 'false'
         * the host will remain in 'maintenance' status after its installation. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after install.
         */
        InstallRequest activate(Boolean activate);
        /**
         * Indicates if the installation should be performed asynchronously.
         */
        InstallRequest async(Boolean async);
        /**
         * When set to `true` this host will also deploy the self-hosted engine components. A missing value
         * is treated as `true` i.e deploy. Omitting this parameter means `false` and will not perform any operation in the
         * self-hosted engine area.
         */
        InstallRequest deployHostedEngine(Boolean deployHostedEngine);
        InstallRequest host(Host host);
        /**
         * The `override_iptables` property is used to indicate if the firewall configuration should be replaced by the
         * default one.
         */
        InstallRequest host(HostBuilder host);
        /**
         * When installing {hypervisor-name}, an ISO image file is required.
         */
        InstallRequest image(String image);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        InstallRequest reboot(Boolean reboot);
        /**
         * The password of the `root` user used to connect to the host via SSH.
         */
        InstallRequest rootPassword(String rootPassword);
        InstallRequest ssh(Ssh ssh);
        /**
         * The SSH details used to connect to the host.
         */
        InstallRequest ssh(SshBuilder ssh);
        /**
         * When set to `true` this host will un-deploy the self-hosted engine components, and this host will
         * not function as part of the High Availability cluster. A missing value is treated as `true` i.e un-deploy.
         * Omitting this parameter means `false` and will not perform any operation in the self-hosted engine area.
         */
        InstallRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Installs the latest version of VDSM and related software on the host.
     * 
     * The action also performs every configuration steps on the host which is done during adding host to the engine:
     * kdump configuration, hosted-engine deploy, kernel options changes, etc.
     * 
     * The host type defines additional parameters for the action.
     * 
     * Example of installing a host, using `curl` and JSON, plain:
     * 
     * [source,bash]
     * ----
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * Example of installing a host using `curl` and JSON with hosted engine components:
     * 
     * [source,bash]
     * ----
     * curl \
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
         * "deploy_hosted_engine" : "true"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is reinstalled we override the host firewall
     * definitions by default.
     */
    public interface InstallResponse extends Response {
    }
    
    /**
     * Installs the latest version of VDSM and related software on the host.
     * 
     * The action also performs every configuration steps on the host which is done during adding host to the engine:
     * kdump configuration, hosted-engine deploy, kernel options changes, etc.
     * 
     * The host type defines additional parameters for the action.
     * 
     * Example of installing a host, using `curl` and JSON, plain:
     * 
     * [source,bash]
     * ----
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * Example of installing a host using `curl` and JSON with hosted engine components:
     * 
     * [source,bash]
     * ----
     * curl \
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --request PUT \
     * --header "Content-Type: application/json" \
     * --header "Accept: application/json" \
     * --header "Version: 4" \
     * --user "admin@internal:..." \
     * --data '
     * {
         *   "root_password": "myrootpassword"
         * "deploy_hosted_engine" : "true"
     * }
     * ' \
     * "https://engine.example.com/ovirt-engine/api/hosts/123"
     * ----
     * 
     * IMPORTANT: Since version 4.1.2 of the engine, when a host is reinstalled we override the host firewall
     * definitions by default.
     */
    InstallRequest install();
    
    /**
     * This method has been deprecated since Engine version 4.4.6.
     * DiscoverIscsi should be used instead.
     * 
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns an array of strings containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/iscsidiscover
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     */
    public interface IscsiDiscoverRequest extends Request<IscsiDiscoverRequest, IscsiDiscoverResponse> {
        /**
         * Indicates if the discovery should be performed asynchronously.
         */
        IscsiDiscoverRequest async(Boolean async);
        IscsiDiscoverRequest iscsi(IscsiDetails iscsi);
        /**
         * The target iSCSI device.
         */
        IscsiDiscoverRequest iscsi(IscsiDetailsBuilder iscsi);
    }
    
    /**
     * This method has been deprecated since Engine version 4.4.6.
     * DiscoverIscsi should be used instead.
     * 
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns an array of strings containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/iscsidiscover
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     */
    public interface IscsiDiscoverResponse extends Response {
        /**
         * The iSCSI targets.
         *         *
         */
        List<String> iscsiTargets();
    }
    
    /**
     * This method has been deprecated since Engine version 4.4.6.
     * DiscoverIscsi should be used instead.
     * 
     * Discovers iSCSI targets on the host, using the initiator details.
     * Returns an array of strings containing the discovered data.
     * 
     * For example, to discover iSCSI targets available in `myiscsi.example.com`,
     * from host `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/iscsidiscover
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <iscsi>
     *     <address>myiscsi.example.com</address>
     *   </iscsi>
     * </action>
     * ----
     */
    IscsiDiscoverRequest iscsiDiscover();
    
    /**
     * Login to iSCSI targets on the host, using the target details.
     * 
     * 
     * IMPORTANT: When using this method to log in, you must use the iscsi details from the
     * discovered targets results in the discoveriscsi method.
     */
    public interface IscsiLoginRequest extends Request<IscsiLoginRequest, IscsiLoginResponse> {
        /**
         * Indicates if the login should be performed asynchronously.
         */
        IscsiLoginRequest async(Boolean async);
        IscsiLoginRequest iscsi(IscsiDetails iscsi);
        /**
         * The target iSCSI device.
         */
        IscsiLoginRequest iscsi(IscsiDetailsBuilder iscsi);
    }
    
    /**
     * Login to iSCSI targets on the host, using the target details.
     * 
     * 
     * IMPORTANT: When using this method to log in, you must use the iscsi details from the
     * discovered targets results in the discoveriscsi method.
     */
    public interface IscsiLoginResponse extends Response {
    }
    
    /**
     * Login to iSCSI targets on the host, using the target details.
     * 
     * 
     * IMPORTANT: When using this method to log in, you must use the iscsi details from the
     * discovered targets results in the discoveriscsi method.
     */
    IscsiLoginRequest iscsiLogin();
    
    /**
     * Refresh the host devices and capabilities.
     */
    public interface RefreshRequest extends Request<RefreshRequest, RefreshResponse> {
        /**
         * Indicates if the refresh should be performed asynchronously.
         */
        RefreshRequest async(Boolean async);
    }
    
    /**
     * Refresh the host devices and capabilities.
     */
    public interface RefreshResponse extends Response {
    }
    
    /**
     * Refresh the host devices and capabilities.
     */
    RefreshRequest refresh();
    
    /**
     * Remove the host from the system.
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request DELETE \
     * --header "Version: 4" \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc"
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * Indicates that the host should be removed even if it is non-responsive,
         * or if it is part of a Gluster Storage cluster and has volume bricks on it.
         */
        RemoveRequest force(Boolean force);
    }
    
    /**
     * Remove the host from the system.
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request DELETE \
     * --header "Version: 4" \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc"
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the host from the system.
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request DELETE \
     * --header "Version: 4" \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc"
     * ----
     */
    RemoveRequest remove();
    
    /**
     * This method is used to change the configuration of the network interfaces of a host.
     * 
     * For example, if you have a host with three network interfaces `eth0`, `eth1` and `eth2` and you want to configure
     * a new bond using `eth0` and `eth1`, and put a VLAN on top of it. Using a simple shell script and the `curl`
     * command line HTTP client that can be done as follows:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <modified_bonds>
     *     <host_nic>
     *       <name>bond0</name>
     *       <bonding>
     *         <options>
     *           <option>
     *             <name>mode</name>
     *             <value>4</value>
     *           </option>
     *           <option>
     *             <name>miimon</name>
     *             <value>100</value>
     *           </option>
     *         </options>
     *         <slaves>
     *           <host_nic>
     *             <name>eth1</name>
     *           </host_nic>
     *           <host_nic>
     *             <name>eth2</name>
     *           </host_nic>
     *         </slaves>
     *       </bonding>
     *     </host_nic>
     *   </modified_bonds>
     *   <modified_network_attachments>
     *     <network_attachment>
     *       <network>
     *         <name>myvlan</name>
     *       </network>
     *       <host_nic>
     *         <name>bond0</name>
     *       </host_nic>
     *       <ip_address_assignments>
     *         <ip_address_assignment>
     *           <assignment_method>static</assignment_method>
     *           <ip>
     *             <address>192.168.122.10</address>
     *             <netmask>255.255.255.0</netmask>
     *           </ip>
     *         </ip_address_assignment>
     *       </ip_address_assignments>
     *       <dns_resolver_configuration>
     *         <name_servers>
     *           <name_server>1.1.1.1</name_server>
     *           <name_server>2.2.2.2</name_server>
     *         </name_servers>
     *       </dns_resolver_configuration>
     *     </network_attachment>
     *   </modified_network_attachments>
     *  </action>
     * ' \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc/setupnetworks"
     * ----
     * 
     * NOTE: This is valid for version 4 of the API. In previous versions some elements were represented as XML
     * attributes instead of XML elements. In particular the `options` and `ip` elements were represented as follows:
     * 
     * [source,xml]
     * ----
     * <options name="mode" value="4"/>
     * <options name="miimon" value="100"/>
     * <ip address="192.168.122.10" netmask="255.255.255.0"/>
     * ----
     * 
     * The same thing can be done using the Python SDK with the following code:
     * 
     * [source,python]
     * ----
     * # Find the service that manages the collection of hosts:
     * hosts_service = connection.system_service().hosts_service()
     * 
     * # Find the host:
     * host = hosts_service.list(search='name=myhost')[0]
     * 
     * # Find the service that manages the host:
     * host_service = hosts_service.host_service(host.id)
     * 
     * # Configure the network adding a bond with two slaves and attaching it to a
     * # network with an static IP address:
     * host_service.setup_networks(
     *     modified_bonds=[
     *         types.HostNic(
     *             name='bond0',
     *             bonding=types.Bonding(
     *                 options=[
     *                     types.Option(
     *                         name='mode',
     *                         value='4',
     *                     ),
     *                     types.Option(
     *                         name='miimon',
     *                         value='100',
     *                     ),
     *                 ],
     *                 slaves=[
     *                     types.HostNic(
     *                         name='eth1',
     *                     ),
     *                     types.HostNic(
     *                         name='eth2',
     *                     ),
     *                 ],
     *             ),
     *         ),
     *     ],
     *     modified_network_attachments=[
     *         types.NetworkAttachment(
     *             network=types.Network(
     *                 name='myvlan',
     *             ),
     *             host_nic=types.HostNic(
     *                 name='bond0',
     *             ),
     *             ip_address_assignments=[
     *                 types.IpAddressAssignment(
     *                     assignment_method=types.BootProtocol.STATIC,
     *                     ip=types.Ip(
     *                         address='192.168.122.10',
     *                         netmask='255.255.255.0',
     *                     ),
     *                 ),
     *             ],
     *             dns_resolver_configuration=types.DnsResolverConfiguration(
     *                 name_servers=[
     *                     '1.1.1.1',
     *                     '2.2.2.2',
     *                 ],
     *             ),
     *         ),
     *     ],
     * )
     * 
     * # After modifying the network configuration it is very important to make it
     * # persistent:
     * host_service.commit_net_config()
     * ----
     * 
     * IMPORTANT: To make sure that the network configuration has been saved in the host, and that it will be applied
     * when the host is rebooted, remember to call <<services/host/methods/commit_net_config, commitnetconfig>>.
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    public interface SetupNetworksRequest extends Request<SetupNetworksRequest, SetupNetworksResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        SetupNetworksRequest async(Boolean async);
        SetupNetworksRequest checkConnectivity(Boolean checkConnectivity);
        /**
         * Specifies whether to automatically save the configuration in the {hypervisor-name} upon completing
         * the setup and re-establishing connectivity between the {hypervisor-name} and {engine-name},
         * and without waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>>
         * request.
         * The default value is `false`, which means that the configuration will not be
         * saved automatically.
         */
        SetupNetworksRequest commitOnSuccess(Boolean commitOnSuccess);
        SetupNetworksRequest connectivityTimeout(Integer connectivityTimeout);
        SetupNetworksRequest connectivityTimeout(Long connectivityTimeout);
        SetupNetworksRequest connectivityTimeout(BigInteger connectivityTimeout);
        SetupNetworksRequest modifiedBonds(List<HostNic> modifiedBonds);
        SetupNetworksRequest modifiedBonds(HostNic... modifiedBonds);
        SetupNetworksRequest modifiedBonds(HostNicBuilder... modifiedBonds);
        SetupNetworksRequest modifiedLabels(List<NetworkLabel> modifiedLabels);
        SetupNetworksRequest modifiedLabels(NetworkLabel... modifiedLabels);
        SetupNetworksRequest modifiedLabels(NetworkLabelBuilder... modifiedLabels);
        SetupNetworksRequest modifiedNetworkAttachments(List<NetworkAttachment> modifiedNetworkAttachments);
        SetupNetworksRequest modifiedNetworkAttachments(NetworkAttachment... modifiedNetworkAttachments);
        SetupNetworksRequest modifiedNetworkAttachments(NetworkAttachmentBuilder... modifiedNetworkAttachments);
        SetupNetworksRequest removedBonds(List<HostNic> removedBonds);
        SetupNetworksRequest removedBonds(HostNic... removedBonds);
        SetupNetworksRequest removedBonds(HostNicBuilder... removedBonds);
        SetupNetworksRequest removedLabels(List<NetworkLabel> removedLabels);
        SetupNetworksRequest removedLabels(NetworkLabel... removedLabels);
        SetupNetworksRequest removedLabels(NetworkLabelBuilder... removedLabels);
        SetupNetworksRequest removedNetworkAttachments(List<NetworkAttachment> removedNetworkAttachments);
        SetupNetworksRequest removedNetworkAttachments(NetworkAttachment... removedNetworkAttachments);
        SetupNetworksRequest removedNetworkAttachments(NetworkAttachmentBuilder... removedNetworkAttachments);
        SetupNetworksRequest synchronizedNetworkAttachments(List<NetworkAttachment> synchronizedNetworkAttachments);
        /**
         * A list of network attachments that will be synchronized.
         */
        SetupNetworksRequest synchronizedNetworkAttachments(NetworkAttachment... synchronizedNetworkAttachments);
        /**
         * A list of network attachments that will be synchronized.
         */
        SetupNetworksRequest synchronizedNetworkAttachments(NetworkAttachmentBuilder... synchronizedNetworkAttachments);
    }
    
    /**
     * This method is used to change the configuration of the network interfaces of a host.
     * 
     * For example, if you have a host with three network interfaces `eth0`, `eth1` and `eth2` and you want to configure
     * a new bond using `eth0` and `eth1`, and put a VLAN on top of it. Using a simple shell script and the `curl`
     * command line HTTP client that can be done as follows:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <modified_bonds>
     *     <host_nic>
     *       <name>bond0</name>
     *       <bonding>
     *         <options>
     *           <option>
     *             <name>mode</name>
     *             <value>4</value>
     *           </option>
     *           <option>
     *             <name>miimon</name>
     *             <value>100</value>
     *           </option>
     *         </options>
     *         <slaves>
     *           <host_nic>
     *             <name>eth1</name>
     *           </host_nic>
     *           <host_nic>
     *             <name>eth2</name>
     *           </host_nic>
     *         </slaves>
     *       </bonding>
     *     </host_nic>
     *   </modified_bonds>
     *   <modified_network_attachments>
     *     <network_attachment>
     *       <network>
     *         <name>myvlan</name>
     *       </network>
     *       <host_nic>
     *         <name>bond0</name>
     *       </host_nic>
     *       <ip_address_assignments>
     *         <ip_address_assignment>
     *           <assignment_method>static</assignment_method>
     *           <ip>
     *             <address>192.168.122.10</address>
     *             <netmask>255.255.255.0</netmask>
     *           </ip>
     *         </ip_address_assignment>
     *       </ip_address_assignments>
     *       <dns_resolver_configuration>
     *         <name_servers>
     *           <name_server>1.1.1.1</name_server>
     *           <name_server>2.2.2.2</name_server>
     *         </name_servers>
     *       </dns_resolver_configuration>
     *     </network_attachment>
     *   </modified_network_attachments>
     *  </action>
     * ' \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc/setupnetworks"
     * ----
     * 
     * NOTE: This is valid for version 4 of the API. In previous versions some elements were represented as XML
     * attributes instead of XML elements. In particular the `options` and `ip` elements were represented as follows:
     * 
     * [source,xml]
     * ----
     * <options name="mode" value="4"/>
     * <options name="miimon" value="100"/>
     * <ip address="192.168.122.10" netmask="255.255.255.0"/>
     * ----
     * 
     * The same thing can be done using the Python SDK with the following code:
     * 
     * [source,python]
     * ----
     * # Find the service that manages the collection of hosts:
     * hosts_service = connection.system_service().hosts_service()
     * 
     * # Find the host:
     * host = hosts_service.list(search='name=myhost')[0]
     * 
     * # Find the service that manages the host:
     * host_service = hosts_service.host_service(host.id)
     * 
     * # Configure the network adding a bond with two slaves and attaching it to a
     * # network with an static IP address:
     * host_service.setup_networks(
     *     modified_bonds=[
     *         types.HostNic(
     *             name='bond0',
     *             bonding=types.Bonding(
     *                 options=[
     *                     types.Option(
     *                         name='mode',
     *                         value='4',
     *                     ),
     *                     types.Option(
     *                         name='miimon',
     *                         value='100',
     *                     ),
     *                 ],
     *                 slaves=[
     *                     types.HostNic(
     *                         name='eth1',
     *                     ),
     *                     types.HostNic(
     *                         name='eth2',
     *                     ),
     *                 ],
     *             ),
     *         ),
     *     ],
     *     modified_network_attachments=[
     *         types.NetworkAttachment(
     *             network=types.Network(
     *                 name='myvlan',
     *             ),
     *             host_nic=types.HostNic(
     *                 name='bond0',
     *             ),
     *             ip_address_assignments=[
     *                 types.IpAddressAssignment(
     *                     assignment_method=types.BootProtocol.STATIC,
     *                     ip=types.Ip(
     *                         address='192.168.122.10',
     *                         netmask='255.255.255.0',
     *                     ),
     *                 ),
     *             ],
     *             dns_resolver_configuration=types.DnsResolverConfiguration(
     *                 name_servers=[
     *                     '1.1.1.1',
     *                     '2.2.2.2',
     *                 ],
     *             ),
     *         ),
     *     ],
     * )
     * 
     * # After modifying the network configuration it is very important to make it
     * # persistent:
     * host_service.commit_net_config()
     * ----
     * 
     * IMPORTANT: To make sure that the network configuration has been saved in the host, and that it will be applied
     * when the host is rebooted, remember to call <<services/host/methods/commit_net_config, commitnetconfig>>.
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    public interface SetupNetworksResponse extends Response {
    }
    
    /**
     * This method is used to change the configuration of the network interfaces of a host.
     * 
     * For example, if you have a host with three network interfaces `eth0`, `eth1` and `eth2` and you want to configure
     * a new bond using `eth0` and `eth1`, and put a VLAN on top of it. Using a simple shell script and the `curl`
     * command line HTTP client that can be done as follows:
     * 
     * [source]
     * ----
     * #!/bin/sh -ex
     * 
     * url="https://engine.example.com/ovirt-engine/api"
     * user="admin@internal"
     * password="..."
     * 
     * curl \
     * --verbose \
     * --cacert /etc/pki/ovirt-engine/ca.pem \
     * --user "${user}:${password}" \
     * --request POST \
     * --header "Version: 4" \
     * --header "Content-Type: application/xml" \
     * --header "Accept: application/xml" \
     * --data '
     * <action>
     *   <modified_bonds>
     *     <host_nic>
     *       <name>bond0</name>
     *       <bonding>
     *         <options>
     *           <option>
     *             <name>mode</name>
     *             <value>4</value>
     *           </option>
     *           <option>
     *             <name>miimon</name>
     *             <value>100</value>
     *           </option>
     *         </options>
     *         <slaves>
     *           <host_nic>
     *             <name>eth1</name>
     *           </host_nic>
     *           <host_nic>
     *             <name>eth2</name>
     *           </host_nic>
     *         </slaves>
     *       </bonding>
     *     </host_nic>
     *   </modified_bonds>
     *   <modified_network_attachments>
     *     <network_attachment>
     *       <network>
     *         <name>myvlan</name>
     *       </network>
     *       <host_nic>
     *         <name>bond0</name>
     *       </host_nic>
     *       <ip_address_assignments>
     *         <ip_address_assignment>
     *           <assignment_method>static</assignment_method>
     *           <ip>
     *             <address>192.168.122.10</address>
     *             <netmask>255.255.255.0</netmask>
     *           </ip>
     *         </ip_address_assignment>
     *       </ip_address_assignments>
     *       <dns_resolver_configuration>
     *         <name_servers>
     *           <name_server>1.1.1.1</name_server>
     *           <name_server>2.2.2.2</name_server>
     *         </name_servers>
     *       </dns_resolver_configuration>
     *     </network_attachment>
     *   </modified_network_attachments>
     *  </action>
     * ' \
     * "${url}/hosts/1ff7a191-2f3b-4eff-812b-9f91a30c3acc/setupnetworks"
     * ----
     * 
     * NOTE: This is valid for version 4 of the API. In previous versions some elements were represented as XML
     * attributes instead of XML elements. In particular the `options` and `ip` elements were represented as follows:
     * 
     * [source,xml]
     * ----
     * <options name="mode" value="4"/>
     * <options name="miimon" value="100"/>
     * <ip address="192.168.122.10" netmask="255.255.255.0"/>
     * ----
     * 
     * The same thing can be done using the Python SDK with the following code:
     * 
     * [source,python]
     * ----
     * # Find the service that manages the collection of hosts:
     * hosts_service = connection.system_service().hosts_service()
     * 
     * # Find the host:
     * host = hosts_service.list(search='name=myhost')[0]
     * 
     * # Find the service that manages the host:
     * host_service = hosts_service.host_service(host.id)
     * 
     * # Configure the network adding a bond with two slaves and attaching it to a
     * # network with an static IP address:
     * host_service.setup_networks(
     *     modified_bonds=[
     *         types.HostNic(
     *             name='bond0',
     *             bonding=types.Bonding(
     *                 options=[
     *                     types.Option(
     *                         name='mode',
     *                         value='4',
     *                     ),
     *                     types.Option(
     *                         name='miimon',
     *                         value='100',
     *                     ),
     *                 ],
     *                 slaves=[
     *                     types.HostNic(
     *                         name='eth1',
     *                     ),
     *                     types.HostNic(
     *                         name='eth2',
     *                     ),
     *                 ],
     *             ),
     *         ),
     *     ],
     *     modified_network_attachments=[
     *         types.NetworkAttachment(
     *             network=types.Network(
     *                 name='myvlan',
     *             ),
     *             host_nic=types.HostNic(
     *                 name='bond0',
     *             ),
     *             ip_address_assignments=[
     *                 types.IpAddressAssignment(
     *                     assignment_method=types.BootProtocol.STATIC,
     *                     ip=types.Ip(
     *                         address='192.168.122.10',
     *                         netmask='255.255.255.0',
     *                     ),
     *                 ),
     *             ],
     *             dns_resolver_configuration=types.DnsResolverConfiguration(
     *                 name_servers=[
     *                     '1.1.1.1',
     *                     '2.2.2.2',
     *                 ],
     *             ),
     *         ),
     *     ],
     * )
     * 
     * # After modifying the network configuration it is very important to make it
     * # persistent:
     * host_service.commit_net_config()
     * ----
     * 
     * IMPORTANT: To make sure that the network configuration has been saved in the host, and that it will be applied
     * when the host is rebooted, remember to call <<services/host/methods/commit_net_config, commitnetconfig>>.
     * 
     * IMPORTANT: Since {engine-name} 4.3, it is possible to also specify `commit_on_success` in
     * the <<services/host/methods/setup_networks, setupnetworks>> request, in which case the new
     * configuration is automatically saved in the {hypervisor-name} upon completing the setup and
     * re-establishing connectivity between the {hypervisor-name} and {engine-name}, and without
     * waiting for a separate <<services/host/methods/commit_net_config, commitnetconfig>> request.
     */
    SetupNetworksRequest setupNetworks();
    
    /**
     * To synchronize all networks on the host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SyncAllNetworksRequest extends Request<SyncAllNetworksRequest, SyncAllNetworksResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        SyncAllNetworksRequest async(Boolean async);
    }
    
    /**
     * To synchronize all networks on the host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SyncAllNetworksResponse extends Response {
    }
    
    /**
     * To synchronize all networks on the host, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/syncallnetworks
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    SyncAllNetworksRequest syncAllNetworks();
    
    /**
     * Discovers the block Storage Domains which are candidates to be imported to the setup. For FCP no arguments are
     * required.
     */
    public interface UnregisteredStorageDomainsDiscoverRequest extends Request<UnregisteredStorageDomainsDiscoverRequest, UnregisteredStorageDomainsDiscoverResponse> {
        /**
         * Indicates if the discovery should be performed asynchronously.
         */
        UnregisteredStorageDomainsDiscoverRequest async(Boolean async);
        UnregisteredStorageDomainsDiscoverRequest iscsi(IscsiDetails iscsi);
        UnregisteredStorageDomainsDiscoverRequest iscsi(IscsiDetailsBuilder iscsi);
    }
    
    /**
     * Discovers the block Storage Domains which are candidates to be imported to the setup. For FCP no arguments are
     * required.
     */
    public interface UnregisteredStorageDomainsDiscoverResponse extends Response {
        List<StorageDomain> storageDomains();
    }
    
    /**
     * Discovers the block Storage Domains which are candidates to be imported to the setup. For FCP no arguments are
     * required.
     */
    UnregisteredStorageDomainsDiscoverRequest unregisteredStorageDomainsDiscover();
    
    /**
     * Update the host properties.
     * 
     * For example, to update a the kernel command line of a host send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123
     * ----
     * 
     * With request body like this:
     * 
     * [source, xml]
     * ----
     * <host>
     *   <os>
     *     <custom_kernel_cmdline>vfio_iommu_type1.allow_unsafe_interrupts=1</custom_kernel_cmdline>
     *   </os>
     * </host>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest host(Host host);
        UpdateRequest host(HostBuilder host);
    }
    
    /**
     * Update the host properties.
     * 
     * For example, to update a the kernel command line of a host send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123
     * ----
     * 
     * With request body like this:
     * 
     * [source, xml]
     * ----
     * <host>
     *   <os>
     *     <custom_kernel_cmdline>vfio_iommu_type1.allow_unsafe_interrupts=1</custom_kernel_cmdline>
     *   </os>
     * </host>
     * ----
     */
    public interface UpdateResponse extends Response {
        Host host();
    }
    
    /**
     * Update the host properties.
     * 
     * For example, to update a the kernel command line of a host send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/hosts/123
     * ----
     * 
     * With request body like this:
     * 
     * [source, xml]
     * ----
     * <host>
     *   <os>
     *     <custom_kernel_cmdline>vfio_iommu_type1.allow_unsafe_interrupts=1</custom_kernel_cmdline>
     *   </os>
     * </host>
     * ----
     */
    UpdateRequest update();
    
    /**
     * Upgrades VDSM and selected software on the host.
     */
    public interface UpgradeRequest extends Request<UpgradeRequest, UpgradeResponse> {
        /**
         * Indicates if the upgrade should be performed asynchronously.
         */
        UpgradeRequest async(Boolean async);
        /**
         * This property is no longer relevant, since Vintage Node is no longer supported, and has been deprecated.
         */
        UpgradeRequest image(String image);
        /**
         * Indicates if the host should be rebooted after the upgrade.
         * By default the host is rebooted.
         * 
         * NOTE: This parameter is ignored for {hypervisor-name}, which is always rebooted after the upgrade.
         */
        UpgradeRequest reboot(Boolean reboot);
        /**
         * Upgrade timeout.
         * 
         * The maximum time to wait for upgrade to finish in minutes.
         * Default value is specified by `ANSIBLE_PLAYBOOK_EXEC_DEFAULT_TIMEOUT` configration option.
         */
        UpgradeRequest timeout(Integer timeout);
        /**
         * Upgrade timeout.
         * 
         * The maximum time to wait for upgrade to finish in minutes.
         * Default value is specified by `ANSIBLE_PLAYBOOK_EXEC_DEFAULT_TIMEOUT` configration option.
         */
        UpgradeRequest timeout(Long timeout);
        /**
         * Upgrade timeout.
         * 
         * The maximum time to wait for upgrade to finish in minutes.
         * Default value is specified by `ANSIBLE_PLAYBOOK_EXEC_DEFAULT_TIMEOUT` configration option.
         */
        UpgradeRequest timeout(BigInteger timeout);
    }
    
    /**
     * Upgrades VDSM and selected software on the host.
     */
    public interface UpgradeResponse extends Response {
    }
    
    /**
     * Upgrades VDSM and selected software on the host.
     */
    UpgradeRequest upgrade();
    
    /**
     * Check if there are upgrades available for the host. If there are upgrades available an icon will be displayed
     * next to host status icon in the Administration Portal. Audit log messages are also added to indicate the
     * availability of upgrades. The upgrade can be started from the webadmin or by using the
     * <<services/host/methods/upgrade, upgrade>> host action.
     */
    public interface UpgradeCheckRequest extends Request<UpgradeCheckRequest, UpgradeCheckResponse> {
    }
    
    /**
     * Check if there are upgrades available for the host. If there are upgrades available an icon will be displayed
     * next to host status icon in the Administration Portal. Audit log messages are also added to indicate the
     * availability of upgrades. The upgrade can be started from the webadmin or by using the
     * <<services/host/methods/upgrade, upgrade>> host action.
     */
    public interface UpgradeCheckResponse extends Response {
    }
    
    /**
     * Check if there are upgrades available for the host. If there are upgrades available an icon will be displayed
     * next to host status icon in the Administration Portal. Audit log messages are also added to indicate the
     * availability of upgrades. The upgrade can be started from the webadmin or by using the
     * <<services/host/methods/upgrade, upgrade>> host action.
     */
    UpgradeCheckRequest upgradeCheck();
    
    public interface ApproveUsingRootPasswordRequest extends Request<ApproveUsingRootPasswordRequest, ApproveUsingRootPasswordResponse> {
        /**
         * When set to 'true', this host will be activated after its approval completes. When set to 'false'
         * the host will remain in 'maintenance' status after its approval. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after approval.
         */
        ApproveUsingRootPasswordRequest activate(Boolean activate);
        /**
         * Indicates if the approval should be performed asynchronously.
         */
        ApproveUsingRootPasswordRequest async(Boolean async);
        ApproveUsingRootPasswordRequest cluster(Cluster cluster);
        /**
         * The cluster where the host will be added after it is approved.
         */
        ApproveUsingRootPasswordRequest cluster(ClusterBuilder cluster);
        ApproveUsingRootPasswordRequest host(Host host);
        /**
         * The host to approve.
         */
        ApproveUsingRootPasswordRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        ApproveUsingRootPasswordRequest reboot(Boolean reboot);
    }
    
    public interface ApproveUsingRootPasswordResponse extends Response {
    }
    
    ApproveUsingRootPasswordRequest approveUsingRootPassword();
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the root
     * password. This has been deprecated.
     */
    public interface InstallUsingRootPasswordRequest extends Request<InstallUsingRootPasswordRequest, InstallUsingRootPasswordResponse> {
        /**
         * When set to 'true', this host will be activated after its installation completes. When set to 'false'
         * the host will remain in 'maintenance' status after its installation. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after install.
         */
        InstallUsingRootPasswordRequest activate(Boolean activate);
        /**
         * Indicates if the installation should be performed asynchronously.
         */
        InstallUsingRootPasswordRequest async(Boolean async);
        /**
         * When set to `true` this host will also deploy the self-hosted engine components. A missing value
         * is treated as `true` i.e deploy. Omitting this parameter means `false` and will not perform any operation in the
         * self-hosted engine area.
         */
        InstallUsingRootPasswordRequest deployHostedEngine(Boolean deployHostedEngine);
        InstallUsingRootPasswordRequest host(Host host);
        /**
         * The `override_iptables` property is used to indicate if the firewall configuration should be replaced by the
         * default one.
         */
        InstallUsingRootPasswordRequest host(HostBuilder host);
        /**
         * When installing {hypervisor-name}, an ISO image file is required.
         */
        InstallUsingRootPasswordRequest image(String image);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        InstallUsingRootPasswordRequest reboot(Boolean reboot);
        /**
         * The password of the `root` user used to connect to the host via SSH.
         */
        InstallUsingRootPasswordRequest rootPassword(String rootPassword);
        InstallUsingRootPasswordRequest ssh(Ssh ssh);
        /**
         * The SSH details used to connect to the host.
         */
        InstallUsingRootPasswordRequest ssh(SshBuilder ssh);
        /**
         * When set to `true` this host will un-deploy the self-hosted engine components, and this host will
         * not function as part of the High Availability cluster. A missing value is treated as `true` i.e un-deploy.
         * Omitting this parameter means `false` and will not perform any operation in the self-hosted engine area.
         */
        InstallUsingRootPasswordRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the root
     * password. This has been deprecated.
     */
    public interface InstallUsingRootPasswordResponse extends Response {
    }
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the root
     * password. This has been deprecated.
     */
    InstallUsingRootPasswordRequest installUsingRootPassword();
    
    /**
     * Update the specified host in the system. This is deprecated and is provided only for backwards compatibility.
     */
    public interface UpdateUsingRootPasswordRequest extends Request<UpdateUsingRootPasswordRequest, UpdateUsingRootPasswordResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateUsingRootPasswordRequest async(Boolean async);
        UpdateUsingRootPasswordRequest host(Host host);
        UpdateUsingRootPasswordRequest host(HostBuilder host);
    }
    
    /**
     * Update the specified host in the system. This is deprecated and is provided only for backwards compatibility.
     */
    public interface UpdateUsingRootPasswordResponse extends Response {
        Host host();
    }
    
    /**
     * Update the specified host in the system. This is deprecated and is provided only for backwards compatibility.
     */
    UpdateUsingRootPasswordRequest updateUsingRootPassword();
    
    /**
     * Approve the specified host to be added to the engine by using ssh authentication. This occurs when the host
     * registers itself with the engine.
     */
    public interface ApproveUsingSshRequest extends Request<ApproveUsingSshRequest, ApproveUsingSshResponse> {
        /**
         * When set to 'true', this host will be activated after its approval completes. When set to 'false'
         * the host will remain in 'maintenance' status after its approval. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after approval.
         */
        ApproveUsingSshRequest activate(Boolean activate);
        /**
         * Indicates if the approval should be performed asynchronously.
         */
        ApproveUsingSshRequest async(Boolean async);
        ApproveUsingSshRequest cluster(Cluster cluster);
        /**
         * The cluster where the host will be added after it is approved.
         */
        ApproveUsingSshRequest cluster(ClusterBuilder cluster);
        ApproveUsingSshRequest host(Host host);
        /**
         * The host to approve.
         */
        ApproveUsingSshRequest host(HostBuilder host);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        ApproveUsingSshRequest reboot(Boolean reboot);
    }
    
    /**
     * Approve the specified host to be added to the engine by using ssh authentication. This occurs when the host
     * registers itself with the engine.
     */
    public interface ApproveUsingSshResponse extends Response {
    }
    
    /**
     * Approve the specified host to be added to the engine by using ssh authentication. This occurs when the host
     * registers itself with the engine.
     */
    ApproveUsingSshRequest approveUsingSsh();
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the SSH
     * password.
     */
    public interface InstallUsingSshRequest extends Request<InstallUsingSshRequest, InstallUsingSshResponse> {
        /**
         * When set to 'true', this host will be activated after its installation completes. When set to 'false'
         * the host will remain in 'maintenance' status after its installation. Absence of this parameter will be
         * interpreted as 'true', since the desired default behavior is activating the host after install.
         */
        InstallUsingSshRequest activate(Boolean activate);
        /**
         * Indicates if the installation should be performed asynchronously.
         */
        InstallUsingSshRequest async(Boolean async);
        /**
         * When set to `true` this host will also deploy the self-hosted engine components. A missing value
         * is treated as `true` i.e deploy. Omitting this parameter means `false` and will not perform any operation in the
         * self-hosted engine area.
         */
        InstallUsingSshRequest deployHostedEngine(Boolean deployHostedEngine);
        InstallUsingSshRequest host(Host host);
        /**
         * The `override_iptables` property is used to indicate if the firewall configuration should be replaced by the
         * default one.
         */
        InstallUsingSshRequest host(HostBuilder host);
        /**
         * When installing {hypervisor-name}, an ISO image file is required.
         */
        InstallUsingSshRequest image(String image);
        /**
         * Indicates if the host should be rebooted after successful installation. The default value is `true`.
         */
        InstallUsingSshRequest reboot(Boolean reboot);
        /**
         * The password of the `root` user used to connect to the host via SSH.
         */
        InstallUsingSshRequest rootPassword(String rootPassword);
        InstallUsingSshRequest ssh(Ssh ssh);
        /**
         * The SSH details used to connect to the host.
         */
        InstallUsingSshRequest ssh(SshBuilder ssh);
        /**
         * When set to `true` this host will un-deploy the self-hosted engine components, and this host will
         * not function as part of the High Availability cluster. A missing value is treated as `true` i.e un-deploy.
         * Omitting this parameter means `false` and will not perform any operation in the self-hosted engine area.
         */
        InstallUsingSshRequest undeployHostedEngine(Boolean undeployHostedEngine);
    }
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the SSH
     * password.
     */
    public interface InstallUsingSshResponse extends Response {
    }
    
    /**
     * Install VDSM and other packages required to get the host ready to be used in the engine providing the SSH
     * password.
     */
    InstallUsingSshRequest installUsingSsh();
    
    /**
     * Updates the specified host in the system.
     */
    public interface UpdateUsingSshRequest extends Request<UpdateUsingSshRequest, UpdateUsingSshResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateUsingSshRequest async(Boolean async);
        UpdateUsingSshRequest host(Host host);
        UpdateUsingSshRequest host(HostBuilder host);
    }
    
    /**
     * Updates the specified host in the system.
     */
    public interface UpdateUsingSshResponse extends Response {
        Host host();
    }
    
    /**
     * Updates the specified host in the system.
     */
    UpdateUsingSshRequest updateUsingSsh();
    
    /**
     * List of scheduling labels assigned to this host.
     */
    AssignedAffinityLabelsService affinityLabelsService();
    /**
     * A reference to the host devices service. Use this service to view the devices of the host object.
     */
    HostDevicesService devicesService();
    /**
     * External network providers provisioned by the system on the host.
     */
    ExternalNetworkProviderConfigurationsService externalNetworkProviderConfigurationsService();
    /**
     * A reference to the fence agents service. Use this service to manage fence and power management agents on the host
     * object.
     */
    FenceAgentsService fenceAgentsService();
    /**
     * A reference to the host hooks service. Use this service to view the hooks available in the host object.
     */
    HostHooksService hooksService();
    /**
     * A reference to the service that can show the applicable errata available on the host. This information is taken
     * from Katello.
     */
    KatelloErrataService katelloErrataService();
    /**
     * A reference to the network attachments service. You can use this service to attach Logical networks to host
     * interfaces.
     */
    NetworkAttachmentsService networkAttachmentsService();
    /**
     * A reference to the service that manages the network interface devices on the host.
     */
    HostNicsService nicsService();
    /**
     * A reference to the service that manage NUMA nodes for the host.
     */
    HostNumaNodesService numaNodesService();
    /**
     * A reference to the host permission service.
     * Use this service to manage permissions on the host object.
     */
    AssignedPermissionsService permissionsService();
    /**
     * A reference to the service that manages the host's storage.
     */
    HostStorageService storageService();
    /**
     * A reference to storage connection extensions.
     */
    StorageServerConnectionExtensionsService storageConnectionExtensionsService();
    /**
     * A reference to the host tags service. Use this service to manage tags on the host object.
     */
    AssignedTagsService tagsService();
    /**
     * A reference to unmanaged networks.
     */
    UnmanagedNetworksService unmanagedNetworksService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

