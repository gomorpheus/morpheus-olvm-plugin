/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ApiSummary;

public class XmlApiSummaryWriter {
    
    public static void writeOne(ApiSummary object, XmlWriter writer) {
        writeOne(object, "api_summary", writer);
    }
    
    public static void writeOne(ApiSummary object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hostsPresent()) {
            XmlApiSummaryItemWriter.writeOne(object.hosts(), "hosts", writer);
        }
        if (object.storageDomainsPresent()) {
            XmlApiSummaryItemWriter.writeOne(object.storageDomains(), "storage_domains", writer);
        }
        if (object.usersPresent()) {
            XmlApiSummaryItemWriter.writeOne(object.users(), "users", writer);
        }
        if (object.vmsPresent()) {
            XmlApiSummaryItemWriter.writeOne(object.vms(), "vms", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ApiSummary> list, XmlWriter writer) {
        writeMany(list, "api_summary", "api_summaries", writer);
    }
    
    public static void writeMany(Iterator<ApiSummary> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlApiSummaryWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

