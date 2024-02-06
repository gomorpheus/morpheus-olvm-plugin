/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterVolumeType;

public class XmlGlusterVolumeTypeWriter {
    
    public static void writeOne(GlusterVolumeType object, XmlWriter writer) {
        writeOne(object, "gluster_volume_type", writer);
    }
    
    public static void writeOne(GlusterVolumeType object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<GlusterVolumeType> list, XmlWriter writer) {
        writeMany(list, "gluster_volume_type", "gluster_volume_types", writer);
    }
    
    public static void writeMany(Iterator<GlusterVolumeType> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterVolumeTypeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

