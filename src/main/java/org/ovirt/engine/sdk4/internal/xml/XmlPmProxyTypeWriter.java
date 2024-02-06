/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PmProxyType;

public class XmlPmProxyTypeWriter {
    
    public static void writeOne(PmProxyType object, XmlWriter writer) {
        writeOne(object, "pm_proxy_type", writer);
    }
    
    public static void writeOne(PmProxyType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<PmProxyType> list, XmlWriter writer) {
        writeMany(list, "pm_proxy_type", "pm_proxy_types", writer);
    }
    
    public static void writeMany(Iterator<PmProxyType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPmProxyTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

