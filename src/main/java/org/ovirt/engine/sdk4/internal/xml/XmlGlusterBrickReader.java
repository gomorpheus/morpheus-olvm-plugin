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
import org.ovirt.engine.sdk4.internal.containers.GlusterBrickContainer;
import org.ovirt.engine.sdk4.types.GlusterBrick;

public class XmlGlusterBrickReader {
    
    public static GlusterBrick readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        GlusterBrickContainer object = new GlusterBrickContainer();
        
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
                case "brick_dir":
                object.brickDir(reader.readString());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "device":
                object.device(reader.readString());
                break;
                case "fs_name":
                object.fsName(reader.readString());
                break;
                case "gluster_clients":
                object.glusterClients(XmlGlusterClientReader.readMany(reader));
                break;
                case "gluster_volume":
                object.glusterVolume(XmlGlusterVolumeReader.readOne(reader));
                break;
                case "instance_type":
                object.instanceType(XmlInstanceTypeReader.readOne(reader));
                break;
                case "memory_pools":
                object.memoryPools(XmlGlusterMemoryPoolReader.readMany(reader));
                break;
                case "mnt_options":
                object.mntOptions(reader.readString());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "pid":
                object.pid(reader.readInteger());
                break;
                case "port":
                object.port(reader.readInteger());
                break;
                case "server_id":
                object.serverId(reader.readString());
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlGlusterBrickStatusReader.readOne(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
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
    
    public static Iterator<GlusterBrick> iterateMany(final XmlReader reader) {
        return new Iterator<GlusterBrick>() {
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
            public GlusterBrick next() {
                GlusterBrick next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<GlusterBrick> readMany(XmlReader reader) {
        List<GlusterBrick> list = new ArrayList<>();
        Iterator<GlusterBrick> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(GlusterBrickContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                case "vms":
                list = new ArrayListWithHref(object.vms());
                list.href(href);
                object.vms(list);
                break;
                default:
                break;
            }
        }
    }
}

