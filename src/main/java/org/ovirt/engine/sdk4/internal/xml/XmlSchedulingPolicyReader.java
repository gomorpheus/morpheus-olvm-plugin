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
import org.ovirt.engine.sdk4.internal.containers.SchedulingPolicyContainer;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;

public class XmlSchedulingPolicyReader {
    
    public static SchedulingPolicy readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        SchedulingPolicyContainer object = new SchedulingPolicyContainer();
        
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
                case "balances":
                object.balances(XmlBalanceReader.readMany(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "default_policy":
                object.defaultPolicy(reader.readBoolean());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "filters":
                object.filters(XmlFilterReader.readMany(reader));
                break;
                case "locked":
                object.locked(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "properties":
                object.properties(XmlPropertyReader.readMany(reader));
                break;
                case "weight":
                object.weight(XmlWeightReader.readMany(reader));
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
    
    public static Iterator<SchedulingPolicy> iterateMany(final XmlReader reader) {
        return new Iterator<SchedulingPolicy>() {
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
            public SchedulingPolicy next() {
                SchedulingPolicy next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<SchedulingPolicy> readMany(XmlReader reader) {
        List<SchedulingPolicy> list = new ArrayList<>();
        Iterator<SchedulingPolicy> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(SchedulingPolicyContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "balances":
                list = new ArrayListWithHref(object.balances());
                list.href(href);
                object.balances(list);
                break;
                case "filters":
                list = new ArrayListWithHref(object.filters());
                list.href(href);
                object.filters(list);
                break;
                case "weight":
                list = new ArrayListWithHref(object.weight());
                list.href(href);
                object.weight(list);
                break;
                default:
                break;
            }
        }
    }
}

