/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostNic;

public class XmlHostNicWriter {
    
    public static void writeOne(HostNic object, XmlWriter writer) {
        writeOne(object, "host_nic", writer);
    }
    
    public static void writeOne(HostNic object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.adAggregatorIdPresent()) {
            writer.writeInteger("ad_aggregator_id", object.adAggregatorId());
        }
        if (object.baseInterfacePresent()) {
            writer.writeElement("base_interface", object.baseInterface());
        }
        if (object.bondingPresent()) {
            XmlBondingWriter.writeOne(object.bonding(), "bonding", writer);
        }
        if (object.bootProtocolPresent()) {
            XmlBootProtocolWriter.writeOne(object.bootProtocol(), "boot_protocol", writer);
        }
        if (object.bridgedPresent()) {
            writer.writeBoolean("bridged", object.bridged());
        }
        if (object.checkConnectivityPresent()) {
            writer.writeBoolean("check_connectivity", object.checkConnectivity());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.customConfigurationPresent()) {
            writer.writeBoolean("custom_configuration", object.customConfiguration());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.ipPresent()) {
            XmlIpWriter.writeOne(object.ip(), "ip", writer);
        }
        if (object.ipv6Present()) {
            XmlIpWriter.writeOne(object.ipv6(), "ipv6", writer);
        }
        if (object.ipv6BootProtocolPresent()) {
            XmlBootProtocolWriter.writeOne(object.ipv6BootProtocol(), "ipv6_boot_protocol", writer);
        }
        if (object.macPresent()) {
            XmlMacWriter.writeOne(object.mac(), "mac", writer);
        }
        if (object.mtuPresent()) {
            writer.writeInteger("mtu", object.mtu());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkPresent()) {
            XmlNetworkWriter.writeOne(object.network(), "network", writer);
        }
        if (object.networkLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.networkLabels().iterator(), "network_label", "network_labels", writer);
        }
        if (object.overrideConfigurationPresent()) {
            writer.writeBoolean("override_configuration", object.overrideConfiguration());
        }
        if (object.physicalFunctionPresent()) {
            XmlHostNicWriter.writeOne(object.physicalFunction(), "physical_function", writer);
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.qosPresent()) {
            XmlQosWriter.writeOne(object.qos(), "qos", writer);
        }
        if (object.speedPresent()) {
            writer.writeInteger("speed", object.speed());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlNicStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.virtualFunctionsConfigurationPresent()) {
            XmlHostNicVirtualFunctionsConfigurationWriter.writeOne(object.virtualFunctionsConfiguration(), "virtual_functions_configuration", writer);
        }
        if (object.vlanPresent()) {
            XmlVlanWriter.writeOne(object.vlan(), "vlan", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostNic> list, XmlWriter writer) {
        writeMany(list, "host_nic", "host_nics", writer);
    }
    
    public static void writeMany(Iterator<HostNic> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostNicWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

