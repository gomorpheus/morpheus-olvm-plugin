/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Event;

public class XmlEventWriter {
    
    public static void writeOne(Event object, XmlWriter writer) {
        writeOne(object, "event", writer);
    }
    
    public static void writeOne(Event object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.codePresent()) {
            writer.writeInteger("code", object.code());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.correlationIdPresent()) {
            writer.writeElement("correlation_id", object.correlationId());
        }
        if (object.customDataPresent()) {
            writer.writeElement("custom_data", object.customData());
        }
        if (object.customIdPresent()) {
            writer.writeInteger("custom_id", object.customId());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.floodRatePresent()) {
            writer.writeInteger("flood_rate", object.floodRate());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.indexPresent()) {
            writer.writeInteger("index", object.index());
        }
        if (object.logOnHostPresent()) {
            writer.writeBoolean("log_on_host", object.logOnHost());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.originPresent()) {
            writer.writeElement("origin", object.origin());
        }
        if (object.severityPresent()) {
            XmlLogSeverityWriter.writeOne(object.severity(), "severity", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.timePresent()) {
            writer.writeDate("time", object.time());
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Event> list, XmlWriter writer) {
        writeMany(list, "event", "events", writer);
    }
    
    public static void writeMany(Iterator<Event> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlEventWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

