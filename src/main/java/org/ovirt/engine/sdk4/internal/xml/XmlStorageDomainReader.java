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
import org.ovirt.engine.sdk4.internal.containers.StorageDomainContainer;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class XmlStorageDomainReader {
    
    public static StorageDomain readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        StorageDomainContainer object = new StorageDomainContainer();
        
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
                case "available":
                object.available(reader.readInteger());
                break;
                case "backup":
                object.backup(reader.readBoolean());
                break;
                case "block_size":
                object.blockSize(reader.readInteger());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "committed":
                object.committed(reader.readInteger());
                break;
                case "critical_space_action_blocker":
                object.criticalSpaceActionBlocker(reader.readInteger());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "data_centers":
                object.dataCenters(XmlDataCenterReader.readMany(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "discard_after_delete":
                object.discardAfterDelete(reader.readBoolean());
                break;
                case "disk_profiles":
                object.diskProfiles(XmlDiskProfileReader.readMany(reader));
                break;
                case "disk_snapshots":
                object.diskSnapshots(XmlDiskSnapshotReader.readMany(reader));
                break;
                case "disks":
                object.disks(XmlDiskReader.readMany(reader));
                break;
                case "external_status":
                object.externalStatus(XmlExternalStatusReader.readOne(reader));
                break;
                case "files":
                object.files(XmlFileReader.readMany(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "images":
                object.images(XmlImageReader.readMany(reader));
                break;
                case "import":
                object.import_(reader.readBoolean());
                break;
                case "master":
                object.master(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "status":
                object.status(XmlStorageDomainStatusReader.readOne(reader));
                break;
                case "storage":
                object.storage(XmlHostStorageReader.readOne(reader));
                break;
                case "storage_connections":
                object.storageConnections(XmlStorageConnectionReader.readMany(reader));
                break;
                case "storage_format":
                object.storageFormat(XmlStorageFormatReader.readOne(reader));
                break;
                case "supports_discard":
                object.supportsDiscard(reader.readBoolean());
                break;
                case "supports_discard_zeroes_data":
                object.supportsDiscardZeroesData(reader.readBoolean());
                break;
                case "templates":
                object.templates(XmlTemplateReader.readMany(reader));
                break;
                case "type":
                object.type(XmlStorageDomainTypeReader.readOne(reader));
                break;
                case "used":
                object.used(reader.readInteger());
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
                break;
                case "warning_low_space_indicator":
                object.warningLowSpaceIndicator(reader.readInteger());
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
    
    public static Iterator<StorageDomain> iterateMany(final XmlReader reader) {
        return new Iterator<StorageDomain>() {
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
            public StorageDomain next() {
                StorageDomain next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<StorageDomain> readMany(XmlReader reader) {
        List<StorageDomain> list = new ArrayList<>();
        Iterator<StorageDomain> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(StorageDomainContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "datacenters":
                list = new ArrayListWithHref(object.dataCenters());
                list.href(href);
                object.dataCenters(list);
                break;
                case "diskprofiles":
                list = new ArrayListWithHref(object.diskProfiles());
                list.href(href);
                object.diskProfiles(list);
                break;
                case "disksnapshots":
                list = new ArrayListWithHref(object.diskSnapshots());
                list.href(href);
                object.diskSnapshots(list);
                break;
                case "disks":
                list = new ArrayListWithHref(object.disks());
                list.href(href);
                object.disks(list);
                break;
                case "files":
                list = new ArrayListWithHref(object.files());
                list.href(href);
                object.files(list);
                break;
                case "images":
                list = new ArrayListWithHref(object.images());
                list.href(href);
                object.images(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "storageconnections":
                list = new ArrayListWithHref(object.storageConnections());
                list.href(href);
                object.storageConnections(list);
                break;
                case "templates":
                list = new ArrayListWithHref(object.templates());
                list.href(href);
                object.templates(list);
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

