/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ReportedConfiguration;

public class XmlReportedConfigurationWriter {
    
    public static void writeOne(ReportedConfiguration object, XmlWriter writer) {
        writeOne(object, "reported_configuration", writer);
    }
    
    public static void writeOne(ReportedConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.actualValuePresent()) {
            writer.writeElement("actual_value", object.actualValue());
        }
        if (object.expectedValuePresent()) {
            writer.writeElement("expected_value", object.expectedValue());
        }
        if (object.inSyncPresent()) {
            writer.writeBoolean("in_sync", object.inSync());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ReportedConfiguration> list, XmlWriter writer) {
        writeMany(list, "reported_configuration", "reported_configurations", writer);
    }
    
    public static void writeMany(Iterator<ReportedConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlReportedConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

