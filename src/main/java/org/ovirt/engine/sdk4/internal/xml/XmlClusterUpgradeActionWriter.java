/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ClusterUpgradeAction;

public class XmlClusterUpgradeActionWriter {
    
    public static void writeOne(ClusterUpgradeAction object, XmlWriter writer) {
        writeOne(object, "cluster_upgrade_action", writer);
    }
    
    public static void writeOne(ClusterUpgradeAction object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ClusterUpgradeAction> list, XmlWriter writer) {
        writeMany(list, "cluster_upgrade_action", "cluster_upgrade_actions", writer);
    }
    
    public static void writeMany(Iterator<ClusterUpgradeAction> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlClusterUpgradeActionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

