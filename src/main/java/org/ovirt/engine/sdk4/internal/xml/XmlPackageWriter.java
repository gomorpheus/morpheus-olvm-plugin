/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Package;

public class XmlPackageWriter {
    
    public static void writeOne(Package object, XmlWriter writer) {
        writeOne(object, "package", writer);
    }
    
    public static void writeOne(Package object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Package> list, XmlWriter writer) {
        writeMany(list, "package", "packages", writer);
    }
    
    public static void writeMany(Iterator<Package> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPackageWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

