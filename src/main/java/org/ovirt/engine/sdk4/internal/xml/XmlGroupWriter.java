/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Group;

public class XmlGroupWriter {
    
    public static void writeOne(Group object, XmlWriter writer) {
        writeOne(object, "group", writer);
    }
    
    public static void writeOne(Group object, String tag, XmlWriter writer) {
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
        if (object.domainPresent()) {
            XmlDomainWriter.writeOne(object.domain(), "domain", writer);
        }
        if (object.domainEntryIdPresent()) {
            writer.writeElement("domain_entry_id", object.domainEntryId());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.namespacePresent()) {
            writer.writeElement("namespace", object.namespace());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.rolesPresent()) {
            XmlRoleWriter.writeMany(object.roles().iterator(), "role", "roles", writer);
        }
        if (object.tagsPresent()) {
            XmlTagWriter.writeMany(object.tags().iterator(), "tag", "tags", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Group> list, XmlWriter writer) {
        writeMany(list, "group", "groups", writer);
    }
    
    public static void writeMany(Iterator<Group> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGroupWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

