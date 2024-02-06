/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Cluster;

public class XmlClusterWriter {
    
    public static void writeOne(Cluster object, XmlWriter writer) {
        writeOne(object, "cluster", writer);
    }
    
    public static void writeOne(Cluster object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.affinityGroupsPresent()) {
            XmlAffinityGroupWriter.writeMany(object.affinityGroups().iterator(), "affinity_group", "affinity_groups", writer);
        }
        if (object.ballooningEnabledPresent()) {
            writer.writeBoolean("ballooning_enabled", object.ballooningEnabled());
        }
        if (object.biosTypePresent()) {
            XmlBiosTypeWriter.writeOne(object.biosType(), "bios_type", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.cpuPresent()) {
            XmlCpuWriter.writeOne(object.cpu(), "cpu", writer);
        }
        if (object.cpuProfilesPresent()) {
            XmlCpuProfileWriter.writeMany(object.cpuProfiles().iterator(), "cpu_profile", "cpu_profiles", writer);
        }
        if (object.customSchedulingPolicyPropertiesPresent()) {
            XmlPropertyWriter.writeMany(object.customSchedulingPolicyProperties().iterator(), "property", "custom_scheduling_policy_properties", writer);
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.displayPresent()) {
            XmlDisplayWriter.writeOne(object.display(), "display", writer);
        }
        if (object.enabledFeaturesPresent()) {
            XmlClusterFeatureWriter.writeMany(object.enabledFeatures().iterator(), "cluster_feature", "enabled_features", writer);
        }
        if (object.errorHandlingPresent()) {
            XmlErrorHandlingWriter.writeOne(object.errorHandling(), "error_handling", writer);
        }
        if (object.externalNetworkProvidersPresent()) {
            XmlExternalProviderWriter.writeMany(object.externalNetworkProviders().iterator(), "external_provider", "external_network_providers", writer);
        }
        if (object.fencingPolicyPresent()) {
            XmlFencingPolicyWriter.writeOne(object.fencingPolicy(), "fencing_policy", writer);
        }
        if (object.fipsModePresent()) {
            XmlFipsModeWriter.writeOne(object.fipsMode(), "fips_mode", writer);
        }
        if (object.firewallTypePresent()) {
            XmlFirewallTypeWriter.writeOne(object.firewallType(), "firewall_type", writer);
        }
        if (object.glusterHooksPresent()) {
            XmlGlusterHookWriter.writeMany(object.glusterHooks().iterator(), "gluster_hook", "gluster_hooks", writer);
        }
        if (object.glusterServicePresent()) {
            writer.writeBoolean("gluster_service", object.glusterService());
        }
        if (object.glusterTunedProfilePresent()) {
            writer.writeElement("gluster_tuned_profile", object.glusterTunedProfile());
        }
        if (object.glusterVolumesPresent()) {
            XmlGlusterVolumeWriter.writeMany(object.glusterVolumes().iterator(), "gluster_volume", "gluster_volumes", writer);
        }
        if (object.haReservationPresent()) {
            writer.writeBoolean("ha_reservation", object.haReservation());
        }
        if (object.ksmPresent()) {
            XmlKsmWriter.writeOne(object.ksm(), "ksm", writer);
        }
        if (object.logMaxMemoryUsedThresholdPresent()) {
            writer.writeInteger("log_max_memory_used_threshold", object.logMaxMemoryUsedThreshold());
        }
        if (object.logMaxMemoryUsedThresholdTypePresent()) {
            XmlLogMaxMemoryUsedThresholdTypeWriter.writeOne(object.logMaxMemoryUsedThresholdType(), "log_max_memory_used_threshold_type", writer);
        }
        if (object.macPoolPresent()) {
            XmlMacPoolWriter.writeOne(object.macPool(), "mac_pool", writer);
        }
        if (object.maintenanceReasonRequiredPresent()) {
            writer.writeBoolean("maintenance_reason_required", object.maintenanceReasonRequired());
        }
        if (object.managementNetworkPresent()) {
            XmlNetworkWriter.writeOne(object.managementNetwork(), "management_network", writer);
        }
        if (object.memoryPolicyPresent()) {
            XmlMemoryPolicyWriter.writeOne(object.memoryPolicy(), "memory_policy", writer);
        }
        if (object.migrationPresent()) {
            XmlMigrationOptionsWriter.writeOne(object.migration(), "migration", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkFiltersPresent()) {
            XmlNetworkFilterWriter.writeMany(object.networkFilters().iterator(), "network_filter", "network_filters", writer);
        }
        if (object.networksPresent()) {
            XmlNetworkWriter.writeMany(object.networks().iterator(), "network", "networks", writer);
        }
        if (object.optionalReasonPresent()) {
            writer.writeBoolean("optional_reason", object.optionalReason());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.requiredRngSourcesPresent()) {
            XmlRngSourceWriter.writeMany(object.requiredRngSources().iterator(), "required_rng_source", "required_rng_sources", writer);
        }
        if (object.schedulingPolicyPresent()) {
            XmlSchedulingPolicyWriter.writeOne(object.schedulingPolicy(), "scheduling_policy", writer);
        }
        if (object.serialNumberPresent()) {
            XmlSerialNumberWriter.writeOne(object.serialNumber(), "serial_number", writer);
        }
        if (object.supportedVersionsPresent()) {
            XmlVersionWriter.writeMany(object.supportedVersions().iterator(), "version", "supported_versions", writer);
        }
        if (object.switchTypePresent()) {
            XmlSwitchTypeWriter.writeOne(object.switchType(), "switch_type", writer);
        }
        if (object.threadsAsCoresPresent()) {
            writer.writeBoolean("threads_as_cores", object.threadsAsCores());
        }
        if (object.trustedServicePresent()) {
            writer.writeBoolean("trusted_service", object.trustedService());
        }
        if (object.tunnelMigrationPresent()) {
            writer.writeBoolean("tunnel_migration", object.tunnelMigration());
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        if (object.virtServicePresent()) {
            writer.writeBoolean("virt_service", object.virtService());
        }
        if (object.vncEncryptionPresent()) {
            writer.writeBoolean("vnc_encryption", object.vncEncryption());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Cluster> list, XmlWriter writer) {
        writeMany(list, "cluster", "clusters", writer);
    }
    
    public static void writeMany(Iterator<Cluster> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlClusterWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

