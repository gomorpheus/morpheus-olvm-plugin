/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SeLinuxMode;

public class XmlSeLinuxModeWriter {
    
    public static void writeOne(SeLinuxMode object, XmlWriter writer) {
        writeOne(object, "se_linux_mode", writer);
    }
    
    public static void writeOne(SeLinuxMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SeLinuxMode> list, XmlWriter writer) {
        writeMany(list, "se_linux_mode", "se_linux_modes", writer);
    }
    
    public static void writeMany(Iterator<SeLinuxMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSeLinuxModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

