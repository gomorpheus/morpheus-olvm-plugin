/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DataCenterStatus;

public class XmlDataCenterStatusWriter {
    
    public static void writeOne(DataCenterStatus object, XmlWriter writer) {
        writeOne(object, "data_center_status", writer);
    }
    
    public static void writeOne(DataCenterStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<DataCenterStatus> list, XmlWriter writer) {
        writeMany(list, "data_center_status", "data_center_statuss", writer);
    }
    
    public static void writeMany(Iterator<DataCenterStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDataCenterStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

