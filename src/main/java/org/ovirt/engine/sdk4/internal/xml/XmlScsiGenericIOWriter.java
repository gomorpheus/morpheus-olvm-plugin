/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ScsiGenericIO;

public class XmlScsiGenericIOWriter {
    
    public static void writeOne(ScsiGenericIO object, XmlWriter writer) {
        writeOne(object, "scsi_generic_i_o", writer);
    }
    
    public static void writeOne(ScsiGenericIO object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ScsiGenericIO> list, XmlWriter writer) {
        writeMany(list, "scsi_generic_i_o", "scsi_generic_i_os", writer);
    }
    
    public static void writeMany(Iterator<ScsiGenericIO> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlScsiGenericIOWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

