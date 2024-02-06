/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;

public class XmlMigrationBandwidthWriter {
    
    public static void writeOne(MigrationBandwidth object, XmlWriter writer) {
        writeOne(object, "migration_bandwidth", writer);
    }
    
    public static void writeOne(MigrationBandwidth object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.assignmentMethodPresent()) {
            XmlMigrationBandwidthAssignmentMethodWriter.writeOne(object.assignmentMethod(), "assignment_method", writer);
        }
        if (object.customValuePresent()) {
            writer.writeInteger("custom_value", object.customValue());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MigrationBandwidth> list, XmlWriter writer) {
        writeMany(list, "migration_bandwidth", "migration_bandwidths", writer);
    }
    
    public static void writeMany(Iterator<MigrationBandwidth> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMigrationBandwidthWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

