/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterVolumeProfileDetails;

public class XmlGlusterVolumeProfileDetailsWriter {
    
    public static void writeOne(GlusterVolumeProfileDetails object, XmlWriter writer) {
        writeOne(object, "gluster_volume_profile_details", writer);
    }
    
    public static void writeOne(GlusterVolumeProfileDetails object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.brickProfileDetailsPresent()) {
            XmlBrickProfileDetailWriter.writeMany(object.brickProfileDetails().iterator(), "brick_profile_detail", "brick_profile_details", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.nfsProfileDetailsPresent()) {
            XmlNfsProfileDetailWriter.writeMany(object.nfsProfileDetails().iterator(), "nfs_profile_detail", "nfs_profile_details", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterVolumeProfileDetails> list, XmlWriter writer) {
        writeMany(list, "gluster_volume_profile_details", "gluster_volume_profile_detailss", writer);
    }
    
    public static void writeMany(Iterator<GlusterVolumeProfileDetails> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterVolumeProfileDetailsWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

