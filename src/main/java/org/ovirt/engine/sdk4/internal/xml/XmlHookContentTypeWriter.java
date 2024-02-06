/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HookContentType;

public class XmlHookContentTypeWriter {
    
    public static void writeOne(HookContentType object, XmlWriter writer) {
        writeOne(object, "hook_content_type", writer);
    }
    
    public static void writeOne(HookContentType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HookContentType> list, XmlWriter writer) {
        writeMany(list, "hook_content_type", "hook_content_types", writer);
    }
    
    public static void writeMany(Iterator<HookContentType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHookContentTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

