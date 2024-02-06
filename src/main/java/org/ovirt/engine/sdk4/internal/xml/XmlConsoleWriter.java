/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Console;

public class XmlConsoleWriter {
    
    public static void writeOne(Console object, XmlWriter writer) {
        writeOne(object, "console", writer);
    }
    
    public static void writeOne(Console object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Console> list, XmlWriter writer) {
        writeMany(list, "console", "consoles", writer);
    }
    
    public static void writeMany(Iterator<Console> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlConsoleWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

