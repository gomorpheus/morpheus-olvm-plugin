/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Agent;

public class XmlAgentWriter {
    
    public static void writeOne(Agent object, XmlWriter writer) {
        writeOne(object, "agent", writer);
    }
    
    public static void writeOne(Agent object, String tag, XmlWriter writer) {
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
        if (object.concurrentPresent()) {
            writer.writeBoolean("concurrent", object.concurrent());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.encryptOptionsPresent()) {
            writer.writeBoolean("encrypt_options", object.encryptOptions());
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.optionsPresent()) {
            XmlOptionWriter.writeMany(object.options().iterator(), "option", "options", writer);
        }
        if (object.orderPresent()) {
            writer.writeInteger("order", object.order());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Agent> list, XmlWriter writer) {
        writeMany(list, "agent", "agents", writer);
    }
    
    public static void writeMany(Iterator<Agent> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAgentWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

