/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AffinityRule;

public class XmlAffinityRuleWriter {
    
    public static void writeOne(AffinityRule object, XmlWriter writer) {
        writeOne(object, "affinity_rule", writer);
    }
    
    public static void writeOne(AffinityRule object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.enforcingPresent()) {
            writer.writeBoolean("enforcing", object.enforcing());
        }
        if (object.positivePresent()) {
            writer.writeBoolean("positive", object.positive());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<AffinityRule> list, XmlWriter writer) {
        writeMany(list, "affinity_rule", "affinity_rules", writer);
    }
    
    public static void writeMany(Iterator<AffinityRule> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAffinityRuleWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

