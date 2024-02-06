/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskBackup;

public class XmlDiskBackupWriter {
    
    public static void writeOne(DiskBackup object, XmlWriter writer) {
        writeOne(object, "disk_backup", writer);
    }
    
    public static void writeOne(DiskBackup object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskBackup> list, XmlWriter writer) {
        writeMany(list, "disk_backup", "disk_backups", writer);
    }
    
    public static void writeMany(Iterator<DiskBackup> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskBackupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

