/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MemoryPolicy;

public class XmlMemoryPolicyWriter {
    
    public static void writeOne(MemoryPolicy object, XmlWriter writer) {
        writeOne(object, "memory_policy", writer);
    }
    
    public static void writeOne(MemoryPolicy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.ballooningPresent()) {
            writer.writeBoolean("ballooning", object.ballooning());
        }
        if (object.guaranteedPresent()) {
            writer.writeInteger("guaranteed", object.guaranteed());
        }
        if (object.maxPresent()) {
            writer.writeInteger("max", object.max());
        }
        if (object.overCommitPresent()) {
            XmlMemoryOverCommitWriter.writeOne(object.overCommit(), "over_commit", writer);
        }
        if (object.transparentHugePagesPresent()) {
            XmlTransparentHugePagesWriter.writeOne(object.transparentHugePages(), "transparent_hugepages", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MemoryPolicy> list, XmlWriter writer) {
        writeMany(list, "memory_policy", "memory_policies", writer);
    }
    
    public static void writeMany(Iterator<MemoryPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMemoryPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

