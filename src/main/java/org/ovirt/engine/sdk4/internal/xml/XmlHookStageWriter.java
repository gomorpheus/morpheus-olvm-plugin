/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HookStage;

public class XmlHookStageWriter {
    
    public static void writeOne(HookStage object, XmlWriter writer) {
        writeOne(object, "hook_stage", writer);
    }
    
    public static void writeOne(HookStage object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<HookStage> list, XmlWriter writer) {
        writeMany(list, "hook_stage", "hook_stages", writer);
    }
    
    public static void writeMany(Iterator<HookStage> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHookStageWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

