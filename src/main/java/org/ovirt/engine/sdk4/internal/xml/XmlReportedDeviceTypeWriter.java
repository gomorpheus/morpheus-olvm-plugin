/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ReportedDeviceType;

public class XmlReportedDeviceTypeWriter {
    
    public static void writeOne(ReportedDeviceType object, XmlWriter writer) {
        writeOne(object, "reported_device_type", writer);
    }
    
    public static void writeOne(ReportedDeviceType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ReportedDeviceType> list, XmlWriter writer) {
        writeMany(list, "reported_device_type", "reported_device_types", writer);
    }
    
    public static void writeMany(Iterator<ReportedDeviceType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlReportedDeviceTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

