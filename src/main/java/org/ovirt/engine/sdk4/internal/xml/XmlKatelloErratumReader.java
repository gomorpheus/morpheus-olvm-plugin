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
import org.ovirt.engine.sdk4.internal.containers.KatelloErratumContainer;
import org.ovirt.engine.sdk4.types.KatelloErratum;

public class XmlKatelloErratumReader {
    
    public static KatelloErratum readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        KatelloErratumContainer object = new KatelloErratumContainer();
        
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
                case "description":
                object.description(reader.readString());
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "issued":
                object.issued(reader.readDate());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "packages":
                object.packages(XmlPackageReader.readMany(reader));
                break;
                case "severity":
                object.severity(reader.readString());
                break;
                case "solution":
                object.solution(reader.readString());
                break;
                case "summary":
                object.summary(reader.readString());
                break;
                case "title":
                object.title(reader.readString());
                break;
                case "type":
                object.type(reader.readString());
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
    
    public static Iterator<KatelloErratum> iterateMany(final XmlReader reader) {
        return new Iterator<KatelloErratum>() {
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
            public KatelloErratum next() {
                KatelloErratum next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<KatelloErratum> readMany(XmlReader reader) {
        List<KatelloErratum> list = new ArrayList<>();
        Iterator<KatelloErratum> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(KatelloErratumContainer object, String[] link) {
    }
}

