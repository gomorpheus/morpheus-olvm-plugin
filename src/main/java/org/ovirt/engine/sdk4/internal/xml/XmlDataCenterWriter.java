/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.DataCenter;

public class XmlDataCenterWriter {
    
    public static void writeOne(DataCenter object, XmlWriter writer) {
        writeOne(object, "data_center", writer);
    }
    
    public static void writeOne(DataCenter object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clustersPresent()) {
            XmlClusterWriter.writeMany(object.clusters().iterator(), "cluster", "clusters", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.iscsiBondsPresent()) {
            XmlIscsiBondWriter.writeMany(object.iscsiBonds().iterator(), "iscsi_bond", "iscsi_bonds", writer);
        }
        if (object.localPresent()) {
            writer.writeBoolean("local", object.local());
        }
        if (object.macPoolPresent()) {
            XmlMacPoolWriter.writeOne(object.macPool(), "mac_pool", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networksPresent()) {
            XmlNetworkWriter.writeMany(object.networks().iterator(), "network", "networks", writer);
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.qossPresent()) {
            XmlQosWriter.writeMany(object.qoss().iterator(), "qos", "qoss", writer);
        }
        if (object.quotaModePresent()) {
            XmlQuotaModeTypeWriter.writeOne(object.quotaMode(), "quota_mode", writer);
        }
        if (object.quotasPresent()) {
            XmlQuotaWriter.writeMany(object.quotas().iterator(), "quota", "quotas", writer);
        }
        if (object.statusPresent()) {
            XmlDataCenterStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.storageDomainsPresent()) {
            XmlStorageDomainWriter.writeMany(object.storageDomains().iterator(), "storage_domain", "storage_domains", writer);
        }
        if (object.storageFormatPresent()) {
            XmlStorageFormatWriter.writeOne(object.storageFormat(), "storage_format", writer);
        }
        if (object.supportedVersionsPresent()) {
            XmlVersionWriter.writeMany(object.supportedVersions().iterator(), "version", "supported_versions", writer);
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<DataCenter> list, XmlWriter writer) {
        writeMany(list, "data_center", "data_centers", writer);
    }
    
    public static void writeMany(Iterator<DataCenter> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDataCenterWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

