/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Cdrom;

public class XmlCdromWriter {
    
    public static void writeOne(Cdrom object, XmlWriter writer) {
        writeOne(object, "cdrom", writer);
    }
    
    public static void writeOne(Cdrom object, String tag, XmlWriter writer) {
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
        if (object.filePresent()) {
            XmlFileWriter.writeOne(object.file(), "file", writer);
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
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
    
    public static void writeMany(Iterator<Cdrom> list, XmlWriter writer) {
        writeMany(list, "cdrom", "cdroms", writer);
    }
    
    public static void writeMany(Iterator<Cdrom> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCdromWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

