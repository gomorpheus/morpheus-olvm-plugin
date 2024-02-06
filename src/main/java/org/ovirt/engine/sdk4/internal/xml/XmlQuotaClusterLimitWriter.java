/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.QuotaClusterLimit;

public class XmlQuotaClusterLimitWriter {
    
    public static void writeOne(QuotaClusterLimit object, XmlWriter writer) {
        writeOne(object, "quota_cluster_limit", writer);
    }
    
    public static void writeOne(QuotaClusterLimit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.memoryLimitPresent()) {
            writer.writeDecimal("memory_limit", object.memoryLimit());
        }
        if (object.memoryUsagePresent()) {
            writer.writeDecimal("memory_usage", object.memoryUsage());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.vcpuLimitPresent()) {
            writer.writeInteger("vcpu_limit", object.vcpuLimit());
        }
        if (object.vcpuUsagePresent()) {
            writer.writeInteger("vcpu_usage", object.vcpuUsage());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<QuotaClusterLimit> list, XmlWriter writer) {
        writeMany(list, "quota_cluster_limit", "quota_cluster_limits", writer);
    }
    
    public static void writeMany(Iterator<QuotaClusterLimit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQuotaClusterLimitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

