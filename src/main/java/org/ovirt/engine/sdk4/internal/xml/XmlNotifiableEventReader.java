/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.NotifiableEvent;

public class XmlNotifiableEventReader {
    
    public static NotifiableEvent readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return NotifiableEvent.fromValue(reader.readString());
    }
    
    public static List<NotifiableEvent> readMany(XmlReader reader) {
        List<NotifiableEvent> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            NotifiableEvent next = NotifiableEvent.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

