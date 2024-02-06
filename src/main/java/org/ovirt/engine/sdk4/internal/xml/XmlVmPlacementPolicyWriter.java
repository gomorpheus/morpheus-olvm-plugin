/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmPlacementPolicy;

public class XmlVmPlacementPolicyWriter {
    
    public static void writeOne(VmPlacementPolicy object, XmlWriter writer) {
        writeOne(object, "vm_placement_policy", writer);
    }
    
    public static void writeOne(VmPlacementPolicy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.affinityPresent()) {
            XmlVmAffinityWriter.writeOne(object.affinity(), "affinity", writer);
        }
        if (object.hostsPresent()) {
            XmlHostWriter.writeMany(object.hosts().iterator(), "host", "hosts", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VmPlacementPolicy> list, XmlWriter writer) {
        writeMany(list, "vm_placement_policy", "vm_placement_policies", writer);
    }
    
    public static void writeMany(Iterator<VmPlacementPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmPlacementPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

