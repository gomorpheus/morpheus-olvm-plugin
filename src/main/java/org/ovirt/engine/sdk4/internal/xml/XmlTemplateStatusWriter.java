/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.TemplateStatus;

public class XmlTemplateStatusWriter {
    
    public static void writeOne(TemplateStatus object, XmlWriter writer) {
        writeOne(object, "template_status", writer);
    }
    
    public static void writeOne(TemplateStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<TemplateStatus> list, XmlWriter writer) {
        writeMany(list, "template_status", "template_statuss", writer);
    }
    
    public static void writeMany(Iterator<TemplateStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTemplateStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

