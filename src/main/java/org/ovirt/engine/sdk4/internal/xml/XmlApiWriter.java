/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Api;

public class XmlApiWriter {
    
    public static void writeOne(Api object, XmlWriter writer) {
        writeOne(object, "api", writer);
    }
    
    public static void writeOne(Api object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.authenticatedUserPresent()) {
            XmlUserWriter.writeOne(object.authenticatedUser(), "authenticated_user", writer);
        }
        if (object.effectiveUserPresent()) {
            XmlUserWriter.writeOne(object.effectiveUser(), "effective_user", writer);
        }
        if (object.productInfoPresent()) {
            XmlProductInfoWriter.writeOne(object.productInfo(), "product_info", writer);
        }
        if (object.specialObjectsPresent()) {
            XmlSpecialObjectsWriter.writeOne(object.specialObjects(), "special_objects", writer);
        }
        if (object.summaryPresent()) {
            XmlApiSummaryWriter.writeOne(object.summary(), "summary", writer);
        }
        if (object.timePresent()) {
            writer.writeDate("time", object.time());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Api> list, XmlWriter writer) {
        writeMany(list, "api", "apis", writer);
    }
    
    public static void writeMany(Iterator<Api> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlApiWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

