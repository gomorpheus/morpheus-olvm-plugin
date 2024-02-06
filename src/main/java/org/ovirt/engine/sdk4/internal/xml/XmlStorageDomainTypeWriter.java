/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageDomainType;

public class XmlStorageDomainTypeWriter {
    
    public static void writeOne(StorageDomainType object, XmlWriter writer) {
        writeOne(object, "storage_domain_type", writer);
    }
    
    public static void writeOne(StorageDomainType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StorageDomainType> list, XmlWriter writer) {
        writeMany(list, "storage_domain_type", "storage_domain_types", writer);
    }
    
    public static void writeMany(Iterator<StorageDomainType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageDomainTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

