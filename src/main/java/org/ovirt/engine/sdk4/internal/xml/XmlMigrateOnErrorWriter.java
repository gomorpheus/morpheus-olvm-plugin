/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MigrateOnError;

public class XmlMigrateOnErrorWriter {
    
    public static void writeOne(MigrateOnError object, XmlWriter writer) {
        writeOne(object, "migrate_on_error", writer);
    }
    
    public static void writeOne(MigrateOnError object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<MigrateOnError> list, XmlWriter writer) {
        writeMany(list, "migrate_on_error", "migrate_on_errors", writer);
    }
    
    public static void writeMany(Iterator<MigrateOnError> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMigrateOnErrorWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

