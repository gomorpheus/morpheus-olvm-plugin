/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.SpmStatus;

public class XmlSpmStatusReader {
    
    public static SpmStatus readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return SpmStatus.fromValue(reader.readString());
    }
    
    public static List<SpmStatus> readMany(XmlReader reader) {
        List<SpmStatus> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            SpmStatus next = SpmStatus.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}
