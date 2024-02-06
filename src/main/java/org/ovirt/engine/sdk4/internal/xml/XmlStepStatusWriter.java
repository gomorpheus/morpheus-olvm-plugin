/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StepStatus;

public class XmlStepStatusWriter {
    
    public static void writeOne(StepStatus object, XmlWriter writer) {
        writeOne(object, "step_status", writer);
    }
    
    public static void writeOne(StepStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StepStatus> list, XmlWriter writer) {
        writeMany(list, "step_status", "step_statuss", writer);
    }
    
    public static void writeMany(Iterator<StepStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStepStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

