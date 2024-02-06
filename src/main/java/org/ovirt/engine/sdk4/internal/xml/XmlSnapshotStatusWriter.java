/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SnapshotStatus;

public class XmlSnapshotStatusWriter {
    
    public static void writeOne(SnapshotStatus object, XmlWriter writer) {
        writeOne(object, "snapshot_status", writer);
    }
    
    public static void writeOne(SnapshotStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SnapshotStatus> list, XmlWriter writer) {
        writeMany(list, "snapshot_status", "snapshot_statuss", writer);
    }
    
    public static void writeMany(Iterator<SnapshotStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSnapshotStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

