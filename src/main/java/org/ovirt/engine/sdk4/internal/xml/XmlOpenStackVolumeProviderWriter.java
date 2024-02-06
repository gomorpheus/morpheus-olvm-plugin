/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;

public class XmlOpenStackVolumeProviderWriter {
    
    public static void writeOne(OpenStackVolumeProvider object, XmlWriter writer) {
        writeOne(object, "openstack_volume_provider", writer);
    }
    
    public static void writeOne(OpenStackVolumeProvider object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.authenticationKeysPresent()) {
            XmlOpenstackVolumeAuthenticationKeyWriter.writeMany(object.authenticationKeys().iterator(), "openstack_volume_authentication_key", "authentication_keys", writer);
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
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
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
        if (object.tenantNamePresent()) {
            writer.writeElement("tenant_name", object.tenantName());
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        if (object.volumeTypesPresent()) {
            XmlOpenStackVolumeTypeWriter.writeMany(object.volumeTypes().iterator(), "open_stack_volume_type", "volume_types", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackVolumeProvider> list, XmlWriter writer) {
        writeMany(list, "openstack_volume_provider", "openstack_volume_providers", writer);
    }
    
    public static void writeMany(Iterator<OpenStackVolumeProvider> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackVolumeProviderWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

