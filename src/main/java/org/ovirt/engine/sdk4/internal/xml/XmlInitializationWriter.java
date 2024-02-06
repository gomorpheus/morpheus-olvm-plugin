/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Initialization;

public class XmlInitializationWriter {
    
    public static void writeOne(Initialization object, XmlWriter writer) {
        writeOne(object, "initialization", writer);
    }
    
    public static void writeOne(Initialization object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.activeDirectoryOuPresent()) {
            writer.writeElement("active_directory_ou", object.activeDirectoryOu());
        }
        if (object.authorizedSshKeysPresent()) {
            writer.writeElement("authorized_ssh_keys", object.authorizedSshKeys());
        }
        if (object.cloudInitPresent()) {
            XmlCloudInitWriter.writeOne(object.cloudInit(), "cloud_init", writer);
        }
        if (object.cloudInitNetworkProtocolPresent()) {
            XmlCloudInitNetworkProtocolWriter.writeOne(object.cloudInitNetworkProtocol(), "cloud_init_network_protocol", writer);
        }
        if (object.configurationPresent()) {
            XmlConfigurationWriter.writeOne(object.configuration(), "configuration", writer);
        }
        if (object.customScriptPresent()) {
            writer.writeElement("custom_script", object.customScript());
        }
        if (object.dnsSearchPresent()) {
            writer.writeElement("dns_search", object.dnsSearch());
        }
        if (object.dnsServersPresent()) {
            writer.writeElement("dns_servers", object.dnsServers());
        }
        if (object.domainPresent()) {
            writer.writeElement("domain", object.domain());
        }
        if (object.hostNamePresent()) {
            writer.writeElement("host_name", object.hostName());
        }
        if (object.inputLocalePresent()) {
            writer.writeElement("input_locale", object.inputLocale());
        }
        if (object.nicConfigurationsPresent()) {
            XmlNicConfigurationWriter.writeMany(object.nicConfigurations().iterator(), "nic_configuration", "nic_configurations", writer);
        }
        if (object.orgNamePresent()) {
            writer.writeElement("org_name", object.orgName());
        }
        if (object.regenerateIdsPresent()) {
            writer.writeBoolean("regenerate_ids", object.regenerateIds());
        }
        if (object.regenerateSshKeysPresent()) {
            writer.writeBoolean("regenerate_ssh_keys", object.regenerateSshKeys());
        }
        if (object.rootPasswordPresent()) {
            writer.writeElement("root_password", object.rootPassword());
        }
        if (object.systemLocalePresent()) {
            writer.writeElement("system_locale", object.systemLocale());
        }
        if (object.timezonePresent()) {
            writer.writeElement("timezone", object.timezone());
        }
        if (object.uiLanguagePresent()) {
            writer.writeElement("ui_language", object.uiLanguage());
        }
        if (object.userLocalePresent()) {
            writer.writeElement("user_locale", object.userLocale());
        }
        if (object.userNamePresent()) {
            writer.writeElement("user_name", object.userName());
        }
        if (object.windowsLicenseKeyPresent()) {
            writer.writeElement("windows_license_key", object.windowsLicenseKey());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Initialization> list, XmlWriter writer) {
        writeMany(list, "initialization", "initializations", writer);
    }
    
    public static void writeMany(Iterator<Initialization> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlInitializationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

