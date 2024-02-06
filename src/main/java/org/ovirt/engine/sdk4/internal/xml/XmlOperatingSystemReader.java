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
import org.ovirt.engine.sdk4.internal.containers.OperatingSystemContainer;
import org.ovirt.engine.sdk4.types.OperatingSystem;

public class XmlOperatingSystemReader {
    
    public static OperatingSystem readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        OperatingSystemContainer object = new OperatingSystemContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "boot":
                object.boot(XmlBootReader.readOne(reader));
                break;
                case "cmdline":
                object.cmdline(reader.readString());
                break;
                case "custom_kernel_cmdline":
                object.customKernelCmdline(reader.readString());
                break;
                case "initrd":
                object.initrd(reader.readString());
                break;
                case "kernel":
                object.kernel(reader.readString());
                break;
                case "reported_kernel_cmdline":
                object.reportedKernelCmdline(reader.readString());
                break;
                case "type":
                object.type(reader.readString());
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
    
    public static Iterator<OperatingSystem> iterateMany(final XmlReader reader) {
        return new Iterator<OperatingSystem>() {
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
            public OperatingSystem next() {
                OperatingSystem next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<OperatingSystem> readMany(XmlReader reader) {
        List<OperatingSystem> list = new ArrayList<>();
        Iterator<OperatingSystem> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(OperatingSystemContainer object, String[] link) {
    }
}

