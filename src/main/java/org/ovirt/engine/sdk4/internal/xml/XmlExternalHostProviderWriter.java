/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class XmlExternalHostProviderWriter {
    
    public static void writeOne(ExternalHostProvider object, XmlWriter writer) {
        writeOne(object, "external_host_provider", writer);
    }
    
    public static void writeOne(ExternalHostProvider object, String tag, XmlWriter writer) {
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
        if (object.computeResourcesPresent()) {
            XmlExternalComputeResourceWriter.writeMany(object.computeResources().iterator(), "external_compute_resource", "compute_resources", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.discoveredHostsPresent()) {
            XmlExternalDiscoveredHostWriter.writeMany(object.discoveredHosts().iterator(), "external_discovered_host", "discovered_hosts", writer);
        }
        if (object.hostGroupsPresent()) {
            XmlExternalHostGroupWriter.writeMany(object.hostGroups().iterator(), "external_host_group", "host_groups", writer);
        }
        if (object.hostsPresent()) {
            XmlHostWriter.writeMany(object.hosts().iterator(), "host", "hosts", writer);
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
    
    public static void writeMany(Iterator<ExternalHostProvider> list, XmlWriter writer) {
        writeMany(list, "external_host_provider", "external_host_providers", writer);
    }
    
    public static void writeMany(Iterator<ExternalHostProvider> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalHostProviderWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

