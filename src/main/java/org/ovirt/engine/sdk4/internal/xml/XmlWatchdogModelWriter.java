/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.WatchdogModel;

public class XmlWatchdogModelWriter {
    
    public static void writeOne(WatchdogModel object, XmlWriter writer) {
        writeOne(object, "watchdog_model", writer);
    }
    
    public static void writeOne(WatchdogModel object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<WatchdogModel> list, XmlWriter writer) {
        writeMany(list, "watchdog_model", "watchdog_models", writer);
    }
    
    public static void writeMany(Iterator<WatchdogModel> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlWatchdogModelWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

