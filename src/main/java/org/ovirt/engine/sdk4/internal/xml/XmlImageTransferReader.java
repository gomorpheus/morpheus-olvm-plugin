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
import org.ovirt.engine.sdk4.internal.containers.ImageTransferContainer;
import org.ovirt.engine.sdk4.types.ImageTransfer;

public class XmlImageTransferReader {
    
    public static ImageTransfer readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ImageTransferContainer object = new ImageTransferContainer();
        
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
                case "active":
                object.active(reader.readBoolean());
                break;
                case "backup":
                object.backup(XmlBackupReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "direction":
                object.direction(XmlImageTransferDirectionReader.readOne(reader));
                break;
                case "disk":
                object.disk(XmlDiskReader.readOne(reader));
                break;
                case "format":
                object.format(XmlDiskFormatReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "image":
                object.image(XmlImageReader.readOne(reader));
                break;
                case "inactivity_timeout":
                object.inactivityTimeout(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "phase":
                object.phase(XmlImageTransferPhaseReader.readOne(reader));
                break;
                case "proxy_url":
                object.proxyUrl(reader.readString());
                break;
                case "shallow":
                object.shallow(reader.readBoolean());
                break;
                case "snapshot":
                object.snapshot(XmlDiskSnapshotReader.readOne(reader));
                break;
                case "timeout_policy":
                object.timeoutPolicy(XmlImageTransferTimeoutPolicyReader.readOne(reader));
                break;
                case "transfer_url":
                object.transferUrl(reader.readString());
                break;
                case "transferred":
                object.transferred(reader.readInteger());
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
    
    public static Iterator<ImageTransfer> iterateMany(final XmlReader reader) {
        return new Iterator<ImageTransfer>() {
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
            public ImageTransfer next() {
                ImageTransfer next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<ImageTransfer> readMany(XmlReader reader) {
        List<ImageTransfer> list = new ArrayList<>();
        Iterator<ImageTransfer> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ImageTransferContainer object, String[] link) {
    }
}

