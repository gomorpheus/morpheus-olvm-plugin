/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MacPool;

public class XmlMacPoolWriter {
    
    public static void writeOne(MacPool object, XmlWriter writer) {
        writeOne(object, "mac_pool", writer);
    }
    
    public static void writeOne(MacPool object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.allowDuplicatesPresent()) {
            writer.writeBoolean("allow_duplicates", object.allowDuplicates());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.defaultPoolPresent()) {
            writer.writeBoolean("default_pool", object.defaultPool());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.rangesPresent()) {
            XmlRangeWriter.writeMany(object.ranges().iterator(), "range", "ranges", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MacPool> list, XmlWriter writer) {
        writeMany(list, "mac_pool", "mac_pools", writer);
    }
    
    public static void writeMany(Iterator<MacPool> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMacPoolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

