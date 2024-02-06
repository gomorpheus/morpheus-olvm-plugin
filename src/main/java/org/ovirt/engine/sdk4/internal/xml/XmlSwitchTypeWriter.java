/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SwitchType;

public class XmlSwitchTypeWriter {
    
    public static void writeOne(SwitchType object, XmlWriter writer) {
        writeOne(object, "switch_type", writer);
    }
    
    public static void writeOne(SwitchType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SwitchType> list, XmlWriter writer) {
        writeMany(list, "switch_type", "switch_types", writer);
    }
    
    public static void writeMany(Iterator<SwitchType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSwitchTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

