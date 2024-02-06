/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.QcowVersion;

public class XmlQcowVersionWriter {
    
    public static void writeOne(QcowVersion object, XmlWriter writer) {
        writeOne(object, "qcow_version", writer);
    }
    
    public static void writeOne(QcowVersion object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<QcowVersion> list, XmlWriter writer) {
        writeMany(list, "qcow_version", "qcow_versions", writer);
    }
    
    public static void writeMany(Iterator<QcowVersion> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQcowVersionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

