/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationLunMapping;

public class XmlRegistrationLunMappingWriter {
    
    public static void writeOne(RegistrationLunMapping object, XmlWriter writer) {
        writeOne(object, "registration_lun_mapping", writer);
    }
    
    public static void writeOne(RegistrationLunMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlDiskWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlDiskWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationLunMapping> list, XmlWriter writer) {
        writeMany(list, "registration_lun_mapping", "registration_lun_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationLunMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationLunMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

