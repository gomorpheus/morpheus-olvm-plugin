/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ProfileDetail;

public class XmlProfileDetailWriter {
    
    public static void writeOne(ProfileDetail object, XmlWriter writer) {
        writeOne(object, "profile_detail", writer);
    }
    
    public static void writeOne(ProfileDetail object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.blockStatisticsPresent()) {
            XmlBlockStatisticWriter.writeMany(object.blockStatistics().iterator(), "block_statistic", "block_statistics", writer);
        }
        if (object.durationPresent()) {
            writer.writeInteger("duration", object.duration());
        }
        if (object.fopStatisticsPresent()) {
            XmlFopStatisticWriter.writeMany(object.fopStatistics().iterator(), "fop_statistic", "fop_statistics", writer);
        }
        if (object.profileTypePresent()) {
            writer.writeElement("profile_type", object.profileType());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ProfileDetail> list, XmlWriter writer) {
        writeMany(list, "profile_detail", "profile_details", writer);
    }
    
    public static void writeMany(Iterator<ProfileDetail> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlProfileDetailWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

