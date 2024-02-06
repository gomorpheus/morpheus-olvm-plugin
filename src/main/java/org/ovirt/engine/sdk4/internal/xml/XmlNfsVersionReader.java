/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.NfsVersion;

public class XmlNfsVersionReader {
    
    public static NfsVersion readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return NfsVersion.fromValue(reader.readString());
    }
    
    public static List<NfsVersion> readMany(XmlReader reader) {
        List<NfsVersion> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            NfsVersion next = NfsVersion.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

