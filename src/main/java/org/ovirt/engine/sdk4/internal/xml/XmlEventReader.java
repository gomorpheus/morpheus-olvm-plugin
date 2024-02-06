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
import org.ovirt.engine.sdk4.internal.containers.EventContainer;
import org.ovirt.engine.sdk4.types.Event;

public class XmlEventReader {
    
    public static Event readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        EventContainer object = new EventContainer();
        
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
                case "code":
                object.code(reader.readInteger());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "correlation_id":
                object.correlationId(reader.readString());
                break;
                case "custom_data":
                object.customData(reader.readString());
                break;
                case "custom_id":
                object.customId(reader.readInteger());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "flood_rate":
                object.floodRate(reader.readInteger());
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "index":
                object.index(reader.readInteger());
                break;
                case "log_on_host":
                object.logOnHost(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "origin":
                object.origin(reader.readString());
                break;
                case "severity":
                object.severity(XmlLogSeverityReader.readOne(reader));
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "time":
                object.time(reader.readDate());
                break;
                case "user":
                object.user(XmlUserReader.readOne(reader));
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
    
    public static Iterator<Event> iterateMany(final XmlReader reader) {
        return new Iterator<Event>() {
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
            public Event next() {
                Event next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Event> readMany(XmlReader reader) {
        List<Event> list = new ArrayList<>();
        Iterator<Event> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(EventContainer object, String[] link) {
    }
}

