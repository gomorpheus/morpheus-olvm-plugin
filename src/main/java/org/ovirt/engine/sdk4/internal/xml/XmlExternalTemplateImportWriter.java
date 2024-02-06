/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;

public class XmlExternalTemplateImportWriter {
    
    public static void writeOne(ExternalTemplateImport object, XmlWriter writer) {
        writeOne(object, "external_template_import", writer);
    }
    
    public static void writeOne(ExternalTemplateImport object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.clone_Present()) {
            writer.writeBoolean("clone", object.clone_());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.cpuProfilePresent()) {
            XmlCpuProfileWriter.writeOne(object.cpuProfile(), "cpu_profile", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.urlPresent()) {
            writer.writeElement("url", object.url());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<ExternalTemplateImport> list, XmlWriter writer) {
        writeMany(list, "external_template_import", "external_template_imports", writer);
    }
    
    public static void writeMany(Iterator<ExternalTemplateImport> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlExternalTemplateImportWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

