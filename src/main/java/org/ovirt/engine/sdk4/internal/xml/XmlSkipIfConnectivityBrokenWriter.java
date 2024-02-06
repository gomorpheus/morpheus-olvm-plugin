/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SkipIfConnectivityBroken;

public class XmlSkipIfConnectivityBrokenWriter {
    
    public static void writeOne(SkipIfConnectivityBroken object, XmlWriter writer) {
        writeOne(object, "skip_if_connectivity_broken", writer);
    }
    
    public static void writeOne(SkipIfConnectivityBroken object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.thresholdPresent()) {
            writer.writeInteger("threshold", object.threshold());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SkipIfConnectivityBroken> list, XmlWriter writer) {
        writeMany(list, "skip_if_connectivity_broken", "skip_if_connectivity_brokens", writer);
    }
    
    public static void writeMany(Iterator<SkipIfConnectivityBroken> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSkipIfConnectivityBrokenWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

