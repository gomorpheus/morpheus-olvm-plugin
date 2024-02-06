/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Step;

public class XmlStepWriter {
    
    public static void writeOne(Step object, XmlWriter writer) {
        writeOne(object, "step", writer);
    }
    
    public static void writeOne(Step object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.endTimePresent()) {
            writer.writeDate("end_time", object.endTime());
        }
        if (object.executionHostPresent()) {
            XmlHostWriter.writeOne(object.executionHost(), "execution_host", writer);
        }
        if (object.externalPresent()) {
            writer.writeBoolean("external", object.external());
        }
        if (object.externalTypePresent()) {
            XmlExternalSystemTypeWriter.writeOne(object.externalType(), "external_type", writer);
        }
        if (object.jobPresent()) {
            XmlJobWriter.writeOne(object.job(), "job", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.numberPresent()) {
            writer.writeInteger("number", object.number());
        }
        if (object.parentStepPresent()) {
            XmlStepWriter.writeOne(object.parentStep(), "parent_step", writer);
        }
        if (object.progressPresent()) {
            writer.writeInteger("progress", object.progress());
        }
        if (object.startTimePresent()) {
            writer.writeDate("start_time", object.startTime());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlStepStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.typePresent()) {
            XmlStepEnumWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Step> list, XmlWriter writer) {
        writeMany(list, "step", "steps", writer);
    }
    
    public static void writeMany(Iterator<Step> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStepWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

