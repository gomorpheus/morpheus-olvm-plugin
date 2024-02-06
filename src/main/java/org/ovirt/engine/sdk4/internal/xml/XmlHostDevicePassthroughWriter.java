/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostDevicePassthrough;

public class XmlHostDevicePassthroughWriter {
    
    public static void writeOne(HostDevicePassthrough object, XmlWriter writer) {
        writeOne(object, "host_device_passthrough", writer);
    }
    
    public static void writeOne(HostDevicePassthrough object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostDevicePassthrough> list, XmlWriter writer) {
        writeMany(list, "host_device_passthrough", "host_device_passthroughs", writer);
    }
    
    public static void writeMany(Iterator<HostDevicePassthrough> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostDevicePassthroughWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

