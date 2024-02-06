/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;

public class XmlGuestOperatingSystemWriter {
    
    public static void writeOne(GuestOperatingSystem object, XmlWriter writer) {
        writeOne(object, "guest_operating_system", writer);
    }
    
    public static void writeOne(GuestOperatingSystem object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.architecturePresent()) {
            writer.writeElement("architecture", object.architecture());
        }
        if (object.codenamePresent()) {
            writer.writeElement("codename", object.codename());
        }
        if (object.distributionPresent()) {
            writer.writeElement("distribution", object.distribution());
        }
        if (object.familyPresent()) {
            writer.writeElement("family", object.family());
        }
        if (object.kernelPresent()) {
            XmlKernelWriter.writeOne(object.kernel(), "kernel", writer);
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GuestOperatingSystem> list, XmlWriter writer) {
        writeMany(list, "guest_operating_system", "guest_operating_systems", writer);
    }
    
    public static void writeMany(Iterator<GuestOperatingSystem> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGuestOperatingSystemWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

