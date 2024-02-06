/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SpmStatus;

public class XmlSpmStatusWriter {
    
    public static void writeOne(SpmStatus object, XmlWriter writer) {
        writeOne(object, "spm_status", writer);
    }
    
    public static void writeOne(SpmStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SpmStatus> list, XmlWriter writer) {
        writeMany(list, "spm_status", "spm_statuss", writer);
    }
    
    public static void writeMany(Iterator<SpmStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSpmStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

