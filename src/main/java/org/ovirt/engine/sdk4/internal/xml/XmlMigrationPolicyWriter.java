/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MigrationPolicy;

public class XmlMigrationPolicyWriter {
    
    public static void writeOne(MigrationPolicy object, XmlWriter writer) {
        writeOne(object, "migration_policy", writer);
    }
    
    public static void writeOne(MigrationPolicy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
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
    
    public static void writeMany(Iterator<MigrationPolicy> list, XmlWriter writer) {
        writeMany(list, "migration_policy", "migration_policies", writer);
    }
    
    public static void writeMany(Iterator<MigrationPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMigrationPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

