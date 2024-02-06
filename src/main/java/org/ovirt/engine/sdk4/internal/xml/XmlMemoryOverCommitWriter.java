/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MemoryOverCommit;

public class XmlMemoryOverCommitWriter {
    
    public static void writeOne(MemoryOverCommit object, XmlWriter writer) {
        writeOne(object, "memory_over_commit", writer);
    }
    
    public static void writeOne(MemoryOverCommit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.percentPresent()) {
            writer.writeInteger("percent", object.percent());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MemoryOverCommit> list, XmlWriter writer) {
        writeMany(list, "memory_over_commit", "memory_over_commits", writer);
    }
    
    public static void writeMany(Iterator<MemoryOverCommit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMemoryOverCommitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

