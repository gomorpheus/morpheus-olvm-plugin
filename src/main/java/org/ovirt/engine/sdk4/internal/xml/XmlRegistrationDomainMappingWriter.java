/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationDomainMapping;

public class XmlRegistrationDomainMappingWriter {
    
    public static void writeOne(RegistrationDomainMapping object, XmlWriter writer) {
        writeOne(object, "registration_domain_mapping", writer);
    }
    
    public static void writeOne(RegistrationDomainMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlDomainWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlDomainWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationDomainMapping> list, XmlWriter writer) {
        writeMany(list, "registration_domain_mapping", "registration_domain_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationDomainMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationDomainMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

