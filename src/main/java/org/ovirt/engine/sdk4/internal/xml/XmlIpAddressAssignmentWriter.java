/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.IpAddressAssignment;

public class XmlIpAddressAssignmentWriter {
    
    public static void writeOne(IpAddressAssignment object, XmlWriter writer) {
        writeOne(object, "ip_address_assignment", writer);
    }
    
    public static void writeOne(IpAddressAssignment object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.assignmentMethodPresent()) {
            XmlBootProtocolWriter.writeOne(object.assignmentMethod(), "assignment_method", writer);
        }
        if (object.ipPresent()) {
            XmlIpWriter.writeOne(object.ip(), "ip", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<IpAddressAssignment> list, XmlWriter writer) {
        writeMany(list, "ip_address_assignment", "ip_address_assignments", writer);
    }
    
    public static void writeMany(Iterator<IpAddressAssignment> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIpAddressAssignmentWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

