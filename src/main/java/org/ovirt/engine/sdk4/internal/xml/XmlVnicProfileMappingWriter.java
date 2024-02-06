/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VnicProfileMapping;

public class XmlVnicProfileMappingWriter {
    
    public static void writeOne(VnicProfileMapping object, XmlWriter writer) {
        writeOne(object, "vnic_profile_mapping", writer);
    }
    
    public static void writeOne(VnicProfileMapping object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.sourceNetworkNamePresent()) {
            writer.writeElement("source_network_name", object.sourceNetworkName());
        }
        if (object.sourceNetworkProfileNamePresent()) {
            writer.writeElement("source_network_profile_name", object.sourceNetworkProfileName());
        }
        if (object.targetVnicProfilePresent()) {
            XmlVnicProfileWriter.writeOne(object.targetVnicProfile(), "target_vnic_profile", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VnicProfileMapping> list, XmlWriter writer) {
        writeMany(list, "vnic_profile_mapping", "vnic_profile_mappings", writer);
    }
    
    public static void writeMany(Iterator<VnicProfileMapping> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVnicProfileMappingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

