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
import org.ovirt.engine.sdk4.internal.containers.DisplayContainer;
import org.ovirt.engine.sdk4.types.Display;

public class XmlDisplayReader {
    
    public static Display readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        DisplayContainer object = new DisplayContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "address":
                object.address(reader.readString());
                break;
                case "allow_override":
                object.allowOverride(reader.readBoolean());
                break;
                case "certificate":
                object.certificate(XmlCertificateReader.readOne(reader));
                break;
                case "copy_paste_enabled":
                object.copyPasteEnabled(reader.readBoolean());
                break;
                case "disconnect_action":
                object.disconnectAction(reader.readString());
                break;
                case "file_transfer_enabled":
                object.fileTransferEnabled(reader.readBoolean());
                break;
                case "keyboard_layout":
                object.keyboardLayout(reader.readString());
                break;
                case "monitors":
                object.monitors(reader.readInteger());
                break;
                case "port":
                object.port(reader.readInteger());
                break;
                case "proxy":
                object.proxy(reader.readString());
                break;
                case "secure_port":
                object.securePort(reader.readInteger());
                break;
                case "single_qxl_pci":
                object.singleQxlPci(reader.readBoolean());
                break;
                case "smartcard_enabled":
                object.smartcardEnabled(reader.readBoolean());
                break;
                case "type":
                object.type(XmlDisplayTypeReader.readOne(reader));
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
    
    public static Iterator<Display> iterateMany(final XmlReader reader) {
        return new Iterator<Display>() {
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
            public Display next() {
                Display next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Display> readMany(XmlReader reader) {
        List<Display> list = new ArrayList<>();
        Iterator<Display> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(DisplayContainer object, String[] link) {
    }
}

