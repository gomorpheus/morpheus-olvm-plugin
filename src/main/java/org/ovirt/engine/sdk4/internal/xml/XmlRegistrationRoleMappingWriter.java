/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationRoleMapping;

public class XmlRegistrationRoleMappingWriter {
    
    public static void writeOne(RegistrationRoleMapping object, XmlWriter writer) {
        writeOne(object, "registration_role_mapping", writer);
    }
    
    public static void writeOne(RegistrationRoleMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.fromPresent()) {
            XmlRoleWriter.writeOne(object.from(), "from", writer);
        }
        if (object.toPresent()) {
            XmlRoleWriter.writeOne(object.to(), "to", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationRoleMapping> list, XmlWriter writer) {
        writeMany(list, "registration_role_mapping", "registration_role_mappings", writer);
    }
    
    public static void writeMany(Iterator<RegistrationRoleMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationRoleMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

