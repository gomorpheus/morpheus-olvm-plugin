/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.LogicalUnit;

public class XmlLogicalUnitWriter {
    
    public static void writeOne(LogicalUnit object, XmlWriter writer) {
        writeOne(object, "logical_unit", writer);
    }
    
    public static void writeOne(LogicalUnit object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.discardMaxSizePresent()) {
            writer.writeInteger("discard_max_size", object.discardMaxSize());
        }
        if (object.discardZeroesDataPresent()) {
            writer.writeBoolean("discard_zeroes_data", object.discardZeroesData());
        }
        if (object.diskIdPresent()) {
            writer.writeElement("disk_id", object.diskId());
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
            XmlLunStatusWriter.writeOne(object.status(), "status", writer);
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
    
    public static void writeMany(Iterator<LogicalUnit> list, XmlWriter writer) {
        writeMany(list, "logical_unit", "logical_units", writer);
    }
    
    public static void writeMany(Iterator<LogicalUnit> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlLogicalUnitWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

