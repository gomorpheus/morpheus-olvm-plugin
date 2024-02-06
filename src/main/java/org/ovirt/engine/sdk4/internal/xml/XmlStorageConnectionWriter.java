/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.StorageConnection;

public class XmlStorageConnectionWriter {
    
    public static void writeOne(StorageConnection object, XmlWriter writer) {
        writeOne(object, "storage_connection", writer);
    }
    
    public static void writeOne(StorageConnection object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.glusterVolumePresent()) {
            XmlGlusterVolumeWriter.writeOne(object.glusterVolume(), "gluster_volume", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.mountOptionsPresent()) {
            writer.writeElement("mount_options", object.mountOptions());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.nfsRetransPresent()) {
            writer.writeInteger("nfs_retrans", object.nfsRetrans());
        }
        if (object.nfsTimeoPresent()) {
            writer.writeInteger("nfs_timeo", object.nfsTimeo());
        }
        if (object.nfsVersionPresent()) {
            XmlNfsVersionWriter.writeOne(object.nfsVersion(), "nfs_version", writer);
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.pathPresent()) {
            writer.writeElement("path", object.path());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.portalPresent()) {
            writer.writeElement("portal", object.portal());
        }
        if (object.targetPresent()) {
            writer.writeElement("target", object.target());
        }
        if (object.typePresent()) {
            XmlStorageTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        if (object.vfsTypePresent()) {
            writer.writeElement("vfs_type", object.vfsType());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<StorageConnection> list, XmlWriter writer) {
        writeMany(list, "storage_connection", "storage_connections", writer);
    }
    
    public static void writeMany(Iterator<StorageConnection> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlStorageConnectionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

