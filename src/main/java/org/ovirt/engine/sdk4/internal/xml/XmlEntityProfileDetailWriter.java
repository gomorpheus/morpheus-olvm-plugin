/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.EntityProfileDetail;

public class XmlEntityProfileDetailWriter {
    
    public static void writeOne(EntityProfileDetail object, XmlWriter writer) {
        writeOne(object, "entity_profile_detail", writer);
    }
    
    public static void writeOne(EntityProfileDetail object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.profileDetailsPresent()) {
            XmlProfileDetailWriter.writeMany(object.profileDetails().iterator(), "profile_detail", "profile_details", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<EntityProfileDetail> list, XmlWriter writer) {
        writeMany(list, "entity_profile_detail", "entity_profile_details", writer);
    }
    
    public static void writeMany(Iterator<EntityProfileDetail> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlEntityProfileDetailWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

