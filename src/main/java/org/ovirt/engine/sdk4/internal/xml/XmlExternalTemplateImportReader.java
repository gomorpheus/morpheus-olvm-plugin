/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.ExternalTemplateImportContainer;
import org.ovirt.engine.sdk4.types.ExternalTemplateImport;

public class XmlExternalTemplateImportReader {
    
    public static ExternalTemplateImport readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ExternalTemplateImportContainer object = new ExternalTemplateImportContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "clone":
                object.clone_(reader.readBoolean());
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "cpu_profile":
                object.cpuProfile(XmlCpuProfileReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "quota":
                object.quota(XmlQuotaReader.readOne(reader));
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "url":
                object.url(reader.readString());
                break;
                case "link":
                // Process the attributes:
                String rel = reader.getAttributeValue("rel");
                String href = reader.getAttributeValue("href");
                if (rel != null && href != null) {
                    links.add(new String[]{rel, href});
                }
                reader.skip();
                break;
                default:
                reader.skip();
                break;
            }
        }
        if (links != null) {
            for (String[] link : links) {
                processLink(object, link);
            }
        }
        
        // Discard the end tag:
        reader.next();
        
        return object;
    }
    
    public static Iterator<ExternalTemplateImport> iterateMany(final XmlReader reader) {
        return new Iterator<ExternalTemplateImport>() {
            private boolean first = true;
            
            @Override
            public void remove() {
                // Empty on purpose
            }
            
            @Override
            public boolean hasNext() {
                if (first) {
                    if (!reader.forward()) {
                        return false;
                    }
                    reader.next();
                    first = false;
                }
                if (!reader.forward()) {
                    reader.next();
                    return false;
                }
                return true;
            }
            
            @Override
            public ExternalTemplateImport next() {
                ExternalTemplateImport next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<ExternalTemplateImport> readMany(XmlReader reader) {
        List<ExternalTemplateImport> list = new ArrayList<>();
        Iterator<ExternalTemplateImport> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ExternalTemplateImportContainer object, String[] link) {
    }
}

