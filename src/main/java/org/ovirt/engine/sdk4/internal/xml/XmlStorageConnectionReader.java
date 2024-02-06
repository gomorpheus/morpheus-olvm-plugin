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
import org.ovirt.engine.sdk4.internal.containers.StorageConnectionContainer;
import org.ovirt.engine.sdk4.types.StorageConnection;

public class XmlStorageConnectionReader {
    
    public static StorageConnection readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        StorageConnectionContainer object = new StorageConnectionContainer();
        
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
                case "address":
                object.address(reader.readString());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "gluster_volume":
                object.glusterVolume(XmlGlusterVolumeReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "mount_options":
                object.mountOptions(reader.readString());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "nfs_retrans":
                object.nfsRetrans(reader.readInteger());
                break;
                case "nfs_timeo":
                object.nfsTimeo(reader.readInteger());
                break;
                case "nfs_version":
                object.nfsVersion(XmlNfsVersionReader.readOne(reader));
                break;
                case "password":
                object.password(reader.readString());
                break;
                case "path":
                object.path(reader.readString());
                break;
                case "port":
                object.port(reader.readInteger());
                break;
                case "portal":
                object.portal(reader.readString());
                break;
                case "target":
                object.target(reader.readString());
                break;
                case "type":
                object.type(XmlStorageTypeReader.readOne(reader));
                break;
                case "username":
                object.username(reader.readString());
                break;
                case "vfs_type":
                object.vfsType(reader.readString());
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
    
    public static Iterator<StorageConnection> iterateMany(final XmlReader reader) {
        return new Iterator<StorageConnection>() {
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
            public StorageConnection next() {
                StorageConnection next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<StorageConnection> readMany(XmlReader reader) {
        List<StorageConnection> list = new ArrayList<>();
        Iterator<StorageConnection> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(StorageConnectionContainer object, String[] link) {
    }
}

