/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalVmImport;

public class XmlExternalVmImportWriter {
    
    public static void writeOne(ExternalVmImport object, XmlWriter writer) {
        writeOne(object, "external_vm_import", writer);
    }
    
    public static void writeOne(ExternalVmImport object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.cpuProfilePresent()) {
            XmlCpuProfileWriter.writeOne(object.cpuProfile(), "cpu_profile", writer);
        }
        if (object.driversIsoPresent()) {
            XmlFileWriter.writeOne(object.driversIso(), "drivers_iso", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.providerPresent()) {
            XmlExternalVmProviderTypeWriter.writeOne(object.provider(), "provider", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.sparsePresent()) {
            writer.writeBoolean("sparse", object.sparse());
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalVmImport> list, XmlWriter writer) {
        writeMany(list, "external_vm_import", "external_vm_imports", writer);
    }
    
    public static void writeMany(Iterator<ExternalVmImport> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalVmImportWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

