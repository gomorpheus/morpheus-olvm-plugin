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
import org.ovirt.engine.sdk4.internal.containers.LogicalUnitContainer;
import org.ovirt.engine.sdk4.types.LogicalUnit;

public class XmlLogicalUnitReader {
    
    public static LogicalUnit readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        LogicalUnitContainer object = new LogicalUnitContainer();
        
        // Process the attributes:
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String image = reader.getAttributeValue(i);
            switch (name) {
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
                case "discard_max_size":
                object.discardMaxSize(reader.readInteger());
                break;
                case "discard_zeroes_data":
                object.discardZeroesData(reader.readBoolean());
                break;
                case "disk_id":
                object.diskId(reader.readString());
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
                object.status(XmlLunStatusReader.readOne(reader));
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
    
    public static Iterator<LogicalUnit> iterateMany(final XmlReader reader) {
        return new Iterator<LogicalUnit>() {
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
            public LogicalUnit next() {
                LogicalUnit next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<LogicalUnit> readMany(XmlReader reader) {
        List<LogicalUnit> list = new ArrayList<>();
        Iterator<LogicalUnit> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(LogicalUnitContainer object, String[] link) {
    }
}

