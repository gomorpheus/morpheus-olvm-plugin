/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostDevice;

public class XmlHostDeviceWriter {
    
    public static void writeOne(HostDevice object, XmlWriter writer) {
        writeOne(object, "host_device", writer);
    }
    
    public static void writeOne(HostDevice object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.capabilityPresent()) {
            writer.writeElement("capability", object.capability());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.driverPresent()) {
            writer.writeElement("driver", object.driver());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.iommuGroupPresent()) {
            writer.writeInteger("iommu_group", object.iommuGroup());
        }
        if (object.mDevTypesPresent()) {
            XmlMDevTypeWriter.writeMany(object.mDevTypes().iterator(), "m_dev_type", "m_dev_types", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.parentDevicePresent()) {
            XmlHostDeviceWriter.writeOne(object.parentDevice(), "parent_device", writer);
        }
        if (object.physicalFunctionPresent()) {
            XmlHostDeviceWriter.writeOne(object.physicalFunction(), "physical_function", writer);
        }
        if (object.placeholderPresent()) {
            writer.writeBoolean("placeholder", object.placeholder());
        }
        if (object.productPresent()) {
            XmlProductWriter.writeOne(object.product(), "product", writer);
        }
        if (object.vendorPresent()) {
            XmlVendorWriter.writeOne(object.vendor(), "vendor", writer);
        }
        if (object.virtualFunctionsPresent()) {
            writer.writeInteger("virtual_functions", object.virtualFunctions());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostDevice> list, XmlWriter writer) {
        writeMany(list, "host_device", "host_devices", writer);
    }
    
    public static void writeMany(Iterator<HostDevice> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostDeviceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

