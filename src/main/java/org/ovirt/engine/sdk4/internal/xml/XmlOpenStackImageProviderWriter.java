/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public class XmlOpenStackImageProviderWriter {
    
    public static void writeOne(OpenStackImageProvider object, XmlWriter writer) {
        writeOne(object, "openstack_image_provider", writer);
    }
    
    public static void writeOne(OpenStackImageProvider object, String tag, XmlWriter writer) {
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
        if (object.certificatesPresent()) {
            XmlCertificateWriter.writeMany(object.certificates().iterator(), "certificate", "certificates", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.imagesPresent()) {
            XmlOpenStackImageWriter.writeMany(object.images().iterator(), "openstack_image", "images", writer);
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
        if (object.tenantNamePresent()) {
            writer.writeElement("tenant_name", object.tenantName());
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackImageProvider> list, XmlWriter writer) {
        writeMany(list, "openstack_image_provider", "openstack_image_providers", writer);
    }
    
    public static void writeMany(Iterator<OpenStackImageProvider> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackImageProviderWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

