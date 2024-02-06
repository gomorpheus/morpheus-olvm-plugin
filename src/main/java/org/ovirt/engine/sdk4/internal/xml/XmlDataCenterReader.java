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
import org.ovirt.engine.sdk4.internal.containers.DataCenterContainer;
import org.ovirt.engine.sdk4.types.DataCenter;

public class XmlDataCenterReader {
    
    public static DataCenter readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        DataCenterContainer object = new DataCenterContainer();
        
        // Process the attributes:
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String image = reader.getAttributeValue(i);
            switch (name) {
                case "href":
                object.href(image);
                break;
                case "id":
                object.id(image);
                break;
                default:
                break;
            }
        }
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "clusters":
                object.clusters(XmlClusterReader.readMany(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "iscsi_bonds":
                object.iscsiBonds(XmlIscsiBondReader.readMany(reader));
                break;
                case "local":
                object.local(reader.readBoolean());
                break;
                case "mac_pool":
                object.macPool(XmlMacPoolReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "networks":
                object.networks(XmlNetworkReader.readMany(reader));
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "qoss":
                object.qoss(XmlQosReader.readMany(reader));
                break;
                case "quota_mode":
                object.quotaMode(XmlQuotaModeTypeReader.readOne(reader));
                break;
                case "quotas":
                object.quotas(XmlQuotaReader.readMany(reader));
                break;
                case "status":
                object.status(XmlDataCenterStatusReader.readOne(reader));
                break;
                case "storage_domains":
                object.storageDomains(XmlStorageDomainReader.readMany(reader));
                break;
                case "storage_format":
                object.storageFormat(XmlStorageFormatReader.readOne(reader));
                break;
                case "supported_versions":
                object.supportedVersions(XmlVersionReader.readMany(reader));
                break;
                case "version":
                object.version(XmlVersionReader.readOne(reader));
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
    
    public static Iterator<DataCenter> iterateMany(final XmlReader reader) {
        return new Iterator<DataCenter>() {
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
            public DataCenter next() {
                DataCenter next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<DataCenter> readMany(XmlReader reader) {
        List<DataCenter> list = new ArrayList<>();
        Iterator<DataCenter> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(DataCenterContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "clusters":
                list = new ArrayListWithHref(object.clusters());
                list.href(href);
                object.clusters(list);
                break;
                case "iscsibonds":
                list = new ArrayListWithHref(object.iscsiBonds());
                list.href(href);
                object.iscsiBonds(list);
                break;
                case "networks":
                list = new ArrayListWithHref(object.networks());
                list.href(href);
                object.networks(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "qoss":
                list = new ArrayListWithHref(object.qoss());
                list.href(href);
                object.qoss(list);
                break;
                case "quotas":
                list = new ArrayListWithHref(object.quotas());
                list.href(href);
                object.quotas(list);
                break;
                case "storagedomains":
                list = new ArrayListWithHref(object.storageDomains());
                list.href(href);
                object.storageDomains(list);
                break;
                default:
                break;
            }
        }
    }
}

