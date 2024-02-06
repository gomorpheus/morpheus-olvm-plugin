/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ApiSummaryItem;

public class XmlApiSummaryItemWriter {
    
    public static void writeOne(ApiSummaryItem object, XmlWriter writer) {
        writeOne(object, "api_summary_item", writer);
    }
    
    public static void writeOne(ApiSummaryItem object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.activePresent()) {
            writer.writeInteger("active", object.active());
        }
        if (object.totalPresent()) {
            writer.writeInteger("total", object.total());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ApiSummaryItem> list, XmlWriter writer) {
        writeMany(list, "api_summary_item", "api_summary_items", writer);
    }
    
    public static void writeMany(Iterator<ApiSummaryItem> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlApiSummaryItemWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

