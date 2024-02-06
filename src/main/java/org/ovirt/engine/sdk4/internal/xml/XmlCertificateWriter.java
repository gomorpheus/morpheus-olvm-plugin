/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Certificate;

public class XmlCertificateWriter {
    
    public static void writeOne(Certificate object, XmlWriter writer) {
        writeOne(object, "certificate", writer);
    }
    
    public static void writeOne(Certificate object, String tag, XmlWriter writer) {
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
        if (object.contentPresent()) {
            writer.writeElement("content", object.content());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.organizationPresent()) {
            writer.writeElement("organization", object.organization());
        }
        if (object.subjectPresent()) {
            writer.writeElement("subject", object.subject());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Certificate> list, XmlWriter writer) {
        writeMany(list, "certificate", "certificates", writer);
    }
    
    public static void writeMany(Iterator<Certificate> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCertificateWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

