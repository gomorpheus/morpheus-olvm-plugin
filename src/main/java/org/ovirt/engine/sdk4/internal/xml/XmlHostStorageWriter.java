/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.HostStorage;

public class XmlHostStorageWriter {
    
    public static void writeOne(HostStorage object, XmlWriter writer) {
        writeOne(object, "host_storage", writer);
    }
    
    public static void writeOne(HostStorage object, String tag, XmlWriter writer) {
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
        if (object.driverOptionsPresent()) {
            XmlPropertyWriter.writeMany(object.driverOptions().iterator(), "property", "driver_options", writer);
        }
        if (object.driverSensitiveOptionsPresent()) {
            XmlPropertyWriter.writeMany(object.driverSensitiveOptions().iterator(), "property", "driver_sensitive_options", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.logicalUnitsPresent()) {
            XmlLogicalUnitWriter.writeMany(object.logicalUnits().iterator(), "logical_unit", "logical_units", writer);
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
        if (object.overrideLunsPresent()) {
            writer.writeBoolean("override_luns", object.overrideLuns());
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
        if (object.volumeGroupPresent()) {
            XmlVolumeGroupWriter.writeOne(object.volumeGroup(), "volume_group", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<HostStorage> list, XmlWriter writer) {
        writeMany(list, "host_storage", "host_storages", writer);
    }
    
    public static void writeMany(Iterator<HostStorage> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlHostStorageWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

