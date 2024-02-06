/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostedEngine;

public class XmlHostedEngineWriter {
    
    public static void writeOne(HostedEngine object, XmlWriter writer) {
        writeOne(object, "hosted_engine", writer);
    }
    
    public static void writeOne(HostedEngine object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.activePresent()) {
            writer.writeBoolean("active", object.active());
        }
        if (object.configuredPresent()) {
            writer.writeBoolean("configured", object.configured());
        }
        if (object.globalMaintenancePresent()) {
            writer.writeBoolean("global_maintenance", object.globalMaintenance());
        }
        if (object.localMaintenancePresent()) {
            writer.writeBoolean("local_maintenance", object.localMaintenance());
        }
        if (object.scorePresent()) {
            writer.writeInteger("score", object.score());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostedEngine> list, XmlWriter writer) {
        writeMany(list, "hosted_engine", "hosted_engines", writer);
    }
    
    public static void writeMany(Iterator<HostedEngine> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostedEngineWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

