/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationClusterMapping;

public class XmlRegistrationClusterMappingWriter {
    
    public static void writeOne(RegistrationClusterMapping object, XmlWriter writer) {
        writeOne(object, "registration_cluster_mapping", writer);
    }
    
    public static void writeOne(RegistrationClusterMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlClusterWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlClusterWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationClusterMapping> list, XmlWriter writer) {
        writeMany(list, "registration_cluster_mapping", "registration_cluster_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationClusterMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationClusterMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

