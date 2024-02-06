/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CpuTune;

public class XmlCpuTuneWriter {
    
    public static void writeOne(CpuTune object, XmlWriter writer) {
        writeOne(object, "cpu_tune", writer);
    }
    
    public static void writeOne(CpuTune object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.vcpuPinsPresent()) {
            XmlVcpuPinWriter.writeMany(object.vcpuPins().iterator(), "vcpu_pin", "vcpu_pins", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CpuTune> list, XmlWriter writer) {
        writeMany(list, "cpu_tune", "cpu_tunes", writer);
    }
    
    public static void writeMany(Iterator<CpuTune> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuTuneWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

