/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MigrationBandwidthAssignmentMethod;

public class XmlMigrationBandwidthAssignmentMethodWriter {
    
    public static void writeOne(MigrationBandwidthAssignmentMethod object, XmlWriter writer) {
        writeOne(object, "migration_bandwidth_assignment_method", writer);
    }
    
    public static void writeOne(MigrationBandwidthAssignmentMethod object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<MigrationBandwidthAssignmentMethod> list, XmlWriter writer) {
        writeMany(list, "migration_bandwidth_assignment_method", "migration_bandwidth_assignment_methods", writer);
    }
    
    public static void writeMany(Iterator<MigrationBandwidthAssignmentMethod> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMigrationBandwidthAssignmentMethodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

