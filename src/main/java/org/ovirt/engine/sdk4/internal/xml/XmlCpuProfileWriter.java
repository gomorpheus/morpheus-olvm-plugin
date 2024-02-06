/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CpuProfile;

public class XmlCpuProfileWriter {
    
    public static void writeOne(CpuProfile object, XmlWriter writer) {
        writeOne(object, "cpu_profile", writer);
    }
    
    public static void writeOne(CpuProfile object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
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
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CpuProfile> list, XmlWriter writer) {
        writeMany(list, "cpu_profile", "cpu_profiles", writer);
    }
    
    public static void writeMany(Iterator<CpuProfile> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCpuProfileWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

