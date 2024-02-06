/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PmProxy;

public class XmlPmProxyWriter {
    
    public static void writeOne(PmProxy object, XmlWriter writer) {
        writeOne(object, "pm_proxy", writer);
    }
    
    public static void writeOne(PmProxy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.typePresent()) {
            XmlPmProxyTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<PmProxy> list, XmlWriter writer) {
        writeMany(list, "pm_proxy", "pm_proxies", writer);
    }
    
    public static void writeMany(Iterator<PmProxy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPmProxyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

