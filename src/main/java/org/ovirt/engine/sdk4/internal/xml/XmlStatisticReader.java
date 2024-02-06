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
import org.ovirt.engine.sdk4.internal.containers.StatisticContainer;
import org.ovirt.engine.sdk4.types.Statistic;

public class XmlStatisticReader {
    
    public static Statistic readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        StatisticContainer object = new StatisticContainer();
        
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
                case "brick":
                object.brick(XmlGlusterBrickReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disk":
                object.disk(XmlDiskReader.readOne(reader));
                break;
                case "gluster_volume":
                object.glusterVolume(XmlGlusterVolumeReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "host_nic":
                object.hostNic(XmlHostNicReader.readOne(reader));
                break;
                case "host_numa_node":
                object.hostNumaNode(XmlNumaNodeReader.readOne(reader));
                break;
                case "kind":
                object.kind(XmlStatisticKindReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "nic":
                object.nic(XmlNicReader.readOne(reader));
                break;
                case "step":
                object.step(XmlStepReader.readOne(reader));
                break;
                case "type":
                object.type(XmlValueTypeReader.readOne(reader));
                break;
                case "unit":
                object.unit(XmlStatisticUnitReader.readOne(reader));
                break;
                case "values":
                object.values(XmlValueReader.readMany(reader));
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
    
    public static Iterator<Statistic> iterateMany(final XmlReader reader) {
        return new Iterator<Statistic>() {
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
            public Statistic next() {
                Statistic next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Statistic> readMany(XmlReader reader) {
        List<Statistic> list = new ArrayList<>();
        Iterator<Statistic> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(StatisticContainer object, String[] link) {
    }
}

