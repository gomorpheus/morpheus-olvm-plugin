/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GracePeriod;

public class XmlGracePeriodWriter {
    
    public static void writeOne(GracePeriod object, XmlWriter writer) {
        writeOne(object, "grace_period", writer);
    }
    
    public static void writeOne(GracePeriod object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.expiryPresent()) {
            writer.writeInteger("expiry", object.expiry());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GracePeriod> list, XmlWriter writer) {
        writeMany(list, "grace_period", "grace_periods", writer);
    }
    
    public static void writeMany(Iterator<GracePeriod> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGracePeriodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

