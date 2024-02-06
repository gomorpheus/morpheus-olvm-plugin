/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SpecialObjects;

public class XmlSpecialObjectsWriter {
    
    public static void writeOne(SpecialObjects object, XmlWriter writer) {
        writeOne(object, "special_objects", writer);
    }
    
    public static void writeOne(SpecialObjects object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.blankTemplatePresent()) {
            XmlTemplateWriter.writeOne(object.blankTemplate(), "blank_template", writer);
        }
        if (object.rootTagPresent()) {
            XmlTagWriter.writeOne(object.rootTag(), "root_tag", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SpecialObjects> list, XmlWriter writer) {
        writeMany(list, "special_objects", "special_objectss", writer);
    }
    
    public static void writeMany(Iterator<SpecialObjects> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSpecialObjectsWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

