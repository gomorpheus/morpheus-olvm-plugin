/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.SwitchType;

public class XmlSwitchTypeReader {
    
    public static SwitchType readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return SwitchType.fromValue(reader.readString());
    }
    
    public static List<SwitchType> readMany(XmlReader reader) {
        List<SwitchType> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            SwitchType next = SwitchType.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

