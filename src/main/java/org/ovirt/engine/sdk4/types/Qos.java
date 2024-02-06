/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * This type represents the attributes to define Quality of service (QoS).
 * 
 * For storage the `type` is <<types/qos_type, storage>>, the attributes `max_throughput`, `max_read_throughput`,
 * `max_write_throughput`, `max_iops`, `max_read_iops` and `max_write_iops` are relevant.
 * 
 * For resources with computing capabilities the `type` is <<types/qos_type, cpu>>, the attribute `cpu_limit` is
 * relevant.
 * 
 * For virtual machines networks the `type` is <<types/qos_type, network>>, the attributes `inbound_average`,
 * `inbound_peak`, `inbound_burst`, `outbound_average`, `outbound_peak` and `outbound_burst` are relevant.
 * 
 * For host networks the `type` is <<types/qos_type, hostnetwork>>, the attributes `outbound_average_linkshare`,
 * `outbound_average_upperlimit` and `outbound_average_realtime` are relevant.
 */
public interface Qos extends Identified {
    BigInteger cpuLimit();
    Byte cpuLimitAsByte();
    Short cpuLimitAsShort();
    Integer cpuLimitAsInteger();
    Long cpuLimitAsLong();
    
    boolean cpuLimitPresent();
    
    BigInteger inboundAverage();
    Byte inboundAverageAsByte();
    Short inboundAverageAsShort();
    Integer inboundAverageAsInteger();
    Long inboundAverageAsLong();
    
    boolean inboundAveragePresent();
    
    BigInteger inboundBurst();
    Byte inboundBurstAsByte();
    Short inboundBurstAsShort();
    Integer inboundBurstAsInteger();
    Long inboundBurstAsLong();
    
    boolean inboundBurstPresent();
    
    BigInteger inboundPeak();
    Byte inboundPeakAsByte();
    Short inboundPeakAsShort();
    Integer inboundPeakAsInteger();
    Long inboundPeakAsLong();
    
    boolean inboundPeakPresent();
    
    BigInteger maxIops();
    Byte maxIopsAsByte();
    Short maxIopsAsShort();
    Integer maxIopsAsInteger();
    Long maxIopsAsLong();
    
    boolean maxIopsPresent();
    
    BigInteger maxReadIops();
    Byte maxReadIopsAsByte();
    Short maxReadIopsAsShort();
    Integer maxReadIopsAsInteger();
    Long maxReadIopsAsLong();
    
    boolean maxReadIopsPresent();
    
    BigInteger maxReadThroughput();
    Byte maxReadThroughputAsByte();
    Short maxReadThroughputAsShort();
    Integer maxReadThroughputAsInteger();
    Long maxReadThroughputAsLong();
    
    boolean maxReadThroughputPresent();
    
    BigInteger maxThroughput();
    Byte maxThroughputAsByte();
    Short maxThroughputAsShort();
    Integer maxThroughputAsInteger();
    Long maxThroughputAsLong();
    
    boolean maxThroughputPresent();
    
    BigInteger maxWriteIops();
    Byte maxWriteIopsAsByte();
    Short maxWriteIopsAsShort();
    Integer maxWriteIopsAsInteger();
    Long maxWriteIopsAsLong();
    
    boolean maxWriteIopsPresent();
    
    BigInteger maxWriteThroughput();
    Byte maxWriteThroughputAsByte();
    Short maxWriteThroughputAsShort();
    Integer maxWriteThroughputAsInteger();
    Long maxWriteThroughputAsLong();
    
    boolean maxWriteThroughputPresent();
    
    BigInteger outboundAverage();
    Byte outboundAverageAsByte();
    Short outboundAverageAsShort();
    Integer outboundAverageAsInteger();
    Long outboundAverageAsLong();
    
    boolean outboundAveragePresent();
    
    BigInteger outboundAverageLinkshare();
    Byte outboundAverageLinkshareAsByte();
    Short outboundAverageLinkshareAsShort();
    Integer outboundAverageLinkshareAsInteger();
    Long outboundAverageLinkshareAsLong();
    
    boolean outboundAverageLinksharePresent();
    
    BigInteger outboundAverageRealtime();
    Byte outboundAverageRealtimeAsByte();
    Short outboundAverageRealtimeAsShort();
    Integer outboundAverageRealtimeAsInteger();
    Long outboundAverageRealtimeAsLong();
    
    boolean outboundAverageRealtimePresent();
    
    BigInteger outboundAverageUpperlimit();
    Byte outboundAverageUpperlimitAsByte();
    Short outboundAverageUpperlimitAsShort();
    Integer outboundAverageUpperlimitAsInteger();
    Long outboundAverageUpperlimitAsLong();
    
    boolean outboundAverageUpperlimitPresent();
    
    BigInteger outboundBurst();
    Byte outboundBurstAsByte();
    Short outboundBurstAsShort();
    Integer outboundBurstAsInteger();
    Long outboundBurstAsLong();
    
    boolean outboundBurstPresent();
    
    BigInteger outboundPeak();
    Byte outboundPeakAsByte();
    Short outboundPeakAsShort();
    Integer outboundPeakAsInteger();
    Long outboundPeakAsLong();
    
    boolean outboundPeakPresent();
    
    QosType type();
    
    boolean typePresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
}
