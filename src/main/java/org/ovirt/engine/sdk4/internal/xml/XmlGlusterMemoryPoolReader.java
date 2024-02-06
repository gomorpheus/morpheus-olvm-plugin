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
import org.ovirt.engine.sdk4.internal.containers.GlusterMemoryPoolContainer;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class XmlGlusterMemoryPoolReader {
    
    public static GlusterMemoryPool readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        GlusterMemoryPoolContainer object = new GlusterMemoryPoolContainer();
        
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
                case "alloc_count":
                object.allocCount(reader.readInteger());
                break;
                case "cold_count":
                object.coldCount(reader.readInteger());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "hot_count":
                object.hotCount(reader.readInteger());
                break;
                case "max_alloc":
                object.maxAlloc(reader.readInteger());
                break;
                case "max_stdalloc":
                object.maxStdalloc(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "padded_size":
                object.paddedSize(reader.readInteger());
                break;
                case "pool_misses":
                object.poolMisses(reader.readInteger());
                break;
                case "type":
                object.type(reader.readString());
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
    
    public static Iterator<GlusterMemoryPool> iterateMany(final XmlReader reader) {
        return new Iterator<GlusterMemoryPool>() {
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
            public GlusterMemoryPool next() {
                GlusterMemoryPool next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<GlusterMemoryPool> readMany(XmlReader reader) {
        List<GlusterMemoryPool> list = new ArrayList<>();
        Iterator<GlusterMemoryPool> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(GlusterMemoryPoolContainer object, String[] link) {
    }
}

