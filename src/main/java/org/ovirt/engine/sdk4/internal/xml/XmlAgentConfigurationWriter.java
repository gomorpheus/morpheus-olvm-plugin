/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AgentConfiguration;

public class XmlAgentConfigurationWriter {
    
    public static void writeOne(AgentConfiguration object, XmlWriter writer) {
        writeOne(object, "agent_configuration", writer);
    }
    
    public static void writeOne(AgentConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.brokerTypePresent()) {
            XmlMessageBrokerTypeWriter.writeOne(object.brokerType(), "broker_type", writer);
        }
        if (object.networkMappingsPresent()) {
            writer.writeElement("network_mappings", object.networkMappings());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<AgentConfiguration> list, XmlWriter writer) {
        writeMany(list, "agent_configuration", "agent_configurations", writer);
    }
    
    public static void writeMany(Iterator<AgentConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAgentConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

