/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Quota;

public class XmlQuotaWriter {
    
    public static void writeOne(Quota object, XmlWriter writer) {
        writeOne(object, "quota", writer);
    }
    
    public static void writeOne(Quota object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterHardLimitPctPresent()) {
            writer.writeInteger("cluster_hard_limit_pct", object.clusterHardLimitPct());
        }
        if (object.clusterSoftLimitPctPresent()) {
            writer.writeInteger("cluster_soft_limit_pct", object.clusterSoftLimitPct());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.disksPresent()) {
            XmlDiskWriter.writeMany(object.disks().iterator(), "disk", "disks", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.quotaClusterLimitsPresent()) {
            XmlQuotaClusterLimitWriter.writeMany(object.quotaClusterLimits().iterator(), "quota_cluster_limit", "quota_cluster_limits", writer);
        }
        if (object.quotaStorageLimitsPresent()) {
            XmlQuotaStorageLimitWriter.writeMany(object.quotaStorageLimits().iterator(), "quota_storage_limit", "quota_storage_limits", writer);
        }
        if (object.storageHardLimitPctPresent()) {
            writer.writeInteger("storage_hard_limit_pct", object.storageHardLimitPct());
        }
        if (object.storageSoftLimitPctPresent()) {
            writer.writeInteger("storage_soft_limit_pct", object.storageSoftLimitPct());
        }
        if (object.usersPresent()) {
            XmlUserWriter.writeMany(object.users().iterator(), "user", "users", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Quota> list, XmlWriter writer) {
        writeMany(list, "quota", "quotas", writer);
    }
    
    public static void writeMany(Iterator<Quota> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQuotaWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

