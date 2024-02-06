/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Kernel;

public class XmlKernelWriter {
    
    public static void writeOne(Kernel object, XmlWriter writer) {
        writeOne(object, "kernel", writer);
    }
    
    public static void writeOne(Kernel object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Kernel> list, XmlWriter writer) {
        writeMany(list, "kernel", "kernels", writer);
    }
    
    public static void writeMany(Iterator<Kernel> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlKernelWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

