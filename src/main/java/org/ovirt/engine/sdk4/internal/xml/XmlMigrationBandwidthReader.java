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
import org.ovirt.engine.sdk4.internal.containers.MigrationBandwidthContainer;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;

public class XmlMigrationBandwidthReader {
    
    public static MigrationBandwidth readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        MigrationBandwidthContainer object = new MigrationBandwidthContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "assignment_method":
                object.assignmentMethod(XmlMigrationBandwidthAssignmentMethodReader.readOne(reader));
                break;
                case "custom_value":
                object.customValue(reader.readInteger());
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
    
    public static Iterator<MigrationBandwidth> iterateMany(final XmlReader reader) {
        return new Iterator<MigrationBandwidth>() {
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
            public MigrationBandwidth next() {
                MigrationBandwidth next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<MigrationBandwidth> readMany(XmlReader reader) {
        List<MigrationBandwidth> list = new ArrayList<>();
        Iterator<MigrationBandwidth> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(MigrationBandwidthContainer object, String[] link) {
    }
}

