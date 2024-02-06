/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.BrickProfileDetail;

public class XmlBrickProfileDetailWriter {
    
    public static void writeOne(BrickProfileDetail object, XmlWriter writer) {
        writeOne(object, "brick_profile_detail", writer);
    }
    
    public static void writeOne(BrickProfileDetail object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.brickPresent()) {
            XmlGlusterBrickWriter.writeOne(object.brick(), "brick", writer);
        }
        if (object.profileDetailsPresent()) {
            XmlProfileDetailWriter.writeMany(object.profileDetails().iterator(), "profile_detail", "profile_details", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<BrickProfileDetail> list, XmlWriter writer) {
        writeMany(list, "brick_profile_detail", "brick_profile_details", writer);
    }
    
    public static void writeMany(Iterator<BrickProfileDetail> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBrickProfileDetailWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

