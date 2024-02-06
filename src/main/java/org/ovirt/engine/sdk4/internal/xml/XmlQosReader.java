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
import org.ovirt.engine.sdk4.internal.containers.QosContainer;
import org.ovirt.engine.sdk4.types.Qos;

public class XmlQosReader {
    
    public static Qos readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        QosContainer object = new QosContainer();
        
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
                case "cpu_limit":
                object.cpuLimit(reader.readInteger());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "inbound_average":
                object.inboundAverage(reader.readInteger());
                break;
                case "inbound_burst":
                object.inboundBurst(reader.readInteger());
                break;
                case "inbound_peak":
                object.inboundPeak(reader.readInteger());
                break;
                case "max_iops":
                object.maxIops(reader.readInteger());
                break;
                case "max_read_iops":
                object.maxReadIops(reader.readInteger());
                break;
                case "max_read_throughput":
                object.maxReadThroughput(reader.readInteger());
                break;
                case "max_throughput":
                object.maxThroughput(reader.readInteger());
                break;
                case "max_write_iops":
                object.maxWriteIops(reader.readInteger());
                break;
                case "max_write_throughput":
                object.maxWriteThroughput(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "outbound_average":
                object.outboundAverage(reader.readInteger());
                break;
                case "outbound_average_linkshare":
                object.outboundAverageLinkshare(reader.readInteger());
                break;
                case "outbound_average_realtime":
                object.outboundAverageRealtime(reader.readInteger());
                break;
                case "outbound_average_upperlimit":
                object.outboundAverageUpperlimit(reader.readInteger());
                break;
                case "outbound_burst":
                object.outboundBurst(reader.readInteger());
                break;
                case "outbound_peak":
                object.outboundPeak(reader.readInteger());
                break;
                case "type":
                object.type(XmlQosTypeReader.readOne(reader));
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
    
    public static Iterator<Qos> iterateMany(final XmlReader reader) {
        return new Iterator<Qos>() {
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
            public Qos next() {
                Qos next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Qos> readMany(XmlReader reader) {
        List<Qos> list = new ArrayList<>();
        Iterator<Qos> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(QosContainer object, String[] link) {
    }
}

