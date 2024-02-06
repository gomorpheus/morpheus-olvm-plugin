/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SsoMethod;

public class XmlSsoMethodWriter {
    
    public static void writeOne(SsoMethod object, XmlWriter writer) {
        writeOne(object, "sso_method", writer);
    }
    
    public static void writeOne(SsoMethod object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SsoMethod> list, XmlWriter writer) {
        writeMany(list, "sso_method", "sso_methods", writer);
    }
    
    public static void writeMany(Iterator<SsoMethod> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSsoMethodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

