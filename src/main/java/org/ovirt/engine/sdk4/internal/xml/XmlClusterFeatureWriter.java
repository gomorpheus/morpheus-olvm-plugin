/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ClusterFeature;

public class XmlClusterFeatureWriter {
    
    public static void writeOne(ClusterFeature object, XmlWriter writer) {
        writeOne(object, "cluster_feature", writer);
    }
    
    public static void writeOne(ClusterFeature object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.clusterLevelPresent()) {
            XmlClusterLevelWriter.writeOne(object.clusterLevel(), "cluster_level", writer);
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
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ClusterFeature> list, XmlWriter writer) {
        writeMany(list, "cluster_feature", "cluster_features", writer);
    }
    
    public static void writeMany(Iterator<ClusterFeature> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlClusterFeatureWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

