/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ProductInfo;

public class XmlProductInfoWriter {
    
    public static void writeOne(ProductInfo object, XmlWriter writer) {
        writeOne(object, "product_info", writer);
    }
    
    public static void writeOne(ProductInfo object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.instanceIdPresent()) {
            writer.writeElement("instance_id", object.instanceId());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.vendorPresent()) {
            writer.writeElement("vendor", object.vendor());
        }
        if (object.versionPresent()) {
            XmlVersionWriter.writeOne(object.version(), "version", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ProductInfo> list, XmlWriter writer) {
        writeMany(list, "product_info", "product_infos", writer);
    }
    
    public static void writeMany(Iterator<ProductInfo> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlProductInfoWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

