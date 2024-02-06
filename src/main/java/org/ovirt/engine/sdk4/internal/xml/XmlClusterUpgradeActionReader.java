/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.types.ClusterUpgradeAction;

public class XmlClusterUpgradeActionReader {
    
    public static ClusterUpgradeAction readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Process the value of enum:
        return ClusterUpgradeAction.fromValue(reader.readString());
    }
    
    public static List<ClusterUpgradeAction> readMany(XmlReader reader) {
        List<ClusterUpgradeAction> list = new ArrayList<>();
        if (!reader.forward()) {
            return list;
        }
        reader.next();
        while (reader.forward()) {
            String v = reader.readString();
            ClusterUpgradeAction next = ClusterUpgradeAction.fromValue(v);
            list.add(next);
        }
        reader.next();
        return list;
    }
    
}

