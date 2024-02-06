/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterClient;

public class XmlGlusterClientWriter {
    
    public static void writeOne(GlusterClient object, XmlWriter writer) {
        writeOne(object, "gluster_client", writer);
    }
    
    public static void writeOne(GlusterClient object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.bytesReadPresent()) {
            writer.writeInteger("bytes_read", object.bytesRead());
        }
        if (object.bytesWrittenPresent()) {
            writer.writeInteger("bytes_written", object.bytesWritten());
        }
        if (object.clientPortPresent()) {
            writer.writeInteger("client_port", object.clientPort());
        }
        if (object.hostNamePresent()) {
            writer.writeElement("host_name", object.hostName());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterClient> list, XmlWriter writer) {
        writeMany(list, "gluster_client", "gluster_clients", writer);
    }
    
    public static void writeMany(Iterator<GlusterClient> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterClientWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

