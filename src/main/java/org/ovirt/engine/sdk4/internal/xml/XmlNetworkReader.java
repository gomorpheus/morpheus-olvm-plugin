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
import org.ovirt.engine.sdk4.internal.containers.NetworkContainer;
import org.ovirt.engine.sdk4.types.Network;

public class XmlNetworkReader {
    
    public static Network readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        NetworkContainer object = new NetworkContainer();
        
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
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "display":
                object.display(reader.readBoolean());
                break;
                case "dns_resolver_configuration":
                object.dnsResolverConfiguration(XmlDnsResolverConfigurationReader.readOne(reader));
                break;
                case "external_provider":
                object.externalProvider(XmlOpenStackNetworkProviderReader.readOne(reader));
                break;
                case "external_provider_physical_network":
                object.externalProviderPhysicalNetwork(XmlNetworkReader.readOne(reader));
                break;
                case "ip":
                object.ip(XmlIpReader.readOne(reader));
                break;
                case "mtu":
                object.mtu(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network_labels":
                object.networkLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "port_isolation":
                object.portIsolation(reader.readBoolean());
                break;
                case "profile_required":
                object.profileRequired(reader.readBoolean());
                break;
                case "qos":
                object.qos(XmlQosReader.readOne(reader));
                break;
                case "required":
                object.required(reader.readBoolean());
                break;
                case "status":
                object.status(XmlNetworkStatusReader.readOne(reader));
                break;
                case "stp":
                object.stp(reader.readBoolean());
                break;
                case "usages":
                object.usages(XmlNetworkUsageReader.readMany(reader));
                break;
                case "vdsm_name":
                object.vdsmName(reader.readString());
                break;
                case "vlan":
                object.vlan(XmlVlanReader.readOne(reader));
                break;
                case "vnic_profiles":
                object.vnicProfiles(XmlVnicProfileReader.readMany(reader));
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
    
    public static Iterator<Network> iterateMany(final XmlReader reader) {
        return new Iterator<Network>() {
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
            public Network next() {
                Network next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Network> readMany(XmlReader reader) {
        List<Network> list = new ArrayList<>();
        Iterator<Network> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(NetworkContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "networklabels":
                list = new ArrayListWithHref(object.networkLabels());
                list.href(href);
                object.networkLabels(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "vnicprofiles":
                list = new ArrayListWithHref(object.vnicProfiles());
                list.href(href);
                object.vnicProfiles(list);
                break;
                default:
                break;
            }
        }
    }
}

