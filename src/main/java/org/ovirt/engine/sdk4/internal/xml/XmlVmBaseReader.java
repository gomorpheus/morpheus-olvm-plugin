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
import org.ovirt.engine.sdk4.internal.containers.VmBaseContainer;
import org.ovirt.engine.sdk4.types.VmBase;

public class XmlVmBaseReader {
    
    public static VmBase readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        VmBaseContainer object = new VmBaseContainer();
        
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
                case "auto_pinning_policy":
                object.autoPinningPolicy(XmlAutoPinningPolicyReader.readOne(reader));
                break;
                case "bios":
                object.bios(XmlBiosReader.readOne(reader));
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
                case "display":
                object.display(XmlDisplayReader.readOne(reader));
                break;
                case "domain":
                object.domain(XmlDomainReader.readOne(reader));
                break;
                case "high_availability":
                object.highAvailability(XmlHighAvailabilityReader.readOne(reader));
                break;
                case "initialization":
                object.initialization(XmlInitializationReader.readOne(reader));
                break;
                case "io":
                object.io(XmlIoReader.readOne(reader));
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
                case "origin":
                object.origin(reader.readString());
                break;
                case "os":
                object.os(XmlOperatingSystemReader.readOne(reader));
                break;
                case "placement_policy":
                object.placementPolicy(XmlVmPlacementPolicyReader.readOne(reader));
                break;
                case "quota":
                object.quota(XmlQuotaReader.readOne(reader));
                break;
                case "rng_device":
                object.rngDevice(XmlRngDeviceReader.readOne(reader));
                break;
                case "serial_number":
                object.serialNumber(XmlSerialNumberReader.readOne(reader));
                break;
                case "small_icon":
                object.smallIcon(XmlIconReader.readOne(reader));
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
                case "stateless":
                object.stateless(reader.readBoolean());
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "storage_error_resume_behaviour":
                object.storageErrorResumeBehaviour(XmlVmStorageErrorResumeBehaviourReader.readOne(reader));
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
                case "virtio_scsi":
                object.virtioScsi(XmlVirtioScsiReader.readOne(reader));
                break;
                case "virtio_scsi_multi_queues":
                object.virtioScsiMultiQueues(reader.readInteger());
                break;
                case "virtio_scsi_multi_queues_enabled":
                object.virtioScsiMultiQueuesEnabled(reader.readBoolean());
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
    
    public static Iterator<VmBase> iterateMany(final XmlReader reader) {
        return new Iterator<VmBase>() {
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
            public VmBase next() {
                VmBase next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<VmBase> readMany(XmlReader reader) {
        List<VmBase> list = new ArrayList<>();
        Iterator<VmBase> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(VmBaseContainer object, String[] link) {
    }
}

