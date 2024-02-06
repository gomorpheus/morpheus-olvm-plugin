/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.ClusterContainer;
import org.ovirt.engine.sdk4.types.Cluster;

public class XmlClusterReader {
    
    public static Cluster readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ClusterContainer object = new ClusterContainer();
        
        // Process the attributes:
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String image = reader.getAttributeValue(i);
            switch (name) {
                case "href":
                object.href(image);
                break;
                case "id":
                object.id(image);
                break;
                default:
                break;
            }
        }
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "affinity_groups":
                object.affinityGroups(XmlAffinityGroupReader.readMany(reader));
                break;
                case "ballooning_enabled":
                object.ballooningEnabled(reader.readBoolean());
                break;
                case "bios_type":
                object.biosType(XmlBiosTypeReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "cpu":
                object.cpu(XmlCpuReader.readOne(reader));
                break;
                case "cpu_profiles":
                object.cpuProfiles(XmlCpuProfileReader.readMany(reader));
                break;
                case "custom_scheduling_policy_properties":
                object.customSchedulingPolicyProperties(XmlPropertyReader.readMany(reader));
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "display":
                object.display(XmlDisplayReader.readOne(reader));
                break;
                case "enabled_features":
                object.enabledFeatures(XmlClusterFeatureReader.readMany(reader));
                break;
                case "error_handling":
                object.errorHandling(XmlErrorHandlingReader.readOne(reader));
                break;
                case "external_network_providers":
                object.externalNetworkProviders(XmlExternalProviderReader.readMany(reader));
                break;
                case "fencing_policy":
                object.fencingPolicy(XmlFencingPolicyReader.readOne(reader));
                break;
                case "fips_mode":
                object.fipsMode(XmlFipsModeReader.readOne(reader));
                break;
                case "firewall_type":
                object.firewallType(XmlFirewallTypeReader.readOne(reader));
                break;
                case "gluster_hooks":
                object.glusterHooks(XmlGlusterHookReader.readMany(reader));
                break;
                case "gluster_service":
                object.glusterService(reader.readBoolean());
                break;
                case "gluster_tuned_profile":
                object.glusterTunedProfile(reader.readString());
                break;
                case "gluster_volumes":
                object.glusterVolumes(XmlGlusterVolumeReader.readMany(reader));
                break;
                case "ha_reservation":
                object.haReservation(reader.readBoolean());
                break;
                case "ksm":
                object.ksm(XmlKsmReader.readOne(reader));
                break;
                case "log_max_memory_used_threshold":
                object.logMaxMemoryUsedThreshold(reader.readInteger());
                break;
                case "log_max_memory_used_threshold_type":
                object.logMaxMemoryUsedThresholdType(XmlLogMaxMemoryUsedThresholdTypeReader.readOne(reader));
                break;
                case "mac_pool":
                object.macPool(XmlMacPoolReader.readOne(reader));
                break;
                case "maintenance_reason_required":
                object.maintenanceReasonRequired(reader.readBoolean());
                break;
                case "management_network":
                object.managementNetwork(XmlNetworkReader.readOne(reader));
                break;
                case "memory_policy":
                object.memoryPolicy(XmlMemoryPolicyReader.readOne(reader));
                break;
                case "migration":
                object.migration(XmlMigrationOptionsReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network_filters":
                object.networkFilters(XmlNetworkFilterReader.readMany(reader));
                break;
                case "networks":
                object.networks(XmlNetworkReader.readMany(reader));
                break;
                case "optional_reason":
                object.optionalReason(reader.readBoolean());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "required_rng_sources":
                object.requiredRngSources(XmlRngSourceReader.readMany(reader));
                break;
                case "scheduling_policy":
                object.schedulingPolicy(XmlSchedulingPolicyReader.readOne(reader));
                break;
                case "serial_number":
                object.serialNumber(XmlSerialNumberReader.readOne(reader));
                break;
                case "supported_versions":
                object.supportedVersions(XmlVersionReader.readMany(reader));
                break;
                case "switch_type":
                object.switchType(XmlSwitchTypeReader.readOne(reader));
                break;
                case "threads_as_cores":
                object.threadsAsCores(reader.readBoolean());
                break;
                case "trusted_service":
                object.trustedService(reader.readBoolean());
                break;
                case "tunnel_migration":
                object.tunnelMigration(reader.readBoolean());
                break;
                case "version":
                object.version(XmlVersionReader.readOne(reader));
                break;
                case "virt_service":
                object.virtService(reader.readBoolean());
                break;
                case "vnc_encryption":
                object.vncEncryption(reader.readBoolean());
                break;
                case "link":
                // Process the attributes:
                String rel = reader.getAttributeValue("rel");
                String href = reader.getAttributeValue("href");
                if (rel != null && href != null) {
                    links.add(new String[]{rel, href});
                }
                reader.skip();
                break;
                default:
                reader.skip();
                break;
            }
        }
        if (links != null) {
            for (String[] link : links) {
                processLink(object, link);
            }
        }
        
        // Discard the end tag:
        reader.next();
        
        return object;
    }
    
    public static Iterator<Cluster> iterateMany(final XmlReader reader) {
        return new Iterator<Cluster>() {
            private boolean first = true;
            
            @Override
            public void remove() {
                // Empty on purpose
            }
            
            @Override
            public boolean hasNext() {
                if (first) {
                    if (!reader.forward()) {
                        return false;
                    }
                    reader.next();
                    first = false;
                }
                if (!reader.forward()) {
                    reader.next();
                    return false;
                }
                return true;
            }
            
            @Override
            public Cluster next() {
                Cluster next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Cluster> readMany(XmlReader reader) {
        List<Cluster> list = new ArrayList<>();
        Iterator<Cluster> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ClusterContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "affinitygroups":
                list = new ArrayListWithHref(object.affinityGroups());
                list.href(href);
                object.affinityGroups(list);
                break;
                case "cpuprofiles":
                list = new ArrayListWithHref(object.cpuProfiles());
                list.href(href);
                object.cpuProfiles(list);
                break;
                case "enabledfeatures":
                list = new ArrayListWithHref(object.enabledFeatures());
                list.href(href);
                object.enabledFeatures(list);
                break;
                case "externalnetworkproviders":
                list = new ArrayListWithHref(object.externalNetworkProviders());
                list.href(href);
                object.externalNetworkProviders(list);
                break;
                case "glusterhooks":
                list = new ArrayListWithHref(object.glusterHooks());
                list.href(href);
                object.glusterHooks(list);
                break;
                case "glustervolumes":
                list = new ArrayListWithHref(object.glusterVolumes());
                list.href(href);
                object.glusterVolumes(list);
                break;
                case "networkfilters":
                list = new ArrayListWithHref(object.networkFilters());
                list.href(href);
                object.networkFilters(list);
                break;
                case "networks":
                list = new ArrayListWithHref(object.networks());
                list.href(href);
                object.networks(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                default:
                break;
            }
        }
    }
}

