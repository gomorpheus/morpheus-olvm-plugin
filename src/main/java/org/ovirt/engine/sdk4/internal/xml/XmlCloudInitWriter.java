/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CloudInit;

public class XmlCloudInitWriter {
    
    public static void writeOne(CloudInit object, XmlWriter writer) {
        writeOne(object, "cloud_init", writer);
    }
    
    public static void writeOne(CloudInit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.authorizedKeysPresent()) {
            XmlAuthorizedKeyWriter.writeMany(object.authorizedKeys().iterator(), "authorized_key", "authorized_keys", writer);
        }
        if (object.filesPresent()) {
            XmlFileWriter.writeMany(object.files().iterator(), "file", "files", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.networkConfigurationPresent()) {
            XmlNetworkConfigurationWriter.writeOne(object.networkConfiguration(), "network_configuration", writer);
        }
        if (object.regenerateSshKeysPresent()) {
            writer.writeBoolean("regenerate_ssh_keys", object.regenerateSshKeys());
        }
        if (object.timezonePresent()) {
            writer.writeElement("timezone", object.timezone());
        }
        if (object.usersPresent()) {
            XmlUserWriter.writeMany(object.users().iterator(), "user", "users", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<CloudInit> list, XmlWriter writer) {
        writeMany(list, "cloud_init", "cloud_inits", writer);
    }
    
    public static void writeMany(Iterator<CloudInit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCloudInitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

