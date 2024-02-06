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
import org.ovirt.engine.sdk4.internal.containers.MigrationOptionsContainer;
import org.ovirt.engine.sdk4.types.MigrationOptions;

public class XmlMigrationOptionsReader {
    
    public static MigrationOptions readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        MigrationOptionsContainer object = new MigrationOptionsContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "auto_converge":
                object.autoConverge(XmlInheritableBooleanReader.readOne(reader));
                break;
                case "bandwidth":
                object.bandwidth(XmlMigrationBandwidthReader.readOne(reader));
                break;
                case "compressed":
                object.compressed(XmlInheritableBooleanReader.readOne(reader));
                break;
                case "encrypted":
                object.encrypted(XmlInheritableBooleanReader.readOne(reader));
                break;
                case "policy":
                object.policy(XmlMigrationPolicyReader.readOne(reader));
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
    
    public static Iterator<MigrationOptions> iterateMany(final XmlReader reader) {
        return new Iterator<MigrationOptions>() {
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
            public MigrationOptions next() {
                MigrationOptions next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<MigrationOptions> readMany(XmlReader reader) {
        List<MigrationOptions> list = new ArrayList<>();
        Iterator<MigrationOptions> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(MigrationOptionsContainer object, String[] link) {
    }
}

