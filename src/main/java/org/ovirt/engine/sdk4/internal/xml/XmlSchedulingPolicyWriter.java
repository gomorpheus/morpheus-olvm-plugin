/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SchedulingPolicy;

public class XmlSchedulingPolicyWriter {
    
    public static void writeOne(SchedulingPolicy object, XmlWriter writer) {
        writeOne(object, "scheduling_policy", writer);
    }
    
    public static void writeOne(SchedulingPolicy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.balancesPresent()) {
            XmlBalanceWriter.writeMany(object.balances().iterator(), "balance", "balances", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.defaultPolicyPresent()) {
            writer.writeBoolean("default_policy", object.defaultPolicy());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.filtersPresent()) {
            XmlFilterWriter.writeMany(object.filters().iterator(), "filter", "filters", writer);
        }
        if (object.lockedPresent()) {
            writer.writeBoolean("locked", object.locked());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.weightPresent()) {
            XmlWeightWriter.writeMany(object.weight().iterator(), "weight", "weight", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SchedulingPolicy> list, XmlWriter writer) {
        writeMany(list, "scheduling_policy", "scheduling_policies", writer);
    }
    
    public static void writeMany(Iterator<SchedulingPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSchedulingPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

