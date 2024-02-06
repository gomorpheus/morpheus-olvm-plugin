/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Payload;

public class XmlPayloadWriter {
    
    public static void writeOne(Payload object, XmlWriter writer) {
        writeOne(object, "payload", writer);
    }
    
    public static void writeOne(Payload object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.filesPresent()) {
            XmlFileWriter.writeMany(object.files().iterator(), "file", "files", writer);
        }
        if (object.typePresent()) {
            XmlVmDeviceTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.volumeIdPresent()) {
            writer.writeElement("volume_id", object.volumeId());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Payload> list, XmlWriter writer) {
        writeMany(list, "payload", "payloads", writer);
    }
    
    public static void writeMany(Iterator<Payload> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPayloadWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

