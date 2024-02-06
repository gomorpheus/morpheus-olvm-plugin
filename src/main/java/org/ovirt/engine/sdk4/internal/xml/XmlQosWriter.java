/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Qos;

public class XmlQosWriter {
    
    public static void writeOne(Qos object, XmlWriter writer) {
        writeOne(object, "qos", writer);
    }
    
    public static void writeOne(Qos object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.cpuLimitPresent()) {
            writer.writeInteger("cpu_limit", object.cpuLimit());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.inboundAveragePresent()) {
            writer.writeInteger("inbound_average", object.inboundAverage());
        }
        if (object.inboundBurstPresent()) {
            writer.writeInteger("inbound_burst", object.inboundBurst());
        }
        if (object.inboundPeakPresent()) {
            writer.writeInteger("inbound_peak", object.inboundPeak());
        }
        if (object.maxIopsPresent()) {
            writer.writeInteger("max_iops", object.maxIops());
        }
        if (object.maxReadIopsPresent()) {
            writer.writeInteger("max_read_iops", object.maxReadIops());
        }
        if (object.maxReadThroughputPresent()) {
            writer.writeInteger("max_read_throughput", object.maxReadThroughput());
        }
        if (object.maxThroughputPresent()) {
            writer.writeInteger("max_throughput", object.maxThroughput());
        }
        if (object.maxWriteIopsPresent()) {
            writer.writeInteger("max_write_iops", object.maxWriteIops());
        }
        if (object.maxWriteThroughputPresent()) {
            writer.writeInteger("max_write_throughput", object.maxWriteThroughput());
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.outboundAveragePresent()) {
            writer.writeInteger("outbound_average", object.outboundAverage());
        }
        if (object.outboundAverageLinksharePresent()) {
            writer.writeInteger("outbound_average_linkshare", object.outboundAverageLinkshare());
        }
        if (object.outboundAverageRealtimePresent()) {
            writer.writeInteger("outbound_average_realtime", object.outboundAverageRealtime());
        }
        if (object.outboundAverageUpperlimitPresent()) {
            writer.writeInteger("outbound_average_upperlimit", object.outboundAverageUpperlimit());
        }
        if (object.outboundBurstPresent()) {
            writer.writeInteger("outbound_burst", object.outboundBurst());
        }
        if (object.outboundPeakPresent()) {
            writer.writeInteger("outbound_peak", object.outboundPeak());
        }
        if (object.typePresent()) {
            XmlQosTypeWriter.writeOne(object.type(), "type", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Qos> list, XmlWriter writer) {
        writeMany(list, "qos", "qoss", writer);
    }
    
    public static void writeMany(Iterator<Qos> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlQosWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

