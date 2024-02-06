/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Sso;

public class XmlSsoWriter {
    
    public static void writeOne(Sso object, XmlWriter writer) {
        writeOne(object, "sso", writer);
    }
    
    public static void writeOne(Sso object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.methodsPresent()) {
            XmlMethodWriter.writeMany(object.methods().iterator(), "method", "methods", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Sso> list, XmlWriter writer) {
        writeMany(list, "sso", "ssos", writer);
    }
    
    public static void writeMany(Iterator<Sso> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSsoWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

