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
import org.ovirt.engine.sdk4.internal.containers.CpuContainer;
import org.ovirt.engine.sdk4.types.Cpu;

public class XmlCpuReader {
    
    public static Cpu readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        CpuContainer object = new CpuContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "architecture":
                object.architecture(XmlArchitectureReader.readOne(reader));
                break;
                case "cores":
                object.cores(XmlCoreReader.readMany(reader));
                break;
                case "cpu_tune":
                object.cpuTune(XmlCpuTuneReader.readOne(reader));
                break;
                case "level":
                object.level(reader.readInteger());
                break;
                case "mode":
                object.mode(XmlCpuModeReader.readOne(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "speed":
                object.speed(reader.readDecimal());
                break;
                case "topology":
                object.topology(XmlCpuTopologyReader.readOne(reader));
                break;
                case "type":
                object.type(reader.readString());
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
    
    public static Iterator<Cpu> iterateMany(final XmlReader reader) {
        return new Iterator<Cpu>() {
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
            public Cpu next() {
                Cpu next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Cpu> readMany(XmlReader reader) {
        List<Cpu> list = new ArrayList<>();
        Iterator<Cpu> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(CpuContainer object, String[] link) {
    }
}

