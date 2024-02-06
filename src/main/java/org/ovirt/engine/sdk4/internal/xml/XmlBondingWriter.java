/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Bonding;

public class XmlBondingWriter {
    
    public static void writeOne(Bonding object, XmlWriter writer) {
        writeOne(object, "bonding", writer);
    }
    
    public static void writeOne(Bonding object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.activeSlavePresent()) {
            XmlHostNicWriter.writeOne(object.activeSlave(), "active_slave", writer);
        }
        if (object.adPartnerMacPresent()) {
            XmlMacWriter.writeOne(object.adPartnerMac(), "ad_partner_mac", writer);
        }
        if (object.optionsPresent()) {
            XmlOptionWriter.writeMany(object.options().iterator(), "option", "options", writer);
        }
        if (object.slavesPresent()) {
            XmlHostNicWriter.writeMany(object.slaves().iterator(), "host_nic", "slaves", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Bonding> list, XmlWriter writer) {
        writeMany(list, "bonding", "bondings", writer);
    }
    
    public static void writeMany(Iterator<Bonding> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlBondingWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

