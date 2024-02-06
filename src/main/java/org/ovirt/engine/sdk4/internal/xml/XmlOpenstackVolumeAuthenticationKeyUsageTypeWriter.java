/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKeyUsageType;

public class XmlOpenstackVolumeAuthenticationKeyUsageTypeWriter {
    
    public static void writeOne(OpenstackVolumeAuthenticationKeyUsageType object, XmlWriter writer) {
        writeOne(object, "openstack_volume_authentication_key_usage_type", writer);
    }
    
    public static void writeOne(OpenstackVolumeAuthenticationKeyUsageType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<OpenstackVolumeAuthenticationKeyUsageType> list, XmlWriter writer) {
        writeMany(list, "openstack_volume_authentication_key_usage_type", "openstack_volume_authentication_key_usage_types", writer);
    }
    
    public static void writeMany(Iterator<OpenstackVolumeAuthenticationKeyUsageType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlOpenstackVolumeAuthenticationKeyUsageTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

