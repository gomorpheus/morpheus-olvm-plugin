/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.User;

public class XmlUserWriter {
    
    public static void writeOne(User object, XmlWriter writer) {
        writeOne(object, "user", writer);
    }
    
    public static void writeOne(User object, String tag, XmlWriter writer) {
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
        if (object.departmentPresent()) {
            writer.writeElement("department", object.department());
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
        if (object.emailPresent()) {
            writer.writeElement("email", object.email());
        }
        if (object.groupsPresent()) {
            XmlGroupWriter.writeMany(object.groups().iterator(), "group", "groups", writer);
        }
        if (object.lastNamePresent()) {
            writer.writeElement("last_name", object.lastName());
        }
        if (object.loggedInPresent()) {
            writer.writeBoolean("logged_in", object.loggedIn());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.namespacePresent()) {
            writer.writeElement("namespace", object.namespace());
        }
        if (object.optionsPresent()) {
            XmlUserOptionWriter.writeMany(object.options().iterator(), "user_option", "options", writer);
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.principalPresent()) {
            writer.writeElement("principal", object.principal());
        }
        if (object.rolesPresent()) {
            XmlRoleWriter.writeMany(object.roles().iterator(), "role", "roles", writer);
        }
        if (object.sshPublicKeysPresent()) {
            XmlSshPublicKeyWriter.writeMany(object.sshPublicKeys().iterator(), "ssh_public_key", "ssh_public_keys", writer);
        }
        if (object.tagsPresent()) {
            XmlTagWriter.writeMany(object.tags().iterator(), "tag", "tags", writer);
        }
        if (object.userNamePresent()) {
            writer.writeElement("user_name", object.userName());
        }
        if (object.userOptionsPresent()) {
            XmlPropertyWriter.writeMany(object.userOptions().iterator(), "property", "user_options", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<User> list, XmlWriter writer) {
        writeMany(list, "user", "users", writer);
    }
    
    public static void writeMany(Iterator<User> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlUserWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

