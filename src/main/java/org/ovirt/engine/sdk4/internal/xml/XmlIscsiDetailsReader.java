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
import org.ovirt.engine.sdk4.internal.containers.IscsiDetailsContainer;
import org.ovirt.engine.sdk4.types.IscsiDetails;

public class XmlIscsiDetailsReader {
    
    public static IscsiDetails readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        IscsiDetailsContainer object = new IscsiDetailsContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "address":
                object.address(reader.readString());
                break;
                case "disk_id":
                object.diskId(reader.readString());
                break;
                case "initiator":
                object.initiator(reader.readString());
                break;
                case "lun_mapping":
                object.lunMapping(reader.readInteger());
                break;
                case "password":
                object.password(reader.readString());
                break;
                case "paths":
                object.paths(reader.readInteger());
                break;
                case "port":
                object.port(reader.readInteger());
                break;
                case "portal":
                object.portal(reader.readString());
                break;
                case "product_id":
                object.productId(reader.readString());
                break;
                case "serial":
                object.serial(reader.readString());
                break;
                case "size":
                object.size(reader.readInteger());
                break;
                case "status":
                object.status(reader.readString());
                break;
                case "storage_domain_id":
                object.storageDomainId(reader.readString());
                break;
                case "target":
                object.target(reader.readString());
                break;
                case "username":
                object.username(reader.readString());
                break;
                case "vendor_id":
                object.vendorId(reader.readString());
                break;
                case "volume_group_id":
                object.volumeGroupId(reader.readString());
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
    
    public static Iterator<IscsiDetails> iterateMany(final XmlReader reader) {
        return new Iterator<IscsiDetails>() {
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
            public IscsiDetails next() {
                IscsiDetails next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<IscsiDetails> readMany(XmlReader reader) {
        List<IscsiDetails> list = new ArrayList<>();
        Iterator<IscsiDetails> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(IscsiDetailsContainer object, String[] link) {
    }
}

