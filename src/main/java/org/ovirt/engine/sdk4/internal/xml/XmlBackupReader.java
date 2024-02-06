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
import org.ovirt.engine.sdk4.internal.containers.BackupContainer;
import org.ovirt.engine.sdk4.types.Backup;

public class XmlBackupReader {
    
    public static Backup readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        BackupContainer object = new BackupContainer();
        
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
                case "comment":
                object.comment(reader.readString());
                break;
                case "creation_date":
                object.creationDate(reader.readDate());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disks":
                object.disks(XmlDiskReader.readMany(reader));
                break;
                case "from_checkpoint_id":
                object.fromCheckpointId(reader.readString());
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "modification_date":
                object.modificationDate(reader.readDate());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "phase":
                object.phase(XmlBackupPhaseReader.readOne(reader));
                break;
                case "to_checkpoint_id":
                object.toCheckpointId(reader.readString());
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
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
    
    public static Iterator<Backup> iterateMany(final XmlReader reader) {
        return new Iterator<Backup>() {
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
            public Backup next() {
                Backup next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Backup> readMany(XmlReader reader) {
        List<Backup> list = new ArrayList<>();
        Iterator<Backup> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(BackupContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "disks":
                list = new ArrayListWithHref(object.disks());
                list.href(href);
                object.disks(list);
                break;
                default:
                break;
            }
        }
    }
}

