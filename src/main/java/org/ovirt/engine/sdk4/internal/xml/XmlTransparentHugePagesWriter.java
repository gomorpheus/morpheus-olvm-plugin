/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.TransparentHugePages;

public class XmlTransparentHugePagesWriter {
    
    public static void writeOne(TransparentHugePages object, XmlWriter writer) {
        writeOne(object, "transparent_hugepages", writer);
    }
    
    public static void writeOne(TransparentHugePages object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<TransparentHugePages> list, XmlWriter writer) {
        writeMany(list, "transparent_hugepages", "transparent_huge_pagess", writer);
    }
    
    public static void writeMany(Iterator<TransparentHugePages> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlTransparentHugePagesWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

