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
import org.ovirt.engine.sdk4.internal.containers.AffinityGroupContainer;
import org.ovirt.engine.sdk4.types.AffinityGroup;

public class XmlAffinityGroupReader {
    
    public static AffinityGroup readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        AffinityGroupContainer object = new AffinityGroupContainer();
        
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
                case "broken":
                object.broken(reader.readBoolean());
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "enforcing":
                object.enforcing(reader.readBoolean());
                break;
                case "host_labels":
                object.hostLabels(XmlAffinityLabelReader.readMany(reader));
                break;
                case "hosts":
                object.hosts(XmlHostReader.readMany(reader));
                break;
                case "hosts_rule":
                object.hostsRule(XmlAffinityRuleReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "positive":
                object.positive(reader.readBoolean());
                break;
                case "priority":
                object.priority(reader.readDecimal());
                break;
                case "vm_labels":
                object.vmLabels(XmlAffinityLabelReader.readMany(reader));
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
                break;
                case "vms_rule":
                object.vmsRule(XmlAffinityRuleReader.readOne(reader));
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
    
    public static Iterator<AffinityGroup> iterateMany(final XmlReader reader) {
        return new Iterator<AffinityGroup>() {
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
            public AffinityGroup next() {
                AffinityGroup next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<AffinityGroup> readMany(XmlReader reader) {
        List<AffinityGroup> list = new ArrayList<>();
        Iterator<AffinityGroup> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(AffinityGroupContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "hostlabels":
                list = new ArrayListWithHref(object.hostLabels());
                list.href(href);
                object.hostLabels(list);
                break;
                case "hosts":
                list = new ArrayListWithHref(object.hosts());
                list.href(href);
                object.hosts(list);
                break;
                case "vmlabels":
                list = new ArrayListWithHref(object.vmLabels());
                list.href(href);
                object.vmLabels(list);
                break;
                case "vms":
                list = new ArrayListWithHref(object.vms());
                list.href(href);
                object.vms(list);
                break;
                default:
                break;
            }
        }
    }
}

