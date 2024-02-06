/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VnicPassThroughMode;

public class XmlVnicPassThroughModeWriter {
    
    public static void writeOne(VnicPassThroughMode object, XmlWriter writer) {
        writeOne(object, "vnic_pass_through_mode", writer);
    }
    
    public static void writeOne(VnicPassThroughMode object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VnicPassThroughMode> list, XmlWriter writer) {
        writeMany(list, "vnic_pass_through_mode", "vnic_pass_through_modes", writer);
    }
    
    public static void writeMany(Iterator<VnicPassThroughMode> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVnicPassThroughModeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

