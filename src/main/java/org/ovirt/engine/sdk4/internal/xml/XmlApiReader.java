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
import org.ovirt.engine.sdk4.internal.containers.ApiContainer;
import org.ovirt.engine.sdk4.types.Api;

public class XmlApiReader {
    
    public static Api readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ApiContainer object = new ApiContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "authenticated_user":
                object.authenticatedUser(XmlUserReader.readOne(reader));
                break;
                case "effective_user":
                object.effectiveUser(XmlUserReader.readOne(reader));
                break;
                case "product_info":
                object.productInfo(XmlProductInfoReader.readOne(reader));
                break;
                case "special_objects":
                object.specialObjects(XmlSpecialObjectsReader.readOne(reader));
                break;
                case "summary":
                object.summary(XmlApiSummaryReader.readOne(reader));
                break;
                case "time":
                object.time(reader.readDate());
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
    
    public static Iterator<Api> iterateMany(final XmlReader reader) {
        return new Iterator<Api>() {
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
            public Api next() {
                Api next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Api> readMany(XmlReader reader) {
        List<Api> list = new ArrayList<>();
        Iterator<Api> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ApiContainer object, String[] link) {
    }
}

