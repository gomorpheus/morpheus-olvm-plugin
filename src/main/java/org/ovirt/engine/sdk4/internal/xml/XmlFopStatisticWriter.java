/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.FopStatistic;

public class XmlFopStatisticWriter {
    
    public static void writeOne(FopStatistic object, XmlWriter writer) {
        writeOne(object, "fop_statistic", writer);
    }
    
    public static void writeOne(FopStatistic object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<FopStatistic> list, XmlWriter writer) {
        writeMany(list, "fop_statistic", "fop_statistics", writer);
    }
    
    public static void writeMany(Iterator<FopStatistic> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFopStatisticWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

