/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StatisticUnit;

public class XmlStatisticUnitWriter {
    
    public static void writeOne(StatisticUnit object, XmlWriter writer) {
        writeOne(object, "statistic_unit", writer);
    }
    
    public static void writeOne(StatisticUnit object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StatisticUnit> list, XmlWriter writer) {
        writeMany(list, "statistic_unit", "statistic_units", writer);
    }
    
    public static void writeMany(Iterator<StatisticUnit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStatisticUnitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

