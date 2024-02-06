/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmStorageErrorResumeBehaviour;

public class XmlVmStorageErrorResumeBehaviourWriter {
    
    public static void writeOne(VmStorageErrorResumeBehaviour object, XmlWriter writer) {
        writeOne(object, "vm_storage_error_resume_behaviour", writer);
    }
    
    public static void writeOne(VmStorageErrorResumeBehaviour object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<VmStorageErrorResumeBehaviour> list, XmlWriter writer) {
        writeMany(list, "vm_storage_error_resume_behaviour", "vm_storage_error_resume_behaviours", writer);
    }
    
    public static void writeMany(Iterator<VmStorageErrorResumeBehaviour> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmStorageErrorResumeBehaviourWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

