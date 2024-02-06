/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Permission;

public class XmlPermissionWriter {
    
    public static void writeOne(Permission object, XmlWriter writer) {
        writeOne(object, "permission", writer);
    }
    
    public static void writeOne(Permission object, String tag, XmlWriter writer) {
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
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.diskPresent()) {
            XmlDiskWriter.writeOne(object.disk(), "disk", writer);
        }
        if (object.groupPresent()) {
            XmlGroupWriter.writeOne(object.group(), "group", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.rolePresent()) {
            XmlRoleWriter.writeOne(object.role(), "role", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.userPresent()) {
            XmlUserWriter.writeOne(object.user(), "user", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmPoolPresent()) {
            XmlVmPoolWriter.writeOne(object.vmPool(), "vm_pool", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Permission> list, XmlWriter writer) {
        writeMany(list, "permission", "permissions", writer);
    }
    
    public static void writeMany(Iterator<Permission> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPermissionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

