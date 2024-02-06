/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.SshAuthenticationMethod;

public class XmlSshAuthenticationMethodWriter {
    
    public static void writeOne(SshAuthenticationMethod object, XmlWriter writer) {
        writeOne(object, "ssh_authentication_method", writer);
    }
    
    public static void writeOne(SshAuthenticationMethod object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<SshAuthenticationMethod> list, XmlWriter writer) {
        writeMany(list, "ssh_authentication_method", "ssh_authentication_methods", writer);
    }
    
    public static void writeMany(Iterator<SshAuthenticationMethod> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlSshAuthenticationMethodWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

