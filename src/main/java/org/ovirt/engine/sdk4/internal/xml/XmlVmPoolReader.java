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
import org.ovirt.engine.sdk4.internal.containers.VmPoolContainer;
import org.ovirt.engine.sdk4.types.VmPool;

public class XmlVmPoolReader {
    
    public static VmPool readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        VmPoolContainer object = new VmPoolContainer();
        
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
                case "auto_storage_select":
                object.autoStorageSelect(reader.readBoolean());
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "display":
                object.display(XmlDisplayReader.readOne(reader));
                break;
                case "instance_type":
                object.instanceType(XmlInstanceTypeReader.readOne(reader));
                break;
                case "max_user_vms":
                object.maxUserVms(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "prestarted_vms":
                object.prestartedVms(reader.readInteger());
                break;
                case "rng_device":
                object.rngDevice(XmlRngDeviceReader.readOne(reader));
                break;
                case "size":
                object.size(reader.readInteger());
                break;
                case "soundcard_enabled":
                object.soundcardEnabled(reader.readBoolean());
                break;
                case "stateful":
                object.stateful(reader.readBoolean());
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "tpm_enabled":
                object.tpmEnabled(reader.readBoolean());
                break;
                case "type":
                object.type(XmlVmPoolTypeReader.readOne(reader));
                break;
                case "use_latest_template_version":
                object.useLatestTemplateVersion(reader.readBoolean());
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
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
    
    public static Iterator<VmPool> iterateMany(final XmlReader reader) {
        return new Iterator<VmPool>() {
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
            public VmPool next() {
                VmPool next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<VmPool> readMany(XmlReader reader) {
        List<VmPool> list = new ArrayList<>();
        Iterator<VmPool> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(VmPoolContainer object, String[] link) {
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
                default:
                break;
            }
        }
    }
}

