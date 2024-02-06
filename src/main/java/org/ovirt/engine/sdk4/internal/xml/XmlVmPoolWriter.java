/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.VmPool;

public class XmlVmPoolWriter {
    
    public static void writeOne(VmPool object, XmlWriter writer) {
        writeOne(object, "vm_pool", writer);
    }
    
    public static void writeOne(VmPool object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.autoStorageSelectPresent()) {
            writer.writeBoolean("auto_storage_select", object.autoStorageSelect());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.displayPresent()) {
            XmlDisplayWriter.writeOne(object.display(), "display", writer);
        }
        if (object.instanceTypePresent()) {
            XmlInstanceTypeWriter.writeOne(object.instanceType(), "instance_type", writer);
        }
        if (object.maxUserVmsPresent()) {
            writer.writeInteger("max_user_vms", object.maxUserVms());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.permissionsPresent()) {
            XmlPermissionWriter.writeMany(object.permissions().iterator(), "permission", "permissions", writer);
        }
        if (object.prestartedVmsPresent()) {
            writer.writeInteger("prestarted_vms", object.prestartedVms());
        }
        if (object.rngDevicePresent()) {
            XmlRngDeviceWriter.writeOne(object.rngDevice(), "rng_device", writer);
        }
        if (object.sizePresent()) {
            writer.writeInteger("size", object.size());
        }
        if (object.soundcardEnabledPresent()) {
            writer.writeBoolean("soundcard_enabled", object.soundcardEnabled());
        }
        if (object.statefulPresent()) {
            writer.writeBoolean("stateful", object.stateful());
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.tpmEnabledPresent()) {
            writer.writeBoolean("tpm_enabled", object.tpmEnabled());
        }
        if (object.typePresent()) {
            XmlVmPoolTypeWriter.writeOne(object.type(), "type", writer);
        }
        if (object.useLatestTemplateVersionPresent()) {
            writer.writeBoolean("use_latest_template_version", object.useLatestTemplateVersion());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<VmPool> list, XmlWriter writer) {
        writeMany(list, "vm_pool", "vm_pools", writer);
    }
    
    public static void writeMany(Iterator<VmPool> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlVmPoolWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

