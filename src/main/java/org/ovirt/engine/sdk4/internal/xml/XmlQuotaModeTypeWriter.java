/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.QuotaModeType;

public class XmlQuotaModeTypeWriter {
    
    public static void writeOne(QuotaModeType object, XmlWriter writer) {
        writeOne(object, "quota_mode_type", writer);
    }
    
    public static void writeOne(QuotaModeType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<QuotaModeType> list, XmlWriter writer) {
        writeMany(list, "quota_mode_type", "quota_mode_types", writer);
    }
    
    public static void writeMany(Iterator<QuotaModeType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQuotaModeTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

