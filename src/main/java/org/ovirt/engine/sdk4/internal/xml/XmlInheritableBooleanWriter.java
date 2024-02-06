/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.InheritableBoolean;

public class XmlInheritableBooleanWriter {
    
    public static void writeOne(InheritableBoolean object, XmlWriter writer) {
        writeOne(object, "inheritable_boolean", writer);
    }
    
    public static void writeOne(InheritableBoolean object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<InheritableBoolean> list, XmlWriter writer) {
        writeMany(list, "inheritable_boolean", "inheritable_booleans", writer);
    }
    
    public static void writeMany(Iterator<InheritableBoolean> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlInheritableBooleanWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

