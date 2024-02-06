/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NfsVersion;

public class XmlNfsVersionWriter {
    
    public static void writeOne(NfsVersion object, XmlWriter writer) {
        writeOne(object, "nfs_version", writer);
    }
    
    public static void writeOne(NfsVersion object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NfsVersion> list, XmlWriter writer) {
        writeMany(list, "nfs_version", "nfs_versions", writer);
    }
    
    public static void writeMany(Iterator<NfsVersion> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNfsVersionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

