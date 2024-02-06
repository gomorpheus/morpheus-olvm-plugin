/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OperatingSystem;

public class XmlOperatingSystemWriter {
    
    public static void writeOne(OperatingSystem object, XmlWriter writer) {
        writeOne(object, "os", writer);
    }
    
    public static void writeOne(OperatingSystem object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.bootPresent()) {
            XmlBootWriter.writeOne(object.boot(), "boot", writer);
        }
        if (object.cmdlinePresent()) {
            writer.writeElement("cmdline", object.cmdline());
        }
        if (object.customKernelCmdlinePresent()) {
            writer.writeElement("custom_kernel_cmdline", object.customKernelCmdline());
        }
        if (object.initrdPresent()) {
            writer.writeElement("initrd", object.initrd());
        }
        if (object.kernelPresent()) {
            writer.writeElement("kernel", object.kernel());
        }
        if (object.reportedKernelCmdlinePresent()) {
            writer.writeElement("reported_kernel_cmdline", object.reportedKernelCmdline());
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OperatingSystem> list, XmlWriter writer) {
        writeMany(list, "os", "oss", writer);
    }
    
    public static void writeMany(Iterator<OperatingSystem> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOperatingSystemWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

