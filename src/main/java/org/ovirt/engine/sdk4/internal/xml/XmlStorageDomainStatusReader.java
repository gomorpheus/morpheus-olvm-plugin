/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.StorageDomainStatus;

public class XmlStorageDomainStatusReader {
    
    public static StorageDomainStatus readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return StorageDomainStatus.fromValue(reader.readString());
    }
    
    public static List<StorageDomainStatus> readMany(XmlReader reader) {
        List<StorageDomainStatus> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            StorageDomainStatus next = StorageDomainStatus.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

