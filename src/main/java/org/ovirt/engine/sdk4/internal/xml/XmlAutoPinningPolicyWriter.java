/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.AutoPinningPolicy;

public class XmlAutoPinningPolicyWriter {
    
    public static void writeOne(AutoPinningPolicy object, XmlWriter writer) {
        writeOne(object, "auto_pinning_policy", writer);
    }
    
    public static void writeOne(AutoPinningPolicy object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<AutoPinningPolicy> list, XmlWriter writer) {
        writeMany(list, "auto_pinning_policy", "auto_pinning_policies", writer);
    }
    
    public static void writeMany(Iterator<AutoPinningPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlAutoPinningPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

