/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationVnicProfileMapping;

public class XmlRegistrationVnicProfileMappingWriter {
    
    public static void writeOne(RegistrationVnicProfileMapping object, XmlWriter writer) {
        writeOne(object, "registration_vnic_profile_mapping", writer);
    }
    
    public static void writeOne(RegistrationVnicProfileMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlVnicProfileWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlVnicProfileWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationVnicProfileMapping> list, XmlWriter writer) {
        writeMany(list, "registration_vnic_profile_mapping", "registration_vnic_profile_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationVnicProfileMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationVnicProfileMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

