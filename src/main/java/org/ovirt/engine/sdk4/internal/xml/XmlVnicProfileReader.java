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
import org.ovirt.engine.sdk4.internal.containers.VnicProfileContainer;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class XmlVnicProfileReader {
    
    public static VnicProfile readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        VnicProfileContainer object = new VnicProfileContainer();
        
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
                case "custom_properties":
                object.customProperties(XmlCustomPropertyReader.readMany(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "failover":
                object.failover(XmlVnicProfileReader.readOne(reader));
                break;
                case "migratable":
                object.migratable(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network":
                object.network(XmlNetworkReader.readOne(reader));
                break;
                case "network_filter":
                object.networkFilter(XmlNetworkFilterReader.readOne(reader));
                break;
                case "pass_through":
                object.passThrough(XmlVnicPassThroughReader.readOne(reader));
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "port_mirroring":
                object.portMirroring(reader.readBoolean());
                break;
                case "qos":
                object.qos(XmlQosReader.readOne(reader));
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
    
    public static Iterator<VnicProfile> iterateMany(final XmlReader reader) {
        return new Iterator<VnicProfile>() {
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
            public VnicProfile next() {
                VnicProfile next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<VnicProfile> readMany(XmlReader reader) {
        List<VnicProfile> list = new ArrayList<>();
        Iterator<VnicProfile> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(VnicProfileContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                default:
                break;
            }
        }
    }
}

