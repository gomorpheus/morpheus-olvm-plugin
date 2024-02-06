/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationAffinityLabelMapping;

public class XmlRegistrationAffinityLabelMappingWriter {
    
    public static void writeOne(RegistrationAffinityLabelMapping object, XmlWriter writer) {
        writeOne(object, "registration_affinity_label_mapping", writer);
    }
    
    public static void writeOne(RegistrationAffinityLabelMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlAffinityLabelWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlAffinityLabelWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationAffinityLabelMapping> list, XmlWriter writer) {
        writeMany(list, "registration_affinity_label_mapping", "registration_affinity_label_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationAffinityLabelMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationAffinityLabelMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

