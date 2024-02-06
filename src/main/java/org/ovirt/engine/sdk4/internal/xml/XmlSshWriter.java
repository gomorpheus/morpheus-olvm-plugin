/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Ssh;

public class XmlSshWriter {
    
    public static void writeOne(Ssh object, XmlWriter writer) {
        writeOne(object, "ssh", writer);
    }
    
    public static void writeOne(Ssh object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.authenticationMethodPresent()) {
            XmlSshAuthenticationMethodWriter.writeOne(object.authenticationMethod(), "authentication_method", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.fingerprintPresent()) {
            writer.writeElement("fingerprint", object.fingerprint());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.publicKeyPresent()) {
            writer.writeElement("public_key", object.publicKey());
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Ssh> list, XmlWriter writer) {
        writeMany(list, "ssh", "sshs", writer);
    }
    
    public static void writeMany(Iterator<Ssh> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSshWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

