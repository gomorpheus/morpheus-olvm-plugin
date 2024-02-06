/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationAffinityGroupMapping;

public class XmlRegistrationAffinityGroupMappingWriter {
    
    public static void writeOne(RegistrationAffinityGroupMapping object, XmlWriter writer) {
        writeOne(object, "registration_affinity_group_mapping", writer);
    }
    
    public static void writeOne(RegistrationAffinityGroupMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlAffinityGroupWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlAffinityGroupWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationAffinityGroupMapping> list, XmlWriter writer) {
        writeMany(list, "registration_affinity_group_mapping", "registration_affinity_group_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationAffinityGroupMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationAffinityGroupMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

