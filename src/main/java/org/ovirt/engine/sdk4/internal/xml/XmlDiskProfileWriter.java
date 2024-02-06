/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DiskProfile;

public class XmlDiskProfileWriter {
    
    public static void writeOne(DiskProfile object, XmlWriter writer) {
        writeOne(object, "disk_profile", writer);
    }
    
    public static void writeOne(DiskProfile object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
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
        if (object.qosPresent()) {
            XmlQosWriter.writeOne(object.qos(), "qos", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<DiskProfile> list, XmlWriter writer) {
        writeMany(list, "disk_profile", "disk_profiles", writer);
    }
    
    public static void writeMany(Iterator<DiskProfile> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDiskProfileWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

