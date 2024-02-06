/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ClusterLevel;

public class XmlClusterLevelWriter {
    
    public static void writeOne(ClusterLevel object, XmlWriter writer) {
        writeOne(object, "cluster_level", writer);
    }
    
    public static void writeOne(ClusterLevel object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterFeaturesPresent()) {
            XmlClusterFeatureWriter.writeMany(object.clusterFeatures().iterator(), "cluster_feature", "cluster_features", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.cpuTypesPresent()) {
            XmlCpuTypeWriter.writeMany(object.cpuTypes().iterator(), "cpu_type", "cpu_types", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permitsPresent()) {
            XmlPermitWriter.writeMany(object.permits().iterator(), "permit", "permits", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ClusterLevel> list, XmlWriter writer) {
        writeMany(list, "cluster_level", "cluster_levels", writer);
    }
    
    public static void writeMany(Iterator<ClusterLevel> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlClusterLevelWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

