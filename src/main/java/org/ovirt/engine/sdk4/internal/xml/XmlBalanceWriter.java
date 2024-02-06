/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Balance;

public class XmlBalanceWriter {
    
    public static void writeOne(Balance object, XmlWriter writer) {
        writeOne(object, "balance", writer);
    }
    
    public static void writeOne(Balance object, String tag, XmlWriter writer) {
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
        if (object.schedulingPolicyPresent()) {
            XmlSchedulingPolicyWriter.writeOne(object.schedulingPolicy(), "scheduling_policy", writer);
        }
        if (object.schedulingPolicyUnitPresent()) {
            XmlSchedulingPolicyUnitWriter.writeOne(object.schedulingPolicyUnit(), "scheduling_policy_unit", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Balance> list, XmlWriter writer) {
        writeMany(list, "balance", "balances", writer);
    }
    
    public static void writeMany(Iterator<Balance> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBalanceWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

