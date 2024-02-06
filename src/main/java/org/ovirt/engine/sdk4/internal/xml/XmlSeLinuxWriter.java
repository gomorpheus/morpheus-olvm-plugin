/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SeLinux;

public class XmlSeLinuxWriter {
    
    public static void writeOne(SeLinux object, XmlWriter writer) {
        writeOne(object, "se_linux", writer);
    }
    
    public static void writeOne(SeLinux object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.modePresent()) {
            XmlSeLinuxModeWriter.writeOne(object.mode(), "mode", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SeLinux> list, XmlWriter writer) {
        writeMany(list, "se_linux", "se_linuxs", writer);
    }
    
    public static void writeMany(Iterator<SeLinux> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSeLinuxWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

