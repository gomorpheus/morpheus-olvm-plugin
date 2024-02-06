/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.GlusterBrick;

public class XmlGlusterBrickWriter {
    
    public static void writeOne(GlusterBrick object, XmlWriter writer) {
        writeOne(object, "brick", writer);
    }
    
    public static void writeOne(GlusterBrick object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.brickDirPresent()) {
            writer.writeElement("brick_dir", object.brickDir());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.devicePresent()) {
            writer.writeElement("device", object.device());
        }
        if (object.fsNamePresent()) {
            writer.writeElement("fs_name", object.fsName());
        }
        if (object.glusterClientsPresent()) {
            XmlGlusterClientWriter.writeMany(object.glusterClients().iterator(), "gluster_client", "gluster_clients", writer);
        }
        if (object.glusterVolumePresent()) {
            XmlGlusterVolumeWriter.writeOne(object.glusterVolume(), "gluster_volume", writer);
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.memoryPoolsPresent()) {
            XmlGlusterMemoryPoolWriter.writeMany(object.memoryPools().iterator(), "memory_pool", "memory_pools", writer);
        }
        if (object.mntOptionsPresent()) {
            writer.writeElement("mnt_options", object.mntOptions());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.pidPresent()) {
            writer.writeInteger("pid", object.pid());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.serverIdPresent()) {
            writer.writeElement("server_id", object.serverId());
        }
        if (object.statisticsPresent()) {
            XmlStatisticWriter.writeMany(object.statistics().iterator(), "statistic", "statistics", writer);
        }
        if (object.statusPresent()) {
            XmlGlusterBrickStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vmsPresent()) {
            XmlVmWriter.writeMany(object.vms().iterator(), "vm", "vms", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<GlusterBrick> list, XmlWriter writer) {
        writeMany(list, "brick", "bricks", writer);
    }
    
    public static void writeMany(Iterator<GlusterBrick> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlGlusterBrickWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

