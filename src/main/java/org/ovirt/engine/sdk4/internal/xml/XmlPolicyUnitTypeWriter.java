/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PolicyUnitType;

public class XmlPolicyUnitTypeWriter {
    
    public static void writeOne(PolicyUnitType object, XmlWriter writer) {
        writeOne(object, "policy_unit_type", writer);
    }
    
    public static void writeOne(PolicyUnitType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<PolicyUnitType> list, XmlWriter writer) {
        writeMany(list, "policy_unit_type", "policy_unit_types", writer);
    }
    
    public static void writeMany(Iterator<PolicyUnitType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPolicyUnitTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

