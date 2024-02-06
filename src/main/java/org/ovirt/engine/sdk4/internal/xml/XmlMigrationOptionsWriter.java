/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.MigrationOptions;

public class XmlMigrationOptionsWriter {
    
    public static void writeOne(MigrationOptions object, XmlWriter writer) {
        writeOne(object, "migration", writer);
    }
    
    public static void writeOne(MigrationOptions object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.autoConvergePresent()) {
            XmlInheritableBooleanWriter.writeOne(object.autoConverge(), "auto_converge", writer);
        }
        if (object.bandwidthPresent()) {
            XmlMigrationBandwidthWriter.writeOne(object.bandwidth(), "bandwidth", writer);
        }
        if (object.compressedPresent()) {
            XmlInheritableBooleanWriter.writeOne(object.compressed(), "compressed", writer);
        }
        if (object.encryptedPresent()) {
            XmlInheritableBooleanWriter.writeOne(object.encrypted(), "encrypted", writer);
        }
        if (object.policyPresent()) {
            XmlMigrationPolicyWriter.writeOne(object.policy(), "policy", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<MigrationOptions> list, XmlWriter writer) {
        writeMany(list, "migration", "migration_optionss", writer);
    }
    
    public static void writeMany(Iterator<MigrationOptions> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlMigrationOptionsWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

