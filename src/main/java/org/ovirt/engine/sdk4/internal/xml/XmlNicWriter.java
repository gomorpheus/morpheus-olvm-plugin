/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Nic;

public class XmlNicWriter {
    
    public static void writeOne(Nic object, XmlWriter writer) {
        writeOne(object, "nic", writer);
    }
    
    public static void writeOne(Nic object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.bootProtocolPresent()) {
            XmlBootProtocolWriter.writeOne(object.bootProtocol(), "boot_protocol", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.interface_Present()) {
            XmlNicInterfaceWriter.writeOne(object.interface_(), "interface", writer);
        }
        if (object.linkedPresent()) {
            writer.writeBoolean("linked", object.linked());
        }
        if (object.macPresent()) {
            XmlMacWriter.writeOne(object.mac(), "mac", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networkPresent()) {
            XmlNetworkWriter.writeOne(object.network(), "network", writer);
        }
        if (object.networkAttachmentsPresent()) {
            XmlNetworkAttachmentWriter.writeMany(object.networkAttachments().iterator(), "network_attachment", "network_attachments", writer);
        }
        if (object.networkFilterParametersPresent()) {
            XmlNetworkFilterParameterWriter.writeMany(object.networkFilterParameters().iterator(), "network_filter_parameter", "network_filter_parameters", writer);
        }
        if (object.networkLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.networkLabels().iterator(), "network_label", "network_labels", writer);
        }
        if (object.onBootPresent()) {
            writer.writeBoolean("on_boot", object.onBoot());
        }
        if (object.pluggedPresent()) {
            writer.writeBoolean("plugged", object.plugged());
        }
        if (object.reportedDevicesPresent()) {
            XmlReportedDeviceWriter.writeMany(object.reportedDevices().iterator(), "reported_device", "reported_devices", writer);
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.syncedPresent()) {
            writer.writeBoolean("synced", object.synced());
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.virtualFunctionAllowedLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.virtualFunctionAllowedLabels().iterator(), "network_label", "virtual_function_allowed_labels", writer);
        }
        if (object.virtualFunctionAllowedNetworksPresent()) {
            XmlNetworkWriter.writeMany(object.virtualFunctionAllowedNetworks().iterator(), "network", "virtual_function_allowed_networks", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        if (object.vnicProfilePresent()) {
            XmlVnicProfileWriter.writeOne(object.vnicProfile(), "vnic_profile", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Nic> list, XmlWriter writer) {
        writeMany(list, "nic", "nics", writer);
    }
    
    public static void writeMany(Iterator<Nic> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNicWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

