/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;

public class XmlQuotaStorageLimitWriter {
    
    public static void writeOne(QuotaStorageLimit object, XmlWriter writer) {
        writeOne(object, "quota_storage_limit", writer);
    }
    
    public static void writeOne(QuotaStorageLimit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.limitPresent()) {
            writer.writeInteger("limit", object.limit());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.usagePresent()) {
            writer.writeDecimal("usage", object.usage());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<QuotaStorageLimit> list, XmlWriter writer) {
        writeMany(list, "quota_storage_limit", "quota_storage_limits", writer);
    }
    
    public static void writeMany(Iterator<QuotaStorageLimit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQuotaStorageLimitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

