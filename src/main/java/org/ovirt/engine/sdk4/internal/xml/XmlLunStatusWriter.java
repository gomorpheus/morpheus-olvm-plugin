/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.LunStatus;

public class XmlLunStatusWriter {
    
    public static void writeOne(LunStatus object, XmlWriter writer) {
        writeOne(object, "lun_status", writer);
    }
    
    public static void writeOne(LunStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<LunStatus> list, XmlWriter writer) {
        writeMany(list, "lun_status", "lun_statuss", writer);
    }
    
    public static void writeMany(Iterator<LunStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlLunStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

