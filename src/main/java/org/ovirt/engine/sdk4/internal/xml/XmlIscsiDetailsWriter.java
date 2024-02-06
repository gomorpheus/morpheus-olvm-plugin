/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.IscsiDetails;

public class XmlIscsiDetailsWriter {
    
    public static void writeOne(IscsiDetails object, XmlWriter writer) {
        writeOne(object, "iscsi_details", writer);
    }
    
    public static void writeOne(IscsiDetails object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.diskIdPresent()) {
            writer.writeElement("disk_id", object.diskId());
        }
        if (object.initiatorPresent()) {
            writer.writeElement("initiator", object.initiator());
        }
        if (object.lunMappingPresent()) {
            writer.writeInteger("lun_mapping", object.lunMapping());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.pathsPresent()) {
            writer.writeInteger("paths", object.paths());
        }
        if (object.portPresent()) {
            writer.writeInteger("port", object.port());
        }
        if (object.portalPresent()) {
            writer.writeElement("portal", object.portal());
        }
        if (object.productIdPresent()) {
            writer.writeElement("product_id", object.productId());
        }
        if (object.serialPresent()) {
            writer.writeElement("serial", object.serial());
        }
        if (object.sizePresent()) {
            writer.writeInteger("size", object.size());
        }
        if (object.statusPresent()) {
            writer.writeElement("status", object.status());
        }
        if (object.storageDomainIdPresent()) {
            writer.writeElement("storage_domain_id", object.storageDomainId());
        }
        if (object.targetPresent()) {
            writer.writeElement("target", object.target());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        if (object.vendorIdPresent()) {
            writer.writeElement("vendor_id", object.vendorId());
        }
        if (object.volumeGroupIdPresent()) {
            writer.writeElement("volume_group_id", object.volumeGroupId());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<IscsiDetails> list, XmlWriter writer) {
        writeMany(list, "iscsi_details", "iscsi_detailss", writer);
    }
    
    public static void writeMany(Iterator<IscsiDetails> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlIscsiDetailsWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

