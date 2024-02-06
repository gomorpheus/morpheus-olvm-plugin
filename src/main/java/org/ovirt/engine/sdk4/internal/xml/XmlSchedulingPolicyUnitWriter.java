/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SchedulingPolicyUnit;

public class XmlSchedulingPolicyUnitWriter {
    
    public static void writeOne(SchedulingPolicyUnit object, XmlWriter writer) {
        writeOne(object, "scheduling_policy_unit", writer);
    }
    
    public static void writeOne(SchedulingPolicyUnit object, String tag, XmlWriter writer) {
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
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.internalPresent()) {
            writer.writeBoolean("internal", object.internal());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.typePresent()) {
            XmlPolicyUnitTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SchedulingPolicyUnit> list, XmlWriter writer) {
        writeMany(list, "scheduling_policy_unit", "scheduling_policy_units", writer);
    }
    
    public static void writeMany(Iterator<SchedulingPolicyUnit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSchedulingPolicyUnitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

