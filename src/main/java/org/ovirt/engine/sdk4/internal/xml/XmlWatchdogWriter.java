/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Watchdog;

public class XmlWatchdogWriter {
    
    public static void writeOne(Watchdog object, XmlWriter writer) {
        writeOne(object, "watchdog", writer);
    }
    
    public static void writeOne(Watchdog object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.actionPresent()) {
            XmlWatchdogActionWriter.writeOne(object.action(), "action", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.modelPresent()) {
            XmlWatchdogModelWriter.writeOne(object.model(), "model", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Watchdog> list, XmlWriter writer) {
        writeMany(list, "watchdog", "watchdogs", writer);
    }
    
    public static void writeMany(Iterator<Watchdog> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlWatchdogWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

