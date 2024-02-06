/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BackupPhase;

public class XmlBackupPhaseWriter {
    
    public static void writeOne(BackupPhase object, XmlWriter writer) {
        writeOne(object, "backup_phase", writer);
    }
    
    public static void writeOne(BackupPhase object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<BackupPhase> list, XmlWriter writer) {
        writeMany(list, "backup_phase", "backup_phases", writer);
    }
    
    public static void writeMany(Iterator<BackupPhase> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBackupPhaseWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

