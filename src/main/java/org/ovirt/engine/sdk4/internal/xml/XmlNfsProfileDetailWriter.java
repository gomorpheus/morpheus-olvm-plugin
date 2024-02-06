/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.NfsProfileDetail;

public class XmlNfsProfileDetailWriter {
    
    public static void writeOne(NfsProfileDetail object, XmlWriter writer) {
        writeOne(object, "nfs_profile_detail", writer);
    }
    
    public static void writeOne(NfsProfileDetail object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.nfsServerIpPresent()) {
            writer.writeElement("nfs_server_ip", object.nfsServerIp());
        }
        if (object.profileDetailsPresent()) {
            XmlProfileDetailWriter.writeMany(object.profileDetails().iterator(), "profile_detail", "profile_details", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<NfsProfileDetail> list, XmlWriter writer) {
        writeMany(list, "nfs_profile_detail", "nfs_profile_details", writer);
    }
    
    public static void writeMany(Iterator<NfsProfileDetail> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlNfsProfileDetailWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

