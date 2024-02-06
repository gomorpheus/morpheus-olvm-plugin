/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SnapshotType;

public class XmlSnapshotTypeWriter {
    
    public static void writeOne(SnapshotType object, XmlWriter writer) {
        writeOne(object, "snapshot_type", writer);
    }
    
    public static void writeOne(SnapshotType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SnapshotType> list, XmlWriter writer) {
        writeMany(list, "snapshot_type", "snapshot_types", writer);
    }
    
    public static void writeMany(Iterator<SnapshotType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSnapshotTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

