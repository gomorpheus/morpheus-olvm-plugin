/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Cpu;

public class XmlCpuWriter {
    
    public static void writeOne(Cpu object, XmlWriter writer) {
        writeOne(object, "cpu", writer);
    }
    
    public static void writeOne(Cpu object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.architecturePresent()) {
            XmlArchitectureWriter.writeOne(object.architecture(), "architecture", writer);
        }
        if (object.coresPresent()) {
            XmlCoreWriter.writeMany(object.cores().iterator(), "core", "cores", writer);
        }
        if (object.cpuTunePresent()) {
            XmlCpuTuneWriter.writeOne(object.cpuTune(), "cpu_tune", writer);
        }
        if (object.levelPresent()) {
            writer.writeInteger("level", object.level());
        }
        if (object.modePresent()) {
            XmlCpuModeWriter.writeOne(object.mode(), "mode", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.speedPresent()) {
            writer.writeDecimal("speed", object.speed());
        }
        if (object.topologyPresent()) {
            XmlCpuTopologyWriter.writeOne(object.topology(), "topology", writer);
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Cpu> list, XmlWriter writer) {
        writeMany(list, "cpu", "cpus", writer);
    }
    
    public static void writeMany(Iterator<Cpu> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

