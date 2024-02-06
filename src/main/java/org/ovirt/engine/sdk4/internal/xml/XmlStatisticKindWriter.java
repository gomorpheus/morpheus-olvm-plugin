/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StatisticKind;

public class XmlStatisticKindWriter {
    
    public static void writeOne(StatisticKind object, XmlWriter writer) {
        writeOne(object, "statistic_kind", writer);
    }
    
    public static void writeOne(StatisticKind object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StatisticKind> list, XmlWriter writer) {
        writeMany(list, "statistic_kind", "statistic_kinds", writer);
    }
    
    public static void writeMany(Iterator<StatisticKind> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStatisticKindWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

