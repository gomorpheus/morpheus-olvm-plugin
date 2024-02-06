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
import org.ovirt.engine.sdk4.internal.containers.VmContainer;
import org.ovirt.engine.sdk4.types.Vm;

public class XmlVmReader {
    
    public static Vm readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        VmContainer object = new VmContainer();
        
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
                case "affinity_labels":
                object.affinityLabels(XmlAffinityLabelReader.readMany(reader));
                break;
                case "applications":
                object.applications(XmlApplicationReader.readMany(reader));
                break;
                case "auto_pinning_policy":
                object.autoPinningPolicy(XmlAutoPinningPolicyReader.readOne(reader));
                break;
                case "bios":
                object.bios(XmlBiosReader.readOne(reader));
                break;
                case "cdroms":
                object.cdroms(XmlCdromReader.readMany(reader));
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "console":
                object.console(XmlConsoleReader.readOne(reader));
                break;
                case "cpu":
                object.cpu(XmlCpuReader.readOne(reader));
                break;
                case "cpu_profile":
                object.cpuProfile(XmlCpuProfileReader.readOne(reader));
                break;
                case "cpu_shares":
                object.cpuShares(reader.readInteger());
                break;
                case "creation_time":
                object.creationTime(reader.readDate());
                break;
                case "custom_compatibility_version":
                object.customCompatibilityVersion(XmlVersionReader.readOne(reader));
                break;
                case "custom_cpu_model":
                object.customCpuModel(reader.readString());
                break;
                case "custom_emulated_machine":
                object.customEmulatedMachine(reader.readString());
                break;
                case "custom_properties":
                object.customProperties(XmlCustomPropertyReader.readMany(reader));
                break;
                case "delete_protected":
                object.deleteProtected(reader.readBoolean());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disk_attachments":
                object.diskAttachments(XmlDiskAttachmentReader.readMany(reader));
                break;
                case "display":
                object.display(XmlDisplayReader.readOne(reader));
                break;
                case "domain":
                object.domain(XmlDomainReader.readOne(reader));
                break;
                case "external_host_provider":
                object.externalHostProvider(XmlExternalHostProviderReader.readOne(reader));
                break;
                case "floppies":
                object.floppies(XmlFloppyReader.readMany(reader));
                break;
                case "fqdn":
                object.fqdn(reader.readString());
                break;
                case "graphics_consoles":
                object.graphicsConsoles(XmlGraphicsConsoleReader.readMany(reader));
                break;
                case "guest_operating_system":
                object.guestOperatingSystem(XmlGuestOperatingSystemReader.readOne(reader));
                break;
                case "guest_time_zone":
                object.guestTimeZone(XmlTimeZoneReader.readOne(reader));
                break;
                case "has_illegal_images":
                object.hasIllegalImages(reader.readBoolean());
                break;
                case "high_availability":
                object.highAvailability(XmlHighAvailabilityReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "host_devices":
                object.hostDevices(XmlHostDeviceReader.readMany(reader));
                break;
                case "initialization":
                object.initialization(XmlInitializationReader.readOne(reader));
                break;
                case "instance_type":
                object.instanceType(XmlInstanceTypeReader.readOne(reader));
                break;
                case "io":
                object.io(XmlIoReader.readOne(reader));
                break;
                case "katello_errata":
                object.katelloErrata(XmlKatelloErratumReader.readMany(reader));
                break;
                case "large_icon":
                object.largeIcon(XmlIconReader.readOne(reader));
                break;
                case "lease":
                object.lease(XmlStorageDomainLeaseReader.readOne(reader));
                break;
                case "memory":
                object.memory(reader.readInteger());
                break;
                case "memory_policy":
                object.memoryPolicy(XmlMemoryPolicyReader.readOne(reader));
                break;
                case "migration":
                object.migration(XmlMigrationOptionsReader.readOne(reader));
                break;
                case "migration_downtime":
                object.migrationDowntime(reader.readInteger());
                break;
                case "multi_queues_enabled":
                object.multiQueuesEnabled(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "next_run_configuration_exists":
                object.nextRunConfigurationExists(reader.readBoolean());
                break;
                case "nics":
                object.nics(XmlNicReader.readMany(reader));
                break;
                case "host_numa_nodes":
                object.numaNodes(XmlNumaNodeReader.readMany(reader));
                break;
                case "numa_tune_mode":
                object.numaTuneMode(XmlNumaTuneModeReader.readOne(reader));
                break;
                case "origin":
                object.origin(reader.readString());
                break;
                case "original_template":
                object.originalTemplate(XmlTemplateReader.readOne(reader));
                break;
                case "os":
                object.os(XmlOperatingSystemReader.readOne(reader));
                break;
                case "payloads":
                object.payloads(XmlPayloadReader.readMany(reader));
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "placement_policy":
                object.placementPolicy(XmlVmPlacementPolicyReader.readOne(reader));
                break;
                case "quota":
                object.quota(XmlQuotaReader.readOne(reader));
                break;
                case "reported_devices":
                object.reportedDevices(XmlReportedDeviceReader.readMany(reader));
                break;
                case "rng_device":
                object.rngDevice(XmlRngDeviceReader.readOne(reader));
                break;
                case "run_once":
                object.runOnce(reader.readBoolean());
                break;
                case "serial_number":
                object.serialNumber(XmlSerialNumberReader.readOne(reader));
                break;
                case "sessions":
                object.sessions(XmlSessionReader.readMany(reader));
                break;
                case "small_icon":
                object.smallIcon(XmlIconReader.readOne(reader));
                break;
                case "snapshots":
                object.snapshots(XmlSnapshotReader.readMany(reader));
                break;
                case "soundcard_enabled":
                object.soundcardEnabled(reader.readBoolean());
                break;
                case "sso":
                object.sso(XmlSsoReader.readOne(reader));
                break;
                case "start_paused":
                object.startPaused(reader.readBoolean());
                break;
                case "start_time":
                object.startTime(reader.readDate());
                break;
                case "stateless":
                object.stateless(reader.readBoolean());
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlVmStatusReader.readOne(reader));
                break;
                case "status_detail":
                object.statusDetail(reader.readString());
                break;
                case "stop_reason":
                object.stopReason(reader.readString());
                break;
                case "stop_time":
                object.stopTime(reader.readDate());
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "storage_error_resume_behaviour":
                object.storageErrorResumeBehaviour(XmlVmStorageErrorResumeBehaviourReader.readOne(reader));
                break;
                case "tags":
                object.tags(XmlTagReader.readMany(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "time_zone":
                object.timeZone(XmlTimeZoneReader.readOne(reader));
                break;
                case "tpm_enabled":
                object.tpmEnabled(reader.readBoolean());
                break;
                case "tunnel_migration":
                object.tunnelMigration(reader.readBoolean());
                break;
                case "type":
                object.type(XmlVmTypeReader.readOne(reader));
                break;
                case "usb":
                object.usb(XmlUsbReader.readOne(reader));
                break;
                case "use_latest_template_version":
                object.useLatestTemplateVersion(reader.readBoolean());
                break;
                case "virtio_scsi":
                object.virtioScsi(XmlVirtioScsiReader.readOne(reader));
                break;
                case "virtio_scsi_multi_queues":
                object.virtioScsiMultiQueues(reader.readInteger());
                break;
                case "virtio_scsi_multi_queues_enabled":
                object.virtioScsiMultiQueuesEnabled(reader.readBoolean());
                break;
                case "vm_pool":
                object.vmPool(XmlVmPoolReader.readOne(reader));
                break;
                case "watchdogs":
                object.watchdogs(XmlWatchdogReader.readMany(reader));
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
    
    public static Iterator<Vm> iterateMany(final XmlReader reader) {
        return new Iterator<Vm>() {
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
            public Vm next() {
                Vm next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Vm> readMany(XmlReader reader) {
        List<Vm> list = new ArrayList<>();
        Iterator<Vm> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(VmContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "affinitylabels":
                list = new ArrayListWithHref(object.affinityLabels());
                list.href(href);
                object.affinityLabels(list);
                break;
                case "applications":
                list = new ArrayListWithHref(object.applications());
                list.href(href);
                object.applications(list);
                break;
                case "cdroms":
                list = new ArrayListWithHref(object.cdroms());
                list.href(href);
                object.cdroms(list);
                break;
                case "diskattachments":
                list = new ArrayListWithHref(object.diskAttachments());
                list.href(href);
                object.diskAttachments(list);
                break;
                case "floppies":
                list = new ArrayListWithHref(object.floppies());
                list.href(href);
                object.floppies(list);
                break;
                case "graphicsconsoles":
                list = new ArrayListWithHref(object.graphicsConsoles());
                list.href(href);
                object.graphicsConsoles(list);
                break;
                case "hostdevices":
                list = new ArrayListWithHref(object.hostDevices());
                list.href(href);
                object.hostDevices(list);
                break;
                case "katelloerrata":
                list = new ArrayListWithHref(object.katelloErrata());
                list.href(href);
                object.katelloErrata(list);
                break;
                case "nics":
                list = new ArrayListWithHref(object.nics());
                list.href(href);
                object.nics(list);
                break;
                case "numanodes":
                list = new ArrayListWithHref(object.numaNodes());
                list.href(href);
                object.numaNodes(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "reporteddevices":
                list = new ArrayListWithHref(object.reportedDevices());
                list.href(href);
                object.reportedDevices(list);
                break;
                case "sessions":
                list = new ArrayListWithHref(object.sessions());
                list.href(href);
                object.sessions(list);
                break;
                case "snapshots":
                list = new ArrayListWithHref(object.snapshots());
                list.href(href);
                object.snapshots(list);
                break;
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                case "tags":
                list = new ArrayListWithHref(object.tags());
                list.href(href);
                object.tags(list);
                break;
                case "watchdogs":
                list = new ArrayListWithHref(object.watchdogs());
                list.href(href);
                object.watchdogs(list);
                break;
                default:
                break;
            }
        }
    }
}

