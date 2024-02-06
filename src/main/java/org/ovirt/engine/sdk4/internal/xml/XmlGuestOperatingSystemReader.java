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
import org.ovirt.engine.sdk4.internal.containers.GuestOperatingSystemContainer;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;

public class XmlGuestOperatingSystemReader {
    
    public static GuestOperatingSystem readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        GuestOperatingSystemContainer object = new GuestOperatingSystemContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "architecture":
                object.architecture(reader.readString());
                break;
                case "codename":
                object.codename(reader.readString());
                break;
                case "distribution":
                object.distribution(reader.readString());
                break;
                case "family":
                object.family(reader.readString());
                break;
                case "kernel":
                object.kernel(XmlKernelReader.readOne(reader));
                break;
                case "version":
                object.version(XmlVersionReader.readOne(reader));
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
    
    public static Iterator<GuestOperatingSystem> iterateMany(final XmlReader reader) {
        return new Iterator<GuestOperatingSystem>() {
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
            public GuestOperatingSystem next() {
                GuestOperatingSystem next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<GuestOperatingSystem> readMany(XmlReader reader) {
        List<GuestOperatingSystem> list = new ArrayList<>();
        Iterator<GuestOperatingSystem> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(GuestOperatingSystemContainer object, String[] link) {
    }
}

