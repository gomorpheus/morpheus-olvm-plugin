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
import org.ovirt.engine.sdk4.internal.containers.GlusterVolumeContainer;
import org.ovirt.engine.sdk4.types.GlusterVolume;

public class XmlGlusterVolumeReader {
    
    public static GlusterVolume readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        GlusterVolumeContainer object = new GlusterVolumeContainer();
        
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
                case "bricks":
                object.bricks(XmlGlusterBrickReader.readMany(reader));
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disperse_count":
                object.disperseCount(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "options":
                object.options(XmlOptionReader.readMany(reader));
                break;
                case "redundancy_count":
                object.redundancyCount(reader.readInteger());
                break;
                case "replica_count":
                object.replicaCount(reader.readInteger());
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlGlusterVolumeStatusReader.readOne(reader));
                break;
                case "stripe_count":
                object.stripeCount(reader.readInteger());
                break;
                case "transport_types":
                object.transportTypes(XmlTransportTypeReader.readMany(reader));
                break;
                case "volume_type":
                object.volumeType(XmlGlusterVolumeTypeReader.readOne(reader));
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
    
    public static Iterator<GlusterVolume> iterateMany(final XmlReader reader) {
        return new Iterator<GlusterVolume>() {
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
            public GlusterVolume next() {
                GlusterVolume next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<GlusterVolume> readMany(XmlReader reader) {
        List<GlusterVolume> list = new ArrayList<>();
        Iterator<GlusterVolume> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(GlusterVolumeContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "bricks":
                list = new ArrayListWithHref(object.bricks());
                list.href(href);
                object.bricks(list);
                break;
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                default:
                break;
            }
        }
    }
}

