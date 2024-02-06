/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;

public class XmlHostNicVirtualFunctionsConfigurationWriter {
    
    public static void writeOne(HostNicVirtualFunctionsConfiguration object, XmlWriter writer) {
        writeOne(object, "host_nic_virtual_functions_configuration", writer);
    }
    
    public static void writeOne(HostNicVirtualFunctionsConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.allNetworksAllowedPresent()) {
            writer.writeBoolean("all_networks_allowed", object.allNetworksAllowed());
        }
        if (object.maxNumberOfVirtualFunctionsPresent()) {
            writer.writeInteger("max_number_of_virtual_functions", object.maxNumberOfVirtualFunctions());
        }
        if (object.numberOfVirtualFunctionsPresent()) {
            writer.writeInteger("number_of_virtual_functions", object.numberOfVirtualFunctions());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostNicVirtualFunctionsConfiguration> list, XmlWriter writer) {
        writeMany(list, "host_nic_virtual_functions_configuration", "host_nic_virtual_functions_configurations", writer);
    }
    
    public static void writeMany(Iterator<HostNicVirtualFunctionsConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostNicVirtualFunctionsConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

