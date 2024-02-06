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
import org.ovirt.engine.sdk4.internal.containers.NetworkAttachmentContainer;
import org.ovirt.engine.sdk4.types.NetworkAttachment;

public class XmlNetworkAttachmentReader {
    
    public static NetworkAttachment readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        NetworkAttachmentContainer object = new NetworkAttachmentContainer();
        
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
                case "dns_resolver_configuration":
                object.dnsResolverConfiguration(XmlDnsResolverConfigurationReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "host_nic":
                object.hostNic(XmlHostNicReader.readOne(reader));
                break;
                case "in_sync":
                object.inSync(reader.readBoolean());
                break;
                case "ip_address_assignments":
                object.ipAddressAssignments(XmlIpAddressAssignmentReader.readMany(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network":
                object.network(XmlNetworkReader.readOne(reader));
                break;
                case "properties":
                object.properties(XmlPropertyReader.readMany(reader));
                break;
                case "qos":
                object.qos(XmlQosReader.readOne(reader));
                break;
                case "reported_configurations":
                object.reportedConfigurations(XmlReportedConfigurationReader.readMany(reader));
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
    
    public static Iterator<NetworkAttachment> iterateMany(final XmlReader reader) {
        return new Iterator<NetworkAttachment>() {
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
            public NetworkAttachment next() {
                NetworkAttachment next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<NetworkAttachment> readMany(XmlReader reader) {
        List<NetworkAttachment> list = new ArrayList<>();
        Iterator<NetworkAttachment> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(NetworkAttachmentContainer object, String[] link) {
    }
}

