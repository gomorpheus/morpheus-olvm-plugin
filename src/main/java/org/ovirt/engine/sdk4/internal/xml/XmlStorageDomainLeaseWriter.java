/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageDomainLease;

public class XmlStorageDomainLeaseWriter {
    
    public static void writeOne(StorageDomainLease object, XmlWriter writer) {
        writeOne(object, "storage_domain_lease", writer);
    }
    
    public static void writeOne(StorageDomainLease object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<StorageDomainLease> list, XmlWriter writer) {
        writeMany(list, "storage_domain_lease", "storage_domain_leases", writer);
    }
    
    public static void writeMany(Iterator<StorageDomainLease> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageDomainLeaseWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

