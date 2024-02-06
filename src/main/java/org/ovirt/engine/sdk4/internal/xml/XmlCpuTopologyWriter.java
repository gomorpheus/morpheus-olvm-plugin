/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CpuTopology;

public class XmlCpuTopologyWriter {
    
    public static void writeOne(CpuTopology object, XmlWriter writer) {
        writeOne(object, "cpu_topology", writer);
    }
    
    public static void writeOne(CpuTopology object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.coresPresent()) {
            writer.writeInteger("cores", object.cores());
        }
        if (object.socketsPresent()) {
            writer.writeInteger("sockets", object.sockets());
        }
        if (object.threadsPresent()) {
            writer.writeInteger("threads", object.threads());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CpuTopology> list, XmlWriter writer) {
        writeMany(list, "cpu_topology", "cpu_topologies", writer);
    }
    
    public static void writeMany(Iterator<CpuTopology> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuTopologyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

