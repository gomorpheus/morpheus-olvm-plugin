/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.FencingPolicy;

public class XmlFencingPolicyWriter {
    
    public static void writeOne(FencingPolicy object, XmlWriter writer) {
        writeOne(object, "fencing_policy", writer);
    }
    
    public static void writeOne(FencingPolicy object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.enabledPresent()) {
            writer.writeBoolean("enabled", object.enabled());
        }
        if (object.skipIfConnectivityBrokenPresent()) {
            XmlSkipIfConnectivityBrokenWriter.writeOne(object.skipIfConnectivityBroken(), "skip_if_connectivity_broken", writer);
        }
        if (object.skipIfGlusterBricksUpPresent()) {
            writer.writeBoolean("skip_if_gluster_bricks_up", object.skipIfGlusterBricksUp());
        }
        if (object.skipIfGlusterQuorumNotMetPresent()) {
            writer.writeBoolean("skip_if_gluster_quorum_not_met", object.skipIfGlusterQuorumNotMet());
        }
        if (object.skipIfSdActivePresent()) {
            XmlSkipIfSdActiveWriter.writeOne(object.skipIfSdActive(), "skip_if_sd_active", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<FencingPolicy> list, XmlWriter writer) {
        writeMany(list, "fencing_policy", "fencing_policies", writer);
    }
    
    public static void writeMany(Iterator<FencingPolicy> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlFencingPolicyWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

