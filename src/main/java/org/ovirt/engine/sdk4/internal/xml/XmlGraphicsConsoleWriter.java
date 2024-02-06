/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GraphicsConsole;

public class XmlGraphicsConsoleWriter {
    
    public static void writeOne(GraphicsConsole object, XmlWriter writer) {
        writeOne(object, "graphics_console", writer);
    }
    
    public static void writeOne(GraphicsConsole object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
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
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.protocolPresent()) {
            XmlGraphicsTypeWriter.writeOne(object.protocol(), "protocol", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.tlsPortPresent()) {
            writer.writeInteger("tls_port", object.tlsPort());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GraphicsConsole> list, XmlWriter writer) {
        writeMany(list, "graphics_console", "graphics_consoles", writer);
    }
    
    public static void writeMany(Iterator<GraphicsConsole> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGraphicsConsoleWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

