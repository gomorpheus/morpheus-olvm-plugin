/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageDomainStatus;

public class XmlStorageDomainStatusWriter {
    
    public static void writeOne(StorageDomainStatus object, XmlWriter writer) {
        writeOne(object, "storage_domain_status", writer);
    }
    
    public static void writeOne(StorageDomainStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<StorageDomainStatus> list, XmlWriter writer) {
        writeMany(list, "storage_domain_status", "storage_domain_statuss", writer);
    }
    
    public static void writeMany(Iterator<StorageDomainStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageDomainStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

