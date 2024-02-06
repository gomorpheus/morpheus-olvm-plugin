/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BootMenu;

public class XmlBootMenuWriter {
    
    public static void writeOne(BootMenu object, XmlWriter writer) {
        writeOne(object, "boot_menu", writer);
    }
    
    public static void writeOne(BootMenu object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<BootMenu> list, XmlWriter writer) {
        writeMany(list, "boot_menu", "boot_menus", writer);
    }
    
    public static void writeMany(Iterator<BootMenu> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBootMenuWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

