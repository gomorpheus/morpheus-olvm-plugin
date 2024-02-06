/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenStackNetworkProvider;

public class XmlOpenStackNetworkProviderWriter {
    
    public static void writeOne(OpenStackNetworkProvider object, XmlWriter writer) {
        writeOne(object, "openstack_network_provider", writer);
    }
    
    public static void writeOne(OpenStackNetworkProvider object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.agentConfigurationPresent()) {
            XmlAgentConfigurationWriter.writeOne(object.agentConfiguration(), "agent_configuration", writer);
        }
        if (object.authenticationUrlPresent()) {
            writer.writeElement("authentication_url", object.authenticationUrl());
        }
        if (object.autoSyncPresent()) {
            writer.writeBoolean("auto_sync", object.autoSync());
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
        if (object.externalPluginTypePresent()) {
            writer.writeElement("external_plugin_type", object.externalPluginType());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.networksPresent()) {
            XmlOpenStackNetworkWriter.writeMany(object.networks().iterator(), "openstack_network", "networks", writer);
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.pluginTypePresent()) {
            XmlNetworkPluginTypeWriter.writeOne(object.pluginType(), "plugin_type", writer);
        }
        if (object.projectDomainNamePresent()) {
            writer.writeElement("project_domain_name", object.projectDomainName());
        }
        if (object.projectNamePresent()) {
            writer.writeElement("project_name", object.projectName());
        }
        if (object.propertiesPresent()) {
            XmlPropertyWriter.writeMany(object.properties().iterator(), "property", "properties", writer);
        }
        if (object.readOnlyPresent()) {
            writer.writeBoolean("read_only", object.readOnly());
        }
        if (object.requiresAuthenticationPresent()) {
            writer.writeBoolean("requires_authentication", object.requiresAuthentication());
        }
        if (object.subnetsPresent()) {
            XmlOpenStackSubnetWriter.writeMany(object.subnets().iterator(), "openstack_subnet", "subnets", writer);
        }
        if (object.tenantNamePresent()) {
            writer.writeElement("tenant_name", object.tenantName());
        }
        if (object.typePresent()) {
            XmlOpenStackNetworkProviderTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.unmanagedPresent()) {
            writer.writeBoolean("unmanaged", object.unmanaged());
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.userDomainNamePresent()) {
            writer.writeElement("user_domain_name", object.userDomainName());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<OpenStackNetworkProvider> list, XmlWriter writer) {
        writeMany(list, "openstack_network_provider", "openstack_network_providers", writer);
    }
    
    public static void writeMany(Iterator<OpenStackNetworkProvider> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenStackNetworkProviderWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

