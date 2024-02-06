/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ImageTransferPhase;

public class XmlImageTransferPhaseWriter {
    
    public static void writeOne(ImageTransferPhase object, XmlWriter writer) {
        writeOne(object, "image_transfer_phase", writer);
    }
    
    public static void writeOne(ImageTransferPhase object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<ImageTransferPhase> list, XmlWriter writer) {
        writeMany(list, "image_transfer_phase", "image_transfer_phases", writer);
    }
    
    public static void writeMany(Iterator<ImageTransferPhase> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlImageTransferPhaseWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

