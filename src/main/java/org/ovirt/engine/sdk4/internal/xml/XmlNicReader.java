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
import org.ovirt.engine.sdk4.internal.containers.NicContainer;
import org.ovirt.engine.sdk4.types.Nic;

public class XmlNicReader {
    
    public static Nic readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        NicContainer object = new NicContainer();
        
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
                case "boot_protocol":
                object.bootProtocol(XmlBootProtocolReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "instance_type":
                object.instanceType(XmlInstanceTypeReader.readOne(reader));
                break;
                case "interface":
                object.interface_(XmlNicInterfaceReader.readOne(reader));
                break;
                case "linked":
                object.linked(reader.readBoolean());
                break;
                case "mac":
                object.mac(XmlMacReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network":
                object.network(XmlNetworkReader.readOne(reader));
                break;
                case "network_attachments":
                object.networkAttachments(XmlNetworkAttachmentReader.readMany(reader));
                break;
                case "network_filter_parameters":
                object.networkFilterParameters(XmlNetworkFilterParameterReader.readMany(reader));
                break;
                case "network_labels":
                object.networkLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "on_boot":
                object.onBoot(reader.readBoolean());
                break;
                case "plugged":
                object.plugged(reader.readBoolean());
                break;
                case "reported_devices":
                object.reportedDevices(XmlReportedDeviceReader.readMany(reader));
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "synced":
                object.synced(reader.readBoolean());
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "virtual_function_allowed_labels":
                object.virtualFunctionAllowedLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "virtual_function_allowed_networks":
                object.virtualFunctionAllowedNetworks(XmlNetworkReader.readMany(reader));
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
                break;
                case "vnic_profile":
                object.vnicProfile(XmlVnicProfileReader.readOne(reader));
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
    
    public static Iterator<Nic> iterateMany(final XmlReader reader) {
        return new Iterator<Nic>() {
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
            public Nic next() {
                Nic next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Nic> readMany(XmlReader reader) {
        List<Nic> list = new ArrayList<>();
        Iterator<Nic> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(NicContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "networkattachments":
                list = new ArrayListWithHref(object.networkAttachments());
                list.href(href);
                object.networkAttachments(list);
                break;
                case "networkfilterparameters":
                list = new ArrayListWithHref(object.networkFilterParameters());
                list.href(href);
                object.networkFilterParameters(list);
                break;
                case "networklabels":
                list = new ArrayListWithHref(object.networkLabels());
                list.href(href);
                object.networkLabels(list);
                break;
                case "reporteddevices":
                list = new ArrayListWithHref(object.reportedDevices());
                list.href(href);
                object.reportedDevices(list);
                break;
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                case "virtualfunctionallowedlabels":
                list = new ArrayListWithHref(object.virtualFunctionAllowedLabels());
                list.href(href);
                object.virtualFunctionAllowedLabels(list);
                break;
                case "virtualfunctionallowednetworks":
                list = new ArrayListWithHref(object.virtualFunctionAllowedNetworks());
                list.href(href);
                object.virtualFunctionAllowedNetworks(list);
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

