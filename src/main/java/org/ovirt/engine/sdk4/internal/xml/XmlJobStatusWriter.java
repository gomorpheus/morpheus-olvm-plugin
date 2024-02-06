/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.JobStatus;

public class XmlJobStatusWriter {
    
    public static void writeOne(JobStatus object, XmlWriter writer) {
        writeOne(object, "job_status", writer);
    }
    
    public static void writeOne(JobStatus object, String tag, XmlWriter writer) {
        writer.writeElement(tag, object.value());
    }
    
    public static void writeMany(Iterator<JobStatus> list, XmlWriter writer) {
        writeMany(list, "job_status", "job_statuss", writer);
    }
    
    public static void writeMany(Iterator<JobStatus> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlJobStatusWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

