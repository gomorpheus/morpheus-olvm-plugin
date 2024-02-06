/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RngSource;

public class XmlRngSourceWriter {
    
    public static void writeOne(RngSource object, XmlWriter writer) {
        writeOne(object, "rng_source", writer);
    }
    
    public static void writeOne(RngSource object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<RngSource> list, XmlWriter writer) {
        writeMany(list, "rng_source", "rng_sources", writer);
    }
    
    public static void writeMany(Iterator<RngSource> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRngSourceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

