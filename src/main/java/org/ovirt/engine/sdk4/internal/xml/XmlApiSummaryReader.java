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
import org.ovirt.engine.sdk4.internal.containers.ApiSummaryContainer;
import org.ovirt.engine.sdk4.types.ApiSummary;

public class XmlApiSummaryReader {
    
    public static ApiSummary readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ApiSummaryContainer object = new ApiSummaryContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "hosts":
                object.hosts(XmlApiSummaryItemReader.readOne(reader));
                break;
                case "storage_domains":
                object.storageDomains(XmlApiSummaryItemReader.readOne(reader));
                break;
                case "users":
                object.users(XmlApiSummaryItemReader.readOne(reader));
                break;
                case "vms":
                object.vms(XmlApiSummaryItemReader.readOne(reader));
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
    
    public static Iterator<ApiSummary> iterateMany(final XmlReader reader) {
        return new Iterator<ApiSummary>() {
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
            public ApiSummary next() {
                ApiSummary next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<ApiSummary> readMany(XmlReader reader) {
        List<ApiSummary> list = new ArrayList<>();
        Iterator<ApiSummary> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ApiSummaryContainer object, String[] link) {
    }
}

