/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HookStatus;

public class XmlHookStatusWriter {
    
    public static void writeOne(HookStatus object, XmlWriter writer) {
        writeOne(object, "hook_status", writer);
    }
    
    public static void writeOne(HookStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HookStatus> list, XmlWriter writer) {
        writeMany(list, "hook_status", "hook_statuss", writer);
    }
    
    public static void writeMany(Iterator<HookStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHookStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

