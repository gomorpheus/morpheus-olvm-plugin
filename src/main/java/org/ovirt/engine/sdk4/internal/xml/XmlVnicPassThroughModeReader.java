/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.VnicPassThroughMode;

public class XmlVnicPassThroughModeReader {
    
    public static VnicPassThroughMode readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return VnicPassThroughMode.fromValue(reader.readString());
    }
    
    public static List<VnicPassThroughMode> readMany(XmlReader reader) {
        List<VnicPassThroughMode> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            VnicPassThroughMode next = VnicPassThroughMode.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

