/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.ConfigurationType;

public class XmlConfigurationTypeReader {
    
    public static ConfigurationType readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return ConfigurationType.fromValue(reader.readString());
    }
    
    public static List<ConfigurationType> readMany(XmlReader reader) {
        List<ConfigurationType> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            ConfigurationType next = ConfigurationType.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

