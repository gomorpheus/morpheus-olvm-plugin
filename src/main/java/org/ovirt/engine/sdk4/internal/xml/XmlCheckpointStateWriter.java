/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.CheckpointState;

public class XmlCheckpointStateWriter {
    
    public static void writeOne(CheckpointState object, XmlWriter writer) {
        writeOne(object, "checkpoint_state", writer);
    }
    
    public static void writeOne(CheckpointState object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<CheckpointState> list, XmlWriter writer) {
        writeMany(list, "checkpoint_state", "checkpoint_states", writer);
    }
    
    public static void writeMany(Iterator<CheckpointState> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlCheckpointStateWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

