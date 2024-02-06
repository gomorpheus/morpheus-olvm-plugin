/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Network;

public class XmlNetworkWriter {
    
    public static void writeOne(Network object, XmlWriter writer) {
        writeOne(object, "network", writer);
    }
    
    public static void writeOne(Network object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.displayPresent()) {
            writer.writeBoolean("display", object.display());
        }
        if (object.dnsResolverConfigurationPresent()) {
            XmlDnsResolverConfigurationWriter.writeOne(object.dnsResolverConfiguration(), "dns_resolver_configuration", writer);
        }
        if (object.externalProviderPresent()) {
            XmlOpenStackNetworkProviderWriter.writeOne(object.externalProvider(), "external_provider", writer);
        }
        if (object.externalProviderPhysicalNetworkPresent()) {
            XmlNetworkWriter.writeOne(object.externalProviderPhysicalNetwork(), "external_provider_physical_network", writer);
        }
        if (object.ipPresent()) {
            XmlIpWriter.writeOne(object.ip(), "ip", writer);
        }
        if (object.mtuPresent()) {
            writer.writeInteger("mtu", object.mtu());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.networkLabels().iterator(), "network_label", "network_labels", writer);
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.portIsolationPresent()) {
            writer.writeBoolean("port_isolation", object.portIsolation());
        }
        if (object.profileRequiredPresent()) {
            writer.writeBoolean("profile_required", object.profileRequired());
        }
        if (object.qosPresent()) {
            XmlQosWriter.writeOne(object.qos(), "qos", writer);
        }
        if (object.requiredPresent()) {
            writer.writeBoolean("required", object.required());
        }
        if (object.statusPresent()) {
            XmlNetworkStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.stpPresent()) {
            writer.writeBoolean("stp", object.stp());
        }
        if (object.usagesPresent()) {
            XmlNetworkUsageWriter.writeMany(object.usages().iterator(), "usage", "usages", writer);
        }
        if (object.vdsmNamePresent()) {
            writer.writeElement("vdsm_name", object.vdsmName());
        }
        if (object.vlanPresent()) {
            XmlVlanWriter.writeOne(object.vlan(), "vlan", writer);
        }
        if (object.vnicProfilesPresent()) {
            XmlVnicProfileWriter.writeMany(object.vnicProfiles().iterator(), "vnic_profile", "vnic_profiles", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Network> list, XmlWriter writer) {
        writeMany(list, "network", "networks", writer);
    }
    
    public static void writeMany(Iterator<Network> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

