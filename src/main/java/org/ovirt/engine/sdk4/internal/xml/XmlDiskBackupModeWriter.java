/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskBackupMode;

public class XmlDiskBackupModeWriter {
    
    public static void writeOne(DiskBackupMode object, XmlWriter writer) {
        writeOne(object, "disk_backup_mode", writer);
    }
    
    public static void writeOne(DiskBackupMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DiskBackupMode> list, XmlWriter writer) {
        writeMany(list, "disk_backup_mode", "disk_backup_modes", writer);
    }
    
    public static void writeMany(Iterator<DiskBackupMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskBackupModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

