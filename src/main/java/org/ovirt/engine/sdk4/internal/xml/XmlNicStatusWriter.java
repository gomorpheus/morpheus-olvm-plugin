/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NicStatus;

public class XmlNicStatusWriter {
    
    public static void writeOne(NicStatus object, XmlWriter writer) {
        writeOne(object, "nic_status", writer);
    }
    
    public static void writeOne(NicStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NicStatus> list, XmlWriter writer) {
        writeMany(list, "nic_status", "nic_statuss", writer);
    }
    
    public static void writeMany(Iterator<NicStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNicStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

