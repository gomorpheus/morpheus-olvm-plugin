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
import org.ovirt.engine.sdk4.internal.containers.PermissionContainer;
import org.ovirt.engine.sdk4.types.Permission;

public class XmlPermissionReader {
    
    public static Permission readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        PermissionContainer object = new PermissionContainer();
        
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
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disk":
                object.disk(XmlDiskReader.readOne(reader));
                break;
                case "group":
                object.group(XmlGroupReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "role":
                object.role(XmlRoleReader.readOne(reader));
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "user":
                object.user(XmlUserReader.readOne(reader));
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
                break;
                case "vm_pool":
                object.vmPool(XmlVmPoolReader.readOne(reader));
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
    
    public static Iterator<Permission> iterateMany(final XmlReader reader) {
        return new Iterator<Permission>() {
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
            public Permission next() {
                Permission next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Permission> readMany(XmlReader reader) {
        List<Permission> list = new ArrayList<>();
        Iterator<Permission> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(PermissionContainer object, String[] link) {
    }
}

