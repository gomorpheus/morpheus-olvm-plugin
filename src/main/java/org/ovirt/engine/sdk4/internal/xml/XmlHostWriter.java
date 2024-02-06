/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Host;

public class XmlHostWriter {
    
    public static void writeOne(Host object, XmlWriter writer) {
        writeOne(object, "host", writer);
    }
    
    public static void writeOne(Host object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.affinityLabelsPresent()) {
            XmlAffinityLabelWriter.writeMany(object.affinityLabels().iterator(), "affinity_label", "affinity_labels", writer);
        }
        if (object.agentsPresent()) {
            XmlAgentWriter.writeMany(object.agents().iterator(), "agent", "agents", writer);
        }
        if (object.autoNumaStatusPresent()) {
            XmlAutoNumaStatusWriter.writeOne(object.autoNumaStatus(), "auto_numa_status", writer);
        }
        if (object.certificatePresent()) {
            XmlCertificateWriter.writeOne(object.certificate(), "certificate", writer);
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.cpuPresent()) {
            XmlCpuWriter.writeOne(object.cpu(), "cpu", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.devicePassthroughPresent()) {
            XmlHostDevicePassthroughWriter.writeOne(object.devicePassthrough(), "device_passthrough", writer);
        }
        if (object.devicesPresent()) {
            XmlHostDeviceWriter.writeMany(object.devices().iterator(), "host_device", "devices", writer);
        }
        if (object.displayPresent()) {
            XmlDisplayWriter.writeOne(object.display(), "display", writer);
        }
        if (object.externalHostProviderPresent()) {
            XmlExternalHostProviderWriter.writeOne(object.externalHostProvider(), "external_host_provider", writer);
        }
        if (object.externalNetworkProviderConfigurationsPresent()) {
            XmlExternalNetworkProviderConfigurationWriter.writeMany(object.externalNetworkProviderConfigurations().iterator(), "external_network_provider_configuration", "external_network_provider_configurations", writer);
        }
        if (object.externalStatusPresent()) {
            XmlExternalStatusWriter.writeOne(object.externalStatus(), "external_status", writer);
        }
        if (object.hardwareInformationPresent()) {
            XmlHardwareInformationWriter.writeOne(object.hardwareInformation(), "hardware_information", writer);
        }
        if (object.hooksPresent()) {
            XmlHookWriter.writeMany(object.hooks().iterator(), "hook", "hooks", writer);
        }
        if (object.hostedEnginePresent()) {
            XmlHostedEngineWriter.writeOne(object.hostedEngine(), "hosted_engine", writer);
        }
        if (object.iscsiPresent()) {
            XmlIscsiDetailsWriter.writeOne(object.iscsi(), "iscsi", writer);
        }
        if (object.katelloErrataPresent()) {
            XmlKatelloErratumWriter.writeMany(object.katelloErrata().iterator(), "katello_erratum", "katello_errata", writer);
        }
        if (object.kdumpStatusPresent()) {
            XmlKdumpStatusWriter.writeOne(object.kdumpStatus(), "kdump_status", writer);
        }
        if (object.ksmPresent()) {
            XmlKsmWriter.writeOne(object.ksm(), "ksm", writer);
        }
        if (object.libvirtVersionPresent()) {
            XmlVersionWriter.writeOne(object.libvirtVersion(), "libvirt_version", writer);
        }
        if (object.maxSchedulingMemoryPresent()) {
            writer.writeInteger("max_scheduling_memory", object.maxSchedulingMemory());
        }
        if (object.memoryPresent()) {
            writer.writeInteger("memory", object.memory());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkAttachmentsPresent()) {
            XmlNetworkAttachmentWriter.writeMany(object.networkAttachments().iterator(), "network_attachment", "network_attachments", writer);
        }
        if (object.networkOperationInProgressPresent()) {
            writer.writeBoolean("network_operation_in_progress", object.networkOperationInProgress());
        }
        if (object.nicsPresent()) {
            XmlHostNicWriter.writeMany(object.nics().iterator(), "host_nic", "nics", writer);
        }
        if (object.numaNodesPresent()) {
            XmlNumaNodeWriter.writeMany(object.numaNodes().iterator(), "host_numa_node", "host_numa_nodes", writer);
        }
        if (object.numaSupportedPresent()) {
            writer.writeBoolean("numa_supported", object.numaSupported());
        }
        if (object.osPresent()) {
            XmlOperatingSystemWriter.writeOne(object.os(), "os", writer);
        }
        if (object.overrideIptablesPresent()) {
            writer.writeBoolean("override_iptables", object.overrideIptables());
        }
        if (object.ovnConfiguredPresent()) {
            writer.writeBoolean("ovn_configured", object.ovnConfigured());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.powerManagementPresent()) {
            XmlPowerManagementWriter.writeOne(object.powerManagement(), "power_management", writer);
        }
        if (object.protocolPresent()) {
            XmlHostProtocolWriter.writeOne(object.protocol(), "protocol", writer);
        }
        if (object.reinstallationRequiredPresent()) {
            writer.writeBoolean("reinstallation_required", object.reinstallationRequired());
        }
        if (object.rootPasswordPresent()) {
            writer.writeElement("root_password", object.rootPassword());
        }
        if (object.seLinuxPresent()) {
            XmlSeLinuxWriter.writeOne(object.seLinux(), "se_linux", writer);
        }
        if (object.spmPresent()) {
            XmlSpmWriter.writeOne(object.spm(), "spm", writer);
        }
        if (object.sshPresent()) {
            XmlSshWriter.writeOne(object.ssh(), "ssh", writer);
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlHostStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.statusDetailPresent()) {
            writer.writeElement("status_detail", object.statusDetail());
        }
        if (object.storageConnectionExtensionsPresent()) {
            XmlStorageConnectionExtensionWriter.writeMany(object.storageConnectionExtensions().iterator(), "storage_connection_extension", "storage_connection_extensions", writer);
        }
        if (object.storagesPresent()) {
            XmlHostStorageWriter.writeMany(object.storages().iterator(), "host_storage", "storages", writer);
        }
        if (object.summaryPresent()) {
            XmlVmSummaryWriter.writeOne(object.summary(), "summary", writer);
        }
        if (object.tagsPresent()) {
            XmlTagWriter.writeMany(object.tags().iterator(), "tag", "tags", writer);
        }
        if (object.transparentHugePagesPresent()) {
            XmlTransparentHugePagesWriter.writeOne(object.transparentHugePages(), "transparent_hugepages", writer);
        }
        if (object.typePresent()) {
            XmlHostTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.unmanagedNetworksPresent()) {
            XmlUnmanagedNetworkWriter.writeMany(object.unmanagedNetworks().iterator(), "unmanaged_network", "unmanaged_networks", writer);
        }
        if (object.updateAvailablePresent()) {
            writer.writeBoolean("update_available", object.updateAvailable());
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        if (object.vgpuPlacementPresent()) {
            XmlVgpuPlacementWriter.writeOne(object.vgpuPlacement(), "vgpu_placement", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Host> list, XmlWriter writer) {
        writeMany(list, "host", "hosts", writer);
    }
    
    public static void writeMany(Iterator<Host> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

