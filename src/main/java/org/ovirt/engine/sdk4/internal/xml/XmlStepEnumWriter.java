/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StepEnum;

public class XmlStepEnumWriter {
    
    public static void writeOne(StepEnum object, XmlWriter writer) {
        writeOne(object, "step_enum", writer);
    }
    
    public static void writeOne(StepEnum object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StepEnum> list, XmlWriter writer) {
        writeMany(list, "step_enum", "step_enums", writer);
    }
    
    public static void writeMany(Iterator<StepEnum> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStepEnumWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

