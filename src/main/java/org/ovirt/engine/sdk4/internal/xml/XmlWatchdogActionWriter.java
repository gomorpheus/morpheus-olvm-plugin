/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.WatchdogAction;

public class XmlWatchdogActionWriter {
    
    public static void writeOne(WatchdogAction object, XmlWriter writer) {
        writeOne(object, "watchdog_action", writer);
    }
    
    public static void writeOne(WatchdogAction object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<WatchdogAction> list, XmlWriter writer) {
        writeMany(list, "watchdog_action", "watchdog_actions", writer);
    }
    
    public static void writeMany(Iterator<WatchdogAction> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlWatchdogActionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

