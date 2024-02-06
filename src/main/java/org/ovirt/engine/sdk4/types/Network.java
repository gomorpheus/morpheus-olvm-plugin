/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * The type for a logical network.
 * 
 * An example of the JSON representation of a logical network:
 * 
 * [source,json]
 * ----
 * {
     *   "network" : [ {
         *     "data_center" : {
             *       "href" : "/ovirt-engine/api/datacenters/123",
             *       "id" : "123"
             *     },
             *     "stp" : "false",
             *     "mtu" : "0",
             *     "usages" : {
                 *       "usage" : [ "vm" ]
                 *     },
                 *     "name" : "ovirtmgmt",
                 *     "description" : "Management Network",
                 *     "href" : "/ovirt-engine/api/networks/456",
                 *     "id" : "456",
                 *     "link" : [ {
                     *       "href" : "/ovirt-engine/api/networks/456/permissions",
                     *       "rel" : "permissions"
                     *     }, {
                         *       "href" : "/ovirt-engine/api/networks/456/vnicprofiles",
                         *       "rel" : "vnicprofiles"
                         *     }, {
                             *       "href" : "/ovirt-engine/api/networks/456/labels",
                             *       "rel" : "labels"
                             *     } ]
                             *   } ]
                         * }
                         * ----
                         * 
                         * An example of the XML representation of the same logical network:
                         * 
                         * [source,xml]
                         * ----
                         * <network href="/ovirt-engine/api/networks/456" id="456">
                         *   <name>ovirtmgmt</name>
                         *   <description>Management Network</description>
                         *   <link href="/ovirt-engine/api/networks/456/permissions" rel="permissions"/>
                         *   <link href="/ovirt-engine/api/networks/456/vnicprofiles" rel="vnicprofiles"/>
                         *   <link href="/ovirt-engine/api/networks/456/labels" rel="labels"/>
                         *   <data_center href="/ovirt-engine/api/datacenters/123" id="123"/>
                         *   <stp>false</stp>
                         *   <mtu>0</mtu>
                         *   <usages>
                         *     <usage>vm</usage>
                         *   </usages>
                         * </network>
                         * ----
                         */
                        public interface Network extends Identified {
                            boolean display();
                            
                            boolean displayPresent();
                            
                            DnsResolverConfiguration dnsResolverConfiguration();
                            
                            boolean dnsResolverConfigurationPresent();
                            
                            Ip ip();
                            
                            boolean ipPresent();
                            
                            BigInteger mtu();
                            Byte mtuAsByte();
                            Short mtuAsShort();
                            Integer mtuAsInteger();
                            Long mtuAsLong();
                            
                            boolean mtuPresent();
                            
                            boolean portIsolation();
                            
                            boolean portIsolationPresent();
                            
                            boolean profileRequired();
                            
                            boolean profileRequiredPresent();
                            
                            boolean required();
                            
                            boolean requiredPresent();
                            
                            NetworkStatus status();
                            
                            boolean statusPresent();
                            
                            boolean stp();
                            
                            boolean stpPresent();
                            
                            List<NetworkUsage> usages();
                            
                            boolean usagesPresent();
                            
                            String vdsmName();
                            
                            boolean vdsmNamePresent();
                            
                            Vlan vlan();
                            
                            boolean vlanPresent();
                            
                            Cluster cluster();
                            
                            boolean clusterPresent();
                            
                            DataCenter dataCenter();
                            
                            boolean dataCenterPresent();
                            
                            OpenStackNetworkProvider externalProvider();
                            
                            boolean externalProviderPresent();
                            
                            Network externalProviderPhysicalNetwork();
                            
                            boolean externalProviderPhysicalNetworkPresent();
                            
                            List<NetworkLabel> networkLabels();
                            
                            boolean networkLabelsPresent();
                            
                            List<Permission> permissions();
                            
                            boolean permissionsPresent();
                            
                            Qos qos();
                            
                            boolean qosPresent();
                            
                            List<VnicProfile> vnicProfiles();
                            
                            boolean vnicProfilesPresent();
                            
                        }
