/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NetworkConfiguration;

public class XmlNetworkConfigurationWriter {
    
    public static void writeOne(NetworkConfiguration object, XmlWriter writer) {
        writeOne(object, "network_configuration", writer);
    }
    
    public static void writeOne(NetworkConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.dnsPresent()) {
            XmlDnsWriter.writeOne(object.dns(), "dns", writer);
        }
        if (object.nicsPresent()) {
            XmlNicWriter.writeMany(object.nics().iterator(), "nic", "nics", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NetworkConfiguration> list, XmlWriter writer) {
        writeMany(list, "network_configuration", "network_configurations", writer);
    }
    
    public static void writeMany(Iterator<NetworkConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNetworkConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

