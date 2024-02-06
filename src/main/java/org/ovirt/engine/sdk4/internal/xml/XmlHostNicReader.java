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
import org.ovirt.engine.sdk4.internal.containers.HostNicContainer;
import org.ovirt.engine.sdk4.types.HostNic;

public class XmlHostNicReader {
    
    public static HostNic readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        HostNicContainer object = new HostNicContainer();
        
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
                case "ad_aggregator_id":
                object.adAggregatorId(reader.readInteger());
                break;
                case "base_interface":
                object.baseInterface(reader.readString());
                break;
                case "bonding":
                object.bonding(XmlBondingReader.readOne(reader));
                break;
                case "boot_protocol":
                object.bootProtocol(XmlBootProtocolReader.readOne(reader));
                break;
                case "bridged":
                object.bridged(reader.readBoolean());
                break;
                case "check_connectivity":
                object.checkConnectivity(reader.readBoolean());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "custom_configuration":
                object.customConfiguration(reader.readBoolean());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "ip":
                object.ip(XmlIpReader.readOne(reader));
                break;
                case "ipv6":
                object.ipv6(XmlIpReader.readOne(reader));
                break;
                case "ipv6_boot_protocol":
                object.ipv6BootProtocol(XmlBootProtocolReader.readOne(reader));
                break;
                case "mac":
                object.mac(XmlMacReader.readOne(reader));
                break;
                case "mtu":
                object.mtu(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network":
                object.network(XmlNetworkReader.readOne(reader));
                break;
                case "network_labels":
                object.networkLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "override_configuration":
                object.overrideConfiguration(reader.readBoolean());
                break;
                case "physical_function":
                object.physicalFunction(XmlHostNicReader.readOne(reader));
                break;
                case "properties":
                object.properties(XmlPropertyReader.readMany(reader));
                break;
                case "qos":
                object.qos(XmlQosReader.readOne(reader));
                break;
                case "speed":
                object.speed(reader.readInteger());
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlNicStatusReader.readOne(reader));
                break;
                case "virtual_functions_configuration":
                object.virtualFunctionsConfiguration(XmlHostNicVirtualFunctionsConfigurationReader.readOne(reader));
                break;
                case "vlan":
                object.vlan(XmlVlanReader.readOne(reader));
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
    
    public static Iterator<HostNic> iterateMany(final XmlReader reader) {
        return new Iterator<HostNic>() {
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
            public HostNic next() {
                HostNic next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<HostNic> readMany(XmlReader reader) {
        List<HostNic> list = new ArrayList<>();
        Iterator<HostNic> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(HostNicContainer object, String[] link) {
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
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                default:
                break;
            }
        }
    }
}

