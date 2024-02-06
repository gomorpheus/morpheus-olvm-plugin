/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.TemplateStatus;

public class XmlTemplateStatusReader {
    
    public static TemplateStatus readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return TemplateStatus.fromValue(reader.readString());
    }
    
    public static List<TemplateStatus> readMany(XmlReader reader) {
        List<TemplateStatus> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            TemplateStatus next = TemplateStatus.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

