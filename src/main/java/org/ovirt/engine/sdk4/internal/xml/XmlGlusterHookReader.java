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
import org.ovirt.engine.sdk4.internal.containers.GlusterHookContainer;
import org.ovirt.engine.sdk4.types.GlusterHook;

public class XmlGlusterHookReader {
    
    public static GlusterHook readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        GlusterHookContainer object = new GlusterHookContainer();
        
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
                case "checksum":
                object.checksum(reader.readString());
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "conflict_status":
                object.conflictStatus(reader.readInteger());
                break;
                case "conflicts":
                object.conflicts(reader.readString());
                break;
                case "content":
                object.content(reader.readString());
                break;
                case "content_type":
                object.contentType(XmlHookContentTypeReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "gluster_command":
                object.glusterCommand(reader.readString());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "server_hooks":
                object.serverHooks(XmlGlusterServerHookReader.readMany(reader));
                break;
                case "stage":
                object.stage(XmlHookStageReader.readOne(reader));
                break;
                case "status":
                object.status(XmlGlusterHookStatusReader.readOne(reader));
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
    
    public static Iterator<GlusterHook> iterateMany(final XmlReader reader) {
        return new Iterator<GlusterHook>() {
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
            public GlusterHook next() {
                GlusterHook next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<GlusterHook> readMany(XmlReader reader) {
        List<GlusterHook> list = new ArrayList<>();
        Iterator<GlusterHook> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(GlusterHookContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "serverhooks":
                list = new ArrayListWithHref(object.serverHooks());
                list.href(href);
                object.serverHooks(list);
                break;
                default:
                break;
            }
        }
    }
}

