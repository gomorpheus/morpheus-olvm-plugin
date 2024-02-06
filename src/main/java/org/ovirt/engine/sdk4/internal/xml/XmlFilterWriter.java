/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Filter;

public class XmlFilterWriter {
    
    public static void writeOne(Filter object, XmlWriter writer) {
        writeOne(object, "filter", writer);
    }
    
    public static void writeOne(Filter object, String tag, XmlWriter writer) {
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
        if (object.positionPresent()) {
            writer.writeInteger("position", object.position());
        }
        if (object.schedulingPolicyUnitPresent()) {
            XmlSchedulingPolicyUnitWriter.writeOne(object.schedulingPolicyUnit(), "scheduling_policy_unit", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Filter> list, XmlWriter writer) {
        writeMany(list, "filter", "filters", writer);
    }
    
    public static void writeMany(Iterator<Filter> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFilterWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

