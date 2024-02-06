/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ErrorHandling;

public class XmlErrorHandlingWriter {
    
    public static void writeOne(ErrorHandling object, XmlWriter writer) {
        writeOne(object, "error_handling", writer);
    }
    
    public static void writeOne(ErrorHandling object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.onErrorPresent()) {
            XmlMigrateOnErrorWriter.writeOne(object.onError(), "on_error", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ErrorHandling> list, XmlWriter writer) {
        writeMany(list, "error_handling", "error_handlings", writer);
    }
    
    public static void writeMany(Iterator<ErrorHandling> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlErrorHandlingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

