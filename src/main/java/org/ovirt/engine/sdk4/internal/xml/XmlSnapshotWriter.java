/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Snapshot;

public class XmlSnapshotWriter {
    
    public static void writeOne(Snapshot object, XmlWriter writer) {
        writeOne(object, "snapshot", writer);
    }
    
    public static void writeOne(Snapshot object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.affinityLabelsPresent()) {
            XmlAffinityLabelWriter.writeMany(object.affinityLabels().iterator(), "affinity_label", "affinity_labels", writer);
        }
        if (object.applicationsPresent()) {
            XmlApplicationWriter.writeMany(object.applications().iterator(), "application", "applications", writer);
        }
        if (object.autoPinningPolicyPresent()) {
            XmlAutoPinningPolicyWriter.writeOne(object.autoPinningPolicy(), "auto_pinning_policy", writer);
        }
        if (object.biosPresent()) {
            XmlBiosWriter.writeOne(object.bios(), "bios", writer);
        }
        if (object.cdromsPresent()) {
            XmlCdromWriter.writeMany(object.cdroms().iterator(), "cdrom", "cdroms", writer);
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.consolePresent()) {
            XmlConsoleWriter.writeOne(object.console(), "console", writer);
        }
        if (object.cpuPresent()) {
            XmlCpuWriter.writeOne(object.cpu(), "cpu", writer);
        }
        if (object.cpuProfilePresent()) {
            XmlCpuProfileWriter.writeOne(object.cpuProfile(), "cpu_profile", writer);
        }
        if (object.cpuSharesPresent()) {
            writer.writeInteger("cpu_shares", object.cpuShares());
        }
        if (object.creationTimePresent()) {
            writer.writeDate("creation_time", object.creationTime());
        }
        if (object.customCompatibilityVersionPresent()) {
            XmlVersionWriter.writeOne(object.customCompatibilityVersion(), "custom_compatibility_version", writer);
        }
        if (object.customCpuModelPresent()) {
            writer.writeElement("custom_cpu_model", object.customCpuModel());
        }
        if (object.customEmulatedMachinePresent()) {
            writer.writeElement("custom_emulated_machine", object.customEmulatedMachine());
        }
        if (object.customPropertiesPresent()) {
            XmlCustomPropertyWriter.writeMany(object.customProperties().iterator(), "custom_property", "custom_properties", writer);
        }
        if (object.datePresent()) {
            writer.writeDate("date", object.date());
        }
        if (object.deleteProtectedPresent()) {
            writer.writeBoolean("delete_protected", object.deleteProtected());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.diskAttachmentsPresent()) {
            XmlDiskAttachmentWriter.writeMany(object.diskAttachments().iterator(), "disk_attachment", "disk_attachments", writer);
        }
        if (object.disksPresent()) {
            XmlDiskWriter.writeMany(object.disks().iterator(), "disk", "disks", writer);
        }
        if (object.displayPresent()) {
            XmlDisplayWriter.writeOne(object.display(), "display", writer);
        }
        if (object.domainPresent()) {
            XmlDomainWriter.writeOne(object.domain(), "domain", writer);
        }
        if (object.externalHostProviderPresent()) {
            XmlExternalHostProviderWriter.writeOne(object.externalHostProvider(), "external_host_provider", writer);
        }
        if (object.floppiesPresent()) {
            XmlFloppyWriter.writeMany(object.floppies().iterator(), "floppy", "floppies", writer);
        }
        if (object.fqdnPresent()) {
            writer.writeElement("fqdn", object.fqdn());
        }
        if (object.graphicsConsolesPresent()) {
            XmlGraphicsConsoleWriter.writeMany(object.graphicsConsoles().iterator(), "graphics_console", "graphics_consoles", writer);
        }
        if (object.guestOperatingSystemPresent()) {
            XmlGuestOperatingSystemWriter.writeOne(object.guestOperatingSystem(), "guest_operating_system", writer);
        }
        if (object.guestTimeZonePresent()) {
            XmlTimeZoneWriter.writeOne(object.guestTimeZone(), "guest_time_zone", writer);
        }
        if (object.hasIllegalImagesPresent()) {
            writer.writeBoolean("has_illegal_images", object.hasIllegalImages());
        }
        if (object.highAvailabilityPresent()) {
            XmlHighAvailabilityWriter.writeOne(object.highAvailability(), "high_availability", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.hostDevicesPresent()) {
            XmlHostDeviceWriter.writeMany(object.hostDevices().iterator(), "host_device", "host_devices", writer);
        }
        if (object.initializationPresent()) {
            XmlInitializationWriter.writeOne(object.initialization(), "initialization", writer);
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.ioPresent()) {
            XmlIoWriter.writeOne(object.io(), "io", writer);
        }
        if (object.katelloErrataPresent()) {
            XmlKatelloErratumWriter.writeMany(object.katelloErrata().iterator(), "katello_erratum", "katello_errata", writer);
        }
        if (object.largeIconPresent()) {
            XmlIconWriter.writeOne(object.largeIcon(), "large_icon", writer);
        }
        if (object.leasePresent()) {
            XmlStorageDomainLeaseWriter.writeOne(object.lease(), "lease", writer);
        }
        if (object.memoryPresent()) {
            writer.writeInteger("memory", object.memory());
        }
        if (object.memoryPolicyPresent()) {
            XmlMemoryPolicyWriter.writeOne(object.memoryPolicy(), "memory_policy", writer);
        }
        if (object.migrationPresent()) {
            XmlMigrationOptionsWriter.writeOne(object.migration(), "migration", writer);
        }
        if (object.migrationDowntimePresent()) {
            writer.writeInteger("migration_downtime", object.migrationDowntime());
        }
        if (object.multiQueuesEnabledPresent()) {
            writer.writeBoolean("multi_queues_enabled", object.multiQueuesEnabled());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.nextRunConfigurationExistsPresent()) {
            writer.writeBoolean("next_run_configuration_exists", object.nextRunConfigurationExists());
        }
        if (object.nicsPresent()) {
            XmlNicWriter.writeMany(object.nics().iterator(), "nic", "nics", writer);
        }
        if (object.numaNodesPresent()) {
            XmlNumaNodeWriter.writeMany(object.numaNodes().iterator(), "host_numa_node", "host_numa_nodes", writer);
        }
        if (object.numaTuneModePresent()) {
            XmlNumaTuneModeWriter.writeOne(object.numaTuneMode(), "numa_tune_mode", writer);
        }
        if (object.originPresent()) {
            writer.writeElement("origin", object.origin());
        }
        if (object.originalTemplatePresent()) {
            XmlTemplateWriter.writeOne(object.originalTemplate(), "original_template", writer);
        }
        if (object.osPresent()) {
            XmlOperatingSystemWriter.writeOne(object.os(), "os", writer);
        }
        if (object.payloadsPresent()) {
            XmlPayloadWriter.writeMany(object.payloads().iterator(), "payload", "payloads", writer);
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.persistMemorystatePresent()) {
            writer.writeBoolean("persist_memorystate", object.persistMemorystate());
        }
        if (object.placementPolicyPresent()) {
            XmlVmPlacementPolicyWriter.writeOne(object.placementPolicy(), "placement_policy", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.reportedDevicesPresent()) {
            XmlReportedDeviceWriter.writeMany(object.reportedDevices().iterator(), "reported_device", "reported_devices", writer);
        }
        if (object.rngDevicePresent()) {
            XmlRngDeviceWriter.writeOne(object.rngDevice(), "rng_device", writer);
        }
        if (object.runOncePresent()) {
            writer.writeBoolean("run_once", object.runOnce());
        }
        if (object.serialNumberPresent()) {
            XmlSerialNumberWriter.writeOne(object.serialNumber(), "serial_number", writer);
        }
        if (object.sessionsPresent()) {
            XmlSessionWriter.writeMany(object.sessions().iterator(), "session", "sessions", writer);
        }
        if (object.smallIconPresent()) {
            XmlIconWriter.writeOne(object.smallIcon(), "small_icon", writer);
        }
        if (object.snapshotStatusPresent()) {
            XmlSnapshotStatusWriter.writeOne(object.snapshotStatus(), "snapshot_status", writer);
        }
        if (object.snapshotTypePresent()) {
            XmlSnapshotTypeWriter.writeOne(object.snapshotType(), "snapshot_type", writer);
        }
        if (object.snapshotsPresent()) {
            XmlSnapshotWriter.writeMany(object.snapshots().iterator(), "snapshot", "snapshots", writer);
        }
        if (object.soundcardEnabledPresent()) {
            writer.writeBoolean("soundcard_enabled", object.soundcardEnabled());
        }
        if (object.ssoPresent()) {
            XmlSsoWriter.writeOne(object.sso(), "sso", writer);
        }
        if (object.startPausedPresent()) {
            writer.writeBoolean("start_paused", object.startPaused());
        }
        if (object.startTimePresent()) {
            writer.writeDate("start_time", object.startTime());
        }
        if (object.statelessPresent()) {
            writer.writeBoolean("stateless", object.stateless());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlVmStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.statusDetailPresent()) {
            writer.writeElement("status_detail", object.statusDetail());
        }
        if (object.stopReasonPresent()) {
            writer.writeElement("stop_reason", object.stopReason());
        }
        if (object.stopTimePresent()) {
            writer.writeDate("stop_time", object.stopTime());
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.storageErrorResumeBehaviourPresent()) {
            XmlVmStorageErrorResumeBehaviourWriter.writeOne(object.storageErrorResumeBehaviour(), "storage_error_resume_behaviour", writer);
        }
        if (object.tagsPresent()) {
            XmlTagWriter.writeMany(object.tags().iterator(), "tag", "tags", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.timeZonePresent()) {
            XmlTimeZoneWriter.writeOne(object.timeZone(), "time_zone", writer);
        }
        if (object.tpmEnabledPresent()) {
            writer.writeBoolean("tpm_enabled", object.tpmEnabled());
        }
        if (object.tunnelMigrationPresent()) {
            writer.writeBoolean("tunnel_migration", object.tunnelMigration());
        }
        if (object.typePresent()) {
            XmlVmTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.usbPresent()) {
            XmlUsbWriter.writeOne(object.usb(), "usb", writer);
        }
        if (object.useLatestTemplateVersionPresent()) {
            writer.writeBoolean("use_latest_template_version", object.useLatestTemplateVersion());
        }
        if (object.virtioScsiPresent()) {
            XmlVirtioScsiWriter.writeOne(object.virtioScsi(), "virtio_scsi", writer);
        }
        if (object.virtioScsiMultiQueuesPresent()) {
            writer.writeInteger("virtio_scsi_multi_queues", object.virtioScsiMultiQueues());
        }
        if (object.virtioScsiMultiQueuesEnabledPresent()) {
            writer.writeBoolean("virtio_scsi_multi_queues_enabled", object.virtioScsiMultiQueuesEnabled());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmPoolPresent()) {
            XmlVmPoolWriter.writeOne(object.vmPool(), "vm_pool", writer);
        }
        if (object.watchdogsPresent()) {
            XmlWatchdogWriter.writeMany(object.watchdogs().iterator(), "watchdog", "watchdogs", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Snapshot> list, XmlWriter writer) {
        writeMany(list, "snapshot", "snapshots", writer);
    }
    
    public static void writeMany(Iterator<Snapshot> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSnapshotWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

