/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.FenceType;

public class XmlFenceTypeReader {
    
    public static FenceType readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return FenceType.fromValue(reader.readString());
    }
    
    public static List<FenceType> readMany(XmlReader reader) {
        List<FenceType> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            FenceType next = FenceType.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

