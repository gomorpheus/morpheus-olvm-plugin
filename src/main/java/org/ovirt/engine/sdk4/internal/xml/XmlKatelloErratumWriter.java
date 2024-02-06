/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.KatelloErratum;

public class XmlKatelloErratumWriter {
    
    public static void writeOne(KatelloErratum object, XmlWriter writer) {
        writeOne(object, "katello_erratum", writer);
    }
    
    public static void writeOne(KatelloErratum object, String tag, XmlWriter writer) {
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
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.issuedPresent()) {
            writer.writeDate("issued", object.issued());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.packagesPresent()) {
            XmlPackageWriter.writeMany(object.packages().iterator(), "package", "packages", writer);
        }
        if (object.severityPresent()) {
            writer.writeElement("severity", object.severity());
        }
        if (object.solutionPresent()) {
            writer.writeElement("solution", object.solution());
        }
        if (object.summaryPresent()) {
            writer.writeElement("summary", object.summary());
        }
        if (object.titlePresent()) {
            writer.writeElement("title", object.title());
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<KatelloErratum> list, XmlWriter writer) {
        writeMany(list, "katello_erratum", "katello_errata", writer);
    }
    
    public static void writeMany(Iterator<KatelloErratum> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlKatelloErratumWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

