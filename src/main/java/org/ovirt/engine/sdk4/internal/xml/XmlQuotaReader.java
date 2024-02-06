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
import org.ovirt.engine.sdk4.internal.containers.QuotaContainer;
import org.ovirt.engine.sdk4.types.Quota;

public class XmlQuotaReader {
    
    public static Quota readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        QuotaContainer object = new QuotaContainer();
        
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
                case "cluster_hard_limit_pct":
                object.clusterHardLimitPct(reader.readInteger());
                break;
                case "cluster_soft_limit_pct":
                object.clusterSoftLimitPct(reader.readInteger());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "disks":
                object.disks(XmlDiskReader.readMany(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "quota_cluster_limits":
                object.quotaClusterLimits(XmlQuotaClusterLimitReader.readMany(reader));
                break;
                case "quota_storage_limits":
                object.quotaStorageLimits(XmlQuotaStorageLimitReader.readMany(reader));
                break;
                case "storage_hard_limit_pct":
                object.storageHardLimitPct(reader.readInteger());
                break;
                case "storage_soft_limit_pct":
                object.storageSoftLimitPct(reader.readInteger());
                break;
                case "users":
                object.users(XmlUserReader.readMany(reader));
                break;
                case "vms":
                object.vms(XmlVmReader.readMany(reader));
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
    
    public static Iterator<Quota> iterateMany(final XmlReader reader) {
        return new Iterator<Quota>() {
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
            public Quota next() {
                Quota next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Quota> readMany(XmlReader reader) {
        List<Quota> list = new ArrayList<>();
        Iterator<Quota> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(QuotaContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "quotaclusterlimits":
                list = new ArrayListWithHref(object.quotaClusterLimits());
                list.href(href);
                object.quotaClusterLimits(list);
                break;
                case "quotastoragelimits":
                list = new ArrayListWithHref(object.quotaStorageLimits());
                list.href(href);
                object.quotaStorageLimits(list);
                break;
                default:
                break;
            }
        }
    }
}

