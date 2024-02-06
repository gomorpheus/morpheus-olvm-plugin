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
import org.ovirt.engine.sdk4.internal.containers.CloudInitContainer;
import org.ovirt.engine.sdk4.types.CloudInit;

public class XmlCloudInitReader {
    
    public static CloudInit readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        CloudInitContainer object = new CloudInitContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "authorized_keys":
                object.authorizedKeys(XmlAuthorizedKeyReader.readMany(reader));
                break;
                case "files":
                object.files(XmlFileReader.readMany(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "network_configuration":
                object.networkConfiguration(XmlNetworkConfigurationReader.readOne(reader));
                break;
                case "regenerate_ssh_keys":
                object.regenerateSshKeys(reader.readBoolean());
                break;
                case "timezone":
                object.timezone(reader.readString());
                break;
                case "users":
                object.users(XmlUserReader.readMany(reader));
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
    
    public static Iterator<CloudInit> iterateMany(final XmlReader reader) {
        return new Iterator<CloudInit>() {
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
            public CloudInit next() {
                CloudInit next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<CloudInit> readMany(XmlReader reader) {
        List<CloudInit> list = new ArrayList<>();
        Iterator<CloudInit> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(CloudInitContainer object, String[] link) {
    }
}

