/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.FipsMode;

public class XmlFipsModeWriter {
    
    public static void writeOne(FipsMode object, XmlWriter writer) {
        writeOne(object, "fips_mode", writer);
    }
    
    public static void writeOne(FipsMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<FipsMode> list, XmlWriter writer) {
        writeMany(list, "fips_mode", "fips_modes", writer);
    }
    
    public static void writeMany(Iterator<FipsMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFipsModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

