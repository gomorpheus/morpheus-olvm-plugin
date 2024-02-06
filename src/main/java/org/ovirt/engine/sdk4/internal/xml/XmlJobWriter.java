/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Job;

public class XmlJobWriter {
    
    public static void writeOne(Job object, XmlWriter writer) {
        writeOne(object, "job", writer);
    }
    
    public static void writeOne(Job object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.autoClearedPresent()) {
            writer.writeBoolean("auto_cleared", object.autoCleared());
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
        if (object.externalPresent()) {
            writer.writeBoolean("external", object.external());
        }
        if (object.lastUpdatedPresent()) {
            writer.writeDate("last_updated", object.lastUpdated());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.ownerPresent()) {
            XmlUserWriter.writeOne(object.owner(), "owner", writer);
        }
        if (object.startTimePresent()) {
            writer.writeDate("start_time", object.startTime());
        }
        if (object.statusPresent()) {
            XmlJobStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.stepsPresent()) {
            XmlStepWriter.writeMany(object.steps().iterator(), "step", "steps", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Job> list, XmlWriter writer) {
        writeMany(list, "job", "jobs", writer);
    }
    
    public static void writeMany(Iterator<Job> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlJobWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

