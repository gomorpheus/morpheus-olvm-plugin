/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.InitializationContainer;
import org.ovirt.engine.sdk4.types.Initialization;

public class XmlInitializationReader {
    
    public static Initialization readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        InitializationContainer object = new InitializationContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "active_directory_ou":
                object.activeDirectoryOu(reader.readString());
                break;
                case "authorized_ssh_keys":
                object.authorizedSshKeys(reader.readString());
                break;
                case "cloud_init":
                object.cloudInit(XmlCloudInitReader.readOne(reader));
                break;
                case "cloud_init_network_protocol":
                object.cloudInitNetworkProtocol(XmlCloudInitNetworkProtocolReader.readOne(reader));
                break;
                case "configuration":
                object.configuration(XmlConfigurationReader.readOne(reader));
                break;
                case "custom_script":
                object.customScript(reader.readString());
                break;
                case "dns_search":
                object.dnsSearch(reader.readString());
                break;
                case "dns_servers":
                object.dnsServers(reader.readString());
                break;
                case "domain":
                object.domain(reader.readString());
                break;
                case "host_name":
                object.hostName(reader.readString());
                break;
                case "input_locale":
                object.inputLocale(reader.readString());
                break;
                case "nic_configurations":
                object.nicConfigurations(XmlNicConfigurationReader.readMany(reader));
                break;
                case "org_name":
                object.orgName(reader.readString());
                break;
                case "regenerate_ids":
                object.regenerateIds(reader.readBoolean());
                break;
                case "regenerate_ssh_keys":
                object.regenerateSshKeys(reader.readBoolean());
                break;
                case "root_password":
                object.rootPassword(reader.readString());
                break;
                case "system_locale":
                object.systemLocale(reader.readString());
                break;
                case "timezone":
                object.timezone(reader.readString());
                break;
                case "ui_language":
                object.uiLanguage(reader.readString());
                break;
                case "user_locale":
                object.userLocale(reader.readString());
                break;
                case "user_name":
                object.userName(reader.readString());
                break;
                case "windows_license_key":
                object.windowsLicenseKey(reader.readString());
                break;
                case "link":
                // Process the attributes:
                String rel = reader.getAttributeValue("rel");
                String href = reader.getAttributeValue("href");
                if (rel != null && href != null) {
                    links.add(new String[]{rel, href});
                }
                reader.skip();
                break;
                default:
                reader.skip();
                break;
            }
        }
        if (links != null) {
            for (String[] link : links) {
                processLink(object, link);
            }
        }
        
        // Discard the end tag:
        reader.next();
        
        return object;
    }
    
    public static Iterator<Initialization> iterateMany(final XmlReader reader) {
        return new Iterator<Initialization>() {
            private boolean first = true;
            
            @Override
            public void remove() {
                // Empty on purpose
            }
            
            @Override
            public boolean hasNext() {
                if (first) {
                    if (!reader.forward()) {
                        return false;
                    }
                    reader.next();
                    first = false;
                }
                if (!reader.forward()) {
                    reader.next();
                    return false;
                }
                return true;
            }
            
            @Override
            public Initialization next() {
                Initialization next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Initialization> readMany(XmlReader reader) {
        List<Initialization> list = new ArrayList<>();
        Iterator<Initialization> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(InitializationContainer object, String[] link) {
    }
}

