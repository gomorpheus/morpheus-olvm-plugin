/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Type representation of a cluster.
 * 
 * A JSON representation of a cluster:
 * 
 * [source]
 * ----
 * {
     *   "cluster" : [ {
         *     "ballooning_enabled" : "false",
         *     "cpu" : {
             *       "architecture" : "x86_64",
             *       "type" : "Intel SandyBridge Family"
             *     },
             *     "custom_scheduling_policy_properties" : {
                 *       "property" : [ {
                     *         "name" : "HighUtilization",
                     *         "value" : "80"
                     *       }, {
                         *         "name" : "CpuOverCommitDurationMinutes",
                         *         "value" : "2"
                         *       } ]
                         *     },
                         *     "error_handling" : {
                             *       "on_error" : "migrate"
                             *     },
                             *     "fencing_policy" : {
                                 *       "enabled" : "true",
                                 *       "skip_if_connectivity_broken" : {
                                     *         "enabled" : "false",
                                     *         "threshold" : "50"
                                     *       },
                                     *       "skip_if_gluster_bricks_up" : "false",
                                     *       "skip_if_gluster_quorum_not_met" : "false",
                                     *       "skip_if_sd_active" : {
                                         *         "enabled" : "false"
                                     *       }
                                     *     },
                                     *     "gluster_service" : "false",
                                     *     "firewall_type" : "iptables",
                                     *     "ha_reservation" : "false",
                                     *     "ksm" : {
                                         *       "enabled" : "true",
                                         *       "merge_across_nodes" : "true"
                                         *     },
                                         *     "memory_policy" : {
                                             *       "over_commit" : {
                                                 *         "percent" : "100"
                                                 *       },
                                                 *       "transparent_hugepages" : {
                                                     *         "enabled" : "true"
                                                 *       }
                                                 *     },
                                                 *     "migration" : {
                                                     *       "auto_converge" : "inherit",
                                                     *       "bandwidth" : {
                                                         *         "assignment_method" : "auto"
                                                         *       },
                                                         *       "compressed" : "inherit",
                                                         *       "policy" : {
                                                             *         "id" : "00000000-0000-0000-0000-000000000000"
                                                         *       }
                                                         *     },
                                                         *     "required_rng_sources" : {
                                                             *       "required_rng_source" : [ "random" ]
                                                             *     },
                                                             *     "switch_type" : "legacy",
                                                             *     "threads_as_cores" : "false",
                                                             *     "trusted_service" : "false",
                                                             *     "tunnel_migration" : "false",
                                                             *     "version" : {
                                                                 *       "major" : "4",
                                                                 *       "minor" : "1"
                                                                 *     },
                                                                 *     "virt_service" : "true",
                                                                 *     "data_center" : {
                                                                     *       "href" : "/ovirt-engine/api/datacenters/123",
                                                                     *       "id" : "123"
                                                                     *     },
                                                                     *     "mac_pool" : {
                                                                         *       "href" : "/ovirt-engine/api/macpools/456",
                                                                         *       "id" : "456"
                                                                         *     },
                                                                         *     "scheduling_policy" : {
                                                                             *       "href" : "/ovirt-engine/api/schedulingpolicies/789",
                                                                             *       "id" : "789"
                                                                             *     },
                                                                             *     "actions" : {
                                                                                 *       "link" : [ {
                                                                                     *         "href" : "/ovirt-engine/api/clusters/234/resetemulatedmachine",
                                                                                     *         "rel" : "resetemulatedmachine"
                                                                                     *       } ]
                                                                                     *     },
                                                                                     *     "name" : "Default",
                                                                                     *     "description" : "The default server cluster",
                                                                                     *     "href" : "/ovirt-engine/api/clusters/234",
                                                                                     *     "id" : "234",
                                                                                     *     "link" : [ {
                                                                                         *       "href" : "/ovirt-engine/api/clusters/234/permissions",
                                                                                         *       "rel" : "permissions"
                                                                                         *     }, {
                                                                                             *       "href" : "/ovirt-engine/api/clusters/234/cpuprofiles",
                                                                                             *       "rel" : "cpuprofiles"
                                                                                             *     }, {
                                                                                                 *       "href" : "/ovirt-engine/api/clusters/234/networkfilters",
                                                                                                 *       "rel" : "networkfilters"
                                                                                                 *     }, {
                                                                                                     *       "href" : "/ovirt-engine/api/clusters/234/networks",
                                                                                                     *       "rel" : "networks"
                                                                                                     *     }, {
                                                                                                         *       "href" : "/ovirt-engine/api/clusters/234/affinitygroups",
                                                                                                         *       "rel" : "affinitygroups"
                                                                                                         *     }, {
                                                                                                             *       "href" : "/ovirt-engine/api/clusters/234/glusterhooks",
                                                                                                             *       "rel" : "glusterhooks"
                                                                                                             *     }, {
                                                                                                                 *       "href" : "/ovirt-engine/api/clusters/234/glustervolumes",
                                                                                                                 *       "rel" : "glustervolumes"
                                                                                                                 *     }, {
                                                                                                                     *       "href" : "/ovirt-engine/api/clusters/234/enabledfeatures",
                                                                                                                     *       "rel" : "enabledfeatures"
                                                                                                                     *     }, {
                                                                                                                         *       "href" : "/ovirt-engine/api/clusters/234/externalnetworkproviders",
                                                                                                                         *       "rel" : "externalnetworkproviders"
                                                                                                                         *     } ]
                                                                                                                         *   } ]
                                                                                                                     * }
                                                                                                                     * ----
                                                                                                                     */
                                                                                                                    public interface Cluster extends Identified {
                                                                                                                        boolean ballooningEnabled();
                                                                                                                        
                                                                                                                        boolean ballooningEnabledPresent();
                                                                                                                        
                                                                                                                        BiosType biosType();
                                                                                                                        
                                                                                                                        boolean biosTypePresent();
                                                                                                                        
                                                                                                                        Cpu cpu();
                                                                                                                        
                                                                                                                        boolean cpuPresent();
                                                                                                                        
                                                                                                                        List<Property> customSchedulingPolicyProperties();
                                                                                                                        
                                                                                                                        boolean customSchedulingPolicyPropertiesPresent();
                                                                                                                        
                                                                                                                        Display display();
                                                                                                                        
                                                                                                                        boolean displayPresent();
                                                                                                                        
                                                                                                                        ErrorHandling errorHandling();
                                                                                                                        
                                                                                                                        boolean errorHandlingPresent();
                                                                                                                        
                                                                                                                        FencingPolicy fencingPolicy();
                                                                                                                        
                                                                                                                        boolean fencingPolicyPresent();
                                                                                                                        
                                                                                                                        FipsMode fipsMode();
                                                                                                                        
                                                                                                                        boolean fipsModePresent();
                                                                                                                        
                                                                                                                        FirewallType firewallType();
                                                                                                                        
                                                                                                                        boolean firewallTypePresent();
                                                                                                                        
                                                                                                                        boolean glusterService();
                                                                                                                        
                                                                                                                        boolean glusterServicePresent();
                                                                                                                        
                                                                                                                        String glusterTunedProfile();
                                                                                                                        
                                                                                                                        boolean glusterTunedProfilePresent();
                                                                                                                        
                                                                                                                        boolean haReservation();
                                                                                                                        
                                                                                                                        boolean haReservationPresent();
                                                                                                                        
                                                                                                                        Ksm ksm();
                                                                                                                        
                                                                                                                        boolean ksmPresent();
                                                                                                                        
                                                                                                                        BigInteger logMaxMemoryUsedThreshold();
                                                                                                                        Byte logMaxMemoryUsedThresholdAsByte();
                                                                                                                        Short logMaxMemoryUsedThresholdAsShort();
                                                                                                                        Integer logMaxMemoryUsedThresholdAsInteger();
                                                                                                                        Long logMaxMemoryUsedThresholdAsLong();
                                                                                                                        
                                                                                                                        boolean logMaxMemoryUsedThresholdPresent();
                                                                                                                        
                                                                                                                        LogMaxMemoryUsedThresholdType logMaxMemoryUsedThresholdType();
                                                                                                                        
                                                                                                                        boolean logMaxMemoryUsedThresholdTypePresent();
                                                                                                                        
                                                                                                                        boolean maintenanceReasonRequired();
                                                                                                                        
                                                                                                                        boolean maintenanceReasonRequiredPresent();
                                                                                                                        
                                                                                                                        MemoryPolicy memoryPolicy();
                                                                                                                        
                                                                                                                        boolean memoryPolicyPresent();
                                                                                                                        
                                                                                                                        MigrationOptions migration();
                                                                                                                        
                                                                                                                        boolean migrationPresent();
                                                                                                                        
                                                                                                                        boolean optionalReason();
                                                                                                                        
                                                                                                                        boolean optionalReasonPresent();
                                                                                                                        
                                                                                                                        List<RngSource> requiredRngSources();
                                                                                                                        
                                                                                                                        boolean requiredRngSourcesPresent();
                                                                                                                        
                                                                                                                        SerialNumber serialNumber();
                                                                                                                        
                                                                                                                        boolean serialNumberPresent();
                                                                                                                        
                                                                                                                        List<Version> supportedVersions();
                                                                                                                        
                                                                                                                        boolean supportedVersionsPresent();
                                                                                                                        
                                                                                                                        SwitchType switchType();
                                                                                                                        
                                                                                                                        boolean switchTypePresent();
                                                                                                                        
                                                                                                                        boolean threadsAsCores();
                                                                                                                        
                                                                                                                        boolean threadsAsCoresPresent();
                                                                                                                        
                                                                                                                        boolean trustedService();
                                                                                                                        
                                                                                                                        boolean trustedServicePresent();
                                                                                                                        
                                                                                                                        boolean tunnelMigration();
                                                                                                                        
                                                                                                                        boolean tunnelMigrationPresent();
                                                                                                                        
                                                                                                                        Version version();
                                                                                                                        
                                                                                                                        boolean versionPresent();
                                                                                                                        
                                                                                                                        boolean virtService();
                                                                                                                        
                                                                                                                        boolean virtServicePresent();
                                                                                                                        
                                                                                                                        boolean vncEncryption();
                                                                                                                        
                                                                                                                        boolean vncEncryptionPresent();
                                                                                                                        
                                                                                                                        List<AffinityGroup> affinityGroups();
                                                                                                                        
                                                                                                                        boolean affinityGroupsPresent();
                                                                                                                        
                                                                                                                        List<CpuProfile> cpuProfiles();
                                                                                                                        
                                                                                                                        boolean cpuProfilesPresent();
                                                                                                                        
                                                                                                                        DataCenter dataCenter();
                                                                                                                        
                                                                                                                        boolean dataCenterPresent();
                                                                                                                        
                                                                                                                        List<ClusterFeature> enabledFeatures();
                                                                                                                        
                                                                                                                        boolean enabledFeaturesPresent();
                                                                                                                        
                                                                                                                        List<ExternalProvider> externalNetworkProviders();
                                                                                                                        
                                                                                                                        boolean externalNetworkProvidersPresent();
                                                                                                                        
                                                                                                                        List<GlusterHook> glusterHooks();
                                                                                                                        
                                                                                                                        boolean glusterHooksPresent();
                                                                                                                        
                                                                                                                        List<GlusterVolume> glusterVolumes();
                                                                                                                        
                                                                                                                        boolean glusterVolumesPresent();
                                                                                                                        
                                                                                                                        MacPool macPool();
                                                                                                                        
                                                                                                                        boolean macPoolPresent();
                                                                                                                        
                                                                                                                        Network managementNetwork();
                                                                                                                        
                                                                                                                        boolean managementNetworkPresent();
                                                                                                                        
                                                                                                                        List<NetworkFilter> networkFilters();
                                                                                                                        
                                                                                                                        boolean networkFiltersPresent();
                                                                                                                        
                                                                                                                        List<Network> networks();
                                                                                                                        
                                                                                                                        boolean networksPresent();
                                                                                                                        
                                                                                                                        List<Permission> permissions();
                                                                                                                        
                                                                                                                        boolean permissionsPresent();
                                                                                                                        
                                                                                                                        SchedulingPolicy schedulingPolicy();
                                                                                                                        
                                                                                                                        boolean schedulingPolicyPresent();
                                                                                                                        
                                                                                                                    }
