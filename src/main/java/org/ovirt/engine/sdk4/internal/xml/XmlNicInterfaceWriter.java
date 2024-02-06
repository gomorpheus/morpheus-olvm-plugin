/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NicInterface;

public class XmlNicInterfaceWriter {
    
    public static void writeOne(NicInterface object, XmlWriter writer) {
        writeOne(object, "nic_interface", writer);
    }
    
    public static void writeOne(NicInterface object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<NicInterface> list, XmlWriter writer) {
        writeMany(list, "nic_interface", "nic_interfaces", writer);
    }
    
    public static void writeMany(Iterator<NicInterface> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNicInterfaceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

