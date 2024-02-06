/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RngDevice;

public class XmlRngDeviceWriter {
    
    public static void writeOne(RngDevice object, XmlWriter writer) {
        writeOne(object, "rng_device", writer);
    }
    
    public static void writeOne(RngDevice object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.ratePresent()) {
            XmlRateWriter.writeOne(object.rate(), "rate", writer);
        }
        if (object.sourcePresent()) {
            XmlRngSourceWriter.writeOne(object.source(), "source", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RngDevice> list, XmlWriter writer) {
        writeMany(list, "rng_device", "rng_devices", writer);
    }
    
    public static void writeMany(Iterator<RngDevice> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRngDeviceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

