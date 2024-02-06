/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.IpVersion;

public class XmlIpVersionWriter {
    
    public static void writeOne(IpVersion object, XmlWriter writer) {
        writeOne(object, "ip_version", writer);
    }
    
    public static void writeOne(IpVersion object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<IpVersion> list, XmlWriter writer) {
        writeMany(list, "ip_version", "ip_versions", writer);
    }
    
    public static void writeMany(Iterator<IpVersion> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIpVersionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

