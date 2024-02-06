/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HardwareInformation;

public class XmlHardwareInformationWriter {
    
    public static void writeOne(HardwareInformation object, XmlWriter writer) {
        writeOne(object, "hardware_information", writer);
    }
    
    public static void writeOne(HardwareInformation object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.familyPresent()) {
            writer.writeElement("family", object.family());
        }
        if (object.manufacturerPresent()) {
            writer.writeElement("manufacturer", object.manufacturer());
        }
        if (object.productNamePresent()) {
            writer.writeElement("product_name", object.productName());
        }
        if (object.serialNumberPresent()) {
            writer.writeElement("serial_number", object.serialNumber());
        }
        if (object.supportedRngSourcesPresent()) {
            XmlRngSourceWriter.writeMany(object.supportedRngSources().iterator(), "supported_rng_source", "supported_rng_sources", writer);
        }
        if (object.uuidPresent()) {
            writer.writeElement("uuid", object.uuid());
        }
        if (object.versionPresent()) {
            writer.writeElement("version", object.version());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HardwareInformation> list, XmlWriter writer) {
        writeMany(list, "hardware_information", "hardware_informations", writer);
    }
    
    public static void writeMany(Iterator<HardwareInformation> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHardwareInformationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

