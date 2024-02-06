/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterHook;

public class XmlGlusterHookWriter {
    
    public static void writeOne(GlusterHook object, XmlWriter writer) {
        writeOne(object, "gluster_hook", writer);
    }
    
    public static void writeOne(GlusterHook object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.checksumPresent()) {
            writer.writeElement("checksum", object.checksum());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.conflictStatusPresent()) {
            writer.writeInteger("conflict_status", object.conflictStatus());
        }
        if (object.conflictsPresent()) {
            writer.writeElement("conflicts", object.conflicts());
        }
        if (object.contentPresent()) {
            writer.writeElement("content", object.content());
        }
        if (object.contentTypePresent()) {
            XmlHookContentTypeWriter.writeOne(object.contentType(), "content_type", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.glusterCommandPresent()) {
            writer.writeElement("gluster_command", object.glusterCommand());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.serverHooksPresent()) {
            XmlGlusterServerHookWriter.writeMany(object.serverHooks().iterator(), "server_hook", "server_hooks", writer);
        }
        if (object.stagePresent()) {
            XmlHookStageWriter.writeOne(object.stage(), "stage", writer);
        }
        if (object.statusPresent()) {
            XmlGlusterHookStatusWriter.writeOne(object.status(), "status", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterHook> list, XmlWriter writer) {
        writeMany(list, "gluster_hook", "gluster_hooks", writer);
    }
    
    public static void writeMany(Iterator<GlusterHook> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterHookWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

