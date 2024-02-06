/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.PowerManagement;

public class XmlPowerManagementWriter {
    
    public static void writeOne(PowerManagement object, XmlWriter writer) {
        writeOne(object, "power_management", writer);
    }
    
    public static void writeOne(PowerManagement object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.addressPresent()) {
            writer.writeElement("address", object.address());
        }
        if (object.agentsPresent()) {
            XmlAgentWriter.writeMany(object.agents().iterator(), "agent", "agents", writer);
        }
        if (object.automaticPmEnabledPresent()) {
            writer.writeBoolean("automatic_pm_enabled", object.automaticPmEnabled());
        }
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.kdumpDetectionPresent()) {
            writer.writeBoolean("kdump_detection", object.kdumpDetection());
        }
        if (object.optionsPresent()) {
            XmlOptionWriter.writeMany(object.options().iterator(), "option", "options", writer);
        }
        if (object.passwordPresent()) {
            writer.writeElement("password", object.password());
        }
        if (object.pmProxiesPresent()) {
            XmlPmProxyWriter.writeMany(object.pmProxies().iterator(), "pm_proxy", "pm_proxies", writer);
        }
        if (object.statusPresent()) {
            XmlPowerManagementStatusWriter.writeOne(object.status(), "status", writer);
        }
        if (object.typePresent()) {
            writer.writeElement("type", object.type());
        }
        if (object.usernamePresent()) {
            writer.writeElement("username", object.username());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<PowerManagement> list, XmlWriter writer) {
        writeMany(list, "power_management", "power_managements", writer);
    }
    
    public static void writeMany(Iterator<PowerManagement> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlPowerManagementWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

