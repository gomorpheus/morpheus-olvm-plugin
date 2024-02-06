/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BlockStatistic;

public class XmlBlockStatisticWriter {
    
    public static void writeOne(BlockStatistic object, XmlWriter writer) {
        writeOne(object, "block_statistic", writer);
    }
    
    public static void writeOne(BlockStatistic object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<BlockStatistic> list, XmlWriter writer) {
        writeMany(list, "block_statistic", "block_statistics", writer);
    }
    
    public static void writeMany(Iterator<BlockStatistic> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBlockStatisticWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

