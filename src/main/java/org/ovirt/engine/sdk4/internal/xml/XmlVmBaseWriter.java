/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmBase;

public class XmlVmBaseWriter {
    
    public static void writeOne(VmBase object, XmlWriter writer) {
        writeOne(object, "vm_base", writer);
    }
    
    public static void writeOne(VmBase object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.autoPinningPolicyPresent()) {
            XmlAutoPinningPolicyWriter.writeOne(object.autoPinningPolicy(), "auto_pinning_policy", writer);
        }
        if (object.biosPresent()) {
            XmlBiosWriter.writeOne(object.bios(), "bios", writer);
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
        if (object.deleteProtectedPresent()) {
            writer.writeBoolean("delete_protected", object.deleteProtected());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.displayPresent()) {
            XmlDisplayWriter.writeOne(object.display(), "display", writer);
        }
        if (object.domainPresent()) {
            XmlDomainWriter.writeOne(object.domain(), "domain", writer);
        }
        if (object.highAvailabilityPresent()) {
            XmlHighAvailabilityWriter.writeOne(object.highAvailability(), "high_availability", writer);
        }
        if (object.initializationPresent()) {
            XmlInitializationWriter.writeOne(object.initialization(), "initialization", writer);
        }
        if (object.ioPresent()) {
            XmlIoWriter.writeOne(object.io(), "io", writer);
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
        if (object.originPresent()) {
            writer.writeElement("origin", object.origin());
        }
        if (object.osPresent()) {
            XmlOperatingSystemWriter.writeOne(object.os(), "os", writer);
        }
        if (object.placementPolicyPresent()) {
            XmlVmPlacementPolicyWriter.writeOne(object.placementPolicy(), "placement_policy", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.rngDevicePresent()) {
            XmlRngDeviceWriter.writeOne(object.rngDevice(), "rng_device", writer);
        }
        if (object.serialNumberPresent()) {
            XmlSerialNumberWriter.writeOne(object.serialNumber(), "serial_number", writer);
        }
        if (object.smallIconPresent()) {
            XmlIconWriter.writeOne(object.smallIcon(), "small_icon", writer);
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
        if (object.statelessPresent()) {
            writer.writeBoolean("stateless", object.stateless());
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.storageErrorResumeBehaviourPresent()) {
            XmlVmStorageErrorResumeBehaviourWriter.writeOne(object.storageErrorResumeBehaviour(), "storage_error_resume_behaviour", writer);
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
        if (object.virtioScsiPresent()) {
            XmlVirtioScsiWriter.writeOne(object.virtioScsi(), "virtio_scsi", writer);
        }
        if (object.virtioScsiMultiQueuesPresent()) {
            writer.writeInteger("virtio_scsi_multi_queues", object.virtioScsiMultiQueues());
        }
        if (object.virtioScsiMultiQueuesEnabledPresent()) {
            writer.writeBoolean("virtio_scsi_multi_queues_enabled", object.virtioScsiMultiQueuesEnabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VmBase> list, XmlWriter writer) {
        writeMany(list, "vm_base", "vm_bases", writer);
    }
    
    public static void writeMany(Iterator<VmBase> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmBaseWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

