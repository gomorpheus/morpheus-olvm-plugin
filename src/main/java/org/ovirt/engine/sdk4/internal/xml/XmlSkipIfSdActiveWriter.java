/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SkipIfSdActive;

public class XmlSkipIfSdActiveWriter {
    
    public static void writeOne(SkipIfSdActive object, XmlWriter writer) {
        writeOne(object, "skip_if_sd_active", writer);
    }
    
    public static void writeOne(SkipIfSdActive object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<SkipIfSdActive> list, XmlWriter writer) {
        writeMany(list, "skip_if_sd_active", "skip_if_sd_actives", writer);
    }
    
    public static void writeMany(Iterator<SkipIfSdActive> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSkipIfSdActiveWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

