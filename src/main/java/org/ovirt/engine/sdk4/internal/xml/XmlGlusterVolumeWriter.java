/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterVolume;

public class XmlGlusterVolumeWriter {
    
    public static void writeOne(GlusterVolume object, XmlWriter writer) {
        writeOne(object, "gluster_volume", writer);
    }
    
    public static void writeOne(GlusterVolume object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.bricksPresent()) {
            XmlGlusterBrickWriter.writeMany(object.bricks().iterator(), "brick", "bricks", writer);
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.disperseCountPresent()) {
            writer.writeInteger("disperse_count", object.disperseCount());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.optionsPresent()) {
            XmlOptionWriter.writeMany(object.options().iterator(), "option", "options", writer);
        }
        if (object.redundancyCountPresent()) {
            writer.writeInteger("redundancy_count", object.redundancyCount());
        }
        if (object.replicaCountPresent()) {
            writer.writeInteger("replica_count", object.replicaCount());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlGlusterVolumeStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.stripeCountPresent()) {
            writer.writeInteger("stripe_count", object.stripeCount());
        }
        if (object.transportTypesPresent()) {
            XmlTransportTypeWriter.writeMany(object.transportTypes().iterator(), "transport_type", "transport_types", writer);
        }
        if (object.volumeTypePresent()) {
            XmlGlusterVolumeTypeWriter.writeOne(object.volumeType(), "volume_type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterVolume> list, XmlWriter writer) {
        writeMany(list, "gluster_volume", "gluster_volumes", writer);
    }
    
    public static void writeMany(Iterator<GlusterVolume> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterVolumeWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

