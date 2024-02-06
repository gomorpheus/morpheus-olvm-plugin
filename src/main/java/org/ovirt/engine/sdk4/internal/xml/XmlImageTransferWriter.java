/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ImageTransfer;

public class XmlImageTransferWriter {
    
    public static void writeOne(ImageTransfer object, XmlWriter writer) {
        writeOne(object, "image_transfer", writer);
    }
    
    public static void writeOne(ImageTransfer object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.activePresent()) {
            writer.writeBoolean("active", object.active());
        }
        if (object.backupPresent()) {
            XmlBackupWriter.writeOne(object.backup(), "backup", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.directionPresent()) {
            XmlImageTransferDirectionWriter.writeOne(object.direction(), "direction", writer);
        }
        if (object.diskPresent()) {
            XmlDiskWriter.writeOne(object.disk(), "disk", writer);
        }
        if (object.formatPresent()) {
            XmlDiskFormatWriter.writeOne(object.format(), "format", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.imagePresent()) {
            XmlImageWriter.writeOne(object.image(), "image", writer);
        }
        if (object.inactivityTimeoutPresent()) {
            writer.writeInteger("inactivity_timeout", object.inactivityTimeout());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.phasePresent()) {
            XmlImageTransferPhaseWriter.writeOne(object.phase(), "phase", writer);
        }
        if (object.proxyUrlPresent()) {
            writer.writeElement("proxy_url", object.proxyUrl());
        }
        if (object.shallowPresent()) {
            writer.writeBoolean("shallow", object.shallow());
        }
        if (object.snapshotPresent()) {
            XmlDiskSnapshotWriter.writeOne(object.snapshot(), "snapshot", writer);
        }
        if (object.timeoutPolicyPresent()) {
            XmlImageTransferTimeoutPolicyWriter.writeOne(object.timeoutPolicy(), "timeout_policy", writer);
        }
        if (object.transferUrlPresent()) {
            writer.writeElement("transfer_url", object.transferUrl());
        }
        if (object.transferredPresent()) {
            writer.writeInteger("transferred", object.transferred());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ImageTransfer> list, XmlWriter writer) {
        writeMany(list, "image_transfer", "image_transfers", writer);
    }
    
    public static void writeMany(Iterator<ImageTransfer> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlImageTransferWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

