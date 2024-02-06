/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PowerManagementStatus;

public class XmlPowerManagementStatusWriter {
    
    public static void writeOne(PowerManagementStatus object, XmlWriter writer) {
        writeOne(object, "power_management_status", writer);
    }
    
    public static void writeOne(PowerManagementStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<PowerManagementStatus> list, XmlWriter writer) {
        writeMany(list, "power_management_status", "power_management_statuss", writer);
    }
    
    public static void writeMany(Iterator<PowerManagementStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPowerManagementStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

