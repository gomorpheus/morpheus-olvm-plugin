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
import org.ovirt.engine.sdk4.internal.containers.DiskSnapshotContainer;
import org.ovirt.engine.sdk4.types.DiskSnapshot;

public class XmlDiskSnapshotReader {
    
    public static DiskSnapshot readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        DiskSnapshotContainer object = new DiskSnapshotContainer();
        
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
                case "active":
                object.active(reader.readBoolean());
                break;
                case "actual_size":
                object.actualSize(reader.readInteger());
                break;
                case "alias":
                object.alias(reader.readString());
                break;
                case "backup":
                object.backup(XmlDiskBackupReader.readOne(reader));
                break;
                case "backup_mode":
                object.backupMode(XmlDiskBackupModeReader.readOne(reader));
                break;
                case "bootable":
                object.bootable(reader.readBoolean());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "content_type":
                object.contentType(XmlDiskContentTypeReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disk":
                object.disk(XmlDiskReader.readOne(reader));
                break;
                case "disk_profile":
                object.diskProfile(XmlDiskProfileReader.readOne(reader));
                break;
                case "disk_snapshots":
                object.diskSnapshots(XmlDiskSnapshotReader.readMany(reader));
                break;
                case "external_disk":
                object.externalDisk(reader.readString());
                break;
                case "format":
                object.format(XmlDiskFormatReader.readOne(reader));
                break;
                case "image_id":
                object.imageId(reader.readString());
                break;
                case "initial_size":
                object.initialSize(reader.readInteger());
                break;
                case "instance_type":
                object.instanceType(XmlInstanceTypeReader.readOne(reader));
                break;
                case "interface":
                object.interface_(XmlDiskInterfaceReader.readOne(reader));
                break;
                case "logical_name":
                object.logicalName(reader.readString());
                break;
                case "lun_storage":
                object.lunStorage(XmlHostStorageReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "openstack_volume_type":
                object.openstackVolumeType(XmlOpenStackVolumeTypeReader.readOne(reader));
                break;
                case "parent":
                object.parent(XmlDiskSnapshotReader.readOne(reader));
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "propagate_errors":
                object.propagateErrors(reader.readBoolean());
                break;
                case "provisioned_size":
                object.provisionedSize(reader.readInteger());
                break;
                case "qcow_version":
                object.qcowVersion(XmlQcowVersionReader.readOne(reader));
                break;
                case "quota":
                object.quota(XmlQuotaReader.readOne(reader));
                break;
                case "read_only":
                object.readOnly(reader.readBoolean());
                break;
                case "sgio":
                object.sgio(XmlScsiGenericIOReader.readOne(reader));
                break;
                case "shareable":
                object.shareable(reader.readBoolean());
                break;
                case "snapshot":
                object.snapshot(XmlSnapshotReader.readOne(reader));
                break;
                case "sparse":
                object.sparse(reader.readBoolean());
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlDiskStatusReader.readOne(reader));
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "storage_domains":
                object.storageDomains(XmlStorageDomainReader.readMany(reader));
                break;
                case "storage_type":
                object.storageType(XmlDiskStorageTypeReader.readOne(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "total_size":
                object.totalSize(reader.readInteger());
                break;
                case "uses_scsi_reservation":
                object.usesScsiReservation(reader.readBoolean());
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
                break;
                case "wipe_after_delete":
                object.wipeAfterDelete(reader.readBoolean());
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
    
    public static Iterator<DiskSnapshot> iterateMany(final XmlReader reader) {
        return new Iterator<DiskSnapshot>() {
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
            public DiskSnapshot next() {
                DiskSnapshot next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<DiskSnapshot> readMany(XmlReader reader) {
        List<DiskSnapshot> list = new ArrayList<>();
        Iterator<DiskSnapshot> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(DiskSnapshotContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "disksnapshots":
                list = new ArrayListWithHref(object.diskSnapshots());
                list.href(href);
                object.diskSnapshots(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                case "storagedomains":
                list = new ArrayListWithHref(object.storageDomains());
                list.href(href);
                object.storageDomains(list);
                break;
                case "vms":
                list = new ArrayListWithHref(object.vms());
                list.href(href);
                object.vms(list);
                break;
                default:
                break;
            }
        }
    }
}

