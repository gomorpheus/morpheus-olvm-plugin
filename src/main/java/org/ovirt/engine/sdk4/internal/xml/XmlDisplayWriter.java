/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Display;

public class XmlDisplayWriter {
    
    public static void writeOne(Display object, XmlWriter writer) {
        writeOne(object, "display", writer);
    }
    
    public static void writeOne(Display object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.allowOverridePresent()) {
            writer.writeBoolean("allow_override", object.allowOverride());
        }
        if (object.certificatePresent()) {
            XmlCertificateWriter.writeOne(object.certificate(), "certificate", writer);
        }
        if (object.copyPasteEnabledPresent()) {
            writer.writeBoolean("copy_paste_enabled", object.copyPasteEnabled());
        }
        if (object.disconnectActionPresent()) {
            writer.writeElement("disconnect_action", object.disconnectAction());
        }
        if (object.fileTransferEnabledPresent()) {
            writer.writeBoolean("file_transfer_enabled", object.fileTransferEnabled());
        }
        if (object.keyboardLayoutPresent()) {
            writer.writeElement("keyboard_layout", object.keyboardLayout());
        }
        if (object.monitorsPresent()) {
            writer.writeInteger("monitors", object.monitors());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.proxyPresent()) {
            writer.writeElement("proxy", object.proxy());
        }
        if (object.securePortPresent()) {
            writer.writeInteger("secure_port", object.securePort());
        }
        if (object.singleQxlPciPresent()) {
            writer.writeBoolean("single_qxl_pci", object.singleQxlPci());
        }
        if (object.smartcardEnabledPresent()) {
            writer.writeBoolean("smartcard_enabled", object.smartcardEnabled());
        }
        if (object.typePresent()) {
            XmlDisplayTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Display> list, XmlWriter writer) {
        writeMany(list, "display", "displays", writer);
    }
    
    public static void writeMany(Iterator<Display> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlDisplayWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

