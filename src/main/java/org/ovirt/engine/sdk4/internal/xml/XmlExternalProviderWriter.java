/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalProvider;

public class XmlExternalProviderWriter {
    
    public static void writeOne(ExternalProvider object, XmlWriter writer) {
        writeOne(object, "external_provider", writer);
    }
    
    public static void writeOne(ExternalProvider object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.authenticationUrlPresent()) {
            writer.writeElement("authentication_url", object.authenticationUrl());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.requiresAuthenticationPresent()) {
            writer.writeBoolean("requires_authentication", object.requiresAuthentication());
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalProvider> list, XmlWriter writer) {
        writeMany(list, "external_provider", "external_providers", writer);
    }
    
    public static void writeMany(Iterator<ExternalProvider> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalProviderWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

